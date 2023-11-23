class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> li = new ArrayList<>(m);
        for(int i=0;i<m;i++){
            int size = r[i]-l[i]+1;
            int[] subar = new int[size];
            int k = 0;
            for(int j=l[i];j<=r[i];j++){
                subar[k++] = nums[j];
            }
            Arrays.sort(subar);
            int diff = subar[1]-subar[0];
            boolean added = false;
            for(int j=1;j<size-1;j++){
                if(subar[j+1]-subar[j] != diff ){
                    added = true;
                    li.add(false);
                    break;
                }
            }
            if(!added) li.add(true);
        }
        return li;
    }
}