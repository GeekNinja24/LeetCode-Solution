class Solution {
    String ans = "";
    public String findDifferentBinaryString(String[] nums) {
    
        Set<String> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            set.add(nums[i]);
        }
        if(nums.length==0)
        return "";
        int n = nums[0].length();
        StringBuffer str = new StringBuffer();

        generate(str,0,n,set);
        return ans;
    }
    public boolean generate(StringBuffer str, int index,int n, Set<String> set){
        if(index>=n){
            if(!set.contains(str.toString())){
                ans=str.toString();
                return true;
            }
            return false;
        }
        str.append("0");
        boolean zero = generate(str,index+1,n,set);
        str.delete(str.length()-1,str.length());
        
        if(zero==true)
        return true;
        
        str.append("1");
        boolean one = generate(str,index+1,n,set);
        str.delete(str.length()-1,str.length());
        if(one==true)
        return true;
        return false;
    }
}