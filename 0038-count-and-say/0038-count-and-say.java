class Solution {
    public String countAndSay(int n) {
        if(n==1)
            return "1";
        
        return rec(n,"1");
    }

    String rec(int n, String s)
    {

// base case
        if(n==1)
            return s;



// string processing 
        int siz = s.length();
        String res = "";
        int count = 1;
        char curr = s.charAt(0);
        for(int i=1;i<siz;i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                count++;
            }
            else
            {
                res= res + count + curr;
                curr = s.charAt(i);
                count = 1; 
            }      
           
        }
        res= res + count + curr;

// processing the stirng unless you reach your desired step 
        return rec(n-1,res);
        
    }
}