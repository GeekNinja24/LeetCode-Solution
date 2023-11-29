class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[]map=new int[26];
        char[]arr=ransomNote.toCharArray();
        char[]arr1=magazine.toCharArray();
        for(int i=0;i<arr.length;i++){
            map[arr[i]-'a']++;
        }
        for(int i=0;i<arr1.length;i++){
            map[arr1[i]-'a']--;
        }
        for(int i=0;i<map.length;i++){
            if(map[i]>0)
                return false;
        }
        return true;


    }
}