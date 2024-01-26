class Node:
    def __init__(self, key = 0, val = 0, prev = None, next = None):
        self.key = key
        self.val = val
        self.prev = prev
        self.next = next

class LRUCache:

    def __init__(self, capacity: int):
        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.hashmap = {}
        self.capacity = capacity
        
    def delete(self, node) -> None:
        prev = node.prev
        nxt = node.next
        prev.next = nxt
        nxt.prev = prev
    
    def insert(self, node) -> None:
        nxt = self.head.next
        self.head.next = node
        node.prev = self.head
        node.next = nxt
        nxt.prev = node

    def get(self, key: int) -> int:
        if key not in self.hashmap:
            return -1
        else:
            node = self.hashmap[key]
            self.delete(node)
            self.insert(node)
            return node.val

    def put(self, key: int, val: int) -> None:
        if key in self.hashmap:
            node = self.hashmap[key]
            newNode = Node(key, val)
            self.delete(node)
            self.insert(newNode)
            self.hashmap[key] = newNode
        else:
            if len(self.hashmap) < self.capacity:
                node = Node(key, val)
                self.hashmap[key] = node
                self.insert(node)
            else:
                last = self.tail.prev
                self.delete(last)
                self.hashmap.pop(last.key)
                node = Node(key, val)
                self.insert(node)
                self.hashmap[key] = node
                

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)