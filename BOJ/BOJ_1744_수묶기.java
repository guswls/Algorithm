package Study_BOJ;

import java.util.Arrays;
import java.util.Scanner;

/*문제 설명 
 * 1. 수열을 두수 끼리 묶어서 최대 합을 출력한다.
 * 
 * 방법 
 * 1. 배열에 입력 값을 다 넣어준다.
 * 2. 정렬해준다.
 * 3. (음,음),(양, 양), (음 ,0) ==> 곱
 * 	  (음,양),(양,0) ==> 더하기
 * 	  (0,0) ==> 상관 x
 * 	  (1,1) -->더하기*/
public class BOJ_1744_수묶기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		int result =0;
		int count =0;
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
			if(num[i]<=0)
				count++;
		} // 일단 배열에 넣기
		Arrays.sort(num);
		for(int i=1; i<count; i+=2)
		{
			result += num[i-1]*num[i];
		}// 음수, 0까지 결과
		
		if(count%2 ==1)
		{ //0포함한 음수가 홀수개일 경우 그냥 더하기
			result+=num[count-1];
		}
		if((N-count)%2 ==1)
		{ //양수가 홀수개일 경우 그냥 더하기
			result+=num[count];
		}
		for(int i =N-1; i>count; i-=2)
		{
			int mul = num[i]*num[i-1]; //두수 곱할 경우
			int sum = num[i]+num[i-1]; // 두수 더할 경우
			if(mul>sum)
				result +=mul;
			else {
				result +=sum;
			}
		}

		System.out.println(result);
	}

}
