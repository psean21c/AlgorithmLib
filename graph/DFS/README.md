
###
[DFS: Connected Cell in a Grid](https://www.hackerrank.com/challenges/ctci-connected-cell-in-a-grid)

```java

import java.util.Scanner;

/**
 * 
4 4 
1 1 0 0 
0 1 1 0 
0 0 1 0 
1 0 0 0
 **/
public class I {
	//static int[][] grid = { { 1, 1, 0, 0 }, { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 1, 0, 0, 0 } };
	static int cells = 0;
	static int N = 0;
	static int M = 0;
	static int[][] grid = null;
	
	static void f(int i, int j) {
		if (i < 0 || j < 0 || i >= N || j >= M) return;
		if (grid[i][j] == 0 || grid[i][j] != 1) return;
		
		cells++;
		grid[i][j] = 2;

		f(i - 1, j - 1);
		f(i - 1, j);
		f(i - 1, j + 1);
		f(i, j - 1);
		f(i, j + 1);
		f(i + 1, j - 1);
		f(i + 1, j);
		f(i + 1, j + 1);

	}
	static int max(int a, int b){
		if(a >=b) return a;
		else return b;
	}
	static int getBiggestRegion(int[][] matrix) {
		int maxCells = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] == 1) {
					cells = 0;
					f(i, j);
					maxCells = max(maxCells,cells);
				}
			}
		}

		return maxCells;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		grid = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				grid[i][j] = in.nextInt();
			}
		}
		int a = getBiggestRegion(grid);
		 System.out.println(a);
	}

}

```
