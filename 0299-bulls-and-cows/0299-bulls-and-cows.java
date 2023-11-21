class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] nums = new int[10]; // Array to count occurrences of digits (0-9)

        // Iterate through the strings to find bulls and cows
        for (int i = 0; i < secret.length(); i++) {
            int a = Character.getNumericValue(secret.charAt(i)); // Get numeric value of character in secret
            int b = Character.getNumericValue(guess.charAt(i));  // Get numeric value of character in guess

            if (a == b) { // If digits match at the same index, it's a bull
                bulls++;
            } else { // If digits don't match, it might be a cow
                if (nums[a] < 0) cows++; // If nums[a] is negative, it means b has occurred before in guess
                if (nums[b] > 0) cows++; // If nums[b] is positive, it means a has occurred before in secret
                nums[a]++; // Increment count for digit a in secret
                nums[b]--; // Decrement count for digit b in guess
            }
        }

        return bulls + "A" + cows + "B"; // Return the count of bulls and cows in the required format
    }
}