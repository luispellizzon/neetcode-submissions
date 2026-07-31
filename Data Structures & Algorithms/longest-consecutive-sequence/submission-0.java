class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        Set<Integer> set = new HashSet<>();

        for(int num: nums){
            set.add(num);
        }   

        int maxSeq = 0;
        for(int num: set){
            if(!set.contains(num-1)){
                int currentSeq = 1;
                int currentNum = num;
                while(set.contains(currentNum +1)){
                    currentSeq++;
                    currentNum ++;
                }
                maxSeq = Math.max(maxSeq, currentSeq);
            }
        }

        return maxSeq;
    }
}
