
import java.util.Scanner;
public class Q4_Partition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkList ob = new LinkList();
        int n;
        do {
            System.out.println("Enter numbers .. -1 o exit");
            n = sc.nextInt();
            if(n!=-1)
                ob.insert_end(n);
        }while(n!=-1);

        ob.display();
        System.out.println("\nEnter x");
        int x = sc.nextInt();

        System.out.println();

        Node t = (new Q4_Partition()).partition(ob.head, x);

        while(t != null) {
            System.out.print(t.num + "  ");
            t=t.next;
        }
    }

    private Node partition(Node head, int x) {
		Node obione = null, obione_end = null, obitwo = null, obitwo_end = null;

		while(head != null) {
			Node next = head.next;
			head.next = null;
			if(head.num < x) {
				if(obione == null) {
					obione = head;
					obione_end = obione;
				} else {
					obione_end.next = head;
					obione_end = head;
				}
			}
			else {
				if(obitwo == null) {
					obitwo = head;
					obitwo_end = obitwo;
				} else {
					obitwo_end.next = head;
					obitwo_end = head;
				}
			}
			head = next;
		}

		if(obione == null) return obitwo;
		else {
			obione_end.next = obitwo;
			return obione;
		}
	}
    
}


/*
 LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;
		
		
		while (node != null) {
			LinkedListNode next = node.next;
			node.next = null;
			if (node.data < x) {
				if (beforeStart == null) {
					beforeStart = node;
					beforeEnd = beforeStart;
				} else {
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else {
				if (afterStart == null) {
					afterStart = node;
					afterEnd = afterStart;
				} else {
					afterEnd.next = node;
					afterEnd = node;
				}
			}	
			node = next;
		}
		
		
		if (beforeStart == null) {
			return afterStart;
		}
		
		beforeEnd.next = afterStart;
		return beforeStart
 */