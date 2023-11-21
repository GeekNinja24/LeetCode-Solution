class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        int k = 0;
        for(String s : words){
            map.put(s,k++);
        }
        for(int i=0;i<words.length;i++){
        // when one string is empty and other is palindrome
            if(words[i].equals("")){
                for(int j=0;j<words.length;j++){
                    String curr = words[j];
                    if(j!=i && isPalindrome(curr,0,curr.length()-1)){
                        ans.add(List.of(i,j));
                        ans.add(List.of(j,i));
                    }
                }
            }
        // if reverse of a string is present in the array
        StringBuilder sb = new StringBuilder(words[i]);
        sb.reverse();
        String str = sb.toString();
        if(map.containsKey(str)){
            int ival = map.get(str);
            if(ival!=i) ans.add(List.of(i,ival));
        }
        for(int j=1; j<str.length(); j++){
            //(sasl,l) check case when prefix is palindrome and rest is present in string
                if(isPalindrome(str,0,j-1)){
                    String sub = str.substring(j);
                    if(map.containsKey(sub)){
                        ans.add(List.of(i,map.get(sub)));
                    }
                }
            //(sasl,l) check case when suffix is palindrome and rest is present in string
                if(isPalindrome(str,j,str.length()-1)){
                    String sub = str.substring(0,j);
                    if(map.containsKey(sub)){
                        ans.add(List.of(map.get(sub),i));
                    }
                }
            }   
        }
        return ans;
    }
    public boolean isPalindrome(String s,int left,int right){
        while(left<right) if(s.charAt(left++)!=s.charAt(right--)) return false;
        return true;
    }
}