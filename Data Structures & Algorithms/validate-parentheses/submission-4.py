class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) == 0:
            return False

        openBracket = {
            "(": ")",
            "{": "}",
            "[": "]"
        }

        closeBracket = {
            ")": "(",
            "}": "{",
            "]": "["
        }

        stack = []

        for char in s:
            if char in closeBracket:
                if len(stack) == 0:
                    return False
                lastInTheStack = stack[-1]
                if lastInTheStack in openBracket and openBracket[lastInTheStack] == char :
                    stack.pop()
                else:
                    return False
            else:
                stack.append(char)
        
        if len(stack) > 0:
            return False
        return True
            
