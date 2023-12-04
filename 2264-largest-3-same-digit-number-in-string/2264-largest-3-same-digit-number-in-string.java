class Solution {
    public String largestGoodInteger(String num) {
        String max = ""; 
        for (int i = 0; i < num.length() - 2; i++) {
            int j = i+1;
            int k = j+1;
                    if (num.charAt(i) == num.charAt(j) && num.charAt(j) == num.charAt(k)) {
                        String ans = "" + num.charAt(i) + num.charAt(j) + num.charAt(j);
                        if (ans.compareTo(max) > 0) { 
                            max = ans;
                }
            }
        }
        return max;
    }
}