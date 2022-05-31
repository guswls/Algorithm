import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] card = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i<N; i++)
		{
			card[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for(int i =0; i<M; i++)
		{
			int num= Integer.parseInt(st.nextToken());
			int first = 0; 
			int last = N-1;
			int mid =0;
			
			while(true)
			{
				mid =(first+last)/2;
				if(card[mid]==num)
				{
					sb.append("1"+" ");
					break;
				}
				if(card[mid]<num)
				{
					first = mid+1;
				}
				else {
					last = mid-1;
				}
				if(first>last)
				{
					sb.append("0"+" ");
					break;
				}
			}
			
		}

		System.out.println(sb);

	}

}