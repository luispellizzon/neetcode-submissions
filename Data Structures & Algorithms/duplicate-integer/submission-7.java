class Solution {
    public boolean hasDuplicate(int[] nums) {
        int slow = 0;
        int fast = slow + 1;
        Arrays.sort(nums);
        if(nums.length == 0 || nums.length ==1) return false;
        while(fast < nums.length){
            if(nums[slow] == nums[fast]) return true;
            slow++;
            fast++;
        }

        return false;
    }
}