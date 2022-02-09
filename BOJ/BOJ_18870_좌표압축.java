import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
/*
 * n개의 좌표  압축 적용
 * x[i]>x[j]를 만족하는 서로 다른 좌표의 개수 = x'[i]
 * 
 * 풀이)
 * 1. 배열에 넣는다 
 * 2. 정렬을 한다
 * 3. 정렬한 배열과 기존 배열을 비교해서 있는 쪽에 count 
 * 4. 이때 동일한 값이 있다면 제외 
 * 
 *(11) 동일한 좌표는 어떻게 체크하지...? => hashmap 사용 
 * */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =  Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] arr =new int[n];

		for(int i =0; i<n; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());//원래
		}
		int [] arrc =arr.clone();
		Arrays.sort(arrc);
		
		HashMap<Integer, Integer> result = new HashMap<>();
		int cnt =0;
		for(int i =0; i<n; i++)
		{
			if(!result.containsKey(arrc[i]))
			{
				result.put(arrc[i], cnt++);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i =0;  i<n; i++)
		{
			sb.append(result.get(arr[i])).append(" ");
		}
		System.out.println(sb.toString());
	}

}
