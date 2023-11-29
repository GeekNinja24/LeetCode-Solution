class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.add(nums[i]);
        }
        int longest = 1;
        for (int v: nums) {
            if (!map.contains(v - 1)) {
                int len = 1;
                while (map.contains(v + len)) {
                    len += 1;
                }
                if (longest < len) {
                    longest = len;
                }
                
            }
        }
        return longest;
    }
}