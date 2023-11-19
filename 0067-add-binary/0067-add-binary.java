class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        int i = 0;
        int a_len = a.length();
        int b_len = b.length();

        while (a_len > i || b_len > i || carry == 1) {
            int x = (a_len > i && a.charAt(a_len - i - 1) == '1') ? 1 : 0;
            int y = (b_len > i && b.charAt(b_len - i - 1) == '1') ? 1 : 0;

            // Calculate the sum bit
            int sum = x ^ y ^ carry;

            // Append the sum bit to the front of the result
            ans.insert(0, sum);

            // Calculate the carry for the next iteration
            carry = (x & y) | (carry & (x ^ y));

            i++;
        }

        return ans.toString();
        
    }
}