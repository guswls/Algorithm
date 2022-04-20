import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<int[]> s = new Stack<>();
		for (int i = 0; i < N; i++) {
			int top = Integer.parseInt(st.nextToken());
			while (!s.isEmpty()) {
				if (s.peek()[0] < top) {// 그 뒤 입력도 top이전의 입력은 수신할 수 없기 때문에 제거가능
					s.pop();
				} else {// 아니라면 이전탑의 번호 출력
					System.out.print(s.peek()[1] + " ");
					break;
				}
			}
			if (s.empty()) {
				// 탑 비어있으면 0
				System.out.print("0" + " ");
			}
			s.push(new int[] { top, i + 1 });// stack에 탑의 높이와 번호를 넣는다
		}
	}
}