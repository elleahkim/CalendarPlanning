
/**
 *
 * @author Elleah Kim 2024
 * this will validate all the user inputs
 */
import java.text.*;
import java.util.*;

public class Validator {

    // validate user input integer
    public static int getValidIntegerInput(String prompt, int min, int max, Scanner scanner) {
        int input;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); 
            }
        }
        return input;
    }

    // validate and trim activity name to lowercase
    public static String getValidActivityName(Scanner scanner) {
        String name;
        while (true) {
            System.out.print("Name: ");
            name = scanner.nextLine().trim();  
            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please enter a valid name.");
            } else {
                break;
            }
        }
        return name;
    }

    // validatestart date
    public static String getValidStartDate(Scanner scanner) {
        String startDate;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);  

        while (true) {
            System.out.print("Enter start date (yyyy-MM-dd): ");
            startDate = scanner.nextLine().trim();  
            try {
                dateFormat.parse(startDate);  
                break;  
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please use yyyy-MM-dd format.");
            }
        }
        return startDate;
    }

    //validate  yes/no
    public static String getValidYesNoInput(Scanner scanner) {
        String input;
        while (true) {
            input = scanner.nextLine().trim(); 
            if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("no")) {
                break;
            } else {
                System.out.print("Please enter 'yes' or 'no': ");
            }
        }
        return input;
    }

    // validate and trim dependencies
    public static List<Activity> getDependencies(Scanner scanner, Map<String, Activity> activityMap) {
        List<Activity> dependencies = new ArrayList<>();
        System.out.print("Does this activity depend on any other activities? (yes/no): ");
        String dependsAnswer = getValidYesNoInput(scanner);

        if (dependsAnswer.equalsIgnoreCase("yes")) {
            int numDependencies = getValidIntegerInput("Enter the number of dependencies: ", 1, Integer.MAX_VALUE, scanner);
            for (int j = 0; j < numDependencies; j++) {
                Activity dependency = null;
                while (dependency == null) {
                    System.out.print("Enter the name of dependency " + (j + 1) + ": ");
                    // Trim and convert to lowercase
                    String dependencyName = scanner.nextLine().trim().toLowerCase();  
                    dependency = activityMap.get(dependencyName); 

                    if (dependency == null) {
                        System.out.println("Error: Activity '" + dependencyName + "' not found. Please enter a valid activity name.");
                    }
                }
                dependencies.add(dependency);
            }
        }

        return dependencies;
    }
}
