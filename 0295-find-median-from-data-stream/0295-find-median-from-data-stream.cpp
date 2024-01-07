class MedianFinder {
public:
    priority_queue<int> maxq;
    priority_queue<int, vector<int>, greater<int>> minq;
    int size = 0;
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        minq.push(num);
        
        int top1 = minq.top();
        minq.pop();

        maxq.push(top1);
        
        int top2 = maxq.top();
        maxq.pop();

        minq.push(top2);
        
        if(minq.size() > maxq.size() + 1)
        {
            int top = minq.top();
            minq.pop();
            
            maxq.push(top);
        }
        
        size++;
    }
    
    double findMedian() {
        if(size % 2 == 0)
        {
            int top1 = minq.top();
            int top2 = maxq.top();
            
            return (1.0 * top1 + top2) / 2;
        }
        else
        {
            int top1 = minq.top();
            return 1.0 * top1;
        }
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */