class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 1){
            return new ArrayList<>(List.of(nums[0]));
        }
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        int comparer = n / 3;
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > comparer){
                res.add(entry.getKey());
            }
        }

        return res;
    }
}