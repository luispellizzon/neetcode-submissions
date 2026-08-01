class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = nums1.clone();
        int first = 0;
        int second = 0;
        int writeIdx = 0;
        int[] arr = new int[m+n];
        while(first < m && second < n){
            if(nums1Copy[first] <= nums2[second]){
                nums1[writeIdx] = nums1Copy[first];
                first++;
                writeIdx++;
            } else {
                nums1[writeIdx] = nums2[second];
                second++;
                 writeIdx++;
            }
        }

        while(first < m){
            nums1[writeIdx] = nums1Copy[first];
            first++;
            writeIdx++;
        }

        while(second < n){
            nums1[writeIdx] = nums2[second];
            second++;
            writeIdx++;
        }
    }
}