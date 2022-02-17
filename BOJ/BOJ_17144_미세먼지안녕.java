package NewStartBOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 미세먼지 확산후 공기청정기 작동 
 * */
public class BOJ_17144_미세먼지안녕 {
	static int R, C, T;
	static int[][] map;//처음 map
	static int[][] copy; //미세먼지 확산 후 map
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int bottom =0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == -1)
					bottom =i;// bottom의 행이 입력
				 
			}
		}
		
		for(int i=0; i<T;i++)
		{//T만큼 수행
			dust();
			air();
		}
		
		int sum =0; 
		for(int i  =0; i<R; i++)
		{
			for(int j =0; j<C; j++)
			{
				if(map[i][j]>0)
					sum+=map[i][j];
			}
		}
		System.out.println(sum);
	}
	
	public static void dust() {
		//미세먼지 확산하는 함수 
		copy = new int[R][C];
		for(int i =0; i<R; i++)
		{//copy 배열에 map 배열 복사해줌
			for(int j =0; j<C; j++)
			{ 
				copy[i][j]+=map[i][j];
				//이미 전에 확산 된 미세먼지가 있기 때문에 뒤에서 copy값이 아닌 map으로 확산양을 나누기때메 + 해주면 다른칸으로 
				//부터 확산된 양은 신경쓸 필요가 없다 
				if(map[i][j]<5)//5 미만이면 확산 안되니까 패스 
					continue;
				int count =0; // 몇방향으로 확산되었는지 알기 위해서 
				int cal = map[i][j]/5;//확산 되는 미세먼지 양
				if(map[i][j]>0)
				{// 0이상이어야 미세먼지가 있다는 것이므로 
					for(int a =0; a<4; a++)
					{// 확산될 방향
						int dx = i+dir[a][0];
						int dy = j+dir[a][1];
						if(dx>=0 && dy>=0 &&dx<R &&dy<C)
						{
							if(map[dx][dy]==-1) //-1은 공기청정기 있는곳이니 패스
								continue;
							else {
								copy[dx][dy]+=cal;
								count++;
							}
						}
					}
					copy[i][j]-=(cal*count);
				}
			}
		}  
		for(int i  =0; i<R; i++)
		{
			for(int j =0; j<C; j++)
			{
				map[i][j]= copy[i][j];
			}
		}
		
	}
	
	public static void air(){
		//
		int top = bottom-1;//bottom은 밑에 칸이기 때문에
		//공기청정기 윗부분(반시계) 
		//1. 0행에서 공기청정기행으로 당기기 
		for(int i =top-1; i>0;i--)
		{
			map[i][0]=map[i-1][0];
		}
		//2. c열에서 0열까지 당기기
		for(int i = 0; i<C-1; i++)
		{
			map[0][i]=map[0][i+1];
		}
		//3. 공기청정기 윗부분행에서 c열의 0행으로 당기기 
		for(int i =0; i<top; i++)
		{
			map[i][C-1]=map[i+1][C-1];
		}
		//4. 공기청정기 행 의 0열에서 C열로 당기기
		for(int i =C-1;i>1; i--)
		{
			map[top][i] = map[top][i-1];
			if(i==2)
				map[top][i-1]=0;
		}
		map[top][0]=-1;
		//공기청정기 아래부분 => 시계방향 
		//1. 맨 마지막 행에서 공기청청기 행까지 
		for(int i =bottom+1; i<R-1; i++)
		{
			map[i][0] = map[i+1][0];
		}
		//2.맨마지막 행의 끝열을 0열로 당기기 
		for(int i =0; i<C-1; i++)
		{
			map[R-1][i] = map[R-1][i+1];
		}
		//3.맨 마지막열의 공기청정기가 있는 행부터 끝행까지 아래로 당기기
		for(int i =R-1; i>bottom; i--)
		{
			map[i][C-1]=map[i-1][C-1];
		}
		//4. 공기청정기 밑부분있는 행의 열을 오른쪽으로 당기기 
		for(int i =C-1; i>1; i--)
		{
			map[bottom][i]=map[bottom][i-1];
			if(i==2)
				map[bottom][i-1]=0;
		}
		map[bottom][0]=-1;
	}

}
