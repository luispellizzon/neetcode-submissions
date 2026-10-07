class Solution {
    class Element{
        int number;
        int frequency;
    
        public Element(int number, int frequency){
            this.number = number;
            this.frequency = frequency;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a,b) ->{
            if(a.frequency != b.frequency){
                return Integer.compare(a.frequency, b.frequency);
            } else {
                return Integer.compare(b.number, a.number);
            }
        });

        HashMap<Integer, Integer> map = new HashMap();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for(int num: map.keySet()){
            minHeap.add(new Element(num, map.get(num)));
        }

        while(minHeap.size() != k){
            minHeap.poll();
        }

        int[] res = new int[minHeap.size()];
        int idx = 0;
        while(!minHeap.isEmpty()){
            res[idx] = minHeap.poll().number;
            idx++;
        }

        return res;
    }
}
