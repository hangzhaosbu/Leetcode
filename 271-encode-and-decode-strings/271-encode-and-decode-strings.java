public class Codec 
{
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) 
    {
        String s = "";
        for(String str : strs)
        {
            s += str.length() + "#" + str;
        }
        return s;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) 
    {
        List<String> result = new ArrayList<>();
        int N = s.length();
        int i = 0;
        
        while(i < N)
        {
            int j = i;
            
            while(s.charAt(j) != '#')
            {
                j++;
            }
            
            int length = Integer.parseInt(s.substring(i, j));
            result.add(s.substring(j + 1, j + 1 + length));
            
            i = j + 1 + length;
        }
        
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));