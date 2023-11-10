class Solution {
    public String getPermutation(int n, int k) {
        int[]nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        for(int i=1;i<k;i++){
            nextPermutation(nums);
        }
        String str="";
        for(int i=0;i<n;i++){
            str+=nums[i];
        }
        return str;
    }
     public void nextPermutation(int[] nums) {
        int pivot=nums[nums.length-1], index=nums.length-1,t=0,mark=nums[nums.length-1],index2=nums.length-1;
        for(int i=nums.length-1;i>=1;i--){
            if(nums[i]>nums[i-1]){
                pivot=nums[i-1];
                index=i-1;
                t=1;
                break;
            }
        }
        if(t==0){
            Arrays.sort(nums);
            return;
        }
        for(int i=nums.length-1;i>index;i--){
            if(nums[i]>pivot){
                mark=nums[i];
                index2=i;
                break;
            }
        }
        int temp=mark;
        nums[index2]=nums[index];
        nums[index]=temp;
        sort(index+1,nums.length-1,nums);
        return ;
    }
    public void sort(int i,int j, int[]nums){
        int[]temp=new int[j-i+1];
        int l=0;
        for(int k=i;k<=j;k++){
            temp[l]=nums[k];
            l++;
        }
        l=0;
        Arrays.sort(temp);
        for(int k=i;k<=j;k++){
            nums[k]=temp[l];
            l++;
        }
    }
}