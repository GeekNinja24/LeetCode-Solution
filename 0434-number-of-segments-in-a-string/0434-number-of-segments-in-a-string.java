class Solution {
    public int countSegments(String s) {
        if (s.isEmpty() || s.isBlank()) return 0;
        String[] arr = s.split(" ");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].isEmpty() || arr[i].isBlank()) continue;
            count++;
        }
        return count;
    }
}