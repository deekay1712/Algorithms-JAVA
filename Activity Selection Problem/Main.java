import java.util.Scanner;

public class Main {
    static void activitySelectionProblem(int[] start, int[] finish, int[] activity) {
        int n = start.length;
        int i=0, j;
        System.out.println("The activities are: ");
        System.out.println(activity[i]+" ");
        for(j=1; j<n; j++) {
            if(start[j] >= finish[i]) {
                System.out.println(activity[j]+" ");
                i = j;
            }
        }            
    }
    static void sortArrays(int[] start, int[] finish, int[] activity){
        int n = start.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - i - 1; j++){
                if (finish[j] > finish[j + 1]) {
                    int temp1 = finish[j];
                    finish[j] = finish[j + 1];
                    finish[j + 1] = temp1;

                    int temp2 = start[j];
                    start[j] = start[j + 1];
                    start[j + 1] = temp2;

                    int temp3 = activity[j];
                    activity[j] = activity[j + 1];
                    activity[j + 1] = temp3;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of activities: ");
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] finish = new int[n];
        System.out.println("Enter the start time of activities: ");
        for(int i=0; i<n; i++)
            start[i] = sc.nextInt();
        System.out.println("Enter the finish time of activities: ");
        for(int i=0; i<n; i++)
            finish[i] = sc.nextInt();
        int[] activity = new int[n];
        for(int i=0; i<n; i++)
            activity[i] = i+1;
        sortArrays(start, finish, activity);
        activitySelectionProblem(start, finish, activity);
        sc.close();
    }
}
