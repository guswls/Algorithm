import java.io.*;
import java.util.*;
/*
목표 : 최대한 많은 부서 물품 구매
구매시 신청금액 전액 지원 

풀이)
1. 최대한 많은 부서 지원 -> 금액이 가장 적은 곳 부터 
2. budget에서 빼주면서 count
*/
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i = 0; i<d.length; i++)
        {
            if(budget>=d[i])
            {
                budget-=d[i];
                answer++;
            }
            else{
                break;
            }
        }
        return answer;
    }
}
