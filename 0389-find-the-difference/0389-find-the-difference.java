class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++)
        {
            if(map.containsKey(t.charAt(i)))
            {
                map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
            }
            else
            {
                map.put(t.charAt(i), 1);
            }
        }
        
        for(int i = 0; i < s.length(); i++)
        {
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }
        
        
        for(Character key : map.keySet())
        {
            if(map.get(key) > 0) return key;
        }
        return 'a';
    }
}