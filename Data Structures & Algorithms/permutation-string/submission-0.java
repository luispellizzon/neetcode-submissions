class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        // sort s1
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch: s1.toCharArray()){
            if(freqMap.containsKey(ch)){
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
                freqMap.put(ch, 1);
            }
        }

        for(int i = 0; i <= s2.length() - s1.length(); i++){
            if(freqMap.containsKey(s2.charAt(i))){
                Map<Character,Integer> copyMap = new HashMap<>();
                for(int j = i; j < i + s1.length(); j++){
                    char ch = s2.charAt(j);
                    if(copyMap.containsKey(ch)){
                        copyMap.put(ch, copyMap.get(ch) + 1);
                    } else {
                        copyMap.put(ch, 1);
                    }
                }

                if(freqMap.equals(copyMap)){
                    return true;
                }
            }
        }


        return false;


    }
}
