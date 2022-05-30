import java.util.Scanner;

public class Main{
    
    public static boolean isBinaryPalindrome(int n){
        int temp = n;
        long reverse = 0;
        while(temp > 0){
            reverse <<= 1;
            if ((temp & 1) == 1)
                reverse |= 1;
            temp >>= 1;
        }
        if(n == reverse)
            return true;
        else
            return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = sc.nextInt();
        if(isBinaryPalindrome(n))
            System.out.println("Number is a binary palindrome");
        else
            System.out.println("Number is not a binary palindrome");
    }
}