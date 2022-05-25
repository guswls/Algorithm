import java.io.*;
import java.util.*;

public class Main {
	static int N, M, map[][],answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		map = new int[N][M];
		answer =0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		}
		dfs(0,0,new boolean[N][M], 0);
		System.out.println(answer);
	}

	static void dfs(int r, int c, boolean visit[][], int sum) {
		if (r == N - 1) {
			answer=Math.max(answer, sum);
			return;
		}
		boolean copyvisit[][] = new boolean[N][M];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < N; j++)
				copyvisit[j] = Arrays.copyOf(visit[j], M);
			int tempsum=isValid(i, r, c, copyvisit);
			if(tempsum > -1) {
				int nc=c+1==M-1?0:c+1;
				int nr=c+1==M-1?r+1:r;
				dfs(nr, nc, copyvisit, sum+tempsum);
			}
		}
	}

	static int isValid(int type, int r, int c, boolean visit[][]) {
		if (type == 0) {
			if (!visit[r][c] && !visit[r][c + 1] && !visit[r + 1][c + 1]) {
				visit[r][c] = true;visit[r][c + 1] = true;visit[r + 1][c + 1] = true;
				return map[r][c]+(2*map[r][c+1])+map[r+1][c+1];
			} 
		} 
		else if (type == 1) {
			if (!visit[r][c + 1] && !visit[r + 1][c + 1] && !visit[r + 1][c]) {
				visit[r][c + 1] = true;visit[r + 1][c + 1] = true;visit[r + 1][c] = true;
				return map[r][c+1]+(2*map[r+1][c+1])+map[r+1][c];
			}
		}
		else if (type == 2) {
			if (!visit[r][c] && !visit[r + 1][c] && !visit[r + 1][c + 1]) {
				visit[r][c] = true;visit[r + 1][c] = true;visit[r + 1][c + 1] = true;
				return map[r][c]+(2*map[r+1][c])+map[r+1][c+1];
			}
		}
		else if (type == 3) {
				if (!visit[r][c] && !visit[r + 1][c] && !visit[r][c + 1]) {
					visit[r][c] = true;visit[r + 1][c] = true;visit[r][c + 1] = true;
					return (2*map[r][c])+map[r+1][c]+map[r][c+1];
				}
		} 
		else if (type == 4) {
				return 0;
			}
		return -1;
	}

	static int stoi(String s) {
		return Integer.valueOf(s);
	}
}