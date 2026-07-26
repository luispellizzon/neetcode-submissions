class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while(l < r){
            int low = numbers[l];
            int high = numbers[r];

            if(low + high == target){
                return new int[]{l+1, r+1};
            } if(low + high > target){
                r--;
            } else {
                l++;
            }
        }

        return new int[]{0,0};
    }
}
