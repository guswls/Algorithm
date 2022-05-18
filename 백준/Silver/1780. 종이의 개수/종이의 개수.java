import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	static int[][] arr;

	static int [] count ;
	public static void main(String[] args) throws NumberFormatException, IOException {


		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String []str = bf.readLine().split(" ");	
			for (int j = 0; j < N; j++) {
				
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		count = new int[3];
		divide(0,0,N);
		// 잘라야 되는 경우
		System.out.println(count[0]);
		System.out.println(count[1]);
		System.out.println(count[2]);
	}
	public static void divide(int r, int c, int n) {
		if (check(r, c, n)) {
			count[arr[r][c]+1]+=1;
		} else {
			int newlen = n / 3;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					divide(i * newlen + r, j * newlen + c, newlen);
				}
			}
		}
	}

	public static boolean check(int r, int c, int n) {
		int checknum = arr[r][c];
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if (arr[i][j] != checknum) {
					return false;
				}
			}
		}
		return true;
	}
}