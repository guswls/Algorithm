import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 문제)
 * 시험장 : N, 응시자: An, 감독1 : B명, 부감독 여러명 : c명
 * 풀이)
 * 응시자의 수 - 감독의 수 한 뒤 나머지는 부감독관이므로 나누기 하면 된다.
 * 각 시험장 마다 총감은 한명씩 꼭 있어야 한다!!
 * 주의) 변수 타입 잘 확인! */
class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []room = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0 ; i<N; i++)
		{
			room[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		// 입력 완료 
		long answer = 0;
		for(int i =0; i<N; i++) {
			if(room[i] - B <=0)
			{// 총감독관 1명으로 감시가 가능한 경우 
				answer++;
			}
			else {//부감독관이 필요한 경우
				answer++;
				if((room[i]-B)%C ==0)
				{//부감독이 감시 가능 인원과 나머지 인원이 딱 떨어지는 경우
					answer+=(room[i]-B)/C;
				}
				else {// 그렇지 않을 경우 1추가 
					answer+=(room[i]-B)/C+1;
				}
			}
		}
		System.out.println(answer);
	}
}
