import java.util.Scanner;

public class Main {
    public static void swap(int arr[], int fi, int si, int d)
    {
        int i, temp;
        for(i = 0; i < d; i++)
        {
            temp = arr[fi + i];
            arr[fi + i] = arr[si + i];
            arr[si + i] = temp;
        }
    }
    public static void leftRotateRec(int arr[], int i, int d, int n)
    {
        if(d == 0 || d == n)
            return;
    
        if(n - d == d){
            swap(arr, i, n - d + i, d);
            return;
        }
          
        if(d < n - d){
            swap(arr, i, n - d + i, d);
            leftRotateRec(arr, i, d, n - d);    
        }
        else{
            swap(arr, i, d, n - d);
            leftRotateRec(arr, n - d + i, 2 * d - n, d); 
        }
    }

    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter the number of rotations: ");
        int d = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements: ");
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        leftRotateRec(arr, 0, d, n);

        for (int i=0; i<n; i++)
            System.out.print(arr[i] + " ");

        sc.close();
    }
}
