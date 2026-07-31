class Solution {
    public String longestCommonPrefix(String[] strs) {
        String[] dic = strs;
        if(dic.length == 1){
            return dic[0];
        }

        StringBuilder lcp = new StringBuilder(); 
        String prefix = dic[0];
        for(int i = 0; i < prefix.length(); i++){
            char candidate = prefix.charAt(i);
            for(int j = 1; j < dic.length; j++){
                if(i >= dic[j].length() || dic[j].charAt(i) != candidate){
                    return lcp.toString();
                }
            }
            lcp.append(candidate);
        }

        return lcp.toString();

    }
}