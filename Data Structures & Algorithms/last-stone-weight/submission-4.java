class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1){
            return stones[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int num: stones){
            heap.add(num);
        }

        while(heap.size() > 1){
            int stone1 = heap.poll(); 
            int stone2 = heap.poll(); 
            int diff = stone1 - stone2;
            if(diff > 0){
                heap.add(diff);
            }
        }

        return heap.size() > 0? heap.poll(): 0;
    }
}
