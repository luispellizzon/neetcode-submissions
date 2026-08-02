class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        long z = 0;
        while(left <= right){
            long mid  = left + (right - left) / 2;

            if(mid * mid == x){
                return (int) mid;
            } else if(mid*mid < x){
                z = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (int)z;
    }
}