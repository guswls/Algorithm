import java.util.Scanner;
// 숫자별 맵핑
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		String n = sc.next();
		int c = s+2;
		int r = 2*s +3;
		int leng = n.length();
		char [][] result = new char[r][c*leng+leng-1];
		for(int i=0; i<result.length;i++)
		{
			for(int j =0; j<result[0].length;j++)
			{
				result[i][j] = ' ';
			}
		} //공백으로 채워주기
		//경우에 맞게 채워주기
		int blank = -1;// 
		for(int i =0; i<leng; i++)
		{
			// 세로선 -> 제일 오른쪽 위 ->s개만큼 |선 생김
			char a = n.charAt(i);
			int k = r*(i+1)+blank;
			if(n.charAt(i)!='5' &&n.charAt(i)!='6')
			{
				for(int j =1; j<r/2; j++)
				{
					result[j][c*(i+1)+blank] ='|';
				}
			}
			//세로선 2 -> 제일 오른쪽 아래 ->s개만큼 |선 생김
			if(n.charAt(i)!='2' )
			{
				for(int j =r/2+1; j<r-1; j++)
				{
					result[j][c*(i+1)+blank] ='|';
				}
			}
			//세로선 3 -> 제일 왼쪽 위 ->s개만큼 |선 생김
			if(n.charAt(i)!='1' &&n.charAt(i)!='2'&&
					n.charAt(i)!='3' && n.charAt(i)!='7')
			{
				for(int j =1; j<r/2; j++)
				{
					result[j][c*(i+1)+blank-c+1] ='|';
				}
			}
			//세로선 4 -> 제일 왼쪽 아래 ->s개만큼 |선 생김
			if(n.charAt(i)=='2' ||n.charAt(i)=='6'||
					n.charAt(i)=='8'||n.charAt(i)=='0')
			{
				for(int j =r/2+1; j<r-1; j++)
				{
					result[j][c*(i+1)+blank-c+1] ='|';
				}
			}
			// 가로선1 -> 맨 위
			if(n.charAt(i)!='1' &&n.charAt(i)!='4')
			{
				for(int j =c*(i+1)+blank-c+2; j<c*(i+1)+blank-c+2+s; j++)
				{
					result[0][j] ='-';
				}
			}
			//가로선2 -> 중간 
			if(n.charAt(i)!='1' &&n.charAt(i)!='7'&&n.charAt(i)!='0')
			{
				for(int j =c*(i+1)+blank-c+2; j<c*(i+1)+blank-c+2+s; j++)
				{
					result[r/2][j] ='-';
				}
			}
			//가로선3-> 마지막 줄
			if(n.charAt(i)!='1' &&n.charAt(i)!='4'&&n.charAt(i)!='7')
			{
				for(int j =c*(i+1)+blank-c+2; j<c*(i+1)+blank-c+2+s; j++)
				{
					result[r-1][j] ='-';
				}
			}
			
			blank++;//숫자 사이 공백 하나씩 늘려주기
		}
		for(int i=0; i<result.length; i++) {
            for(int j=0; j<result[0].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
	}

}