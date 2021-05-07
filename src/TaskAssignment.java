import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TaskAssignment {
    //O(n log n) time where n is the length of input array
    //O(n) space - storing pairs for output
    public static ArrayList<ArrayList<Integer>> taskAssignments(int k, ArrayList<Integer> tasks){
        ArrayList<ArrayList<Integer>> pairedTasks = new ArrayList<ArrayList<Integer>>(); //initialize output

        //Map taskDuration to Index (original)
        var taskDurationsToIndices = getTaskDurationsToIndices(tasks); //key is duration, value is index (original)

        //create a reference with an updated name to distinguish from unsorted vs. sorted tasks
        ArrayList<Integer> sortedTasks = tasks;
        Collections.sort(sortedTasks);

        for(int idx = 0; idx < k; idx++){
            int taskOneDuration = sortedTasks.get(idx); //get smallest duration
            ArrayList<Integer> indicesWithTaskOneDuration = taskDurationsToIndices.get(taskOneDuration);
            int taskOneIdx = indicesWithTaskOneDuration.remove(indicesWithTaskOneDuration.size() - 1); //take index w/ at end of list

            int taskTwoSortedIdx = sortedTasks.size() - 1 - idx; //idx w/ largest duration in sorted array is last item - idx (onion layers)
            int taskTwoDuration = sortedTasks.get(taskTwoSortedIdx); //get largest duration
            ArrayList<Integer> indicesWithTaskTwoDuration = taskDurationsToIndices.get(taskTwoDuration); //get original idx for largest duration
            int taskTwoIndex = indicesWithTaskTwoDuration.remove(indicesWithTaskTwoDuration.size() - 1);

            ArrayList<Integer> pairedTask = new ArrayList<Integer>();
            pairedTask.add(taskOneIdx);
            pairedTask.add(taskTwoIndex);
            pairedTasks.add(pairedTask);
        }

        return pairedTasks;
    }

    public static HashMap<Integer, ArrayList<Integer>> getTaskDurationsToIndices(ArrayList<Integer> tasks){
        //helper function maps taskDurations to indices
        HashMap<Integer, ArrayList<Integer>> taskDurationsToIndices = new HashMap <Integer, ArrayList<Integer>>();

        for(int idx = 0; idx < tasks.size(); idx++){
            int taskDuration = tasks.get(idx);
            //if key already exists (taskDuration), append value (another index) to ArrayList
            if(taskDurationsToIndices.containsKey(taskDuration)) {
                taskDurationsToIndices.get(taskDuration).add(idx);
            } else {
                //if key !exist, create new ArrayList, append idx, store as value for taskDuration (key)
                var idxArrayList = new ArrayList<Integer>();
                idxArrayList.add(idx);
                taskDurationsToIndices.put(taskDuration, idxArrayList);
            }
        }
        return taskDurationsToIndices;
    }
}
