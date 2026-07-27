class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        
        StringBuilder reversed = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed.append(s.charAt(i));
        }
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = reversed.length() - 1; j >= 0; j--){
                if(s.charAt(i) == reversed.charAt(j)){
                    dp[i][j] = 1 + dp[i + 1][j+ 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }

        return dp[0][0];
    }
}