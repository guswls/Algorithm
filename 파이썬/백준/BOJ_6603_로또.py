
#난이도 : 실2

# 어려웠던 점 : 프린트 출력 
# print(i, end=" ")-> (1,2,3,4,5,6)이런 형태 출력 
# print(*i) =>i개 만큼 출력해라
# 리스트-> 문자열로 출력하는 방법 
# 1. "".join(리스트이름)
import sys
from itertools import combinations  #조합
input = sys.stdin.readline

while True:
    num = list(map(int, input().split()))
    if num[0] == 0:
        break
    com = list(combinations(num[1:], 6))
    for i in com:
        print(*i)          
    print()
