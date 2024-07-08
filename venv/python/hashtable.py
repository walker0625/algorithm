### twon_sum : target 14

def two_sum(nums, target):

    numsDic = {}

    for n in nums:
        numsDic[n] = True

    for n in numsDic:
        need_number = target-n
        if n != need_number and need_number in numsDic:
            return True
        #if need_number in nums : 리스트에서 바로 찾는 경우 O(1)이 아니라 O(n)의 동작이 됨(순회하면서 있는지 확인)
        #   return True
        
    return False

print(two_sum([4,1,5,7,9,3,16], 14))


### consecutive seq

def consecutiveSeq(nums):

    longest = 0
    num_dict = {}

    for n in nums:
        num_dict[n] = True

    for n in num_dict:
        if n-1 not in num_dict:
            count = 1
            target = n+1
            while target in num_dict:
                count += 1
                target += 1
            longest = max(longest, count)    

    return longest

print(consecutiveSeq([6, 7, 100, 5, 4, 4]))


def consecutiveSeq2(nums): # value값으로 target을 대체
    
    longest = 0
    num_dict = {}

    for n in nums:
        num_dict[n] = n+1

    for n in num_dict:
        if n-1 not in num_dict:
            count = 1
            target = num_dict[n]
            while target in num_dict:
                count += 1
                target += 1
            longest = max(longest, count)

    return longest

print(consecutiveSeq2([6, 7, 100, 5, 4, 4]))


def consecutiveSeq3(nums): # set 자료구조로 대체
    
    longest = 0
    num_set = set(nums)

    for n in num_set:
        if n-1 not in num_set:
            count = 1
            target = n + 1
            while target in num_set:
                count += 1
                target += 1
            longest = max(longest, count)

    return longest

print(consecutiveSeq3([6, 7, 100, 5, 4, 4]))