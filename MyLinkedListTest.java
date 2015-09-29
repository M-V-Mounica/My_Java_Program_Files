import java.util.Scanner;
public class MyLinkedListTest
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		LinkedList ll = new LinkedList();
		do
		{
			System.out.println("Enter commands : pushFront \n pushBack \n insertAtIndex \n insertAfter \n insertBefore \n popFront \n popBack \n removeIndex \n removeElement \n concat \n concatAtIndex \n makeEmpty \n  display \n end\n ");
			String choice = scan.next();
			switch(choice)
			{
				case "pushFront":System.out.println("Enter element:");
								int element = scan.nextInt();
								ll.pushFront(element);
								break;
				case "pushBack" : System.out.println("Enter element:");
								 element = scan.nextInt();
								ll.pushBack(element);
								break;
				case "insertAtIndex":System.out.println("Enter index and element:");
									int index = scan.nextInt();
									element = scan.nextInt();
									ll.insert(index,element);
									break;
				case "insertAfter" : System.out.println("Enter element and new element:");
									element = scan.nextInt();
									int newElement = scan.nextInt();
									ll.insertAfter(element,newElement);
									break;
				case "insertBefore" :System.out.println("Enter element and new element:");
									element = scan.nextInt();
									newElement = scan.nextInt();
									ll.insertBefore(element,newElement);
									break;	
				case "popFront" : ll.popFront();
									break;
				case "popBack":ll.popBack();
								break;
				case "removeIndex":	System.out.println("Enter index:");
								index = scan.nextInt();
								ll.removeIndex(index);
								break;
				case "removeElement" : 	System.out.println("Enter element:");
										element = scan.nextInt();
										ll.removeElement(element);
										break;
				case "concat" : System.out.println("Enter head element of new list:");
								element = scan.nextInt();
								Node newHead = new Node(element);
								ll.concat(newHead);
								break;
				case "concatAtIndex" : System.out.println("Enter index and head element:");
										index = scan.nextInt();
										element = scan.nextInt();
										newHead = new Node(element);
										ll.concatAtIndex(index,newHead);
										break;			
				case "makeEmpty":ll.makeEmpty();
								break;
				case "display": ll.display();
								break;
				case "end" : System.exit(0);																										
			}
		}while(true);
		
	}
}
class Node
{
	public int data;
	public Node next;
	public Node()
	{
		next = null;
		data = 0;
	}
	public Node( int d, Node n)
	{
		next = n;
		data = d;
	}
	public Node( int d)
	{	
		this(d,null);
	}
	public void setData(int d)
	{
		data = d;
	}
	public void setNext(Node n)
	{
		next = n;
	}
	public Node getNext()
	{
		return next;
	}
	public int getData()
	{
		return data;
	}
	public void display()
	{
		System.out.println(data);
	}
	public String toString()
	{
		return String.valueOf(data);
	}
	
}
class LinkedList
{
	Node head;
	Node tail;
	int entryCount;
	public LinkedList()
	{
		head = null;
		tail = null;
		entryCount = 0;
	}
	public void insert(int index,int data)
	{
		Node node = head;
		Node addTo = new Node(data);
		int count=0;
		while(node!=null)
		{
			if(count!=index)
			{
				count++;
				node = node.next;
			}
			else
			{
				Node temp = getNode(index-1);
				//System.out.println(temp);
			Node temp1 = getNode(index);
			//System.out.println(temp1);
			addTo.setNext(temp1);
			temp.setNext(addTo);
			entryCount++;
			break;
			}
		}
		if(index == 0)
		{
			pushFront(0);
		}
		else
		pushBack(data);
	}

	void display() {
		Node node = head;
		//System.out.println(head);

		while(node != null) {

			node.display();
			node = node.next;
			//System.out.println("Next "+node);
		}
	}
	public void pushFront(int element)
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
	public void pushBack(int element)
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
			tail.next = node;
			tail = node;
			entryCount++;
		}
	}
	public void insertAfter(int afterElement,int element)
	{

		Node node = head;
		Node addTo = new Node(element);
		while(node!=null)
		{
		if(node.getData() != afterElement)
		{
			node = node.next;
		}
		else
		{
			Node temp = node;
			Node temp1 = node.next;
			addTo.next = temp1;
			temp.next = addTo;
			entryCount++;
			break;
		}
		}
	}
	public void insertBefore(int beforeElement,int element)
	{
		int count =0;
		Node node = head;
		Node addTo = new Node(element);
		
			while(node!=null)
			{
			if(node.getData() != beforeElement)
			{
				count++;
				node = node.next;
			}
			else
			{
			Node temp = getNode(count);
			//System.out.println("    "+temp);
			Node temp1 = node;
			addTo.setNext(temp1);
			temp.setNext(addTo);
			entryCount++;
			break;
		}
		}

}

public Node getNode(int index)
{
	int count = 1;
	Node node = head;
	while(node!=null)
	{
		if(count!=index)
		{
			count++;
			node = node.next;
		}
		else
		{
			return node;
		}
	}
	return node;
}
public void removeIndex(int index)
{
	Node node = head;
	int count =0;
	while(node!=null)
	{
		if(count!=index)
		{
			count++;
			node = node.next;
		}
		else
		{
			Node temp = getNode(count-1);
			//System.out.println(temp);
			Node temp1 = node;
			temp.next = temp1;
			break;
		}
	}
}
public void removeElement(int element)
{
	Node node = head;
	int count = 0;
	while(node!=null)
	{
		if(node.getData()!=element)
		{
			count++;
			node=node.next;
		}
		else
		{
			Node temp =   getNode(count);
			Node temp1 = node.next;
			//System.out.println(temp1);
			temp.next = temp1;
			break;
		}
	}
}
public void popFront()
{
	Node node = head;
	head = node.next;
	entryCount--;
}
public void popBack()
{
	Node node = head;
	int count=0;
	while(node!=null)
	{
		if(node!=null)
		{
			count++;
			node = node.next;
		}
	}
	Node temp = getNode(count-1);
	tail = temp;
	temp.next = null;
	entryCount -- ;
}
public void concat(Node newHead)
{
	Node node = head;
	while(node!=null)
	{
		if(node!=null)
		{
			node = node.next;
		}
	}
	node = newHead;
}
public void makeEmpty()
{
	 head = null;

}
public void concatAtIndex(int element,Node newHead)
{
	int count=0;
	Node node = head;
	while(node!=null)
	{
		if(node.getData()!=element)
		{
			count++;
			node = node.next;
		}
		else
		{
			Node temp = getNode(count);
			temp.next = newHead;
		}
	}
}
}
