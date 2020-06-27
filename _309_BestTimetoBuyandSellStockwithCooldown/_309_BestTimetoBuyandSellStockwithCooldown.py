"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


class _309_BestTimetoBuyandSellStockwithCooldown:
    def maxProfit(self, prices: List[int]) -> int:
        sell = 0
        prevSell = 0
        buy = -math.inf
        for price in prices:
            prevBuy = buy
            buy = max(prevSell - price, prevBuy)
            prevSell = sell
            sell = max(prevBuy + price, prevSell)
        return sell
