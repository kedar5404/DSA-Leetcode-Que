
/*
 *Given a linked list where nodes can contain values 0s, 1s, and 2s only. The task is to 
 segregate 0s, 1s, and 2s linked list such that all zeros segregate to the head side, 2s at the 
 end of the linked list, and 1s in the middle of 0s and 2s.

Examples:

Input: LinkedList: 1->2->2->1->2->0->2->2
Output: 0->1->1->2->2->2->2->2
Explanation: All the 0s are segregated to the left end of the linked list, 2s to the right end of 
the list, and 1s in between. 
 */
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

class Solution {
    // Function to sort a linked list of 0s, 1s, and 2s.
    static Node segregate(Node head) {
        if (head == null || head.next == null) {
            return head; // If list is empty or has only one element, return it as is.
        }
        // Dummy nodes to help build the final list of 0s, 1s, and 2s.
        Node zeroD = new Node(0);
        Node oneD = new Node(0);
        Node twoD = new Node(0);

        // Pointers to the last nodes of three lists.
        Node zero = zeroD, one = oneD, two = twoD;
        // Traverse the list and link nodes to the appropriate lists.
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        // Combine the three lists.
        zero.next = (oneD.next != null) ? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null; // The last element of the list should point to null.
        // The head of the sorted list is the next of the dummy node for zeros.
        return zeroD.next;
    }
}

// { Driver Code Starts.

class SortLL0s1s2s {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(input);
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); i++) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            head = new Solution().segregate(head);
            printList(head);
        }
    }
}
// } Driver Code Ends