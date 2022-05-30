import java.util.*;

public class Main {
    public static void findLeaders(int arr[]){
        int max = Integer.MIN_VALUE;
        Vector<Integer> leaders = new Vector<Integer>();
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i] > max){
                max = arr[i];
                leaders.add(max);
            }
        }

        System.out.println("Leaders are: ");
        for(int i=leaders.size()-1;i>=0;i--){
            System.out.print(leaders.get(i) + " ");
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        findLeaders(arr);
        sc.close();
    }
}
