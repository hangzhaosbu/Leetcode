class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder titleString = new StringBuilder("");
        while(columnNumber-->0){
            titleString.append(""+(char)(columnNumber%26+'A'));
            columnNumber /= 26;
        }
        return titleString.reverse().toString();
    }
}