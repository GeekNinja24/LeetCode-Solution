class Solution {
    public String reverseWords(String s) {
        
        String[]  str =s.trim().split("\\s+");
        
        
        String o="";
        
        
        
        for(int i=str.length-1;i>=0;--i){
            o+=  str[i]+" ";
        }
        
        return o.trim();
        
        
        
        

    }
}