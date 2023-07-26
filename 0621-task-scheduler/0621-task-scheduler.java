class Q {
    private int N;
    private int[][] arr;
    private int front, back;
    private int size;
    
    public Q(){
        N = (int) 1e4 + 1;
        arr = new int[N][2];
        front = 0;
        back = 0;
        size = 0;
    }
    
    public void push(int cnt, int time)
    {
        arr[back][0] = cnt;
        arr[back][1] = time;
        back++;
        size++;
    }
    
    public int[] popleft()
    {
        int[] result = arr[front++];
        size--;
        return result;
    }
    
    public int[] peek()
    {
        int[] result = arr[front];
        return result;
    }
    
    public boolean isEmpty()
    {
        return front == back;
    }
    
    public int size()
    {
        return size;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>(); 
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b)
            {
                return b - a;
            }
        });
        Q myQueue = new Q();
        int time = 0;
        
        for(char task : tasks)
        {
            if(map.containsKey(task))
            {
                map.put(task, map.get(task) + 1);
            }
            else
            {
                map.put(task, 1);
            }
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet())
        {
            pq.offer(entry.getValue());
        }
        
        
        while(!pq.isEmpty() || !myQueue.isEmpty())
        {
            time++;
            if(!pq.isEmpty())
            {
                int cnt = pq.poll() - 1;
                
                if(cnt != 0)
                    myQueue.push(cnt, time + n);
            }
            
            if(!myQueue.isEmpty() && time == myQueue.peek()[1])
            {
                int[] curt = myQueue.popleft();
                pq.offer(curt[0]);
            }
        }
        
        return time;
    }
}