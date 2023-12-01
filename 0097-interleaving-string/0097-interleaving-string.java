class Solution 
{
    public int checkInterleave(String s1,String s2,String s3,int indexs1,int indexs2,int indexs3,int[][][] dp)
    {
        if(indexs3>=s3.length())
        {
            if(indexs1>=s1.length() && indexs2>=s2.length())
            return 1;

            else
            return 0;
        }

        if(dp[indexs1][indexs2][indexs3]!=-1)
        return dp[indexs1][indexs2][indexs3];

        if(indexs1<s1.length() && indexs2<s2.length())
        {
            if(s1.charAt(indexs1)==s3.charAt(indexs3) && s2.charAt(indexs2)==s3.charAt(indexs3))
            {
            int firstString=checkInterleave(s1,s2,s3,indexs1+1,indexs2,indexs3+1,dp);
            int secondString=checkInterleave(s1,s2,s3,indexs1,indexs2+1,indexs3+1,dp);
            if(firstString==1 || secondString==1)
            dp[indexs1][indexs2][indexs3]=1;

            else
            dp[indexs1][indexs2][indexs3]=0;

            return dp[indexs1][indexs2][indexs3];
            }
        }

        if(indexs1<s1.length())
        {
        if(s1.charAt(indexs1)==s3.charAt(indexs3))
        return dp[indexs1][indexs2][indexs3]=checkInterleave(s1,s2,s3,indexs1+1,indexs2,indexs3+1,dp);
        }

        if(indexs2<s2.length())
        {
        if(s2.charAt(indexs2)==s3.charAt(indexs3))
        return dp[indexs1][indexs2][indexs3]=checkInterleave(s1,s2,s3,indexs1,indexs2+1,indexs3+1,dp);
        }

        return dp[indexs1][indexs2][indexs3]=0;
    }
    public boolean isInterleave(String s1, String s2, String s3) 
    {
        int indexs1=0;
        int indexs2=0;
        int indexs3=0;

        int s1Length=s1.length();
        int s2Length=s2.length();
        int s3Length=s3.length();

        int dp[][][]=new int[s1Length+1][s2Length+1][s3Length+1];

        for(int counter=0;counter<s1Length+1;counter++)
        {
            for(int counter2=0;counter2<s2Length+1;counter2++)
            {
                for(int counter3=0;counter3<s3Length+1;counter3++)
                {
                    dp[counter][counter2][counter3]=-1;
                }
            }
        }
        if(checkInterleave(s1,s2,s3,indexs1,indexs2,indexs3,dp)==1)
        return true;

        else
        return false;
    }
}