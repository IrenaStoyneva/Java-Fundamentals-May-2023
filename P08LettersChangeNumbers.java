import java.util.Scanner;

public class P08LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        StringBuilder st = new StringBuilder(input);

        int explosionStrenght = 0;

        for (int position = 0; position < st.length(); position++) {
           char currentSymbol = st.charAt(position);
           if (currentSymbol == '>'){
               int deletedExplosion = Integer.parseInt(st.charAt(position + 1 )+ "");
               explosionStrenght += deletedExplosion;
           }else if (currentSymbol != '>' && explosionStrenght > 0 ){

               st.deleteCharAt(position);
               explosionStrenght--;
               position--;
           }

        }
        System.out.println(st);
    }
}
