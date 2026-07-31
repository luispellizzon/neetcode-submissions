class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1) return nums[0];

        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int num: nums){
            heap.offer(num);
        }

        int element = heap.poll();
        int counter = 1;
        while(counter < k){
            element = heap.poll();
            counter++;
        }

        return element;
    }
}
