package project;

public class SortingAlgorithm{
    void displayarray(int[] arr){
        int n=arr.length;
        for (int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    void BubbleSort(int[] arr) {
        int n = arr.length;
        boolean flag;
        for (int i = 0; i < n - 1; i++) {
            flag=false;
            for (int j = 0; j < n - i - 1; j++) { //since we don't have to check for the i number of elements which is already sorted
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag=true;
                }

            if (!flag) break;
            }
        }
    }
    
    private void Merge(int[] arr,int left, int mid, int right) {
        //Create two separate arrays first
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) leftArr[i] = arr[left + i];
        for (int i = 0; i < n2; i++) rightArr[i] = arr[mid + 1 + i];

        //Sort. Here k is the starting index of our sorted array
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }  
    void MergeSort(int[] arr, int left, int right) { //we split the array into smaller parts
        if (left < right) {
            int mid = (left + right) / 2;
            MergeSort(arr,left, mid);
            MergeSort(arr,mid + 1, right);
            Merge(arr,left, mid, right);
        }
    }    
    
    private int Partition(int a[], int low, int high)
    {
        int pivot = a[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++)
        {
            if (a[j] <= pivot)
            {
                i++;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        int temp = a[i+1];
        a[i+1] = a[high];
        a[high] = temp;

        return i+1; //index of the pivot element in its position
    }
    void PartitionSort(int a[], int l, int h)
    {
        if (l < h)
        {
            int pi = Partition(a, l, h);
            PartitionSort(a, l, pi-1);
            PartitionSort(a, pi+1, h);
        }
    }
    
    void SelectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }
    
    void InsertionSort(int[] arr){
        int n=arr.length;
        for (int i=1;i<n;i++){
            int temp=arr[i];
            int j=i-1;
            while ((j!=-1)&&(arr[j]>temp)){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=temp;
        }
    }
}
