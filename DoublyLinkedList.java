public class DoublyLinkedList {
	DLLNode head;
	int entryCount;
	public DoublyLinkedList() {
		// TODO Auto-generated constructor stub
		head = new DLLNode();
	}

	public String toString() {
		// TODO Auto-generated method stub
		String s = "";
		DLLNode temp;
			temp = head.next;
			while (temp != head)
		{
			s += temp.data;
			temp = temp.next;
		}
		return s;
	}

	public void pushBack(String element) {

		DLLNode newnode = new DLLNode(element);
		//DLLNode temp = head;
		if (head.next == null) {
			head.next = newnode;
			newnode.prev = head;
			newnode.next = head;
			head.prev = newnode;
			entryCount++;
		}
		else
		{
			DLLNode last=head.prev;
			last.next=newnode;
			newnode.prev=last;
			newnode.next=head;
			head.prev=newnode;
			entryCount++;
			//head.next = last;
			//last.prev=head;
		}

	}
	public void pushFront(String element)
	{
		DLLNode newnode = new DLLNode(element);
		DLLNode node = head.next;
		if(head.next == null)
		{
			head.next = newnode;
			newnode.prev = head;
			newnode.next = head;
			head.prev = newnode;
			entryCount++;
		}
		else
		{
			head.next = newnode;
			newnode.next = node;
			node.prev = newnode;
			newnode.prev=head;
			entryCount++;
			//node.next = head;
			//entryCount++;
		}
		//System.out.println(head);
	}
	public DLLNode getNode(int index)
	{
		int count = 1;
		DLLNode node = head;
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
	public void removeElement(String element)
	{
		int count=0;
		DLLNode node = head.next;
		while(node!=null)
		{
			if(node.getData()!=element)
			{
				count++;
				node = node.next;
			}
			else
			{
				DLLNode temp = getNode(count+1);
				//System.out.println(temp);
				DLLNode temp1 = node.next;
				//System.out.println(temp1);
				temp.next = temp1;
				temp1.prev = temp;
				entryCount--;
				break;
			}
		}

	}
	public void removeBack()
	{
		DLLNode node = head.prev;
		DLLNode temp = node.prev;
		temp.next = head;
		head.prev= temp;
		entryCount--;
	}
	public void removeFront()
	{
		DLLNode node = head.next;
		DLLNode temp = node.next;
		head.next = temp;
		temp.prev = head;
		entryCount --;
	}
	public int getSize()
	{
		return entryCount;
	}
	
}


public class DLLNode {

	String data;
	DLLNode prev;
	DLLNode next;
	
	public DLLNode() {
		// TODO Auto-generated constructor stub
		prev=null;
		next=null;
		data = null;
	}

	/**
	 * @param data
	 */
	public DLLNode(String data)
	{
		this.data=data;
		prev=null;
		next=null;
	}
	public String getData()
	{
		return data;
	}
	public void display() {
		// TODO Auto-generated method stub
		System.out.println(data);
	}
	public String toString()
	{
		return data;
	}
}
