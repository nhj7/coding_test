package problems.n2.Add_Two_Numbers;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode resultNode = null;
    	ListNode nextNode = null;
    	int carry = 0;
    	while( l1 != null || l2 != null  || carry > 0){    		
    		int newVal = (l1 != null ? l1.val : 0) + (l2 != null ?l2.val:0) + carry;
    		carry = 0;
    		if( newVal >= 10){
    			carry = 1;
    			newVal = newVal - 10;
    		}
    		if( resultNode == null ){
    			resultNode = new ListNode( newVal );
    			nextNode = resultNode;
    		}    			
    		else {
    			nextNode.next = new ListNode( newVal );
				nextNode = nextNode.next;
				
    		}
    		l1 = (l1 != null ? l1.next : null);
    		l2 = (l2 != null ? l2.next : null);
    	}    	
        return resultNode;
    }
    
    
    public static void main(String[] args) {
    	ListNode l1 = new ListNode(2);
    	l1.next = new ListNode(4);
    	l1.next.next = new ListNode(3);
    	
    	ListNode l2 = new ListNode(5);
    	l2.next = new ListNode(6);
    	l2.next.next = new ListNode(4);
    	
    	ListNode ln = addTwoNumbers(l1, l2);
    	
    	while( ln != null ){
    		System.out.println(ln.val);
    		ln = ln.next;
		}	

	}
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
