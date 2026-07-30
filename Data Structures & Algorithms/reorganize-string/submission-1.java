

class Solution {
    public class CharCount{
        char ch;
        int count;
        public CharCount(char ch, int count){
            this.ch = ch;
            this.count = count;
        };
    }
    public String reorganizeString(String s) {
        Map<Character, Integer> charFrequency = new HashMap<>();

        for(char ch: s.toCharArray()){
            charFrequency.putIfAbsent(ch, 0);
            charFrequency.put(ch, charFrequency.get(ch) + 1);
        }

        PriorityQueue<CharCount> maxHeap = new PriorityQueue<>((a,b) -> {
            return Integer.compare(b.count, a.count);
        });

        for(Map.Entry<Character, Integer> charEntry: charFrequency.entrySet()){
            char ch = charEntry.getKey();
            int count = charEntry.getValue();
            maxHeap.add(new CharCount(ch, count));
        }

        CharCount prev = null;
        StringBuilder res = new StringBuilder();
        while(!maxHeap.isEmpty() || prev != null){
            if(maxHeap.isEmpty() && prev != null){
                return "";
            }
            CharCount current = maxHeap.poll();
            res.append(current.ch);
            current.count -= 1;
            
            if(prev != null){
                maxHeap.add(prev);
                prev = null;
            }

            if(current.count > 0){
                prev = current;
            }
        }

        return res.toString();
    }
}