class Solution {
    public boolean isValid(String s) {
        Map<Character,Character> map = Map.of(
            ']', '[',
            '}', '{',
            ')', '('
        );

        Deque<Character> q = new ArrayDeque<>();

        for(Character ch: s.toCharArray()){
            if(!q.isEmpty() && q.peek() == map.get(ch)){
                q.pop();
            } else{
                q.push(ch);
            }
        }

        return q.size() == 0;

    }
}
