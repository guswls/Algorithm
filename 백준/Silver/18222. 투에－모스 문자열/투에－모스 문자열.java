import java.util.Scanner;

// n 번째 숫자는 n보다 작은 2의 거듭제곱 값의 반전 
//ex) 5-> 4=0->1
public class Main {
	static long[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long k = sc.nextLong();
		arr = new long[65];
		arr[0] = 1;
		for (int i = 1; i < 65; ++i) {
			arr[i] = arr[i - 1] * 2;
		}
		System.out.print(get(k));
	}

	static long get(long k) {
		if (k == 1)
			return 0;

		for (int i = 0; i < 65; ++i) {
			if (k <= arr[i])
				return 1 - get(k - arr[i - 1]);
		}
		return 0;
	}

}