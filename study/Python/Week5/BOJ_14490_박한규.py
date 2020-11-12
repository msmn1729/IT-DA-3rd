import sys
import math

s = sys.stdin.readline()
a = int(s[:s.index(":")])
b = int(s[s.index(":")+1:])
gcd = math.gcd(a, b)
print("{}:{}".format(a//gcd, b//gcd))