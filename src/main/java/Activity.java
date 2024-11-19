/**
 *
 * @author Elleah Kim 2024
 */
import java.util.*;
import java.text.*;

public class Activity {
    private String name;
    private int duration;
    private String startDate;
    private String endDate;
    private List<Activity> dependencies;

    public Activity(String name, int duration, List<Activity> dependencies) {
        this.name = name;
        this.duration = duration;
        this.dependencies = dependencies != null ? dependencies : new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Activity> getDependencies() {
        return dependencies;
    }

    // calculate end date from the start date and duration
    public void calculateEndDate() {
        if (startDate == null) {
            return;
        }
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            Date start = dateFormat.parse(startDate);
            calendar.setTime(start);
            calendar.add(Calendar.DAY_OF_YEAR, duration);
            this.endDate = dateFormat.format(calendar.getTime());
        } catch (ParseException e) {
        }
    }
}
