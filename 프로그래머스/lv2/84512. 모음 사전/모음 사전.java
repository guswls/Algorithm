import java.util.*;

class Solution {
    public int solution(String word) {
        int answer = 0;
        int len = word.length();
        int max =0; 
      
        for(int i =1; i<=5; i++)
        { // 최대 값
             max += Math.pow(5, i);
        }
          for (int i = 1; i <= len; i++) {
            if (word.charAt(i-1) == 'A') {
                answer += 1;
            } else if (word.charAt(i-1) == 'E') {
                answer += ((max / Math.pow(5, i)) * 1) + 1;
            } else if (word.charAt(i-1) == 'I') {
                answer += ((max / Math.pow(5, i)) * 2) + 1;
            } else if (word.charAt(i-1) == 'O') {
                answer += ((max / Math.pow(5, i)) * 3) + 1;
            } else {
                answer += ((max / Math.pow(5, i)) * 4) + 1;
            }
        }
        return answer;
    }
}
