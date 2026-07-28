class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] req: prerequisites){
            indegree[req[1]]++;
            adj.get(req[0]).add(req[1]);
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        int finish = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            finish++;

            for(int nei : adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.offer(nei);
                }
            }
        }


        return finish == numCourses;

    }
}
