class Solution {
    long[] levels = new long[15];
    
    int curr = 0;
    public int findNthDigit(int n) {
        if(n<10) return n;
        levels[0] = 9;

        int level = getLevel(n);
        //System.out.print(level);
        int num = n - (int)levels[level-1];
        //System.out.print("num1: "+num+"\n");
        int digit = (int)num % (level+1);
        //System.out.print("digit: "+digit+"\n");
        num = num / (level+1);
        //System.out.print("num2: "+num+"\n");
        int start = (int)Math.pow(10,level);
        if(digit==0){
            return (start + num -1)%10;
        }else{
            num = num + start;
            //System.out.print("num3: "+num+"\n");
            num /= Math.pow(10,level+1-digit);
            num = num%10;
            //System.out.print("num4: "+num+"\n");
            return num;
        }
        // for(int i=0; i<15; i++){
        //     System.out.print(i+" "+levels[i]+" ");
        // }
        
        //return -1;
    }

    private int getLevel(int n){
        if(levels[curr]<(long)n){
            while(levels[curr]<(long)n){
                curr++;
                levels[curr] = levels[curr-1] + 9 * (curr+1) * (long)Math.pow(10,curr);
            }
            return curr;
        }else{
            for(int i=0; i<=curr; i++){
                if(levels[i]>=(long)n) return i;
            }
        }
        return -1;
        
        
        
    }
}