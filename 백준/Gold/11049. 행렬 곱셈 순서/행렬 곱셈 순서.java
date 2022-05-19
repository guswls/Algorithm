import java.util.Arrays;
import java.util.Scanner;
public class Main {
	static int[][] matrix;
	static int[][] dp;
	static int N;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		matrix=new int[N][2];
		dp=new int[N][N];
		
		for(int i=0;i<N;i++) {
			matrix[i][0]=sc.nextInt();
			matrix[i][1]=sc.nextInt();
		}
		
		find(0,N-1);
		System.out.println(dp[0][N-1]);
		
	}
	
	public static int find(int x,int y) {
		int ans= 2147483647;
		if(x==y) {
			return 0; 	
		}
		if(dp[x][y]!=0) {
			return dp[x][y];
		}
		for(int i=x;i<y;i++) {
			ans=Math.min(ans, find(x,i)+find(i+1,y)+matrix[x][0]*matrix[i][1]*matrix[y][1]);
			dp[x][y]=ans;
		}
		return ans;
	}
}