/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        HashSet<Integer> hashset = new HashSet<>();
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i = 0; i < n; ++i)
        {
            hashset.add(i);
            hashmap.put(i, 0);
        }
        
        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(i == j)
                {
                    continue;
                }
                
                if(knows(i, j))
                {
                    hashset.remove(i);
                    hashmap.put(j, hashmap.get(j) + 1);
                }
            }
        }
        
        if(hashset.size() != 1 || hashmap.get(hashset.iterator().next()) != n - 1)
        {
            return -1;
        }
        return hashset.iterator().next();
    }
}