import java.util.Scanner;


public class D {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int A = in.nextInt();
		for (int i = 0; i < A; i++) {
			int Q = in.nextInt();
			int[] arr = new int[Q];
			long sum = 0;
			int cnt = 0;
			for (int j = 0; j < Q; j++) {
				arr[j] = in.nextInt();
				sum += arr[j];
				if (arr[j] != 0)
					cnt++;
			}

			int[] newSum = new int[cnt];
			int newCnt = 0;
			for (int j = 0; j < Q; j++) {
				if (arr[j] != 0)
					newSum[newCnt++] = arr[j];
			}
			if (sum == 0)
				System.out.println(Q - 1);
			else
				System.out.println(count(newSum));
		}

	}

	static int count(int[] arr) {
		int len = arr.length;
		int mid = len / 2;
		long sum = 0;
		for (int i = 0; i < len; i++) {
			sum += arr[i];
		}

		if (sum % 2 == 0 && len > 1) {
			long half = sum / 2;
			long acc = 0;
			int idx = 0;
			for (int i = 0; i < len; i++) {
				acc += arr[i];
				if (half == acc) {
					idx = i;
					break;
				} else if (acc > half) {
					return 0;
				}
			}

			int size1 = idx + 1;
			int size2 = len - (idx + 1);
			int[] arr1 = new int[size1];
			int[] arr2 = new int[size2];

			int cnt = 0;
			for (int i = 0; i < size1; i++) {
				arr1[cnt++] = arr[i];
			}

			cnt = 0;
			for (int i = size1; i < len; i++) {
				arr2[cnt++] = arr[i];
			}

			return 1 + max(count(arr1), count(arr2));
		} else if (len == 1) {
			return 0;
		} else {
			return 0;
		}

	}

	static int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

}
