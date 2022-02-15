//2022 카카오 블라인드 문제 
import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int [] result = new int[10000];
        int [] visit = new int[10000];//in-out 체크 배열
        int [] time = new int[10000]; //누적시간 체크 배열 
        int [] time2 = new int[10000];//입출 한번씩 시간
        for(int i=0; i<records.length; i++)
        {
            String [] check = records[i].split(" ");
            String []timecount =check[0].split(":");
            int h = Integer.parseInt(timecount[0]);// 시
            int m = Integer.parseInt(timecount[1]);// 분
            int min = h*60+m;//시간 체크 -> 분으로 변경
            int num =Integer.parseInt(check[1]); //차량 넘버
            visit[num]++;
            if(visit[num]%2==0)
            {//한번 입차 기록이 있는 것이므로 
                time2[num]=Math.abs(time2[num]-min);//소요시간 체크 
                time[num]+=time2[num];
                time2[num]=0;
            }
            else{
                time2[num]+=min;
            }
        }
        // 모든 for문을 돌고 출차가 되지 않은 내역들
        for(int i =0; i<10000; i++)
        {
            if(visit[i]%2!=0)
            {
                time[i]+=Math.abs((23*60+59)-time2[i]);   
            }
        }
        //실제 요금 계산 
        int count =0;
        for(int i =0; i<10000;i++)
        {
            if(time[i]!=0){
                count++;
                if(time[i]<=fees[0])
                { //누적시간이 기본시간보다 작거나 같을 경우
                    result[i] +=fees[1];
                }
                else{//누적시간이 기본시간보다 클 경우
                    int s = (time[i]-fees[0]);
                    s= (time[i]-fees[0])/fees[2];
                    
                    if((time[i]-fees[0])%fees[2]!=0) //올림해주기 
                        s+=1;
                    result[i] += fees[1]+ s*fees[3];
                }
            }
        }
        int[] answer = new int[count];
        int k =0;
        for(int i =0; i<10000;i++)
        {
            if(visit[i]!=0)
                answer[k++]=result[i];
        }
        return answer;
    }
}
