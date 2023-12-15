class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for(int num : nums){
            for(int i = 0; i < 32; i++){
                bits[i] += (num >> i) & 1;
            }
        }
        int result = 0;
        for(int i = 0; i < 32; i++){
            result += (bits[i] % 3) << i;
        }
        return result;
    }
}