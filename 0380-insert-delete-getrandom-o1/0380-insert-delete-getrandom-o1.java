class RandomizedSet {
    ArrayList<Integer> al;
    HashMap<Integer, Integer> hm;
    Random rand;

    public RandomizedSet() {
        al = new ArrayList<>();
        hm = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        if (!hm.containsKey(val)) {
            al.add(val);
            hm.put(val, al.size()-1);
            return true;
        }
        return false;
    }
    
    public boolean remove(int val) {
        if (hm.containsKey(val)) {
            Integer idx = hm.get(val);
            hm.remove(val);
            if (idx!=al.size()-1)
                hm.put(al.get(al.size()-1), idx);
            al.set(idx, al.get(al.size()-1));
            al.remove(al.size()-1);
            return true;
        }
        return false;
    }
    
    public int getRandom() {
        // int x = (int)Math.random()*(al.size()+1);
        // return al.get(x);
        return al.get(rand.nextInt(al.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */