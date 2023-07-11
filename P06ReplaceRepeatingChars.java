import java.util.Scanner;

public class P06ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder st = new StringBuilder(input);

        for (int i = 0; i < st.length() - 1 ; i++) {
            if (st.charAt(i) == st.charAt(i + 1)){
                st.deleteCharAt(i + 1);
                i--;
            }
        }
        System.out.println(st);
    }
}
