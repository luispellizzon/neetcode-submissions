class KthLargest {
    // private PriorityQueue<Integer>
    private PriorityQueue<Integer> minHeap;
    private int k;

    // public KthLargest(int k, int[] nums) {
    //     this.k = k;
    //     for(int num: nums){
    //         heap.add(num);
    //     }
    // }
    
    // public int add(int val) {
    //     heap.add(val);
    
    //     if(heap.size() > k){
    //         heap.poll();
    //     }

    //     return heap.peek();
    // }
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
