import java.util.*;
public class Main {
    public static void findMajorityElement(int arr[]){
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int size = arr.length;
        int majority = size/2;
        int count;
        for(int i=0;i<size;i++){
            if(map.containsKey(arr[i])){
                count = map.get(arr[i]);
                map.put(arr[i], count+1);
                if(count+1 > majority){
                    System.out.println("Majority element is: " + arr[i]);
                    return;
                }
            }
            else{
                map.put(arr[i], 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        findMajorityElement(arr);
        sc.close();
    }
}
