class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
       int n = nums.length;
        int[] sortedNums = Arrays.copyOf(nums, n);
        Arrays.sort(sortedNums);

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            countMap.putIfAbsent(sortedNums[i], i);
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = countMap.get(nums[i]);
        }
        
        return result;
        
    }
}