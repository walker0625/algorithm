### recursion

def factorial(n):
    if n == 1:
        return 1
    return n * factorial(n-1)


### Node & Make Tree

class TreeNode:
    def __init__(self, value=0, left=None, right=None):
        self.value = value
        self.left = left
        self.right = right

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
root.left.left = TreeNode(4)
root.left.right = TreeNode(5)
root.right.left = TreeNode(6)
root.right.right = TreeNode(7)
root.right.right.right = TreeNode(8)


### bfs(tree traversal)

from collections import deque

def bfs(root):
    visited = []
    
    if root is None:
        return []
    
    q = deque()
    q.append(root)
    
    while q:
        cur_node = q.popleft()
        visited.append(cur_node.value)

        if cur_node.left:
            q.append(cur_node.left)
        if cur_node.right:
            q.append(cur_node.right)

    return visited


### dfs

def dfs(cur_node):
    if cur_node is None:
        return
    
    print(cur_node.value) # 전위순회
    dfs(cur_node.left)
    print(cur_node.value) # 중위순회
    dfs(cur_node.right)
    print(cur_node.value) # 후위순회


### LCA

def LCA(root, p, q):
    if root == None:
        return None
    
    left = LCA(root.left, p, q)
    right = LCA(root.right, p, q)
    if root == p or root == q:
        return root
    elif left and right:
        return root
    return left or right


### Max Dept(bfs)

from collections import deque

def maxDepthByBFS(root):

    max_depth = 0

    if root is None:
        return 0
    
    q = deque()
    q.append((root, 1))

    while q:
        cur_node, cur_depth = q.popleft()
        max_depth = cur_depth # queue에 있는 depth가 가장 깊음
        if cur_node.left:
            q.append((cur_node.left, cur_depth + 1))
        if cur_node.right:
            q.append((cur_node.right, cur_depth + 1))

    return max_depth

print(maxDepthByBFS(root))


### Max Dept(dfs)

def maxDepthByDFS(root):

    if root is None:
        return 0 
    
    left = maxDepthByDFS(root.left)
    right = maxDepthByDFS(root.right)

    return max(left, right) + 1

print(maxDepthByDFS(root))