/**
 *
 * @author Elleah Kim 2024
 * methods for printing, and calculating schedules
 */
import java.util.*;

public class Schedule {

    // print the schedule for all activities.
    public static void printSchedule(List<Activity> activities) {
        System.out.println("\nCurrent Schedule:");
        if (activities.isEmpty()) {
            System.out.println("No activities to display.");
        } else {
            
            for (Activity activity : activities) {
                System.out.printf("Activity: %-15s | Start Date: %-10s | End Date: %-10s\n", 
                        activity.getName(), activity.getStartDate(), activity.getEndDate());
                if (!activity.getDependencies().isEmpty()) {
                    System.out.print("Dependencies: ");
                    for (Activity dep : activity.getDependencies()) {
                        System.out.print(dep.getName() + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    // calculate the start and end dates for each activity/dependencies
    public static void calculateSchedules(List<Activity> activities) {
        for (Activity activity : activities) {
            if (!activity.getDependencies().isEmpty()) {
                //latest end date dependencies
                String latestEndDate = getLatestEndDate(activity.getDependencies());
                activity.setStartDate(latestEndDate);
            }
            // calculates
            activity.calculateEndDate();
        }
    }

    // find the latest end date dependencies
    private static String getLatestEndDate(List<Activity> dependencies) {
        String latestEndDate = null;
        for (Activity dep : dependencies) {
            if (latestEndDate == null || dep.getEndDate().compareTo(latestEndDate) > 0) {
                latestEndDate = dep.getEndDate();
            }
        }
        return latestEndDate;
    }
}
