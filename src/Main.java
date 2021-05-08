import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
       var k = 3;
       var tasks = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 1, 4));
       var assignments = TaskAssignment.taskAssignments(3, tasks);
        System.out.println(assignments);
    }
}

