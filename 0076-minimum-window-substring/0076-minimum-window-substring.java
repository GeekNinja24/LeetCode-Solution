class Solution {
    HashMap<Character, Integer> mp = new HashMap<>();
    HashMap<Character, Integer> ans = new HashMap<>();
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();

        int i, j;
        for (i = 0; i < tlen; i++) {
            Integer mvalue = mp.get(t.charAt(i));
            if (mvalue!=null) {
                mp.put(t.charAt(i), mvalue+1);
            } else {
                mp.put(t.charAt(i), 1);
            }
        }

        int start,end;
        start=end=0;
        String sol = "";
        while (end<slen) {
            if (compareMap()==true) {
                break;
            } else {
                Integer mvalue = ans.get(s.charAt(end));
                if (mvalue==null) {
                    ans.put(s.charAt(end), 1);
                } else {
                    ans.put(s.charAt(end), mvalue + 1);
                }
                end++;
            }
        }
        if (end==slen && compareMap()==false) {
            return "";
        }
        sol = s.substring(start, end);
        // extra removal from start
        System.out.println(start + " " + end + " " + sol);
        while (start<end) {
            char schar = s.charAt(start);
            Integer scount = ans.get(schar);

            if (scount==null) {
                start++;
            } else {
                if (scount==1) {
                    ans.remove(schar);

                    // check
                    if (compareMap()==true) {
                        start++;
                        if (sol.length()>s.substring(start, end).length()) {
                            sol= s.substring(start, end);
                        }
                    } else {
                        ans.put(schar, 1);
                        break;
                    }
                    //add back

                } else {
                    ans.put(schar, scount-1);

                    // check
                    if (compareMap()==true) {
                        start++;
                        if (sol.length()>s.substring(start, end).length()) {
                            sol= s.substring(start, end);
                        }
                    } else {
                        ans.put(schar, scount);
                        break;
                    }

                }
            }
        }
        System.out.println(start + " " + end + " " + sol);
        while (end<slen) {
            // add end and move start
            Integer mvalue = ans.get(s.charAt(end));
            if (mvalue==null) {
                ans.put(s.charAt(end), 1);
            } else {
                ans.put(s.charAt(end), mvalue + 1);
            }

            while (start<end) {
                char schar = s.charAt(start);
                Integer scount = ans.get(schar);

                if (scount==null) {
                    start++;
                } else {
                    if (scount==1) {
                        ans.remove(schar);

                        // check
                        if (compareMap()==true) {
                            start++;
                            if (sol.length()>s.substring(start, end+1).length()) {
                                sol= s.substring(start, end+1);
                            }
                        } else {
                            ans.put(schar, 1);
                            break;
                        }
                        //add back

                    } else {
                        ans.put(schar, scount-1);

                        // check
                        if (compareMap()==true) {
                            start++;
                            if (sol.length()>s.substring(start, end+1).length()) {
                                sol= s.substring(start, end+1);
                            }
                        } else {
                            ans.put(schar, scount);
                            break;
                        }

                    }
                }
            }
            end++;
        }

        return sol;
    }

    private boolean compareMap() {
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            if (entry.getValue()> (ans.get(entry.getKey())==null ? 0 : ans.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }
}