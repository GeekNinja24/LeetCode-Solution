class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s).reverse();
        int index = s.length();
        while(index > 0 && !s.substring(0, index).equals(sb.substring(s.length() - index, s.length()))) index--;
        return sb.append(s.substring(index)).reverse().toString();
    }

}