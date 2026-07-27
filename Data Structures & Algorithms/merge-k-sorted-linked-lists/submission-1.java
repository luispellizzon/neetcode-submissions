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
        List<Integer> res = new ArrayList<>();

        for(ListNode node: lists){
            while(node != null){
                res.add(node.val);
                node = node.next;
            }
        }

        res.sort(Comparator.naturalOrder());

        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        for(int i  = 0; i < res.size(); i ++){
            curr.next =  new ListNode(res.get(i));
            curr = curr.next;
        }

        return dummy.next;
    }
}
