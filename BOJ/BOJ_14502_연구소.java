package NewStartBOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*벽은 꼭 3개 세워야한다.
 * 0 = 빈칸, 1=벽, 2= 바이러스
 * 벽을 세우지 않으면 주변으로 확산 
 * 3개 세우고 바이러스 퍼지지 않는 곳 = 안전영역
 * 안전영역 최대값?*/
public class BOJ_14502_연구소 {
	static int [][]map;
	static int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
	static int [][]copy;
	static int N,M;
	static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copy= new int[N][M];
		for(int i =0; i<N; i++)
		{
			st= new StringTokenizer(br.readLine());
			for(int j =0; j<M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		wall(0);
		System.out.println(max);
	}
	
	public static void virus(int x, int y) {
		//바이러스 확산 dfs
		for(int i=0; i<4; i++) {
			int dx = x+dir[i][0];
			int dy = y+dir[i][1];
			
			if(dx>=0 &&dy>=0 &&dx<N &&dy<M&&copy[dx][dy]==0)
			{/* 여기서 map이 아닌 copy 써야하는 이유: 
				벽을 세울떄  map 기준이 아닌 copy 기준으로 하는데 여기서 map으로 
				하면 초기 map에 확산만 하는 경우가 되기 때문에 */
				copy[dx][dy] = 2;
				virus(dx,dy);
			}
		}
	}
	
	public static void wall(int depth) {
		//3개의 벽 세우기 -> 조합...
		if(depth==3) {
			//map을 copy에 옮겨준다.
			for(int i =0; i<N; i++)
			{
				for(int j =0; j<M; j++)
				{
					copy[i][j]=map[i][j];
				}
			}
			//바이러스가 존재할 때 바이러스를 퍼트린다...
			for(int i =0; i<N; i++)
			{
				for(int j =0; j<M; j++)
				{
					if(copy[i][j]==2)
						virus(i,j);
				}
			}
			//안전영역 구하기 
			int count =0;
			for(int i =0; i<N; i++)
			{
				for(int j =0; j<M; j++)
				{
					if(copy[i][j]==0)
						count++;
				}
			}
			if(count>max)
			{
				max = count;
			}
			return;
		}
		//벽을 세울 곳 3군데 구하기
		for(int i =0; i <N; i++)
		{
			for(int j =0;j<M; j++)
			{
				if(map[i][j]==0)
				{
					map[i][j]=1;
					wall(depth+1); //하나 벽을 만들었으니 depth도 1추가 
					map[i][j]=0; //다음 경우의 수 때문에 원래대로 
				}
			}
		}
			
	}

}
