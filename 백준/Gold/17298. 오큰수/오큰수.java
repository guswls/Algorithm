import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
        int size = Integer.parseInt(br.readLine());
        // 배열 크기 저장
        String[] numbersStr = br.readLine().split(" ");
        // split 해서 배열에 저장
        int[] numbers = Arrays.stream(numbersStr).mapToInt(Integer::parseInt).toArray();
        // 크기 비교를 위해 int 배열로 변경
        int[] nge = new int[size];
        // 오큰수 담을 배열 생성
        Arrays.fill(nge, -1);
        // 배열 전체를 일단 -1로 초기화
 
        Stack<Integer> stack = new Stack<Integer>();
        // 스택 생성
        
        stack.push(0);
        // 첫번째 인덱스 저장
        
        for (int i = 0; i < size; i++) {
            
            while(!stack.isEmpty()) {
                // 스택이 빌 때 까지 반복한다
                if (numbers[i] > numbers[stack.peek()]) {
                    // stack의 가장 위 숫자와 숫자를 비교해서 크면
                    
                    nge[stack.pop()] = numbers[i];
                    // 그 전에 스택에 있던 숫자를 지우고
                    // 그 숫자를 그 전 인덱스의 오큰수로 넣는다
                } else {
                    // 작거나 같으면
                    stack.add(i);
                    // 스택에 집어 넣고
                    break;
                    // 반복을 종료한다
                }
            }
            
            if (stack.isEmpty()) {
                // 스택이 비어있으면
                stack.add(i);
                // 스택에 인덱스를 집어 넣는다
            }
        }
 
        for (int i = 0; i < size; i++) {
            bw.write(nge[i]+" ");
            // 배열에 있는 값을 출력
        }
        
        bw.flush();
        
        br.close();
        bw.close();
 
    }
 
}