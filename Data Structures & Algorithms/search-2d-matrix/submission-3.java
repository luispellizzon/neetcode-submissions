class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int row = 0; row < matrix.length; row++){
            int lastNum = matrix[row][matrix[row].length - 1];
            if(target == lastNum) return true;
            if(target < lastNum){
                for(int num: matrix[row]){
                    if(target == num) return true;
                }
            }
        }

        return false;
    }
}
