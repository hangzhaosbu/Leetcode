class Pair {
    int val = 0;
    int count = 0;
    
    public Pair(int val, int count)
    {
        this.val = val;
        this.count = count;
    }
}

class Solution {
    public int[] pathsWithMaxScore(List<String> board)
    {
        /*
        ["E11345",
         "X452XX",
         "3X43X4",
         "44X312",
         "23452X",
         "1342XS"]

          
          
          0, 1|1, 1|3, 1|
          1, 1|0, 1|4, 1|
          3, 1|4, 1|4, 1|
        
        */
        
        int N = board.size();
        Pair[][] dp = new Pair[N][N];
        int MOD = (int) Math.pow(10, 9) + 7;
        
        dp[0][0] = new Pair(0, 1);
        
        for(int i = 0; i < N; ++i)
        {
            for(int j = 0; j < N; ++j)
            {
                
                if(i == 0 && j == 0)
                {
                    continue;
                }
                
                if(!board.get(i).substring(j, j + 1).equals("X"))
                {
                    int top = i - 1 >= 0 && !board.get(i - 1).substring(j, j + 1).equals("X") ? dp[i - 1][j].val : -1;
                    int left = j - 1 >= 0 && !board.get(i).substring(j - 1, j).equals("X") ? dp[i][j - 1].val : -2;
                    int diagonal = i - 1 >= 0 && j - 1 >= 0 && !board.get(i - 1).substring(j - 1, j).equals("X") ? dp[i - 1][j - 1].val : -3;
                    
                    int curt = board.get(i).substring(j, j + 1).equals("E") || board.get(i).substring(j, j + 1).equals("S") ? 0 : Integer.parseInt(board.get(i).substring(j, j + 1));
                                
                    if(top == left && top == diagonal)
                    {
                        dp[i][j] = new Pair((top + curt) % MOD, ((i - 1 >= 0 && dp[i - 1][j] != null ? dp[i - 1][j].count : 0) + (j - 1 >= 0 && dp[i][j - 1] != null ? dp[i][j - 1].count : 0) + (i - 1 >= 0 && j - 1 >= 0 && dp[i - 1][j - 1] != null ? dp[i - 1][j - 1].count : 0)) % MOD);
                        // System.out.println(i + ":" + j + " **" + dp[i][j].val + ", " + dp[i][j].count + "**");
                        // System.out.println
                    }
                    else
                    {
                        if(top == left)
                        {
                            dp[i][j] = new Pair((top + curt) % MOD, ((i - 1 >= 0 && dp[i - 1][j] != null ? dp[i - 1][j].count : 0) + (j - 1 >= 0 && dp[i][j - 1] != null ? dp[i][j - 1].count : 0)) % MOD);
                        }
                        
                        else if(top == diagonal)
                        {
                            dp[i][j] = new Pair((top + curt) % MOD, ((i - 1 >= 0 && dp[i - 1][j] != null ? dp[i - 1][j].count : 0) + (i - 1 >= 0 && j - 1 >= 0 && dp[i - 1][j - 1] != null ? dp[i - 1][j - 1].count : 0)) % MOD);
                        }
                        
                        else if(left == diagonal)
                        {
                            dp[i][j] = new Pair((left + curt) % MOD, ((j - 1 >= 0 && dp[i][j - 1] != null ? dp[i][j - 1].count : 0) + (i - 1 >= 0 && j - 1 >= 0 && dp[i - 1][j - 1] != null ? dp[i - 1][j - 1].count : 0)) % MOD);
                        }
                        
                        else{
                            if(top > left && top > diagonal)
                            {
                                dp[i][j] = new Pair((top + curt) % MOD, ((i - 1 >= 0 && dp[i - 1][j] != null ? dp[i - 1][j].count : 0)) % MOD);
                            }
                            else if(left > top && left > diagonal)
                            {
                                dp[i][j] = new Pair((left + curt) % MOD, ((j - 1 >= 0 && dp[i][j - 1] != null ? dp[i][j - 1].count : 0)) % MOD);
                            }
                            else
                            {
                                dp[i][j] = new Pair((diagonal + curt) % MOD, ((i - 1 >= 0 && j - 1 >= 0 && dp[i - 1][j - 1] != null ? dp[i - 1][j - 1].count : 0)) % MOD);
                            }
                        }
                        
                    }
                    
                }
            }
        }
        
        // for(Pair[] a : dp)
        //     for(Pair b : a)
        //         System.out.print(b.val + ", " + b.count + "|");
        
        
        if(dp[N - 1][N - 1].count == 0)
        {
            return new int[]{0, 0};
        }
        return new int[]{dp[N - 1][N - 1].val, dp[N - 1][N - 1].count};
        
    }
}