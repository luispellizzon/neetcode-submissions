class Solution {
    public boolean isPalindrome(String s) {
      String filtered = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();

      int l = 0;
      int r = filtered.length()-1;

      while(l<r){
        if(filtered.charAt(l) != filtered.charAt(r)){
            return false;
        }

        l++;
        r--;
      }

      return true;
    }
}
