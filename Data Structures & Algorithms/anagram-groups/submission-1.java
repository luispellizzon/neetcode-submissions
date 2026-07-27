class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        String[] sorted = strs.clone();
        for(int i = 0; i < strs.length; i++){
            char[] string = strs[i].toCharArray();
            Arrays.sort(string);
            sorted[i] = new String(string);
        }

        Map<String, List<String>> hashMap = new HashMap<>();

        for(int i = 0; i < sorted.length; i++){
            if(hashMap.containsKey(sorted[i])){
                hashMap.get(sorted[i]).add(strs[i]);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                hashMap.put(sorted[i], newList );
            }
        }    

        hashMap.forEach((key, val) ->{
            res.add(val);
        });
    
        return res;
    }


}
