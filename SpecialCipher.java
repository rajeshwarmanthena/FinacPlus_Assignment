import java.util.*;
public class SpecialCipher{
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      String input = sc.nextLine();
      int rotation = sc.nextInt();
      input = CaesarsCipher(input,rotation);
      System.out.println(SimpleRLE(input));
      
      
    }
    private static String CaesarsCipher(String input,int k){
        StringBuilder result = new StringBuilder();
        for(char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                char newChar = (char) (((c - base + k) % 26) + base);
                result.append(newChar);
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }
    private static String SimpleRLE(String input){
        StringBuilder result = new StringBuilder();
        if (input == null || input.isEmpty()) {
            return result.toString();
        }

        char prevChar = input.charAt(0);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == prevChar) {
                count++;
            } else {
                result.append(prevChar);
               if(count>1) result.append(count);
                count = 1;
                prevChar = currentChar;
            }
        }
        result.append(prevChar);
        if(count>1)result.append(count);
        return result.toString();

    }
}
