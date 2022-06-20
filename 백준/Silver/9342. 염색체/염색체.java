import java.io.*;
import java.util.*;
public class Main {
static int N;
static String no = "Good";
static String yes = "Infected!";
public static void main(String[] args) throws IOException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
N = Integer.parseInt(st.nextToken());
for(int i=0; i<N; i++){
if(parser(br.readLine())){
System.out.println(yes);
}else{
System.out.println(no);
}
}
}
public static boolean parser(String s){
String pattern = "^[A-F]?A+F+C+[A-F]?$";
boolean val = s.matches(pattern);
return val;
}
}
