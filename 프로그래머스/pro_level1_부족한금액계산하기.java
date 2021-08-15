import java.io.*;
import java.util.*;
/*
문제)
N번째이용 : price*N
놀이기구 count번 타면 가진금액에서 얼마나 모자라는지 
-> 부족하지 않으면 0리턴
풀이)
1.count만큼 for문 돌면서 총금액을 구한다
2. 총금액-가진값 = result
3. result가 0이하면 0리턴*/

class Solution {
    public long solution(int price, int money, int count) {
        long rp=0;
        for(int i=1; i<=count;i++)
        {
            rp+=i*price;
        }
        long answer = 0;
        answer = rp-money;
        if(answer>0)
            return answer;
        else
            return 0;
    }
}
