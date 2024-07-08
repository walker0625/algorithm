"""
def twoSum(nums, target):
    n = len(nums)
    for i in range(n):
        for j in range(n):
            if nums[i] + nums[j] == target:
                return True
    return False

print(twoSum(nums = [1,2,3,4,5], target = 7))
"""

"""
def twoSum(nums, target):

    nums.sort()
    l, r = 0, len(nums) - 1

    while l<r:
        if nums[l] + nums[r] > target:
            r -= 1
        elif nums[l] + nums[r] < target:
            l += 1
        elif nums[l] + nums[r] == target:
            return True
        
    return False

print(twoSum(nums = [2,1,5,7], target = 4))
"""

"""
class Node :
    
    def __init__(self, value = 0, next = None):
        self.value = value
        self.next = next

class LinkedList(object):
    
    def __init__(self):
        self.head = None
    
    def append(self, value):
        new_node = Node(value)
        if self.head is None:
            self.head = new_node
        else:
            current = self.head
            while(current.next):
                current = current.next
            current.next = new_node

    def get(self, idx):
        current = self.head
        for _ in range(idx):
            current = current.next
        return current.value

ll = LinkedList()
ll.append(1)
ll.append(2)
ll.append(3)
ll.append(4)
print(ll.get(2))
"""

class Node(object):
    def __init__(self, val=0, prev=None, next=None):
        self.val = val
        self.prev = prev
        self.next = next

class History(object):
    def __init__(self, home):
        self.current = Node(val=home)
    def visit(self, url): 
        self.current.next = Node(val=url, prev=self.current)
        self.current = self.current.next
        return None
    def back(self, steps):
        while steps > 0 and self.current.prev != None:
            steps -= 1
            self.current = self.current.prev
        return self.current.val
    def forward(self, steps):
        while steps > 0 and self.current.next != None:
            steps -= 1
            self.current = self.current.next
        return self.current.val
    
history = History("www.naver.com")
history.visit("www.google.com")
history.visit("www.kakao.com")
history.visit("www.toss.com")
print(history.back(2))
