class Solution {
    public boolean isSameAfterReversals(int num) {
        int n1=rev1(num);
        int n2=rev1(n1);
      
         
        
         
       
        if(n2==num){
            return true;
        }
        else{
            return false;
        }
        
        
        
    }
    public int rev1(int n){
        int rev=0;
            while(n>0){
                int r =n%10;
            rev=rev*10+r;
            n/=10;
            }
        
        return rev;
        
         }
    
    
}