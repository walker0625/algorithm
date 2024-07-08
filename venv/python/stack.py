"""
def isValidBrackets(str):
    
    stack = []

    for b in str:
        if b == "(":
            stack.append(")")
        elif b == "{":
            stack.append("}")
        elif b == "[":
            stack.append("]")
        elif not stack or stack.pop() != b:
            return False
        
    return not stack

print(isValidBrackets("({[]})"))
"""

def dailyTemperatures(temperatures):
    ans = [0] * len(temperatures)
    stack = []
    for cur_day, cur_temp in enumerate(temperatures):
        while stack and stack[-1][1] < cur_temp:
            prev_day, _ = stack.pop()
            ans[prev_day] = cur_day - prev_day
        stack.append((cur_day, cur_temp))
    return ans

print(dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]))