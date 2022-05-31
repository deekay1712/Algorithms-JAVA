import java.util.Scanner;

public class Main {
    public static void findFrequency(String s, int freq[]){
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
    }

    public static boolean isLexicographicallyPalindromePossible(String s, int freq[]){
        int length = s.length();
        int odd_count = 0;
        for(int i = 0; i < freq.length; i++){
            if(freq[i]%2 != 0){
                odd_count++;
            }
        }

        if(length%2 == 0 && odd_count == 0){
            return true;
        }
        else if(length%2 != 0 && odd_count == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public static String lexicographicallyPalindrome(String s){
        String odd_str="", front_str="", back_str="";
        int freq[] = new int [26];
        findFrequency(s, freq);

        if(isLexicographicallyPalindromePossible(s, freq)){
            for(int i=0; i<26; i++){
                if(freq[i]%2 != 0){
                    for(int j=0; j<freq[i]; j++){
                        odd_str += (char)(i+'a');
                    }
                }
            }
            for(int i=0; i<26; i++){
                if(freq[i]%2 == 0){
                    for(int j=0; j<freq[i]/2; j++){
                        front_str += (char)(i+'a');
                    }
                }
            }
            for(int i=25; i>=0; i--){
                if(freq[i]%2 == 0){
                    for(int j=0; j<freq[i]/2; j++){
                        back_str += (char)(i+'a');
                    }
                }
            }
            return front_str + odd_str + back_str;
        }
        else
            return "Lexicographically Palindrome is not possible";
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String s = sc.nextLine();
        System.out.println(lexicographicallyPalindrome(s));
        sc.close();
    }
}
