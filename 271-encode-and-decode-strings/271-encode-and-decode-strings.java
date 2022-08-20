public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs)
    {
        StringBuilder s = new StringBuilder();
        
        for(String str : strs)
        {
            String size = String.valueOf(str.length());
            s.append(size + "#");
            s.append(str);
        }
        
        return s.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s)
    {
        List<String> result = new ArrayList<>();
        int i = 0, N = s.length();
        
        while(i < N)
        {
            int j = i;
            
            while(j < N && s.charAt(j) != '#')
            {
                j++;
            }
            
            int size = Integer.parseInt(s.substring(i, j));
            result.add(s.substring(j + 1, j + size + 1));
            i = j + size + 1;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));