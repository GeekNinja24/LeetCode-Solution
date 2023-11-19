class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int temp;
        int correctPos;
        int[] shifted = new int[n];
        for (int i = 0; i < n; i++){
            shifted[(i + k) % n] = nums[i];
        }
        for (int j = 0; j < n; j++){
            nums[j] = shifted[j];
        }
    }
}