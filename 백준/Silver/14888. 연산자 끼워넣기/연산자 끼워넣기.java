import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int [] num;
	static int [] cal;
	static int min = Integer.MAX_VALUE , max= Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int [N];
		cal = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i= 0; i<N; i++)
		{
			num[i] =Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i= 0; i<4; i++)
		{
			cal[i] =Integer.parseInt(st.nextToken());
		}
		dfs(num[0], 1);
		System.out.println(max);
		System.out.println(min);
	}
	static void dfs(int check, int idx)
	{//
		if(idx==N)
		{//모든 연산자 다 사용했을 경우, 연산자는 무조건 N-1개 주어진다!!!!
			if(check>max)
				max= check;
			if(check <min)
				min = check;
			return;
		}
		int result = 0;
		for(int i =0; i<4; i++)
		{
			if(cal[i]!=0) {//0일때는 사용될 연산자가 없기 때문에 패스
				cal[i]--; // 사용된 연산자 하나 제거
				switch (i) { // cal[i]의 경우에 맞게 연산
				case 0:
					result = check + num[idx];
					break;
				case 1:
					result = check - num[idx];
					break;
				case 2:
					result = check * num[idx];
					break;
				case 3:
					if(check<0 && num[idx]>0)
					{//나누기의 경우 음수 체크
						check*=-1;
						result = check/num[idx];
						result*=-1;
					}
					else {
						result = check / num[idx];
					}
					break;
				default:
					break;
				}
				dfs(result, idx+1);//연산의 결과와 index 1추가한거 넘기기
				cal[i] ++;//모두 탐색하고 다시 원래대로 돌려두기 위한 1추가
			}
		}
	}

}
