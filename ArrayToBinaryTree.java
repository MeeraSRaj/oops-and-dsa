package project;

public class ArrayToBinaryTree{
    // intialise from arr[0]
    public static TNode arrayTotree(int[] arr){
        return buildTree(arr,0);   // returns the root node
    }

    private static TNode buildTree(int[] arr, int index){
        if (index>=arr.length) return null;
        TNode node =new TNode(arr[index]);
        node.left= buildTree(arr, 2*index +1);
        node.right = buildTree(arr, 2*index+2);
        return node; //returns the constructed node
    }
}