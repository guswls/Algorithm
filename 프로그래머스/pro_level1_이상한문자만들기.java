import java.io.*;
import java.util.*;
/*
1. 문자열 전체가 아닌 단어별로 인덱스 판단을 해야한다.  => 단어를 분리하자
2. String 배열로 분리한다.
3. 배열에 공백이 있을때는 count , 즉 인덱스 값을 0으로 초기화 해준다.
4. toLowerCase()(소->대), toUpperCase() (대->소)를 이용해서 변환해준다.
*/
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] ans = s.split("");
        int count =0; // 공백이 생겼을때 다시 0으로 
        for(int i=0; i<ans.length; i++)
        {
            if(ans[i].equals(" "))
                count=0;
            else if(count %2 ==0)
            {
                ans[i] = ans[i].toUpperCase();
                count++;
            }else{
                ans[i] = ans[i].toLowerCase();
                count++;
            }
             answer+=ans[i];
        }
        
        return answer;
    }
}
