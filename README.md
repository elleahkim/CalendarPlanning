A calendar schedules for project plans, where each plan consists of tasks, each with a specific duration. 
Some tasks may depend on others, meaning they can only begin once the dependent tasks are completed. 
The solution should generate a schedule that accounts for the durations and dependencies of all tasks by assigning a Start Date and an End Date to each task in the set.

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Example input/output:

Choose an option:
1. Add new activity
2. Print schedule
3. Exit
Enter your choice: 1

Enter details for a new activity:
Name: Activity 1
Duration (in days): 10
Does this activity depend on any other activities? (yes/no): Please enter 'yes' or 'no': no
Enter start date (yyyy-MM-dd): 2024-12-01
Activity added successfully.

Current Schedule:
Activity: activity 1      | Start Date: 2024-12-01 | End Date: 2024-12-11

Choose an option:
1. Add new activity
2. Print schedule
3. Exit
Enter your choice: 1

Enter details for a new activity:
Name: Activity 2
Duration (in days): 40
Does this activity depend on any other activities? (yes/no): Please enter 'yes' or 'no': yes
Enter the number of dependencies: 1
Enter the name of dependency 1: Activity 1
Activity added successfully.

Current Schedule:
Activity: activity 1      | Start Date: 2024-12-01 | End Date: 2024-12-11
Activity: activity 2      | Start Date: 2024-12-11 | End Date: 2025-01-20
Dependencies: activity 1 

Choose an option:
1. Add new activity
2. Print schedule
3. Exit
Enter your choice: 3

Exiting and printing the final schedule...

Current Schedule:
Activity: activity 1      | Start Date: 2024-12-01 | End Date: 2024-12-11
Activity: activity 2      | Start Date: 2024-12-11 | End Date: 2025-01-20
Dependencies: activity 1 
