

```java
package nov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class G {

	static HashMap<HashSet<Integer>,List<Integer>> map = new HashMap<HashSet<Integer>,List<Integer>>();  
	static int totalCnt = 0;
	static int[][] ar = null;
	
	static int f(int n){
		return n * (n-1);
	}
	
	static int sumGroup(int n){
		if(n==1) return f(n);
		return sumGroup(n-1) + f(n);
	}
	
	static void printA(){
		for(int i=0;i<ar[0].length;i++){
			System.out.println(ar[0][i] + " " + ar[1][i]);
		}
	}
	
	static void calculate(){
		int acc = 0;
		for(int i=0;i<ar[0].length;i++){
			int member = ar[0][i];
			int count = ar[1][i];
			//System.out.println(ar[0][i] + " " + ar[1][i]);
			int med = sumGroup(member);
			int full = f(member);
			int remain = totalCnt - (member - 1);
			int med2 = full * remain;
			totalCnt -= (member - 1);
			acc += med + med2;
		}
		System.out.println(acc);
	}
	
	static int[][] sort(int[][] ar2)	{
		int len = ar2[0].length;
		int mid = len/2;
		
		if(ar2[0].length == 1){
			return ar2;
		}else{
			int[][] a = new int[2][mid];
			int[][] b = new int[2][len-mid];
			int a_cnt = 0, b_cnt = 0;
			for(int i=0;i<len;i++){
				if(i<mid) {
					a[0][a_cnt] = ar2[0][i];
					a[1][a_cnt] = ar2[1][i];
					a_cnt++;
				}
				else {
					b[0][b_cnt] = ar2[0][i];
					b[1][b_cnt] = ar2[1][i];
					b_cnt++;
				}
			}
			int[][] l = sort(a);
			int[][] r = sort(b);
			int[][] m = merge(l,r);
			return m;
		}
	}

	static int[][] merge(int[][]a, int[][]b){
		int len_a = a[0].length;
		int len_b = b[0].length;
		int[][] s = new int[2][len_a + len_b];
		int i=0, j=0, idx = 0;

		while(i<len_a && j<len_b){
			if(a[0][i] >= b[0][j]) {
				s[0][idx] = a[0][i];
				s[1][idx] = a[1][i];
				i++;
			}
			else{
				s[0][idx] = b[0][j];
				s[1][idx] = b[1][j];
				j++;
			}
			idx++;
		}
		
		if(i<len_a && j==len_b) {
			while(i<len_a){
				s[0][idx] = a[0][i];
				s[1][idx] = a[1][i];
				idx++;
				i++;
			}
		}
		if(j<len_b && i==len_a)  {
			while(j<len_b) {
				s[0][idx] = b[0][j];
				s[1][idx] = b[1][j];
				idx++;
				j++;
			}
		}
		
		return s;
	}


	static int valueGroup(){
		//size = ;
		ar = new int[2][map.size()];
		int i = 0;
		for(HashSet<Integer> key: map.keySet()) {
			List<Integer> lst = map.get(key);
			//System.out.println(key.size() + ":" + lst.get(1));
			totalCnt += lst.get(1);
			ar[0][i] = key.size();
			ar[1][i] = lst.get(1);
			i++;
			//int i2 = i++;
		}
		//System.out.println(totalCnt);
		return 0;
	}
	
	// 0: need to create new Group
	// 1/-1: join the group
	// 2: merge the group
	static int verfifyGroup(int a,int b){
	
		boolean isA = false;
		boolean isB = false;
		int status = 0;
		for(HashSet<Integer> key: map.keySet()) {
			if(key.contains(a) & !key.contains(b)) isA = true;
			else if(!key.contains(a) & key.contains(b)) isB = true;
			else if(key.contains(a) & key.contains(b)) isA = true;
		}
		if(!isA & !isB) status = 0;
		else if(isA & isB) status = 2;
		else {
			if(isA) status = 1;
			else status = -1;
		}
		
		return status;
	}
	
	static void buildGroup(int a, int b){
		int s = verfifyGroup(a,b);
		if(s==0) newGroup(a,b);
		else if(s==2) mergeGroup(a,b);
		else{
			if(s==1) addGroup(a,b);
			else addGroup(b,a);
		}
	}

	static void mergeGroup(int a,int b){ 
		HashSet<Integer> set = new HashSet<Integer>();
		List<Integer> lst = new ArrayList<Integer>();
		HashSet<Integer> remove1 = null;
		HashSet<Integer> remove2 = null;
		int weight = 0;
		int cnt = 0;
		for(HashSet<Integer> key: map.keySet()) {
			List<Integer> tLst = map.get(key);
			if(key.contains(a)){
				for(Integer k:key) set.add(k);
				int i = 0;
				for(Integer l:tLst){
					if(i==0) weight += l;
					if(i==1) cnt += l;
					i++;
				}
				remove1 = key;
			}
			if(key.contains(b)){
				for(Integer k:key) set.add(k);
				int i = 0;
				for(Integer l:tLst){
					if(i==0) weight += l;
					if(i==1) cnt += l;
					i++;
				}
				remove2 = key;
			}
			
		}
		map.remove(remove1);
		map.remove(remove2);
		lst.add(weight);
		lst.add(++cnt);
		map.put(set, lst);
	}
	
	// insert 'b' in the group having 'a'
	static void addGroup(int a,int b){ 
		HashSet<Integer> set = new HashSet<Integer>();
		List<Integer> lst = new ArrayList<Integer>();
		HashSet<Integer> remove1 = null;
		
		for(HashSet<Integer> key: map.keySet()) {
			//System.out.println(key);
			List<Integer> tLst = map.get(key);
			if(key.contains(a)){
				for(Integer k:key){
					set.add(k);
				}
				set.add(b);
				int i = 0;
				int n = f(set.size());
				for(Integer l:tLst){
					if(i==0) {
						lst.add(l+n);
					}
					if(i==1) lst.add(++l);
					i++;
				}
				remove1 = key;
				
			}
		}
		
		map.remove(remove1);
		map.put(set, lst);
	}

	
	static void newGroup(int a, int b){
		HashSet<Integer> set = new HashSet<Integer>();
		List<Integer> lst = new ArrayList<Integer>();
		
		Integer a1 = Integer.valueOf(a);
		Integer b1 = Integer.valueOf(b);
		set.add(a1);
		set.add(b1);
		int val = 2;
		int cnt = 1;
		lst.add(val);
		lst.add(cnt);
		map.put(set, lst);
	}

	static void printG(){ 
		System.out.println("/========Start=========");
		for(HashSet<Integer> key: map.keySet()) {
			for(Integer k:key){
				System.out.print(k + " ");
			}
			List<Integer> lst = map.get(key);
			for(Integer l:lst){
				System.out.print(" >> " + l + " ");
			}
			System.out.println();
		}
		System.out.println("========End=========/\n");
		
	}
		
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		for (int a0 = 0; a0 < t; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			for (int a1 = 0; a1 < m; a1++) {
				int x = in.nextInt();
				int y = in.nextInt();
				buildGroup(x,y);
			}
		}

		valueGroup();
		ar = sort(ar);
		calculate();


	}
}

/***

		// TC-1 >> 32
		buildGroup(1,2);
		buildGroup(3,2);
		buildGroup(4,2);
		buildGroup(4,3);

		//TC-2 >> 92
		buildGroup(1,2);
		buildGroup(2,4);
		buildGroup(1,4);
		buildGroup(7,8);
		buildGroup(8,9);
		buildGroup(2,3);
		buildGroup(5,6);
		
		// TC-3 >> 16
		buildGroup(1,2);
		buildGroup(3,4);
		buildGroup(4,5);

		//TC-4 >> 352		
		buildGroup(7,  8);
		buildGroup(1,  2);
		buildGroup(2,  3);
		buildGroup(1,  3);
		buildGroup(4,  5);
		buildGroup(4,  6);
		buildGroup(5,  6);
		buildGroup(10, 11);
		buildGroup(13, 12);
		buildGroup(12, 11);
		buildGroup(13, 11);
		buildGroup(13, 10);
		buildGroup(12, 10);
		buildGroup(12, 9);

		//
		valueGroup();
		ar = sort(ar);
		printA();
		calculate();
**/


```
