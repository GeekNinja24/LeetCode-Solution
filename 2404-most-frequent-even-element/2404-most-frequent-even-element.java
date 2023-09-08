class Solution {
    public int mostFrequentEven(int[] nums) {
        int even=-1,max=0;
       for(int i=0;i<nums.length;i++){
            int count=0;
           if(nums[i]%2==0){
              
         for(int j=0;j<nums.length;j++){
            if(nums[i]==nums[j])count++;
         }
       }
       if(count>max){ 
           even=nums[i];
           max=count;   
       }
       if(count==max && nums[i]<even)
           even=nums[i];
       
       }
       return even;
    }
}