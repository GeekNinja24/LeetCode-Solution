class Solution {
    public List<String> summaryRanges(int[] nums) {
       List<String> list = new ArrayList<>();

       //just copy what the other guy did
       if(nums.length == 0){
           return list;
       }

       int start = nums[0];
       int end = nums[0];

       for(int i = 1; i < nums.length; i++){
           if(nums[i] == nums[i-1] + 1){
               end = nums[i];
           }else{
               pushRanges(list, start, end);
               start = nums[i];
               end = nums[i];
           }
       }

       pushRanges(list, start, end);

       return list;
    }

    void pushRanges(List<String> list, int start, int end){
        if(start != end){
            list.add(Integer.toString(start) + "->" + Integer.toString(end));
        }else{
            list.add(Integer.toString(start));
        }
    }
}