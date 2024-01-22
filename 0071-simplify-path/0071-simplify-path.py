class Solution:
    def simplifyPath(self, path: str) -> str:
        res = []
        
        paths = path.split("/")
        
        for path in paths:
            if len(path) == 0:
                continue
            else:
                
                if path == "..":
                    
                    if len(res) > 0:
                        res.pop()
                elif path == ".":
                    pass
                else:
                    res.append(path)
        
        return "/" + "/".join(res)