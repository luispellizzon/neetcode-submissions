class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int num: piles){
            max = Math.max(num, max);
        }
        int l = 1;
        int r = max;
        int res = r;
        while(l <= r){
            int k = l + (r - l) / 2;
            long hours  = 0 ;
            for(int num: piles){
                hours += (num + k - 1) / k ;
            }
            if(hours <= h){
                res = k;
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return res;

    }
}
