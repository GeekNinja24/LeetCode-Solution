class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int m = profits.length;
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for(int i = 0; i < m; i++){
            list.add(new Pair<>(profits[i], capital[i]));
        }
        Collections.sort(list, new Comparator<Pair<Integer, Integer>>(){
            public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b){
                if(a.getValue() == b.getValue()){
                    return 0;
                }
                return a.getValue() < b.getValue() ? -1 : 1;
            }
        });
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>(){
            public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b){
                if(a.getKey() == b.getKey()){
                    return 0;
                }
                return a.getKey() > b.getKey() ? -1 : 1;
            }
        });
        int count = 0;
        int index = 0;
        while(count < k){
            for(; index < list.size(); index++){
                if(list.get(index).getValue() <= w){
                    maxHeap.offer(list.get(index));
                }
                else{
                    break;
                }
            }
            if(maxHeap.size() == 0){
                break;
            }
            Pair<Integer, Integer> top = maxHeap.poll();
            int c = top.getValue();
            int p = top.getKey();
            w += p;
            count++;
        }
        return w;
    }
}