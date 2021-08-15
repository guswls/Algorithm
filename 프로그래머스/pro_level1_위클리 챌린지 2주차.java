import java.io.*;
import java.util.*;
/*
문제)
1.배열의 행 별로 평균내서 학점부여 
2. 자기 평가 -> 유일한 최고점, 최저점일땐 제외
풀이)
1. 각 행의 max, min 판단 -> (n,n)제외하고
2. n,n을 max, min과비교해서 최고 혹은 최저 일 경우 sum에서 빼주고 평균을 낸다. 
3. 평균에 따라 학점 문자열에 넣기 */

class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        for(int col =0; col<scores.length; col++){
            int sum =0; 
            double avg =0;
            int max =0; // 최댓값
            int min =100;

            for(int row = 0; row <scores.length; row++){
                if(row!=col){
                    if(max<scores[row][col])
                        max = scores[row][col];
                    if(min>scores[row][col])
                        min = scores[row][col];
                }
                sum+=scores[row][col];
            }
            
            // 유일한지 체크
            if(max<scores[col][col] ||min>scores[col][col] )
            {
                sum -=scores[col][col];
                avg = sum/(scores.length-1);
            }
            else
                avg = sum/scores.length;            
            //학점으로 변환
           
            if(avg>=90)
                answer+='A';
            else if(avg>=80 && avg<90)
                answer+='B';
            else if(avg>=70 && avg<80)
                answer+='C';
            else if(avg>=50 && avg<70)
                answer+='D';
            else
                answer+='F';
        }
        return answer;
    }
}
