//输入一个链表，反转链表后，输出新链表的表头
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre=null;
        ListNode cur=head;
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
        return newHead;
    }
}

//将给定的链表向右转动k个位置，k是非负数。
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
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null){
            return null;
        }
        int len=getLen(head);
        n=n%len;
        if(n==0){
            return head;
        }
        ListNode cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=head;
        cur=head;
        for(int i=0;i<len-1-n;i++){
            cur=cur.next;
        }
        ListNode newHead=cur.next;
        cur.next=null;
        return newHead;
    }
    public int getLen(ListNode head){
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            cur=cur.next;
            len++;
        }
        return len;
    }
}

//对链表进行插入排序。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=head;
        while(cur!=null&&cur.next!=null&&cur.val<cur.next.val){
            cur=cur.next;
        }
       
        while(cur!=null){
             ListNode pre=dummy;
            if(cur.next!=null&&cur.next.val<cur.val){
                ListNode curNext=cur.next;
                cur.next=curNext.next;
                while(pre.next.val<curNext.val){
                    pre=pre.next;
                }
                curNext.next=pre.next;
                pre.next=curNext;
            }else{
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}

//给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reorder-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null){
            return ;
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
        cur=head;
        while(newHead!=null&&cur.next!=null){
            ListNode newHeadNext=newHead.next;
            newHead.next=cur.next;
            cur.next=newHead;
            cur=cur.next.next;
            newHead=newHeadNext;
        }
       
    }
}