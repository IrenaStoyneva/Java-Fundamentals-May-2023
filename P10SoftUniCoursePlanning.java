import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> initialSchedule = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());


        String modifyCommand = scanner.nextLine();


        while (!modifyCommand.equals("course start")) {
            String firstLessonTitle = commandRead(modifyCommand)[1];
            String command = commandRead(modifyCommand)[0];
            String secondLessonTitle = "";
            int index = 0;

            if (commandRead(modifyCommand).length > 2) {
                secondLessonTitle = commandRead(modifyCommand)[2];
            }

            switch (command) {
                case "Add":
                    if (!initialSchedule.contains(firstLessonTitle)) {
                        initialSchedule.add(firstLessonTitle);
                    }
                    break;
                case "Insert":
                    index = Integer.parseInt(commandRead(modifyCommand)[2]);
                    if (!initialSchedule.contains(firstLessonTitle)) {
                        initialSchedule.add(index, firstLessonTitle);
                    }
                    break;
                case "Remove":
                    if (initialSchedule.contains(firstLessonTitle)) {
                        if (secondTittleExercise(initialSchedule, firstLessonTitle)) {
                            int indexExercise = initialSchedule.indexOf(firstLessonTitle) + 1;
                            initialSchedule.remove(indexExercise);
                        }
                        initialSchedule.remove(firstLessonTitle);
                    }
                    break;
                case "Swap":
                    swapCommand(initialSchedule, firstLessonTitle, secondLessonTitle);
                    break;
                case "Exercise":
                    if (initialSchedule.contains(firstLessonTitle)) {
                        if (!firstTittleExercise(initialSchedule, firstLessonTitle)) {
                            int indexExercise = initialSchedule.indexOf(firstLessonTitle) + 1;
                            initialSchedule.add(indexExercise, firstLessonTitle + "-Exercise");
                        }
                    } else {
                        initialSchedule.add(firstLessonTitle);
                        initialSchedule.add(firstLessonTitle + "-Exercise");
                    }
                    break;
            }
            modifyCommand = scanner.nextLine();
        }

        int count = 1;
        for (String element : initialSchedule) {
            System.out.println(count + "." +element);
            count++;
        }
    }

    public static void swapCommand(List<String> initialSchedule, String firstLessonTitle, String secondLessonTitle) {
        if (initialSchedule.contains(firstLessonTitle) && initialSchedule.contains(secondLessonTitle)) {
            int indexFirstTitle = initialSchedule.indexOf(firstLessonTitle);
            int indexSecondTitle = initialSchedule.indexOf(secondLessonTitle);
            initialSchedule.set(indexSecondTitle, firstLessonTitle);
            initialSchedule.set(indexFirstTitle, secondLessonTitle);
            if (firstTittleExercise(initialSchedule, firstLessonTitle)
                    && secondTittleExercise(initialSchedule, secondLessonTitle)) {
                initialSchedule.set(indexFirstTitle + 1, secondLessonTitle + "-Exercise");
                initialSchedule.set(indexSecondTitle + 1, firstLessonTitle + "-Exercise");
            } else if (firstTittleExercise(initialSchedule, firstLessonTitle)) {
                initialSchedule.add(indexSecondTitle + 1, firstLessonTitle + "-Exercise");
                initialSchedule.remove(indexFirstTitle + 1);
            } else if (secondTittleExercise(initialSchedule, secondLessonTitle)) {
                initialSchedule.add(indexFirstTitle + 1, secondLessonTitle + "-Exercise");
                initialSchedule.remove(indexSecondTitle + 2);
            }
        }
    }

    public static String[] commandRead(String modifyCommand) {
        String[] commandSplit = modifyCommand.split(":");
        return commandSplit;
    }

    public static boolean firstTittleExercise(List<String> initialSchedule, String firstLessonTitle) {
        return initialSchedule.contains(firstLessonTitle + "-Exercise");
    }

    public static boolean secondTittleExercise(List<String> initialSchedule, String secondLessonTitle) {
        return initialSchedule.contains(secondLessonTitle + "-Exercise");
    }
}

