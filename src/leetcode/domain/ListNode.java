package leetcode.domain;

/**
 * @desc 官方定义链表结构
 * @author GaryLeeeee
 * @date 2021/06/28 00:41
 *
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) { this.val = val; }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
