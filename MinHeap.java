import java.util.*;
public class MinHeap
{
 public static void main(String[] args)
 {
 	Scanner scan = new Scanner(System.in);
    int numOEle = Integer.parseInt(scan.nextLine());
    MinHeapOp hp= new MinHeapOp();
    String input = scan.nextLine();
    int[] values = new int[numOEle];
    int i=0;
    StringTokenizer st = new StringTokenizer(input);
    while (st.hasMoreTokens()) {
        String str =(st.nextToken(","));
        int value = Integer.parseInt(str);
        values[i] = value;
        i++;
    }
        
        if(hp.isHeap(values))
        {
            System.out.println(true);
        }
        else
        {
            for(int j=0;j<values.length;j++)
            {
                hp.insert(values[j]);
            }
            hp.display();
        }
 }
}
class MinHeapOp
{
	int i;
	int[] heapArray ;
	int size;
	int current;
	int FRONT;
	public MinHeapOp()
	{
		FRONT =0;
		current=0;
		i =0;
		size =1;
		heapArray = new int[size];
	}
	public int parent(int position)
	{
		return (position-1)/2;
	}
	public int left(int position)
	{
		return position*2+1;
	}
	public int right(int position)
	{
		return (position*2)+2;
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
		
		if(size==1)
		{
			heapArray[i] = element;
			size++;
			heapArray = Arrays.copyOf(heapArray,size);
			i++;
		}
		else
		{
			heapArray[i] = element;
			current = i;
			size++;
			heapArray = Arrays.copyOf(heapArray,size);
			while((heapArray[current])<(heapArray[parent(current)]))
			{
				swap(current,parent(current));
				current = parent(current);
			}
			i++;
		}	
	}
    public boolean isHeap(int[] values)
    {
        boolean status = false;
        for(int i=0;i<values.length;i++)
        {
            if((2*i+1)<values.length)
            {
                if(values[i]<values[2*i+1])
                    status = true;
                else
                    status = false;
            }
            if((2*i+2)<values.length)
            {
                if(values[i]<values[2*i+2])
                    status = true;
                else
                    status = false;
            }
        }
        return status;
    }
	public void heapify(int position)
    {
	     int left, r, min, tmp;	
		left = left(position);  
		r = right(position);   
	  	if(left < (size-1) && heapArray[left] < heapArray[position])
	     		min = left;         
	  	else
	  	   	min = position;

	  	if(r < (size-1) && heapArray[r] < heapArray[min])
	     		min = r; 

	  	if(min != position)	 
	  	{
	      		tmp = heapArray[position]; 
	      		heapArray[position] = heapArray[min];
	      		heapArray[min] = tmp;
	      		heapify(min); 

	     	}

    }
    public void modify(int index,int element)
    {
    	heapArray[index-1] = element;
    	if((index-1)==0)
    	{
    		heapify(index-1);
    	}
    	else
    	{
    	BubbleUp(index-1);
    	heapify(index-1);
    }
    }
    public int delete()
    {
    	int popped = heapArray[FRONT];
        int temp = heapArray[size-2]; 
         heapArray[FRONT] = temp;
         size--;
        heapArray = Arrays.copyOf(heapArray,size);
        heapify(FRONT);
        i--;
        return popped;
    }
    public void BubbleUp(int index) {
   int parent = (index-1)/2;

   while(index>1||heapArray[parent]>heapArray[index]) {

         swap(parent,index);
         index = parent;
         parent = (index-1)/2;
   }

}
	public void print(int index)
    {
    	int count =0 ;
        for (int i = 0; i <heapArray.length-1; i++ )
        {
        	if(count==index)
        	{
        		System.out.print(heapArray[i]+" ");
        		break;
        	}
            else count++;
        }
    }
    public void display()
    {
    	//int count =0 ;
        for (int i = 0; i <heapArray.length-1; i++ )
        {
        	//if(count==index)
        	{
        		System.out.print(heapArray[i]+" ");
        		//break;
        	}
            //else count++;
        }
    }
}
