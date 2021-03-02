using System;
 
public class Day29 {
    public void sort(int[] arr)
    {
        int n = arr.Length;
 
        for (int i = n / 2 - 1; i >= 0; i--)
            heapsort(arr, n, i);
 
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            heapsort(arr, i, 0);
        }
    }
 

    void heapsort(int[] arr, int n, int i)
    {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2;
 
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            heapsort(arr, n, largest);
        }
    }
 
    static void printArray(int[] arr)
    {
        int n = arr.Length;
        for (int i = 0; i < n; ++i)
            Console.Write(arr[i] + " ");
        Console.Read();
    }
 
    public static void Main()
    {
        int[] arr = { 67, 17, 44, 87, 9, 2, 90 };
        int n = arr.Length;
 
        HeapSort ob = new Day29();
        ob.sort(arr);
 
        Console.WriteLine("Sorted result: ");
        printArray(arr);
    }
}
