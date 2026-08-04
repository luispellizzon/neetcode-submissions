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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)  return;

        List<ListNode> map = new ArrayList<>();

        ListNode current = head;
        while(current != null){
            map.add(current);
            current = current.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        int left = 0;
        int right = map.size() - 1;
        while(left <= right){
            curr.next = map.get(left++);
            curr = curr.next;

            if(left <= right){
                curr.next = map.get(right--);
                curr = curr.next;
            }
        }
        curr.next = null;

    }
}
