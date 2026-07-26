class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] solution = new int[2];

        for(int i = 0; i < numbers.length; i++){
            if(i == numbers.length - 1){
                break;
            }
            for (int j = i + 1; j < numbers.length; j++){
                int currtSum = numbers[i] + numbers[j];
                if(currtSum == target){
                    solution[0] = i + 1;
                    solution[1] = j + 1;
                }
            }
        }

        return solution;
    }
}
