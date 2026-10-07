class Solution {
    public boolean isAnagram(String s, String t) {
        int[] dict1 = new int[26];
        int[] dict2 = new int[26];

        for(char letter: s.toCharArray()){
            int idx = Character.toLowerCase(letter) - 'a';
            dict1[idx]++;
        }

        
        for(char letter: t.toCharArray()){
            int idx = Character.toLowerCase(letter) - 'a';
            dict2[idx]++;
        }

        return Arrays.equals(dict1, dict2);
    }
}
