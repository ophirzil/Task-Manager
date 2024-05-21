import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Task implements Comparable<Task>{

    private String description;
    private String priority;
    private String asignee;
    private LocalDateTime time;
    private  final int ID;

    private static final Map<String, Integer> priorityMap= new HashMap<>();
    {
        priorityMap.put("h",3);
        priorityMap.put("n",2);
        priorityMap.put("l",1);
    }

    public Task(String description, String priority, String asignee, LocalDateTime time,int ID){

        this.description=description;
        this.priority=priority;
        this.asignee=asignee;
        this.time=time;
        this.ID=ID;

    }
    public String getDescription(){
        return description;
    }
    public String getPriority(){
        return priority;
    }
    public String getAsignee(){
        return asignee;
    }
    public LocalDateTime getTime(){
        return time;
    }
    @Override
    public int compareTo(Task other){
        int thisPRIO= priorityMap.get(this.priority);
        int otherPRIO= priorityMap.get(other.priority);
        int compare= Integer.compare(thisPRIO, otherPRIO);
        if (compare != 0) return compare;

        return this.time.compareTo(other.time);

    }
    @Override
    public String toString(){
        return "description: "+ this.description+ " assignee: " + this.asignee;
    }



}
