
# 난이도 브2

#문제설명 
# M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합


n, m = map(int, input().split()) #입력 
num = list(map(int, input().split())) # 배열 입력 
length = len(num)
res = 0

# case1 :  삼중 for문으로 구하기 
for i in range(n):
    for j in range(i+1, n):
        for k in range(j+1, n):
            sum = num[i] + num[j]+ num[k]
            if sum <=m:
                res = max(res, sum)
print(res)


#case 2 : itertools 라이브러리 이용하기 

from itertools import permutations

per = permutations(num,3) # 3개 조합
for i in per:
    if(m>= sum(i)): # 조합 배열에 있는거 3개 더하기 
        res = max(res, sum(i))
print(res)
        
