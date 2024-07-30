# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        ret = []
        def dfs(node):
            if not node:
                ret.append("N")
                return
            
            ret.append(str(node.val))
            dfs(node.left)
            dfs(node.right)
        dfs(root)
        return ",".join(ret)

    def deserialize(self, data):
        data = data.split(",")
        self.i = 0
        
        def dfs():
            if data[self.i] == 'N':
                self.i += 1
                return None
            
            node = TreeNode(int(data[self.i]))
            self.i += 1
            
            node.left = dfs()
            node.right = dfs()
            
            return node
        
        return dfs()

# Your Codec object will be instantiated and called as such:
# ser = Codec()
# deser = Codec()
# ans = deser.deserialize(ser.serialize(root))