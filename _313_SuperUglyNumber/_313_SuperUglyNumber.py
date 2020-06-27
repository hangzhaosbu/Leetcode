"""
本代码来自 CSON 官方视频课程，由 @CSON 提供
题目来源：http://leetcode.com
- CSON 致力于在 CS 领域内帮助中国人找到工作，让更多海内外国人受益
- 讲师：Edward Shi
- 官方网站：https://cspiration.com
- 版权归 CSON 所有，转发请注明出处
"""


class _313_SuperUglyNumber:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        result = [0 for _ in range(n)]
        heap = []
        result[0] = 1
        for prime in primes:
            heapq.heappush(heap, (prime, 1, prime))
        for i in range(1, n):
            result[i] = heap[0][0]
            while heap[0][0] == result[i]:
                next = heapq.heappop(heap)
                heapq.heappush(heap, (next[2] * result[next[1]], next[1] + 1, next[2]))
        return result[n - 1]
