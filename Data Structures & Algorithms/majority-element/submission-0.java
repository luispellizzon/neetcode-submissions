class Solution {
    public class Entry{
        int number;
        int count;
        public Entry(int number, int count){
            this.number = number;
            this.count = count;
        }
    }
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Entry> heap = new PriorityQueue<>((a,b) -> Integer.compare(b.count, a.count));
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            heap.add(new Entry(entry.getKey(), entry.getValue()));
        }

        return heap.peek().number;
    
    }
}