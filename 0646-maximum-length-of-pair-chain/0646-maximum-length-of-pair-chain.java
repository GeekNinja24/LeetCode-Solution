class Solution {
    public int findLongestChain(int[][] pairs) {
       Arrays.sort(pairs,new Comparator<int[]>()
        {
            @Override
            public int compare(int[] row1, int[] row2) {
                    return Integer.compare(row1[1], row2[1]);
            }
        });
        int end = Integer.MIN_VALUE;
        int count = 0;
        for(int[] arr : pairs)
        {
            if(arr[0] > end)
            {
                end = arr[1];
                count++;
            }
        }
        return count;
    }
}