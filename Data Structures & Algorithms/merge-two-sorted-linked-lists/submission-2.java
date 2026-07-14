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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode cleaner = null;
        ListNode head = null;
        if(p1.val < p2.val){
            head = p1;
            cleaner = p1;
            p1 = p1.next;
            cleaner = null;
        } else {
            head = p2;
            cleaner = p2;
            p2 = p2.next;
            cleaner = null;
        }
        
        ListNode tail = head;

        while(p1 != null && p2 != null){
            ListNode newNode = new ListNode();
            if(p1.val < p2.val){
                newNode.val = p1.val;
                tail.next = newNode;
                tail = newNode;
                cleaner = p1;
                p1 = p1.next;
                cleaner = null;
            }
            else {
                newNode.val = p2.val;
                tail.next = newNode;
                tail = newNode;
                cleaner = p2;
                p2 = p2.next;
                cleaner = null;
            }
        }

        if(p1 != null){
            tail.next = p1;
        }

        
        if(p2 != null){
            tail.next = p2;
        }
        tail = null;


        return head;
    }
}