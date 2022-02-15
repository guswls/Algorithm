//2022 카카오 블라인드 문제
import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int [id_list.length]; //전송결과 카운팅 배열
        int [][] check = new int [id_list.length][id_list.length]; //[신고자][신고당한사람]
        for(int i =0; i<report.length; i++)
        {//신고 내역을 파악하기 위한 for문
            String str = report[i];
            String str1 = str.split(" ")[0]; //신고자
            String str2 = str.split(" ")[1];// 신고당한사람
            int a=0;
            int b =0;
            for(int j=0; j<id_list.length; j++)
            {//신고자와 신고당한사람이 누군지 파악해서 check 배열에 넣는 for문
                if(str1.equals(id_list[j]))
                    a = j;
                if(str2.equals(id_list[j]))
                    b=j;  
            }
            if(check[a][b]==1) //이미 신고한 내역이 있기때문에 패스 
                continue;
            else check[a][b] ++;
        }
        
        //k번 이상 했는지 여부 파악하기
        for(int i =0; i<id_list.length; i++)
        {//열 합산
            int sum =0;
            for(int j =0; j<id_list.length; j++)
            {//행
                sum+=check[j][i];
            }
            if(sum>=k)
            {
                for(int j =0; j<id_list.length; j++)
                {//행
                    if(check[j][i]==1)
                        answer[j]++;
                }
            }
        }     
        return answer;
    }
}
