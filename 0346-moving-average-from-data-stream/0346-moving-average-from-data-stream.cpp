class MovingAverage {
public:
    int data[10010];
    int p = 0;
    double total = 0;
    int size = 0;
    
    MovingAverage(int size) {
        this->size = size;
    }
    
    double next(int val) {
        if(this->p < this->size)
        {
            data[this->p] = val;
            this->total += val;
            this->p++;
        }
        else
        {
            this->total -= data[this->p - this->size];
            data[this->p] = val;
            this->total += val;
            this->p++;
        }
        
        return total / min(this->p, this->size);
    }
};

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage* obj = new MovingAverage(size);
 * double param_1 = obj->next(val);
 */