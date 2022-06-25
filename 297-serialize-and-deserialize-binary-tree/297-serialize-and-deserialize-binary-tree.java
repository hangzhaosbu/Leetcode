/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    int idx = 0;
    
    private void serialize_dfs(TreeNode node, StringBuilder str)
    {
        if(node == null)
        {
            str.append("N,");
            return;
        }
        
        str.append(node.val + ",");
        serialize_dfs(node.left, str);
        serialize_dfs(node.right, str);
    }
    
    private TreeNode deserialize_dfs(String[] strs)
    {
        if(strs[idx].equals("N"))
        {
            idx++;
            return null;
        }
        
        TreeNode node = new TreeNode(Integer.parseInt(strs[idx]));
        idx++;
        node.left = deserialize_dfs(strs);
        node.right = deserialize_dfs(strs);
        
        return node;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root)
    {
        StringBuilder str = new StringBuilder();
        serialize_dfs(root, str);
        return str.toString().substring(0, str.length() - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data)
    {
        String[] strs = data.split(",");
        return deserialize_dfs(strs);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));