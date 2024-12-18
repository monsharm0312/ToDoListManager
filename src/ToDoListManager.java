import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListManager {

    private List<Task> tasks = new ArrayList<>();


    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
        System.out.println("Task added: " + description);
    }


    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted.");
        } else {
            System.out.println("Invalid task index.");
        }
    }


    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("Your tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                Task task = tasks.get(i);
                System.out.println((i + 1) + ". " + task.getDescription() + " (" + (task.isComplete() ? "Completed":"Incomplete") + ")");
            }
        }
    }


    public void markTaskComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).setComplete(true);
            System.out.println("Task marked as complete.");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public static void main(String[] args) {
        ToDoListManager manager = new ToDoListManager();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\nTo-Do List Manager");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Mark Task Complete");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();


            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    scanner.nextLine(); // Consume newline
                    String description = scanner.nextLine();
                    manager.addTask(description);
                    break;
                case 2:
                    System.out.print("Enter task index to delete: ");
                    int deleteIndex = scanner.nextInt() - 1;
                    manager.deleteTask(deleteIndex);
                    break;
                case 3:
                    manager.viewTasks();
                    break;
                case 4:
                    System.out.print("Enter task index to mark as complete: ");
                    int completeIndex = scanner.nextInt() - 1;
                    manager.markTaskComplete(completeIndex);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}


class Task {
    private String description;
    private boolean isComplete;

    public Task(String description) {
        this.description = description;
        this.isComplete = false;
    }


    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }
}