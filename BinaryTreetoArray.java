package project;

public class BinaryTreetoArray{
    //we'll have to count the number of elements in the binary tree first. 
    // so as to create the array with the spcific number of elements
    private static int countNodes(TNode node){
        if (node==null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    public static int[] treeToarray(TNode node){
        int size=countNodes(node);

        int[] arr = new int[size]; //creating an array of size 
        addElement(node,arr,0);
        return arr;
    }
    private static void addElement(TNode node, int[] arr, int index){
        if (node==null || index>=arr.length) return; //recursive function so as to add elements in the array

        arr[index]=node.data;

        addElement(node.left,arr, 2*index+1);
        addElement(node.right,arr,2*index+2);
     }
}