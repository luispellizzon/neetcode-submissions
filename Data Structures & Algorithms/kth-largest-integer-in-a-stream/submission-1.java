class KthLargest {
    // private PriorityQueue<Integer>
    private List<Integer> nums = new ArrayList<>();
    private int k;
    private int current;

    public KthLargest(int k, int[] nums) {
        if(nums.length > 0){
            for(int num: nums){
                this.nums.add(num);
            }
            Collections.sort(this.nums);
        }
        this.k = k;
    }
    
    public int add(int val) {
        nums.add(val);
        Collections.sort(this.nums);
        this.current = nums.get(this.nums.size() - k);
        return current;
    }
}
