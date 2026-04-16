class Solution {
    public boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;

        while (begin < end) {
            char beginChar = s.charAt(begin);
            char endChar = s.charAt(end);

            if (!Character.isLetterOrDigit(beginChar)) {
                begin++;
                continue;
            }

            if (!Character.isLetterOrDigit(endChar)) {
                end--;
                continue;
            }

            if (Character.toLowerCase(beginChar) != Character.toLowerCase(endChar)) return false;

            begin++;
            end--;
        }

        return true;
    }
}
