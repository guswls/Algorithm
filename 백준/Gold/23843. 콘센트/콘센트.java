import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		st = new StringTokenizer(br.readLine());
		int [] arr =new int [N];
		for(int i =0; i<N; i++)
		{
			arr[i]= Integer.parseInt(st.nextToken());	
		}
		Arrays.sort(arr);
		for(int i=0; i<M;i++)
		{ // 초기는 0 으로 맞추기 
			pq.offer(0);
		}
		for(int i =N-1; i>=0; i--)
		{// 충전시간이 가장 긴 것부터 꺼내서 pq에 넣어주기 
			int tmp = pq.poll(); //충전 끝나면 빼기
			pq.offer(tmp+arr[i]);// 이전 시간 +새로운 전자기기 넣어주기 
		}
		for(int i=0; i<M-1; i++)
		{// M개니까 마지막 하나빼고 다 빼주기 
			pq.poll();
		}
		System.out.println(pq.poll());
	}
}
