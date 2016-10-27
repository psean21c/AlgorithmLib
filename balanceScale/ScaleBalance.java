import java.io.*;
import java.util.*;
import java.util.Map.Entry;


/****
 * Author: Simon Park


1) Test case-1
input
A,20,D
D,2,4
output
A,0,0
D,6,4


        2     4
        |_____|
   20     D 
    |_____|
       A
       
        2(6)  4(4)
        |_____|
   20     D
    |_____|
       A


* Number inside () is the solution 


2) Test case-2
input
A,2,D
D,2,4
output 
A,10,0
D,2,0 


        2     4
        |_____|
    2     D
    |_____|
       A


        2(2)  4
        |_____|
   2(10)  D
    |_____|
       A


3) Steps to explain the test-case 1
============
step-1
A[20,D,0,0]
D[2, 4,0,0]
============
step-2
A[20,D,0,8*]
D[2, 4,2,0]


** Whenever there is any value(8) for the alphabetic node(D) - A[20,D*,0,8*]
*  it has to be re-distributed to child nodes
===========
step-3
8* => 4 : 4
A[20,D,0,0]
D[2, 4,2+4,0+4]
===========
step-4
A[20,D,0,0]
D[2, 4,6,4]


===========
step-5
3rd,4th elements in the List are answers
A[20,D,|0,0]
D[2, 4,|6,4]


**/


public class ScaleBalance {
	private static String filePath = "src/solve/";
	private static HashMap<String, List<String>> scaleData = new HashMap<String, List<String>>();


	public static void main(String[] args) {
		scaleData = initEclipse();
		printHashMap(scaleData); // Check the initial data set
		System.out.println("=========================");
		findWeight("A");
		printHashMap(scaleData);
	}


	
	/**
	 * Main process
	 * 1) return the weight for the node
	 * 2) put delta weight on the side which is lighter than the other
	 * 3) call the distribute() in order to re-balance the scale
	 */
	static int findWeight(String node) {
		
		int weight = 0;
		
		try {
			String leftNode = findLeft(node);
			String rightNode = findRight(node);
			boolean isLeftNumeric = isInteger(leftNode);
			boolean isRightNumeric = isInteger(rightNode);
			
			int delta = 0;
			List<String> lst = searchNode(node);
			int left = 0;
			int right = 0;


			if(isLeftNumeric) left = Integer.parseInt(leftNode);
			else left = findWeight(leftNode) + 4;
			
			if(isRightNumeric) right = Integer.parseInt(rightNode);
			else right = findWeight(rightNode) + 4;


			int leftValue = new Integer(lst.get(2));
			int rightValue = new Integer(lst.get(3));
			
			if(left > right) {
				delta = Math.abs(left-right);
				weight = left + right + delta;
				if(isInteger(rightNode)){
					lst.set(2, new Integer(leftValue).toString());
					lst.set(3, new Integer(rightValue + delta).toString());
					scaleData.put(node, lst);			
				} else {
					distribute(rightNode,delta);
				}				
			} else if(left < right) {
				delta = Math.abs(right-left);
				weight = left + right + delta;
				if(isInteger(leftNode)){
					lst.set(2, new Integer(leftValue + delta).toString());
					lst.set(3, new Integer(rightValue).toString());
					scaleData.put(node, lst);			
				} else {
					distribute(leftNode,delta);
				}				
				
			} else {
				weight = left + right;
			}
			
		} catch (NumberFormatException e) {
			
		}
		
		return weight;
	}
	
	/**
	 * re-balance the scale
	 */
	static void distribute(String node, int delta){
		
		List<String> values = searchNode(node);
		String leftNode = values.get(0);
		String rightNode = values.get(1);
		int leftValue = new Integer(values.get(2));
		int rightValue = new Integer(values.get(3));
		
		if(isInteger(leftNode) & isInteger(rightNode)){
			values.set(2, new Integer(leftValue + delta/2).toString());
			values.set(3, new Integer(rightValue + delta/2).toString());
			scaleData.put(node, values);
		} else if(!isInteger(leftNode) & isInteger(rightNode)) {
			values.set(2, new Integer(leftValue).toString());
			values.set(3, new Integer(rightValue + delta/2).toString());
			scaleData.put(node, values);
			distribute(leftNode,delta/2);
		} else if(isInteger(leftNode) & !isInteger(rightNode)) {
			values.set(2, new Integer(leftValue + delta/2).toString());
			values.set(3, new Integer(rightValue).toString());
			scaleData.put(node, values);
			distribute(rightNode,delta/2);
		} else {
			distribute(leftNode,delta/2);
			distribute(rightNode,delta/2);
		}
	}
	


	
	/**
	 * i.e. Will return 3 for D : D[3,7]
	 */
	static String findLeft(String node) {
		List<String> values = searchNode(node);
		String leftNode = values.get(0);
		return leftNode;
	}
	
	/**
	 * i.e. Will return 7 for D : D[3,7]
	 */
	static String findRight(String node) {
		List<String> values = searchNode(node);
		String rightNode = values.get(1);
		return rightNode;
	}


	/**
	 * Search node and return values associated with the key = node
	 */
	public static List<String> searchNode(String node){
		 
		Set<Entry<String, List<String>>> entrySet = scaleData.entrySet();
		List<String> values = new ArrayList<String>();
		for(Entry<String, List<String>> entry: entrySet) {
			//System.out.println(entry.getKey() + "=" + entry.getValue());
			if(entry.getKey().equalsIgnoreCase(node)){
				values = entry.getValue();
			}
		}			
		return values;
	}
	
	/**
	 * print for HashMap Dataset
	 */
	public static void printHashMap(HashMap<String, List<String>> scaleData){
		 
		Set<Entry<String, List<String>>> entrySet = scaleData.entrySet();
			for(Entry<String, List<String>> entry: entrySet) {
				System.out.println(entry.getKey() + "=" + entry.getValue());
			}			
	 }
	 
	/**
	 * print for Node
	 */
	public static void printHashNode(String node){
		List<String> lst = scaleData.get(node);
		System.out.print(node + ":");
		for(String ls:lst) {
			System.out.print(ls + " ");
		}
		System.out.println();
	}


	/**
	 * Boolean to check if it is number or not.
	 */
	static boolean isInteger(String string){
		boolean isInteger = false;
		
		try{
			int isNodeNumber = Integer.parseInt(string);
			isInteger = true;
		} catch(NumberFormatException e) {
			//System.out.println("NumberFormatException:" + e);
		} catch(Exception e){
			//System.out.println("Exception:" + e);
		}
		
		return isInteger;
	}	
	
	/**
	 * Read input data from text file & Save it to HashMap & return it
	 */
	public static HashMap<String, List<String>> initEclipse(){
		String fileName = "README.txt";
		HashMap<String, List<String>> scaleNode = new HashMap<String, List<String>>();
		
		try {
		
			BufferedReader br = new BufferedReader(new InputStreamReader(
				new DataInputStream( 
				new FileInputStream(filePath + fileName))));
			
			String strLine;
			
			while ((strLine = br.readLine()) != null ) {
				StringTokenizer st = new StringTokenizer(strLine,",");
				int idx = 0;
				String key = "";
				String left = "";
				String right = "";
				List<String> value = new ArrayList<String>();
				
				while (st.hasMoreElements()) {
					String stNext = st.nextToken();
					if(idx==0) key = stNext;
					else if(idx==1) left = stNext;
					else right = stNext;
					idx++;
				}	
				value.add(left);
				value.add(right);
				value.add("0");
				value.add("0");
				scaleNode.put(key, value);
			} 
			
		
		} catch (NumberFormatException e){
			System.out.println("NumberFormatException: " + e);
		} catch (IOException e) {
			System.out.println("IOException:" + e);
		}
		
		return scaleNode;
	}  


}


