class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();
        int first = 0;
        int second = 0;
        while(first < word1.length() && second < word2.length()){
            res.append(word1.charAt(first));
            res.append(word2.charAt(second));
            first++;
            second++;
        }

        if(first < word1.length()){
            res.append(word1.substring(first));
        }
        
        if(second < word2.length()){
            res.append(word2.substring(second));
        }

        return res.toString();
    }
}