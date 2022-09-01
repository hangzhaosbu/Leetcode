class Solution {
    public List<List<String>> groupAnagrams(String[] strs)
    {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> hashmap = new HashMap<>();
        for(int i = 0; i < strs.length; ++i)
        {
            String str = strs[i];
            
            char[] key_list = str.toCharArray();
            
            Arrays.sort(key_list);
            
            String key = String.valueOf(key_list);
            
            if(!hashmap.containsKey(key))
            {
                hashmap.put(key, new ArrayList<>());
            }
            
            hashmap.get(key).add(str);
        }
        
        for(String key : hashmap.keySet())
        {
            result.add(hashmap.get(key));
        }
        
        return result;
    }
}