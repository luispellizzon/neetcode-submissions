

class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        //build freq
        for(int i = 0; i < s.length(); i++){
            if(freq.containsKey(s.charAt(i))){
                freq.put(s.charAt(i), freq.get(s.charAt(i)) + 1);
            } else {
                freq.put(s.charAt(i), 1);
            }
        }

        
        //[count, char]
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));

        freq.forEach((k, v) -> heap.add(new int[]{v, k}));

        StringBuilder res = new StringBuilder();

        int[] prev = null;
        while(!heap.isEmpty() || prev != null){
            if(prev != null && heap.isEmpty()){
                return "";
            }

            int [] current = heap.poll();
            char chToAppend = (char)current[1];
            res.append(chToAppend);
            current[0]--;

            if(prev != null){
                heap.add(prev);
                prev = null;
            }

            if(current[0] > 0){
                prev = current;
            }
        }

        return res.toString();
    }
}