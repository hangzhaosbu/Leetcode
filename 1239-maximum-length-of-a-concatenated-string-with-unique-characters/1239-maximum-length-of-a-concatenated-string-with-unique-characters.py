class Solution:
    def maxLength(self, arr: List[str]) -> int:    
        # Pre-process arr with an optimizing helper
        # which converts each word to its character bitset
        # and then uses a set to prevent duplicate results
        opt_set = set()
        for word in arr:
            self.word_to_bitset(opt_set, word)

        # Convert the set back to an array for iteration
        # then start up the recursive helper
        opt_arr = list(opt_set)
        return self.backtracking(opt_arr, 0, 0, 0)
        
    def word_to_bitset(self, opt_arr: Set[int], word: str) -> None:        
        # Initialize an empty int to use as a character bitset
        char_bitset = 0
        for c in word:            
            # If the bitset contains a duplicate character
            # then discard this word with an early return
            # otherwise add the character to the bitset
            mask = 1 << ord(c) - 97
            if char_bitset & mask:
                return
            char_bitset += mask
        
        # Store the length of the word in the unused space
        # then add the completed bitset to our optimized set
        opt_arr.add(char_bitset + (len(word) << 26))
        
    def backtracking(self, opt_arr: List[int], pos: int, res_chars: int, res_len: int) -> int:
        # Recurse through each possible next option
        # and find the best answer
        best = res_len
        for i in range(pos, len(opt_arr)):
            new_chars = opt_arr[i] & ((1 << 26) - 1)
            new_len = opt_arr[i] >> 26
            
            # If the two bitsets overlap, skip to the next result
            if new_chars & res_chars:
                continue
            
            # Add the current word to the result
            # and recurse to the next position
            res_chars += new_chars
            res_len += new_len
            best = max(best, self.backtracking(opt_arr, i + 1, res_chars, res_len))
            
            # Backtrack the result before continuing
            res_chars -= new_chars
            res_len -= new_len
        return best