class Solution {
    /**
     * @param {string} s
     * @return {boolean}
     */
    isValid(s) {
        const stack = [];
        const closeMatcher = {
            ')': '(',
            '}': '{',
            ']': '[',
        }

        for(const char of s){
            if(closeMatcher[char]){
                if(stack.length === 0) return false;
                if(stack.length > 0 && stack[stack.length - 1] === closeMatcher[char]){
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(char);
            }
        }

        return stack.length === 0 ? true : false;
    }
}
