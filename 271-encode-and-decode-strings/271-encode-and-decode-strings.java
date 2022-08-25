public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for(String str : strs)
        {
            int size = str.length();
            result.append(String.valueOf(size) + ";" + str);
        }
        return result.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int i = 0, N = s.length();
        List<String> result = new ArrayList<>();
        
        while(i < N)
        {
            int j = i;
            while(s.charAt(j) != ';')
            {
                j++;
            }
            
            int size = Integer.parseInt(s.substring(i, j));
            
            result.add(s.substring(j + 1, j + 1 + size));
            i = j + size + 1;
        }
        
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));