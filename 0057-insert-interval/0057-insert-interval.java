class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        int min = newInterval[0];
        int max = newInterval[1];

        // Add intervals that come before the newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals or add the newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][1]);
            i++;
        }

        result.add(new int[]{min, max});

        // Add remaining intervals after the merged interval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert List to array
        int[][] output = new int[result.size()][2];
        for (int j = 0; j < result.size(); j++) {
            output[j] = result.get(j);
        }

        return output;
    }
}