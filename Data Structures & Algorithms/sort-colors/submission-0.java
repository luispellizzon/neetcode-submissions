class Solution {
    public void sortColors(int[] nums) {
        int[] buckets = new int[3];

        for(int i = 0; i < nums.length; i++){
            buckets[nums[i]]++;
        }

        int i = 0;
        for(int idx = 0; idx < buckets.length; idx++){
            int freq = buckets[idx];
            while(freq != 0){
                nums[i] = idx;
                freq--;
                i++;
            }
        }
    }
}