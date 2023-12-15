class MedianFinder {
    ArrayList<Double> list;

    public MedianFinder() {
        this.list = new ArrayList<Double>();
    }

    public void addNum(int num) {
        int insertionPoint = Collections.binarySearch(this.list, (double) num);
        int actualInsertionPoint = insertionPoint < 0 ? -(insertionPoint + 1) : insertionPoint;
        this.list.add(actualInsertionPoint, (double) num);
    }
    
    public double findMedian() {
        if(this.list.size()%2>0) {
            return this.list.get(this.list.size()/2);
        } else {
            return (this.list.get(this.list.size()/2) + this.list.get((this.list.size()/2)-1))/2;
        }
    }
}