/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root==null) {
            return root;
        }

        connectMChild(root);
        connectFarChilds(root);
        return root;


        // Queue<Node> q = new LinkedList<>();
        // q.add(root);

        // while(!q.isEmpty()){
        //     int n = q.size();
        //     Node prev = null;
        //     for(int i=0; i<n; i++){
        //         Node curr = q.poll();
        //         if(prev!=null){
        //             prev.next = curr;
        //         }
        //         prev = curr;
        //         if(curr.left!=null){
        //             q.offer(curr.left);
        //         }
        //         if(curr.right!=null){
        //             q.offer(curr.right);
        //         }
        //     }
        // }

        // return root;
        
    }

    public void connectMChild(Node node) {
        if(node==null) {
            return;
        }
        if(node.left!=null && node.right!=null){
            node.left.next = node.right;
        }

        connectMChild(node.left);
        connectMChild(node.right);
    }

    public void connectFarChilds(Node node) {
        if(node==null){
            return ;
        }

        if((node.left!=null && node.left.next==null) || (node.right!=null && node.right.next==null)) {
            Node parent = node;
            Node levelNode = (parent.left!=null && parent.left.next==null) ? parent.left : parent.right;
            while(levelNode!=null && parent!=null) {
                Node nextPar = getNextPar(parent);
                if(nextPar==null){
                    break;
                }
                levelNode.next = nextPar.left!=null ? nextPar.left:nextPar.right;
                parent = nextPar;
                levelNode = (parent.left!=null && parent.left.next==null) ? parent.left : parent.right;
            }
        }

        connectFarChilds(node.left);
        connectFarChilds(node.right);

    }


    public Node getNextPar(Node parent){
       

        Node next = parent.next;
        while(next!=null){
            if(next.left!=null || next.right!=null){
                return next;
            }
           next =  next.next;
        }

        return null;
    }


}