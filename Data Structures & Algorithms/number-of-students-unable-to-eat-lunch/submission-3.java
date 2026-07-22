class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
      Deque<Integer> stack = new ArrayDeque<Integer>();

        for(int i = sandwiches.length - 1; i >=0; i--){
            stack.push(sandwiches[i]);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int student:students){
            queue.add(student);
        }

        int tries = 0;
        while(tries < stack.size() && queue.peek() != null){
            int currStudent = queue.poll();
            int currFood = stack.peek();

            if(currStudent == currFood){
                stack.pop();
                tries = 0;
            } else {
                queue.add(currStudent);
                tries++;
            }
        }

        return tries;
    }
}