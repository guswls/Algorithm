import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][] map  = new int [n][n];
		int [] result = new int[n];
		for(int i =0; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0; j<n; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i==n-1)				{
					result[j]= map[i][j]; //마지막행을 넣기 
				}
			}
		}
		// 마지막행 넣은 배열 정렬 
		Arrays.sort(result);
		//for문으로 그전행부터 돌기 
		for(int i =n-2;i>=0; i--)
		{// 행
			int check =0;
			for(int j =0; j<n; j++)
			{//열
				if(map[i][j]>result[0])
				{
					result[0]=map[i][j];
					Arrays.sort(result);
					check ++;
				}
			}
			if(check ==0)
				break;
		}
		System.out.println(result[0]);
		
	}

}
