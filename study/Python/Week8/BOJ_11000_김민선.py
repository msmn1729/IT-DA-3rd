#시간초과
import sys

N = int(sys.stdin.readline())
st = list()
for i in range(N):
    S,T = map(int,sys.stdin.readline().split())
    if S in st and st.index(S) % 2 != 0:
        st[st.index(S)+1:st.index(S)+1]=S,T
    else:
        st.append(S); st.append(T)

classroom = 1
for i in range(2,len(st),2):
    if st[i] < st[i-1] : classroom += 1

print(classroom)