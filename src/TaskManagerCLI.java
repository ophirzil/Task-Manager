import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class TaskManagerCLI{
    private TaskManager taskManager;

    public TaskManagerCLI(){
        this.taskManager=new TaskManager();
    }
    public void cli() {
        Scanner scanner = new Scanner(System.in);
        String command;
        System.out.println("Welcome to the the Task Manager");
        while (true) {
            System.out.println("Available commands are: insert, complete,get by priority, get by assignee, get by assignee and priority,change capacity, get 10 completed ,exit");
            command = scanner.nextLine();

            switch (command) {
                case "insert":
                    System.out.println("please enter ID, description, priority and assignee(by this order");
                    int ID= scanner.nextInt();
                    String description= scanner.nextLine();
                    String priority= scanner.nextLine();
                    String assignee= scanner.nextLine();
                    taskManager.addTask(new Task(description,priority,assignee, LocalDateTime.now(), ID));
                    break;
                case "complete":
                    taskManager.MarkCompleted();
                    break;
                case "change capacity":
                    System.out.println("enter new capacity");
                    int capacity= scanner.nextInt();
                    taskManager.changeCapacity(capacity);
                    break;
                case "get by priority":
                    taskManager.RetrieveByPrio();
                    break;
                case "get by assignee":
                    System.out.println("enter assignee");
                    String assigne=scanner.nextLine();
                    Task task= taskManager.RetrieveByAssign(assigne);
                    task.toString();
                    break;
                case "get by assignee and priority":
                    System.out.println("enter assignee and priority");
                    assigne= scanner.nextLine();
                    priority=scanner.nextLine();
                    List<Task> list= taskManager.RetrieveForAsigneePrio(assigne, priority);
                    System.out.println(Arrays.toString(list.toArray()));
                case "get 10 completed":
                    list= taskManager.RetrieveCompleted();
                    System.out.println(Arrays.toString(list.toArray()));
                    break;
                case "exit":
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command.");
                    break;




            }
        }
    }

}