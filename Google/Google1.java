/**
 * QUES 1 -> Merge K sorted Lists (LEETCODE - 23)
 * 
 * Company - Google
 * 
 * #revisewitharsh 
 * #6companies30dayschallenge
 */
class Solution {
    private class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;

        ListNode left = mergeKLists(lists, start, mid);

        ListNode right = mergeKLists(lists, mid+1, end);

        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1);

        ListNode temp = head;

        while(left != null && right != null) {
            if(left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        while(left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }

        while(right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }
        return head.next;
    }
}