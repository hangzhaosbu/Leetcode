class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        queue = deque()

        # Initialize the queue with ticket indices
        for i in range(len(tickets)):
            queue.append(i)

        time = 0

        # Loop until the queue is empty
        while queue:
            # Increment the time counter for each iteration
            time += 1

            # Get the front element of the queue
            front = queue.popleft()

            # Buy a ticket for the front person
            tickets[front] -= 1

            # If person k bought all their tickets, return time
            if k == front and tickets[front] == 0:
                return time

            # Re-add the current index to the queue for the next iteration
            if tickets[front] != 0:
                queue.append(front)

        return time