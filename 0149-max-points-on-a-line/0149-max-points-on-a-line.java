import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
class Solution {
    public int maxPoints(int [][]points){
        List<List<Integer>> al=new ArrayList<List<Integer>>();
    int len=points.length;
    if (len==1)return 1;
    for(int i=0;i<len;i++){
        for(int j=i+1;j<len;j++){
            List<Integer> cu=new ArrayList<Integer>();
            int x1=points[i][0],x2=points[j][0],y1=points[i][1],y2=points[j][1];
            cu.add(y2-y1);cu.add(x1-x2);cu.add(x1*y2-x2*y1);
            al.add(cu);
        }
    }
    int max=0;
    for(List<Integer> cu: al){
        int currmax=0;
        for(int i=0;i<len;i++){
            int x=points[i][0];int y=points[i][1];
            if(cu.get(0)*x+cu.get(1)*y==cu.get(2))currmax++;
        }
        max=Math.max(currmax,max);
    }
    return max;
    }
}