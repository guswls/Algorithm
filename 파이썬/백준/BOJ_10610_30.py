#난이도 : 실4

#문제 : 숫자 조합 -> 30의 배수 중 가장 큰수 -> 3의배수 +10의 배수 
# 풀이 :
# 입력받은 수중 0 없으면 탈락 
# 문자의 합이 3의 배수가 아니면 탈락 

# 주의 : 
# 위의 조건에 맞다면 가장 큰수는 숫자를 내림차순으로 정렬했을 때가 가장 큰 결과값

n = input()
n = sorted(n, reverse=True)  # 큰순으로 정렬 
sum = 0 
if '0' not in n:
    print(-1)
else:
    for i in n:
        sum += int(i) # 자리 더해주기
    if  sum %3 !=0:
        print(-1)
    else:
        print(''.join(n))
