class MedianFinder {

    PriorityQueue<Integer> max_heap;
    PriorityQueue<Integer> min_heap;
    
    public MedianFinder() {
        min_heap = new PriorityQueue<>();
        max_heap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b)
            {
                return b - a;
            }
        });
    }
    
    public void addNum(int num) {
        max_heap.offer(num);
        min_heap.offer(max_heap.poll());
        if(max_heap.size() < min_heap.size())
        {
            max_heap.offer(min_heap.poll());
        }
    }
    
    public double findMedian() {
        if(max_heap.size() == min_heap.size())
        {
            return (max_heap.peek() + min_heap.peek()) / 2.0;
        }
        else
        {
            return max_heap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */