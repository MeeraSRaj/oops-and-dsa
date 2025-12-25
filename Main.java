package project;

public class Main{
    public static void main(String[] args) {

        //Sorting Algorithm implementation
        SortingAlgorithm Sort=new SortingAlgorithm();
    
        //Bubble
        System.out.println("Bubble Sort");
        int[] arr1= {64, 34, 25, 12, 22, 11, 90};  
        System.out.println("Unsorted Array:");
        Sort.displayarray(arr1);
        Sort.BubbleSort(arr1);
        System.out.println("Sorted Array:");
        Sort.displayarray(arr1);
        System.out.println();

         // merge
        System.out.println("Merge Sort");        
        int[] arr2 = {5, 2, 9, 1, 5, 6};
        System.out.println("Unsorted Array:");
        Sort.displayarray(arr2);
        Sort.MergeSort(arr2,0,arr2.length-1);
        System.out.println("Sorted Array:");
        Sort.displayarray(arr2);          
        System.out.println(); 
        
         //quick
        System.out.println("Quick Sort");       
        int[] arr3 = {10, 7, 8, 9, 1, 5};
        System.out.println("Unsorted Array:");
        Sort.displayarray(arr3);
        Sort.PartitionSort(arr3,0,arr3.length-1);
        System.out.println("Sorted Array:");
        Sort.displayarray(arr3);  
         System.out.println();     
         
         //selection
        System.out.println("Selection Sort");        
        int[] arr4 = {12, 11, 13, 5, 6};
        System.out.println("Unsorted Array:");
        Sort.displayarray(arr4);
        Sort.SelectionSort(arr4);
        System.out.println("Sorted Array:");
        Sort.displayarray(arr4); 
        System.out.println();       
        
         //insertion
        System.out.println("Insertion Sort");
        int[] arr5={8,53,20,72,4};
        System.out.println("Unsorted Array:");
        Sort.displayarray(arr5);
        Sort.InsertionSort(arr5);
        System.out.println("Sorted Array:");
        Sort.displayarray(arr5);
        System.out.println();


        //Linked List Operations 
        LinkedList list = new LinkedList();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        System.out.println("Initial list:");
        list.display();

        list.insertAtBeginning(5);
        System.out.println("After inserting 5 at the beginning:");
        list.display();

        list.insertAfter(10, 15);
        System.out.println("After inserting 15 after 10:");
        list.display();

        list.deleteByKey(20);
        System.out.println("After deleting key 20:");
        list.display();

        list.deleteAtBeginning();
        System.out.println("After deleting from beginning:");
        list.display();

        list.deleteAtEnd();
        System.out.println("After deleting from end:");
        list.display();

        //Infix to Postfix and PostFix Evaluation
        String[] testExpressions = {
            "2+3*4",
            "5*2+3",
            "(2+3)*4",
            "6/2+1"
        };

        for (String expr : testExpressions) {
            InfixToPostfix infixConverter = new InfixToPostfix(expr.length() * 2);
            PostfixEvaluator evaluator = new PostfixEvaluator(expr.length() * 2);
            String postfix = infixConverter.convertToPostfix(expr);
            int result = evaluator.evaluatePostfix(postfix);
            System.out.println("Infix: " + expr);
            System.out.println("Postfix: " + postfix);
            System.out.println("Result: " + result);
            System.out.println();
        }


        //Binary Tree(Linked List)
        System.out.println("Binary Tree: ");
        int[] arr ={1,2,3,4,5,6,7};
        BinaryTree tree = new BinaryTree();
        tree.root = ArrayToBinaryTree.arrayTotree(arr);

        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root);

        System.out.println("\n Preorder Traversal:");
        tree.preorder(tree.root);

        System.out.println("\n Postorder Traversal:");
        tree.postorder(tree.root);

        System.out.println("\nThe Maximum element is: " + tree.findMax(tree.root));
        System.out.println("The Minimum element is: " + tree.findMin(tree.root));
        System.out.println("Is 12 there in this Binary Tree? : " + tree.search(tree.root, 12));

        System.out.println("Is Binary Search Tree?:"+ tree.isBST(tree.root));


        //Binary Tree: Array-Based
        System.out.println("\nBinary Tree to Array and Array-based Operations:");
        BinaryArrayTree BAT = new BinaryArrayTree();
        int[] treeArray = BinaryTreetoArray.treeToarray(tree.root);
        System.out.print("Tree as Array: ");
        for (int val : treeArray) {
            System.out.print(val + " ");
        }
        System.out.println();

        System.out.println("Array-based Inorder Traversal:");
        BAT.inorder(treeArray, 0);
        System.out.println();

        System.out.println("Array-based Preorder Traversal:");
        BAT.preorder(treeArray, 0);
        System.out.println();

        System.out.println("Array-based Postorder Traversal:");
        BAT.postorder(treeArray, 0);
        System.out.println();

        System.out.println("Maximum element (using traversal): " + BAT.findMax(treeArray, treeArray.length, 0, false));
        System.out.println("Minimum element (using traversal): " + BAT.findMin(treeArray, treeArray.length, 0, false));
        System.out.println("Find element 5 (using search): " + BAT.search(treeArray, treeArray.length, 0, 5, true));
        System.out.println("Is Binary Search Tree?:" + BAT.isBST(treeArray, treeArray.length, 0));
        

        //Binary Search Tree (Linked List)
        System.out.println("\nBinary Search Tree:");
        int[] bstArray = {10, 5, 20, 3, 7, 15, 25};
        BinarySearchTree bst = new BinarySearchTree();
        bst.root= ArrayToBinaryTree.arrayTotree(bstArray);

        System.out.println("Is Binary Search Tree?:" + bst.isBST(bst.root));
        

        System.out.println("The Maximum element is: " + bst.findMax(bst.root));
        System.out.println("The Minimum element is: " + bst.findMin(bst.root));
        System.out.println("Is 12 there in this Binary Tree? : " + bst.search(bst.root, 12));

        //Graph Algorithms implementation 
        GraphSearch Graph1 = new GraphSearch(6);

        Graph1.addEdge(0, 1);
        Graph1.addEdge(0, 3);
        Graph1.addEdge(1, 4);
        Graph1.addEdge(2, 4);
        Graph1.addEdge(2, 5);
        Graph1.addEdge(3, 1);
        Graph1.addEdge(4, 3);
        Graph1.addEdge(4, 2);
        Graph1.addEdge(5, 0);

        Graph1.BFS(0);
        Graph1.DFS();

        GraphShortestPath Graph2 = new GraphShortestPath(6);

        Graph2.addEdge(0, 1, 1);
        Graph2.addEdge(0, 3, -4);
        Graph2.addEdge(1, 4, 7);
        Graph2.addEdge(1, 5, 5);
        Graph2.addEdge(2, 5, 10);
        Graph2.addEdge(3, 1, 2);
        Graph2.addEdge(4, 0, -1);
        Graph2.addEdge(4, 3, 3);
        Graph2.addEdge(4, 2, 8);

        boolean ncycle = Graph2.BellmanFord(0);
        if (!ncycle){
            System.out.println("No solution sice there are negative cycles!!!");
        }

        GraphShortestPath Graph3 = new GraphShortestPath(6);

        Graph3.addEdge(0, 1, 1);
        Graph3.addEdge(0, 3, 5);
        Graph3.addEdge(1, 4, 7);
        Graph3.addEdge(1, 5, 5);
        Graph3.addEdge(2, 5, 4);
        Graph3.addEdge(3, 1, 2);
        Graph3.addEdge(4, 0, 1);
        Graph3.addEdge(4, 3, 3);
        Graph3.addEdge(4, 2, 8);


        Graph3.Dijkstra(0);
        Graph3.FloydWarshall();


    }
}