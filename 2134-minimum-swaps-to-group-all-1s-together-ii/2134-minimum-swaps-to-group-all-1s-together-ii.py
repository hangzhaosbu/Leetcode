class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        op1 = self.min_swaps_helper(nums, 0)  # Grouping all 0s together
        op2 = self.min_swaps_helper(nums, 1)  # Grouping all 1s together
        return min(op1, op2)

    def min_swaps_helper(self, data: List[int], val: int) -> int:
        length = len(data)
        right_suffix_sum = [0] * (length + 1)

        # Construct the suffix sum array for counting opposite values
        # (val ^ 1)
        for i in range(length - 1, -1, -1):
            right_suffix_sum[i] = right_suffix_sum[i + 1]
            if data[i] == (val ^ 1):
                right_suffix_sum[i] += 1

        # Total zeros in the array if `val` is 1 (or vice versa)
        total_swaps_needed = right_suffix_sum[0]
        # Track current number of required swaps in the current segment
        current_swap_count = 0
        minimum_swaps = (
            total_swaps_needed - right_suffix_sum[length - total_swaps_needed]
        )

        # Iterate to find the minimum swaps by sliding
        # the potential block of grouped `val`
        for i in range(total_swaps_needed):
            if data[i] == (val ^ 1):
                current_swap_count += 1
            remaining = total_swaps_needed - i - 1
            required_swaps = ((i + 1) - current_swap_count) + (
                remaining - right_suffix_sum[length - remaining]
            )
            minimum_swaps = min(minimum_swaps, required_swaps)
        return minimum_swaps