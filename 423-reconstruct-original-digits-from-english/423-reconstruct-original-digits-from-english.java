class Solution {
    public String originalDigits(String s)
    {
        HashMap<Character, String[]> number = new HashMap<>();
        number.put('z', new String[]{"zero", "0"});
        number.put('w', new String[]{"two", "2"});
        number.put('u', new String[]{"four", "4"});
        number.put('f', new String[]{"five", "5"});
        number.put('o', new String[]{"one", "1"});
        number.put('g', new String[]{"eight", "8"});
        number.put('t', new String[]{"three", "3"});
        number.put('x', new String[]{"six", "6"});
        number.put('i', new String[]{"nine", "9"});
        number.put('v', new String[]{"seven", "7"});
        
        Character[] numbers = new Character[]{'z', 'w', 'u', 'f', 'o', 'g', 't', 'x', 'i', 'v'};
        
        HashMap<Character, Integer> hashmap = new HashMap<>();
        int[] records = new int[10];
        
        for(int i = 0; i < s.length(); ++i)
        {
            hashmap.put(s.charAt(i), hashmap.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for(int i = 0; i < numbers.length; ++i)
        {
            Character s1 = numbers[i];
            
            if(hashmap.containsKey(s1))
            {
                String letter = number.get(s1)[0];
                String num = number.get(s1)[1];
                int count = hashmap.get(s1);
                
                for(int j = 0; j < letter.length(); ++j)
                {
                    hashmap.put(letter.charAt(j), hashmap.get(letter.charAt(j)) - count);
                    
                    
                    if(hashmap.get(letter.charAt(j)) == 0)
                    {
                        hashmap.remove(letter.charAt(j));
                    }
                }
                
                for(int j = 0; j < count; ++j)
                {
                    records[Integer.parseInt(num)]++;
                }
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < 10; ++i)
        {
            result.append(String.valueOf(i).repeat(records[i]));
        }
        
        return result.toString();
    }
}