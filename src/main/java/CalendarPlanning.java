/**
 *
 * @author Elleah Kim 2024
 * main flow
 */

import java.util.*;

public class CalendarPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Activity> activityMap = new HashMap<>();
        List<Activity> activities = new ArrayList<>();
        String startDate = null;  

        while (true) {
            // System.out.println("\nChoose an option:");
            System.out.println("1. Add new activity");
            System.out.println("2. Print schedule");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = Validator.getValidIntegerInput("", 1, 3, scanner);

            switch (choice) {
                case 1 -> {
                    // add activity
                    System.out.println("\nEnter details for a new activity:");

                    String name = Validator.getValidActivityName(scanner); 
                    name = name.toLowerCase(); // Make it case insensitive
                    while (activityMap.containsKey(name)) {  // Check if activity already exists
                        System.out.println("An activity with that name already exists. Please enter a different name.");
                        name = Validator.getValidActivityName(scanner).toLowerCase();
                    }

                    // activity duration in days
                    int duration = Validator.getValidIntegerInput("Duration (in days): ", 1, Integer.MAX_VALUE, scanner);

                    // get dependencies
                    List<Activity> dependencies = Validator.getDependencies(scanner, activityMap);

                    //ask once
                    if (startDate == null) {
                        startDate = Validator.getValidStartDate(scanner);  
                    }

                    // create new activity and add to the list and map
                    Activity activity = new Activity(name, duration, dependencies);
                    activity.setStartDate(startDate);
                    activity.calculateEndDate();

                    // add activity to map key is lowercase
                    activities.add(activity);
                    activityMap.put(name, activity);

                    System.out.println("Activity added successfully.");
                    Schedule.calculateSchedules(activities); 
                    Schedule.printSchedule(activities);  
                }

                case 2 -> {
                    // print the schedule
                    System.out.println("\nPrinting the current schedule...");
                    Schedule.printSchedule(activities);
                }

                case 3 -> {
                    // exit program
                    System.out.println("\nExiting and printing the final schedule...");
                    Schedule.printSchedule(activities);
                    return;
                }

                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
