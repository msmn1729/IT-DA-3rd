n = int(input())
m = int(input())
dictionary = {}
for i in range(1, m + 1):
    dictionary[i] = []


for i in range(m):
    a, b = input().split()
    x, y = int(a), int(b)
    dictionary[x].append(y)


def invite(start_v):
    discovered = [start_v]
    queue = [start_v]
    v = queue.pop(0)
    for w in dictionary[v]:
        if w not in discovered:
            discovered.append(w)
            queue.append(w)
    while queue:
        v = queue.pop(0)
        for w in dictionary[v]:
            if w not in discovered:
                discovered.append(w)
    discovered.pop(0)
    return discovered

print(len(invite(1)))

