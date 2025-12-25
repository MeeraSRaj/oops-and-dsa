package project;

public class BinarySearchTree extends BinaryTree{
    @Override  //can point out if there is a miss-overriding (not even a word)
    public int findMax(TNode node){
        if (node==null) return Integer.MIN_VALUE;
        while (node.right != null){
            node=node.right;
        }
        return node.data;
    }

    @Override
    public int findMin (TNode node){
        if (node==null) return Integer.MAX_VALUE;
        while (node.left !=null){
            node=node.left;
        }
        return node.data;
    }

    @Override
    public boolean search(TNode node, int key){
        if (node==null) return false;
        if (node.data== key) return true;
        return key<node.data? search(node.left, key): search(node.right,key);
    }
}