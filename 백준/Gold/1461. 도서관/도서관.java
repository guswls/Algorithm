import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer> plus = new ArrayList<>();
		ArrayList<Integer> minus = new ArrayList<>();
		int result = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (a < 0)
				minus.add(a);
			else
				plus.add(a);
		}
		// 마이너스랑 플러스 나눠서 넣기
		Collections.sort(plus, Collections.reverseOrder());// 플러스는 내림차순으로 정렬
		Collections.sort(minus);

		for (int i = 0; i < minus.size(); i += M) {
			result += (Math.abs(minus.get(i))) * 2;
		}
		// 마이너스 계산
		for (int i = 0; i < plus.size(); i += M) {
			result += (Math.abs(plus.get(i))) * 2;
		} // 플러스 계산

		// 여기서 리스트 빈것 체크 안하면 런타임 오류남 
		// 반례 
		/*5 2
		 * 1 2 3 4 5
		 * */
		if (!minus.isEmpty() & !plus.isEmpty()) {
			if (Math.abs(minus.get(0)) >= Math.abs(plus.get(0))) {
				// 마이너스가 크니까 한번 더했던걸 빼주기
				result -= (Math.abs(minus.get(0)));
			} else {
				result -= (Math.abs(plus.get(0)));
			}
		}
		else {
			if(minus.isEmpty())
				result -= (Math.abs(plus.get(0)));
			else
				result -= (Math.abs(minus.get(0)));
		}
		System.out.println(result);

	}
}
