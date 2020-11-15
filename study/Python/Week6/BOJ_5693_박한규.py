from collections import deque
import sys
read = sys.stdin.readline

tree = deque()
while True:
    a = read()
    if a == '\n':
        break
    else:
        tree.append(a)

for i in range(len(tree)):
    if tree[i] < tree[i+1]:
        print(tree.pop(i))







# import sys
# read = sys.stdin.readline
#
# class Node:
#     def __init__(self, data):
#         self.data = data
#         self.left = None
#         self.right = None
#
# def init_tree(root, i):
#     new_node = Node(i)
#
#     if root == i:
#        root = new_node
#     if root > i:
#         if root.right is None:
#             tmp = root
#             root = new_node
#             root.right = tmp
#         elif root.left is None:
#             root.left = new_node
#         elif root.left is not None:
#             init_tree(root.left, i)
#     elif root < i:
#         if root.right is None:
#             root.right = new_node
#         else:
#             init_tree(root.right, i)
#
# def postorder_traverse(node):
#     if node == None: return
#     postorder_traverse(node.left)
#     postorder_traverse(node.right)
#     print(node.data)
#
#
# tree = []
# while True:
#     a = read()
#     if a == '\n':
#         break
#     else:
#         tree.append(a)
#
# for i in range(len(tree)):
#     init_tree(tree[0], tree[i])
#
# postorder_traverse(tree[0])
#
#
#
#
#
