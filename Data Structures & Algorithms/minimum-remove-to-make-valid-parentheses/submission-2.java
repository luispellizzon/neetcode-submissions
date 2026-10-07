class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder tracker = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < tracker.length(); i++){
            if(tracker.charAt(i) == '('){
                stack.push(i);
            } else if(tracker.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                } else {
                    tracker.setCharAt(i, '\0');
                }
            }
        }

        while(!stack.isEmpty()){
            tracker.setCharAt(stack.pop(),'\0');
        }

        StringBuilder result = new StringBuilder();

        for(int i = 0 ; i < tracker.length(); i++){
            if(tracker.charAt(i) != '\0'){
                result.append(tracker.charAt(i));
            }
        }

        return result.toString();
    }
}