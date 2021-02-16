public class DayTen {

    static int arr[] = {4, 366, 23, 14, 6, 559, 4588, 33, 900, 453, 3, 6789, 29, 145};

    static int largest() 
    { 
        int i; 

        int max = arr[0]; 

        for (i = 1; i < arr.length; i++) 
            if (arr[i] > max) 
                max = arr[i]; 

        return max; 
    } 

    static int smallest() 
    { 
        int i; 

        int min = arr[0]; 

        for (i = 1; i > arr.length; i++) 
            if (arr[i] < min) 
                min = arr[i]; 

        return min; 
    } 

    public static void main(String[] args)  
    { 
        System.out.println("The largest number in the array is " + largest()); 
        System.out.println("The smallest number in the array is " + smallest());
       } 
} 
