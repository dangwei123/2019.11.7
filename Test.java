给定两个代表非负数的链表，数字在链表中是反向存储的（链表头结点处的数字是个位数，第二个结点
上的数字是百位数...），求这个两个数的和，结果也用链表表示。
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出： 7 -> 0 -> 8
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        int carry=0;
        while(l1!=null||l2!=null||carry!=0){
            int num1=l1==null?0:l1.val;
            int num2=l2==null?0:l2.val;
            int num=num1+num2+carry;
            carry=num/10;
            cur.next=new ListNode(num%10);
            cur=cur.next;
            if(l1!=null){
                l1=l1.next;
            }if(l2!=null){
                l2=l2.next;
            }
        }
        return dummy.next;
    }
}

将给定的单链表L： L 0→L 1→…→L n-1→L n,
重新排序为： L 0→L n →L 1→L n-1→L 2→L n-2→…
要求使用原地算法，并且不改变节点的值
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode cur=slow.next;
        slow.next=null;
        ListNode pre=null;
        ListNode newHead=null;
        while(cur!=null){
            ListNode curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        slow=head;
        while(newHead!=null){
            ListNode curNext=newHead.next;
            newHead.next=slow.next;
            slow.next=newHead;
            slow=slow.next.next;
            newHead=curNext;
        }
    }
}