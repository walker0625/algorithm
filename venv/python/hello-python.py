"""
for i in range(2,10):
    for j in range(1,10):
        print("{} x {} = {}".format(i, j, i*j))
"""

"""
numbers = range(10)
odd_numbers = []

for n in numbers:
    if n % 2 == 1:
        odd_numbers.append(n)

print(odd_numbers)
"""

"""
numbers = range(10)
odd_numbers = []

odd_numbers = [number for number in numbers if number % 2 == 1]

print(odd_numbers)
"""

"""
for n in range(10):
    if n%2 == 0:
        continue
    print(n)
    if n == 7:
        break
"""


def twoSum(nums, target):
    n = len(nums)
    for i in range(n):
        for j in range(i+1, n):
            if nums[i] + nums[j] == target:
                return True
    return False

print(twoSum(nums=[1,2,3,4,5], target=7))
        
                
