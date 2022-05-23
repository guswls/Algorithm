import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		int count=0;
		int acount;
		int min=b.length();
		int k = b.length()- a.length();

		char[] arr = new char[a.length()];
		
		for (int i = 0; i < a.length(); i++) {
			arr[i]= a.charAt(i); 
		}
		char[] arr2 = new char[b.length()];
		for (int i = 0; i < b.length(); i++) {
			arr2[i]= b.charAt(i); 
		}
		
		if(a.length() ==b.length())
		{
			for (int i = 0; i < b.length(); i++) {
				if(arr[i]!=arr2[i])
					count++;
			}			
			System.out.println(count);
		}	
		else  {	
			for (int i = 0; i <=k; i++) {
				acount=0;
				for (int j = 0; j < arr.length; j++) {
					if(arr[j]!=arr2[j+i])
					{
						acount++;
					}	
				}
				if(acount<min)
					min =acount;
			}
			System.out.println(min);		
		}
		
	}

}