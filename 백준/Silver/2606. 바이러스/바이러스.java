import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int c,v; 
	static int count=0;
	static int [][] graph;
	static boolean [] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		c = Integer.parseInt(br.readLine());
		v = Integer.parseInt(br.readLine());
		graph = new int[c+1][c+1];
		visit = new boolean[c+1];
		for(int i =0 ; i<v; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			graph [v1][v2]= 1;
			graph [v2][v1]=1;// 간선 연결처리
		}
		dfs(1);
		System.out.println(count);
	}
	static void dfs(int x) {
		visit[x] =true;
		for(int i =1; i<c+1; i++)
		{
			if(graph[x][i]==1 &&!visit[i]) {
				count++;
				visit[i] = true;
				dfs(i);
			}
		}
	}

}
