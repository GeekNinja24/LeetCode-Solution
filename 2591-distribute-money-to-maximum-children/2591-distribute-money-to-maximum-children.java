class Solution {
    public int distMoney(int m, int c) {
        int ans=0, rem, temp;
        if(m<c)
            return -1;
        if(m == c*8) 
            return c;
        if(m>c*8) 
            return c-1; 
        temp= m-c;
        ans = temp/7;
        rem = temp%7;
        if(c - ans==1 && rem==3) 
            ans--;
        return ans;
    }
}