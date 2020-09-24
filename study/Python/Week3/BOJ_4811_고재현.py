# 4811 알약

def sol(W, H):
  if dp[W][H] != 0:
    return dp[W][H] #여러번 계산하지 않기 위해서
  
  if W == 0 and H == 0:
    dp[W][H] = 1
    
  elif W > 0 and H == 0:
    dp[W][H] = sol(W - 1, H + 1)
    
  elif W == 0  and H > 0 :
    dp[W][H] = sol(0, H - 1)
    
  else:
    dp[W][H] = sol(W - 1, H + 1) + sol(W, H - 1)
    
  return dp[W][H]


dp = [[0] * 31 for _ in range(31)]
# dp[w][h] = 알약이 W,H개 남았을 때, 만들 수 있는 글자의 수

while True:
  N = int(input())
  if N == 0:
    break
  print(sol(N, 0))
