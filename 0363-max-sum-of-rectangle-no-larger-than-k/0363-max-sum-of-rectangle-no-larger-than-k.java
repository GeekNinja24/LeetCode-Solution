class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int result = Integer.MIN_VALUE;
        for(int i=0;i<matrix[0].length;i++) {
            int runningSum[] = new int[matrix.length];
            for(int j=i;j<matrix[0].length;j++){
                for(int r = 0;r<runningSum.length;r++) {
                    runningSum[r]+=matrix[r][j];
                }
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                int cs = 0;
                for(int sum : runningSum) {
                    cs+=sum;

                    Integer lowerBound = set.ceiling(cs-k);
                    if(lowerBound != null){
                        result = Math.max(result,cs-lowerBound);
                    }
                    set.add(cs);
                }
            }
        }
        return result;
    }
}