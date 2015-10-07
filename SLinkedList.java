import java.util.Scanner;
class StackLinkedList{
	
	Node head;
	Node tail;
	int entryCount;
	boolean status;
	StackLinkedList()
	{
		head = null;
		tail = null;
		entryCount = 0;
		status = false;
	}
	public void push(String element)
	{
		Node node = new Node(element,null);
		if(head == null)
		{
			head = node;
			tail = node;
			entryCount++;
		}
		else
		{
			node.next = head;
			head = node;
			entryCount++;
		}
		//System.out.println(head);
	}
	public String pop()
	{
	Node node = head;
	head = node.next;
	entryCount--;
	return node.getData();
	}
	void display() {
		Node node = head;
		//System.out.println(head);

		while(node != null) {

			node.display();
			node = node.next;
			//System.out.println("Next "+node);
		}
		//System.out.println(entryCount);
	}
	public String top()
	{
		
		return head.getData();
	}
public boolean isEmpty()
{
	if(head==null)
	{
		status = true;
	}
	else
		return status;
	return status;
}
}
public class SLinkedList{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		StackLinkedList sll = new StackLinkedList();
		do{
			String choice = scan.next();
			switch(choice)
			{
				case "push":String element = scan.next();
							sll.push(element);
							break;
				case "pop" : System.out.println(sll.pop());
								break;
				case "top": System.out.println(sll.top());
							break;
				case "display" : sll.display();
									break;
				case "end" : System.exit(0);
														
			}
		}while(true);
	}
}
