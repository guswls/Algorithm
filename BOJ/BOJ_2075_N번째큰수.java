package NewStartBOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 문제)
 * 1.모든 수는 자신의 한칸 위의 수보다 크다 (1행<2행<3행..<n행)
 * 2. n번째 큰수 찾기 
 * 
 * 처음 생각한 풀이1) 2차원 배열
 * 일단 마지막 행이 모든 열중에 가장 클것이다...
 * 마지막 행을 기준으로 찾으면 될듯..?
 * 1. 마지막 행을 배열에 넣고 정렬을 시킨다. 
 * 2. 그 전 행을 차례대로 비교 
 * 3. 정렬하고 반복 
 * 
 * 나중 풀이)
 * 어차피 n번째 큰수 찾기 위해 정렬할것이니... 
 * 애초에 1차원 배열에 입력을 받고 정렬후 찾기
 * */
public class BOJ_2075_N번째큰수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//첫번째 방법
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
		
		//두번째 방법
		
		/*
		 * int [] map  = new int [n*n];
		int idx =0;
		for(int i =0; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0; j<n; j++)
			{
				map[idx++] = Integer.parseInt(st.nextToken());		
			}
		}
		Arrays.sort(map);
		System.out.println(map[n*n-n]);*/
	}

}
