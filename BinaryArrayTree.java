package project;

public class BinaryArrayTree{
    public void inorder(int arr[], int i) {
        int n=arr.length;
        if (i >= n || arr[i] == -1) {
            return;
        }
        inorder(arr, 2 * i + 1);
        System.out.print(arr[i] + " ");
        inorder(arr, 2 * i + 2);
    }

    public void preorder(int arr[],  int i) {
        int n=arr.length;
        if (i >= n || arr[i] == -1) {
            return;
        }
        System.out.print(arr[i] + " ");
        preorder(arr, 2 * i + 1);
        preorder(arr, 2 * i + 2);
    }

    public void postorder(int arr[], int i) {
        int n=arr.length;
        if (i >= n || arr[i] == -1) {
            return;
        }
        postorder(arr, 2 * i + 1);
        postorder(arr, 2 * i + 2);
        System.out.print(arr[i] + " ");
    }

    private void traversal(int arr[], int n, int i, int[] result) {
        if (i >= n || arr[i] == -1) {
            return;
        }

        if (arr[i] > result[0]) {
            result[0] = arr[i];
        }
        if (arr[i] < result[1]) {
            result[1] = arr[i];
        }

        traversal(arr, n, 2 * i + 1, result);
        traversal(arr, n, 2 * i + 2, result);
    }

    public int findMax(int arr[], int n, int i, boolean bst) {
        if (bst == true) {
            while (2 * i + 2 < n && arr[2 * i + 2] != -1) {
                i = 2 * i + 2;
            }
            return arr[i];
        } else {
            int[] result = {Integer.MIN_VALUE, Integer.MAX_VALUE};
            traversal(arr, n, 0, result);
            return result[0];
        }
    }
    public int findMin(int arr[], int n, int i, boolean bst) {
        if (bst == true) {
            while (2 * i + 1 < n && arr[2 * i + 1] != -1) {
                i = 2 * i + 1;
            }
            return arr[i];
        } else {
            int[] result = {Integer.MIN_VALUE, Integer.MAX_VALUE};
            traversal(arr, n, 0, result);
            return result[1];
        }
    }

    public int search(int arr[], int n, int i, int key, boolean bst) {
        if (bst == true) {
            if (i >= n || arr[i] == -1) {
                return -1;
            }
            if (arr[i] == key) {
                return i;
            }
            int left = search(arr, n, 2 * i + 1, key, bst);
            if (left != -1) {
                return left;
            }
            int right = search(arr, n, 2 * i + 2, key, bst);
            return right;
        } 
        else {
            while (i < n && arr[i] != -1) {
                if (key == arr[i]) {
                    return i;
                } 
                else if (key < arr[i]) {
                    i = 2 * i + 1;
                } 
                else {
                    i = 2 * i + 2;
                }
            }
            return -1;
        }
    }

    private boolean isBSTUtil(int arr[], int n, int i, int min, int max) {
        if (i >= n || arr[i] == -1) {
            return true;
        }
        if (arr[i] < min || arr[i] > max) {
            return false;
        }
        return isBSTUtil(arr, n, 2 * i + 1, min, arr[i] - 1) &&
               isBSTUtil(arr, n, 2 * i + 2, arr[i] + 1, max);
    }

    public boolean isBST(int arr[], int n, int i){
        return isBSTUtil(arr, n, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}