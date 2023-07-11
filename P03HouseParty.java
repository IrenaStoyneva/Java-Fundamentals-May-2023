import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCommands = Integer.parseInt(scanner.nextLine());

        List<String> commandsList = new ArrayList<>();



        for (int i = 1; i <= countCommands; i++) {
            String commands = scanner.nextLine();
            String name = commands.split(" ")[0];

            if (commands.contains("is going!")){


                if (commandsList.contains(name)){

                    System.out.println(name + " is already in the list!");
                }else {
                    commandsList.add(name);
                }

            } else if (commands.contains(" is not going!")) {

                if (commandsList.contains(name)){
                    commandsList.remove(name);
                }else {
                    System.out.println(name + " is not in the list!");
                }

                
            }

        }

        for ( String names : commandsList) {
            System.out.println(names);

        }
    }
}
