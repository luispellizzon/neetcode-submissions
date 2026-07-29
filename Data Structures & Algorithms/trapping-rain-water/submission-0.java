
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int totalWater = 0;
        for (int i = 0; i < n; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = 0; j <= i; j++) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            totalWater += Math.min(maxLeft, maxRight) - height[i];
        }
        return totalWater;
    }
}
