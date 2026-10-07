class Solution {
    public void reverseWords(char[] s) {
        // reverse entire list
        int left = 0;
        int right = s.length - 1;
        while(left < right){
            char temp = s[left];
            s[left]= s[right];
            s[right]= temp;
            right--;
            left++;
        }

        // reverse each word
        int start = 0;
        int end = 0;
        int mark = 0;

        while(mark < s.length+1){
            if(mark == s.length || s[mark] == ' '){
                end = mark-1;
                while(start < end){
                    char temp = s[end];
                    s[end] = s[start];
                    s[start] = temp;
                    start++;
                    end--;
                }
                start = mark+1;
                end = mark+1;
            }
            mark++; 
        }
    }
}
