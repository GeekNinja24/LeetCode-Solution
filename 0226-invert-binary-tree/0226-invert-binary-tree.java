class Solution {
    public TreeNode invertTree(TreeNode root) {
         // Base Case
        if(root==null)
            return null;
        invertTree(root.left); //Call the left substree
        invertTree(root.right); //Call the right substree
        // Swap the nodes
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root; // Return the root
    }
}