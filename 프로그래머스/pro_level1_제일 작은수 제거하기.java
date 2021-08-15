import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer ={};
        if(arr.length <=1)
        {//arr 길이가 1일때 
            int [] answer2 = {-1};
            return answer2;
        }     
        answer = new int [arr.length-1];    
        int [] rearr = new int [arr.length]; // 복사 배열
        for(int i =0; i<arr.length; i++)
        {
            rearr[i] = arr[i];
        }
        Arrays.sort(rearr);
        //배열 첫번째 자리를 뺀 나머지를 answer배열에 넣어줌 
        int count=0;
        for(int i =0; i<arr.length;i++)
        {
            if(rearr[0] != arr[i])
                answer[count++] = arr[i];
        }
        return answer;
    }
}
