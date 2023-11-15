/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildhelp(int instart,int poststart,int inend,int postend,int inorder[],int postorder[],Map<Integer,Integer> map){
        if(instart>inend || poststart>postend) return null;
        TreeNode root=new TreeNode(postorder[postend]);
        int inindex=map.get(root.val);
        root.left=buildhelp(instart,poststart,inindex-1,poststart+inindex-instart-1,inorder,postorder,map);
        root.right=buildhelp(inindex+1,poststart+inindex-instart,inend,postend-1,inorder,postorder,map);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return buildhelp(0,0,inorder.length-1,postorder.length-1,inorder,postorder,map);   
    }
}