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
    public static void getInOrder(TreeNode root,ArrayList<Integer>list){
        if(root==null){
            return;
        }
        getInOrder(root.left,list);
        list.add(root.val);
        getInOrder(root.right,list);
    }
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        getInOrder(root,list);
        return list.get(k-1);
    }
}