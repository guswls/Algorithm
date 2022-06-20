import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int [] arr =new int[301];
		for (int i = 1; i <= t; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
	
		int [] dp = new int [301];
		dp[1] = arr[1];
		dp[2] = arr[2]+arr[1];
		dp[3] = Math.max(arr[1]+arr[3], arr[2]+arr[3]);
		for (int i = 4; i <=t; i++) {
			dp[i] = Math.max(dp[i-3]+arr[i]+arr[i-1], dp[i-2]+arr[i]);
		}
		System.out.println(dp[t]);
		
	}

}