import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopologicalSort {

    //O(j + d) time, space complexity

    public List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps){
        var jobGraph = createJobGraph(jobs, deps);
        return getOrderedJobs(jobGraph);
    }

    public JobGraph createJobGraph(List<Integer> jobs, List<Integer[]> deps){
        var graph = new JobGraph(jobs); //JG constructor populates graph with nodes
        for(Integer[] dep: deps){
            graph.addPrereq(dep[1], dep[0]); //iterate all dependencies
        }
        return graph;
    }

    public List<Integer> getOrderedJobs(JobGraph graph){
        List<Integer> orderedJobs = new ArrayList<Integer>();
        List<JobNode> jobs = new ArrayList<JobNode>(graph.jobs);
        while(jobs.size() > 0){
            var job = jobs.get(jobs.size() -1);
            jobs.remove(jobs.size() -1);
            boolean containsCycle = depthFirstTraverse(job, orderedJobs);
            if(containsCycle) return new ArrayList<Integer>(); //return empty array list
        }
        return orderedJobs;
    }

    public boolean depthFirstTraverse(JobNode job, List<Integer> orderedJobs) {
        if(job.visited) return false; //skip
        if(job.visiting) return true; //have a cycle
        job.visiting = true;
        for(var preReqJob : job.preRequesiteJobs){
            boolean containsCycle = depthFirstTraverse(preReqJob, orderedJobs);
            if(containsCycle) return true;
        }
        job.visited = true;
        job.visiting = false;
        orderedJobs.add(job.job);
        return false;
    }

    public class JobGraph {
        public List<JobNode> jobs; //List interface
        public Map<Integer, JobNode> graph; //Graph interface

        public JobGraph(List<Integer> jobs) {
            this.jobs = new ArrayList<JobNode>(); //ArrayList - programing against an List interface
            graph = new HashMap<Integer, JobNode>();
            for (Integer job: jobs){
                addNode(job); //iterate over all nodes
            }
        }
        public void addNode(Integer job){
            graph.put(job, new JobNode(job));
            jobs.add(graph.get(job));
        }
        public void addPrereq(Integer job, Integer prereq){
            var jobNode = getNode(job);
            var preReqNode = getNode(prereq);
            jobNode.preRequesiteJobs.add(preReqNode); //field w/in JobNode
        }
        public JobNode getNode(Integer job){
            if(!graph.containsKey(job)) addNode(job);
            return graph.get(job);
        }
    }

    public class JobNode {
        public Integer job; //label
        public List<JobNode> preRequesiteJobs;
        public boolean visited;
        public boolean visiting;

        public JobNode(Integer job) {
            this.job = job;
            preRequesiteJobs = new ArrayList<JobNode>();
            visited = false;
            visiting = false;
        }
    }
}
