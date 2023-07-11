import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int countDays = 0;
        int totalAmound = 0;

        while (startingYield >= 100) {
            int workersCrew = startingYield - 26;
            totalAmound += workersCrew;
            startingYield -= 10;
            countDays++;
        }

        System.out.println(countDays);

            if (totalAmound >= 26) {
                totalAmound -= 26;
            }
                System.out.println(totalAmound);

            }
            
    }
