import java.util.Arrays;
import java.util.Scanner;
/*
 * 문제 이해)
 * 1. defile -> 최종적으로 한번만 실행 모두 모독 성공
 * 2. 그러기 위해서 제이나를 고용해서 점수 변경 
 * 3. 제이나 한명이 1점 낮출수 있음 
 * 4. 오름차순 정렬후 차례대로 point[i]-(i+1)을 결과값에 더해준다
 * -> 이전 배열보다 1차이 나야함*/
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] point = new int [n];
		for(int i =0; i<n; i++)
		{
			point[i] = sc.nextInt();
		}
		Arrays.sort(point);
		long sum =0;
		if(point[0]!=1)
		{
			sum+= (point[0]-1);
			point[0]=1;
		}
		for(int i=1; i<n; i++)
		{
			if(point[i]>point[i-1])
			{
				sum+= point[i]-(point[i-1]+1);
				point[i] = (point[i-1]+1);
			}
		}
		System.out.println(sum);
		
	}

}