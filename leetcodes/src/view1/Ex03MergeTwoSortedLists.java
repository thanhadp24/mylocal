package view1;

/**
	You are given the heads of two sorted linked lists list1 and list2.
	Merge the two lists into one sorted list. The list should be made 
	by splicing together the nodes of the first two lists.
	Return the head of the merged linked list.
	
	Ex1
	Input: list1 = [1,2,4], list2 = [1,3,4]
	Output: [1,1,2,3,4,4]
	
	Ex2
	Input: list1 = [], list2 = [0]
	Output: [0]
 */

public class Ex03MergeTwoSortedLists {
	public static void main(String[] args) {

		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);

		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);

		
		ListNode mergedList = mergeTwoLists(list1, list2);

		printList(mergedList);
	}
	private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
	
	private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		// Dummy nodes "Sometimes get used as first and last nodes in the list".
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				head.next= list1;
				list1 = list1.next;
			} else {
				head.next = list2;
				list2 = list2.next;
			}
			head = head.next;
		}
		
		if (list1 != null) {
			head.next = list1;
		}
		if (list2 != null) {
			head.next = list2;
		}
		
		return dummy.next;
	}
}

class ListNode{
	int val;
	ListNode next;
	
	public ListNode() {
	}
	
	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}
}
