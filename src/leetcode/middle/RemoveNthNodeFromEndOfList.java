package leetcode.middle;

import leetcode.domain.ListNode;

/**
 * @desc
 *  题目：19. 删除链表的倒数第 N 个结点
 *  描述：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *  链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *  参考题解：无
 *  难度(自己)：会解法
 *  备注：有部分case没通过，需要注意
 * @author GaryLeeeee
 * @date 2021/06/28 00:40
 *
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * 解法：双指针
     * 思路：
     *  1.用快慢指针，起点相隔n，当快指针到终点时，慢指针刚好在倒数第n个结点
     *  2.由于是删除操作，所以需要目标结点的pre节点(由于链表结构里面没有，需要我们自定义)
     * 解法：
     *  1.定义一个新的头结点newHead(指向next为head)
     *  2.定义快慢指针fast、slow
     *  3.fast先走n+1步(由于我们是要找到目标结点的pre结点，所以+1)
     *  4.快慢指针同时遍历，直到fast为null
     *  5.此时slow.next为目标结点，执行删除操作(见代码)
     *  6.返回第一步定义newHead的next(因为实际是要返回head)
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //定义head的pre结点(方便输出结果)
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        //定义快慢指针
        ListNode slow = newHead;
        ListNode fast = newHead;
        //双指针，一个先到达终点，另一个就是倒数第n个结点
        for (int i = 0; i <= n; i++) {//这里是为了下面另一个指向倒数第n个结点前一个结点(方便删除)
            fast = fast.next;
        }

        //当fast到达终点null时，slow到达倒数第n个结点前一个结点
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        //fast指针到终点，slow指针是倒数第n个结点上
        ListNode next = slow.next.next;
        slow.next = next;

        //返回head
        return newHead.next;
    }

    /**
     * 例子：
     *  输入：head = [1,2,3,4,5], n = 2
     *  输出：[1,2,3,5]
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 2).val);
    }
}
