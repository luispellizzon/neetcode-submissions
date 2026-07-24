class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
            (a,b) -> {
                int distA = Math.abs(a - x);
                int distB = Math.abs(b - x);

                if(distA != distB){
                    return Integer.compare(distB, distA);
                } else {
                    return Integer.compare(b, a);
                }
            }
        );

        for(int num: arr){
            maxHeap.offer(num);
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        int i = 0;
        while(i < k){
            result.add(maxHeap.poll());
            i++;
        }

        Collections.sort(result);
        return result;
    }
}