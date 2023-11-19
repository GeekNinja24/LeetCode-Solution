class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
         int majority = 0;
        for(int val : nums){
            if(count==0){
                majority = val;

            }
            if(val==majority){
                count+=1;
            }
            else{
                count-=1;
            }
        }
return majority;
        
    }
}