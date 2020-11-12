import sys

class Node:
    def __init__(self,key,data=None):
        self.key = key
        self.data = data # 원래 구현은 이렇게 하지만 이 문제에서는 딱히 없어도 된다.
        self.children = {}
        
class Trie:
    def __init__(self):
        self.root=Node(None)
    
    def insert(self,phone_num):
        current_node = self.root
        for i in phone_num:
            if i not in current_node.children:
                current_node.children[i] = Node(i)
            current_node = current_node.children[i]
        
        current_node.data = phone_num
        
    def search_prefix(self, phone_num):
        current_node = self.root
        
        for i in phone_num:
            current_node = current_node.children[i]
        
        if current_node.children: # 자식이 있으면
            return False
        else:
            return True
    
if __name__ == "__main__":
    for _ in range(int(input())):
        n = int(input())
        
        if n == 1:
            print('YES')
            continue
        
        lst = []
        trie = Trie()
        
        for _ in range(n):
            num = input()
            trie.insert(num)
            lst.append(num)

        flag = True
        for p in lst:
            if not trie.search_prefix(p):
                flag = False
                break
        
        if flag:
            print('YES')
        else:
            print('NO')
        
