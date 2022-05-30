import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int [n];
		for(int i=0; i<n; i++)
		{
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int max = Integer.MIN_VALUE;
		//특정 로프 사용-> 특정 로프보다 큰 무게는 모두 사용하는 것이 이득 
        // 4 10 15 일때 4를 이용하는 것보다 이용하지 않는것이 이득..
        //-> 정렬 후 가장 큰 무게를 들 수 있는 로프를 기준으로 계산..  
		for(int i=0; i<n; i++)
		{
			max = Math.max(max, arr[i]*(n-i));
		}
		System.out.println(max);	
	}
}