import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N; 
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		
		for(int i =0; i<N; i++)
		{
			arr.add(sc.nextInt());
		}
		dfs(arr, 0);
		System.out.println(max);
		
	}
	static void dfs(ArrayList<Integer>arr, int mul) {
		if(arr.size()<=2)
		{
			if(max<mul) {
				max = mul;
			}
			return;
		}
		for(int i =1; i<arr.size()-1; i++)
		{
			int temp = arr.get(i);
			int a = arr.get(i-1)*arr.get(i+1);
			arr.remove(i);
			dfs(arr,mul+a);
			arr.add(i,temp);
		}
		
	}

}