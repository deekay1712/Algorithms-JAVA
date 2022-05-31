import java.io.*;
public class Main {
    public static int flipBit(int num){
        int currLen = 0, maxLen = 0, prevLen = 0;
        while(num!=0){
            if((num & 1) == 1){
                currLen++;
            }
            else if((num & 1) == 0){
                prevLen = (num & 2) == 0 ? 0 : currLen;
                currLen = 0;
            }
            num >>= 1;
            maxLen = Math.max(maxLen, currLen + prevLen);
        }
        return maxLen;
    }

    public static void main(String args[])
    throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a number: ");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Longest subsequence: " + flipBit(n));
    }
}
