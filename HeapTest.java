import java.util.*;
public class HeapTest{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		//System.out.println("Enter size of heap:");
		//int size = scan.nextInt();
		HeapOperation heap = new HeapOperation();
		do
		{
			//System.out.println("Enter commands : insert \n deleteMin \n extractMin \n heapify");
			String choice = scan.next();
			switch(choice)
			{
				case "i" : //System.out.println("Enter element to be inserted:");
								int element = scan.nextInt();
								heap.insert(element);
								heap.print();
								break;
				case "d" : heap.remove();
							heap.print();
							break;
				case "mo" : //System.out.println("Enter index");
							int index = scan.nextInt();
							//System.out.println("Enter element");
							element = scan.nextInt();
							heap.modify(index,element);
							heap.print();
							break;
				
				case "e" : System.exit(0);					
			}
		}while(true);
	}
}
class HeapOperation
{
	int[] heapArray;
	int size;
	int heapSize;
	int FRONT;
	int i;
	protected HeapOperation()
	{
		FRONT=1;
		//int size = 10;
		i=0;
		size = 1;
		heapSize = size;
		heapArray = new int[size+2];
		heapArray[0] = Integer.MIN_VALUE;
		//System.out.println(heapArray[0]);
	}
	public int parent(int position)
	{
		return position/2;
	}
	public int left(int position)
	{
		return position*2;
	}
	public int right(int position)
	{
		return (position*2)+1;
	}
	private boolean isLeaf(int position)
    {
        if (position >=  (size / 2)  &&  position <= size)
        {
            return true;
        }
        return false;
    }
	public void swap(int felement,int selement)
	{
		int temp;
		temp = heapArray[felement];
		heapArray[felement] = heapArray[selement];
		heapArray[selement] = temp;
	}
	
	public void insert(int element)
	{
			heapArray[++i] = element;
			int current = size;
			heapArray = Arrays.copyOf(heapArray,size+2);
			while((heapArray[current]) < heapArray[parent(current)])
			{
				swap(current,parent(current));
				current = parent(current);
			}
			++size;
			System.out.println(size);
	}
	public int remove()
    {
        int popped = heapArray[FRONT];
        int temp = heapArray[size-1]; 
        //System.out.println(temp);
         heapArray[FRONT] = temp;
       //maxHeap();
        //System.out.println(heapArray[size--]);
        size=size-2;
        //System.out.println(heapArray[FRONT]);
        heapify(FRONT);
        return popped;
    }
    public void modify(int index,int element)
    {
    	System.out.println(heapArray[index]);
    	heapArray[index] = element;

    	heapify(index);
    }
	public void heapify(int position)
    {
        if(heapArray[left(position)] < heapArray[right(position)] )
        {
        	swap(position,left(position));
        	heapify(left(position));
        }
        else
        {
        	swap(position,right(position));
        	heapify(right(position));
        }
    }
    public void maxHeap()
    {
    	//System.out.println(size);
        for (int pos = (size / 2); pos >= 1; pos--)
        {
        	//System.out.println(pos);
        	//System.out.println("Entered");
            heapify(pos);
        }
    }
    
    
	public void print()
    {
    	//System.out.println(size);
        for (int i = 1; i <=size ; i++ )
        {
        	if(heapArray[i]!=0)
            System.out.print(heapArray[i]+" ");
            //System.out.println();
        }
    }
}
