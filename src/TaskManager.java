import java.util.*;
public class TaskManager {

    private PriorityQueue<Task> tasks;
    private Map<String, PriorityQueue<Task>> Mapasignee;
    private  Deque<Task> completedTasks;
    private int capacity= 50;


    public TaskManager(){
        tasks= new PriorityQueue<>();
        Mapasignee= new HashMap<>();
        completedTasks= new ArrayDeque<>() {
        };

    }
    public void addTask(Task task){
        if(tasks.size()< capacity){
            tasks.add(task);
            Mapasignee.computeIfAbsent(task.getAsignee(),k -> new PriorityQueue<>()).add(task);
        }
        else {
            System.out.println("Task Capacity reached");
        }
    }
    public Task RetrieveByPrio(){
        return tasks.peek();
    }
    public Task RetrieveByAssign(String asignee){
        PriorityQueue<Task> tasksForAsignee= Mapasignee.get(asignee);
        if (tasksForAsignee != null){
            return tasksForAsignee.peek();
        }
        return null;
    }
    public void MarkCompleted(){
        if (!tasks.isEmpty()){
            Task task= tasks.poll();
            Mapasignee.get(task.getAsignee()).remove(task);
            completedTasks.addFirst(task);
            if(completedTasks.size() > 10){
                completedTasks.removeLast();
            }
            else{
                System.out.println("NO TASKS AVAILABLE TO COMPLETE");
            }

        }
    }
    public void changeCapacity(int capacity){
        capacity= capacity;

    }
    public List<Task> RetrieveForAsignee(String assigne){
        List<Task> list= new ArrayList<>(Mapasignee.get(assigne));
        return list;

    }
    public List<Task> RetrieveForAsigneePrio(String assigne, String priority){
        List<Task> list= new ArrayList<>(Mapasignee.get(assigne));
        for (Task task : list) {
            if( task.getPriority() != priority){
                list.remove(task);
            }
        }
        return list;
    }
    public List<Task> RetrieveCompleted(){
        List<Task> list= new ArrayList<>(completedTasks);
        return list;
    }



}
