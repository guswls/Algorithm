import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Long> s = new Stack<>();
		long result =0;
		for(int i =0; i<n; i++)
		{
			long high = sc.nextLong();
			while(!s.isEmpty()) {
				if(s.peek()<=high)
					s.pop();
				else
					break;
			}
			result+=s.size();
			s.push(high);
		}
		System.out.println(result);
		
	}

}