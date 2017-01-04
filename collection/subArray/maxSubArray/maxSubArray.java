
import java.util.Scanner;

/***
Author: Simon Park
***/
public class maxSubArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Q = in.nextInt();
		for (int i = 0; i < Q; i++) {
			int A = in.nextInt();
			int[] ar = new int[A];
			for (int j = 0; j < A; j++) {
				ar[j] = in.nextInt();
			}
			findMaxSumSubArray(ar);
		}
	}

	private static void findMaxSumSubArray(int[] ar) {
		int MAX = 10000;
		int max_ending_here = (-1 * MAX);
		int max_so_far = (-1 * MAX);
		int max_sum = 0;

		for (int i = 0; i < ar.length; i++) {
			max_ending_here = max(ar[i], max_ending_here + ar[i]);
			max_so_far = max(max_so_far, max_ending_here);
			if (ar[i] > 0) max_sum += ar[i];
		}

		if (max_so_far < 0) max_sum = max_so_far;
		System.out.println(max_so_far + " " + max_sum);
	}

	private static int max(int a, int b) {
		if (a > b) return a;
		else return b;
	}

}
