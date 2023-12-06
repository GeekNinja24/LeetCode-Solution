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
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return Integer.MAX_VALUE;
        }

        int minLeft = getMinimumDifference(root.left);
        TreeNode predecessor = root.left;
        while(predecessor != null && predecessor.right != null){
            predecessor = predecessor.right;
        }
        if(predecessor == null){
            minLeft = Math.min(minLeft,Integer.MAX_VALUE);
        }else{
            minLeft = Math.min(minLeft, Math.abs(root.val - predecessor.val)); 
        }
        
        int minRight = getMinimumDifference(root.right);
        TreeNode successor = root.right;
        while(successor != null && successor.left != null){
            successor = successor.left;
        }
        if(successor == null){
            minRight = Math.min(minRight, Integer.MAX_VALUE);
        }else{
            minRight = Math.min(minRight, Math.abs(root.val - successor.val)); 
        }
        return Math.min(minRight, minLeft);
    }
}