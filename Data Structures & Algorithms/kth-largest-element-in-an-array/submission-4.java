class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1) return nums[0];

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int num: nums){
            heap.offer(num);
            if(heap.size() > k){
                heap.poll();
            }
        }

        return heap.poll();
    }
}
