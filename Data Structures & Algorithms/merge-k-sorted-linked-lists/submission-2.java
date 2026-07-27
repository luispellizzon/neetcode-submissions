/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // List<Integer> res = new ArrayList<>();

        // for(ListNode node: lists){
        //     while(node != null){
        //         res.add(node.val);
        //         node = node.next;
        //     }
        // }

        // res.sort(Comparator.naturalOrder());

        // ListNode dummy = new ListNode();
        // ListNode curr = dummy;
        // for(int i  = 0; i < res.size(); i ++){
        //     curr.next =  new ListNode(res.get(i));
        //     curr = curr.next;
        // }

        // return dummy.next;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for(ListNode list:lists){
            if(list != null){
                minHeap.add(list);
            }
        }
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        while(!minHeap.isEmpty()){
            ListNode removedNode =  minHeap.poll();
            if(removedNode.next != null){
                minHeap.add(removedNode.next);
            }
            removedNode.next = null;
            curr.next = removedNode;
            curr = curr.next;
        }

        return dummy.next;
    }
}
