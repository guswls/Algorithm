import java.io.*;
import java.util.*;
/*
문제)
짝수 => /2 홀수 = *3+1
=> 1이될때까지 횟수 
*/
class Solution {
    public int solution(int num) {
        long num2 = num;
        int answer = 0;
        while(true){
            if(num2%2==0){
                num2= num2/2;
            }        
            else{
                num2 = num2*3+1;
            }        
            answer++;
            if(answer==500 ||num2==1)
                break;
        }
        if(answer == 500)
            answer=-1;
        if(num ==1)
            answer =0;
        return answer;
    }
}
