class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        if(n == 0) return true;
        
        if(flowerbed.size() == 1)
        {
            if(flowerbed[0] != 0 && n > 0) return false;
            if(flowerbed[0] == 0 && n == 1) return true;
            if(flowerbed[0] == 0 && n > 1) return false;
            
        }
        for(int i = 0; i < flowerbed.size(); i++)
        {
            if(i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0)
            {
                n--;
                flowerbed[i] = 1;
            }
            else if(i > 0 && i < flowerbed.size() - 1 && flowerbed[i] == 0 &&  flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0)
            {
                n--;
                flowerbed[i] = 1;
            }
            else if(i == flowerbed.size() - 1 && flowerbed[i] == 0 && flowerbed[i - 1] == 0)
            {
                n--;
                flowerbed[i] = 1;
            }
        }
        
        return n <= 0;
    }
};