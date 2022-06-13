class Solution {
    public List<List<String>> groupAnagrams(String[] strs)
    {
        HashMap<String, List<String>> hashmap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        
        for(String str : strs)
        {
            char charArray[] = str.toCharArray();
            Arrays.sort(charArray);
            
            String key = new String(charArray);
            
            if(hashmap.containsKey(key))
            {
                hashmap.get(key).add(str);
            }
            else
            {
                hashmap.put(key, new ArrayList<>());
                hashmap.get(key).add(str);
            }
        }
        
        for(String key : hashmap.keySet())
        {
            result.add(hashmap.get(key));
        }
        
        return result;
    }
}