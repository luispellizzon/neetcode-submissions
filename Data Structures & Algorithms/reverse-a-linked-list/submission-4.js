/**
 * Definition for singly-linked list.
 * class ListNode {
 *     constructor(val = 0, next = null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    /**
     * @param {ListNode} head
     * @return {ListNode}
     */
    reverseList(head) {
        const stack = [];
        while(head !== null){
            stack.push(head);
            head = head.next;
        }

        if(stack.length > 0){
            head = stack.pop();
            let el = head;
            while(stack.length > 0){
                el.next = stack.pop();
                el = el.next;
            }
            el.next = null;
        }
        return head;
    }
}
