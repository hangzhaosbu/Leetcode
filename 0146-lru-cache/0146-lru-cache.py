class Node:
    key = 0
    val = 0
    nxt = None
    prev = None

    def __init__(self, key, val, nxt=None, prev=None):
        self.key = key
        self.val = val
        self.nxt = nxt
        self.prev = prev

class LRUCache:
    
    
    def __init__(self, capacity: int):
        self.head = Node(0, 0)
        self.tail = Node(0, 0)
        self.head.next = self.tail
        self.tail.prev = self.head
        self.hashmap = {}
        self.size = capacity

    def get(self, key: int) -> int:
        if key in self.hashmap:
            
            node = self.hashmap[key]
            self.delete(node)
            self.insertHead(node)
            
            return self.hashmap[key].val
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if len(self.hashmap) < self.size:
            if key in self.hashmap:
                self.delete(self.hashmap[key])
                self.hashmap.pop(key)
            newNode = Node(key, value)
            self.hashmap[key] = newNode
            self.insertHead(newNode)
            
        else:
            if key in self.hashmap:
                self.delete(self.hashmap[key])
                
                
            else:
                lastNode = self.tail.prev
                self.delete(lastNode)
                
                self.hashmap.pop(lastNode.key)
            
            newNode = Node(key, value)
            self.hashmap[key] = newNode
            self.insertHead(newNode)
    
    def delete(self, node) -> None:
        prev = node.prev
        nxt = node.next
        
        prev.next = nxt
        nxt.prev = prev
        
    
    def insertHead(self, node) -> None:
        nxt = self.head.next;
        self.head.next = node
        node.prev = self.head
        
        node.next = nxt
        nxt.prev = node
            

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)