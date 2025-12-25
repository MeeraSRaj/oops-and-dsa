package project;

class TNode{
    int data;
    TNode left, right;

    public TNode(int data){
        this.data=data;
        this.left = this.right = null;
    }
}

public class BinaryTree{
    TNode root; 

    //Tree Traversals

    public void inorder(TNode node){
        if (node==null) return;
        inorder(node.left);
        System.out.print(node.data+ "-->");
        inorder(node.right);
    }

    public void preorder(TNode node){
        if (node==null) return;
        System.out.print(node.data+ "-->");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(TNode node){
        if (node==null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+ "-->");
    }

    public int findMax(TNode node){
        if (node==null) return Integer.MIN_VALUE;
        int left_max=findMax(node.left);
        int right_max= findMax(node.right);
        return Math.max(node.data, Math.max(left_max,right_max));
    }

    public int findMin(TNode node){
        if (node==null) return Integer.MAX_VALUE;
        int left_min=findMin(node.left);
        int right_min=findMin(node.right);
        return Math.min(node.data, Math.min(left_min,right_min));
    }

    public boolean search(TNode node, int key){
        if (node==null) return false;
        if (node.data==key) return true;
        return search(node.left, key) || search(node.right,key);
    }

    private boolean isBSTUtil(TNode node, int min, int max){
        if (node==null) return true;
        if (node.data<=min || node.data>=max) return false;
        return isBSTUtil(node.left, min,node.data) && isBSTUtil(node.right,node.data,max);
    }

    public boolean isBST(TNode node){
        return isBSTUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

}
