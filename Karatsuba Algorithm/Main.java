import java.util.Scanner;

public class Main {
    public static int lengthOfNum(long num){
        int count = 0;
        while(num>0){
            count++;
            num/=10;
        }
        return count;
    }

    public static long karatsuba(long x, long y){
        if(x<10 || y<10)
            return x*y;

        int n = Math.max(lengthOfNum(x), lengthOfNum(y));
        int m = n/2;
        long a = x/((long)Math.pow(10, m));
        long b = x%((long)Math.pow(10, m));
        long c = y/((long)Math.pow(10, m));
        long d = y%((long)Math.pow(10, m));

        long ac = karatsuba(a, c);
        long bd = karatsuba(b, d);
        long ad_plus_bc = karatsuba((a+b), (c+d));
        return ac*((long)Math.pow(10, 2*m)) + (ad_plus_bc - ac - bd)*((long)Math.pow(10, m)) + bd;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        long x = sc.nextLong();
        System.out.println("Enter the second number: ");
        long y = sc.nextLong();
        System.out.println("The product of the two numbers is: " + karatsuba(x, y));
        sc.close();
    }
}
