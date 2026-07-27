class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        for(char ch : tasks){
            if(freq.containsKey(ch)){
                freq.put(ch, freq.get(ch) + 1);
            } else {
                freq.put(ch, 1);
            }
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int val: freq.values()){
            maxHeap.add(val);
        }

        int time = 0;
        Queue<int[]> queue = new LinkedList<>();

        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time+=1;

            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll() - 1;
                if(count != 0){
                    queue.add(new int[]{count, time + n});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1] == time){
                maxHeap.add(queue.poll()[0]);
            }
        }

        return time;

    }
}
