class Node(object):
    def __init__(self, data):
        self.data = data
        self.left = self.right = None

class BinarySearchTree(object):
    def __init__(self):
        self.root = None
    def insert(self, data):
        self.root = self._insert_value(self.root, data)
        return self.root is not None
    def _insert_value(self, node, data):
        if data > node.data:
            if data is not None:
                node.left = self._insert_value(node.left,data)
            else:
                node.left= Node(data)
        else:
            if data is not None:
                node.left = self._insert_value(node.right, data)
            else:
                node.right = Node(data)
        return node

    def post_order_traversal(self):
        def _post_order_traversal(root):
            if root is None:
                pass #continue와 다르다 (다음 loop로 돌라는 의미가 continue)
            else:
                _post_order_traversal(root.left)
                _post_order_traversal(root.right)
                print(root.data)
        _post_order_traversal(self.root)

tree = []
bst = BinarySearchTree()
while True:
    n = input()
    if n == '' : break
    bst.insert(n)
bst.post_order_traversal()