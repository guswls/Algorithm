# 문제 설명 
'''
그룹단어 : 문자가 연속해서 나오는 경우  
ex) ccazzzzbb c, a, z, b  -> O
ex2) aabbbccb  b가 떨어져서 나타남 ->X
그룹단어의 수는?
''' 
# 풀이 
'''
문자열 첫 원소부터 나머지 원소 비교 > 같은거 확인 
다음원소랑 같지 않은데 그 뒤꺼랑 같으면 그룹단어 x
'''


n = int(input()) # 입력 
count = n 
#n만큼의 입력 받기 
for i in range(n):
    word = input()  # 단어 입력
    for idx in range(0,len(word)-1): # 0부터 단어길이-1까지 for문
        if word[idx] == word[idx+1]: #연속 확인
            continue
        elif word[idx] in word[idx+1:]:  #단어의 idx 부터 그 뒤로 단어 있는지 확인
            count-=1
            break
print(count)
