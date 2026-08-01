class Solution {
    public boolean isPalindrome(String s) {
        String filtered = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        int left = 0;
        int right = filtered.length()-1;
        
        while(left<right){
            if(filtered.charAt(left) != filtered.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
        
    }
}
