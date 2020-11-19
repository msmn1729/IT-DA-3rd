import sys

def search(numbers):
  numbers.sort()
  for i in range(len(numbers)-1):
    if numbers[i] in numbers[i+1]:
      return False
  return True


test = int(input())
numbers=[]
answer = []

for i in range(test):
  leng = int(input())
  for _ in range(leng):
    numbers.append(sys.stdin.readline().strip())
  answer.append(search(numbers))
  numbers.clear()

for i in answer:
  if i == True:
    print("YES")
  else:
    print("NO")
