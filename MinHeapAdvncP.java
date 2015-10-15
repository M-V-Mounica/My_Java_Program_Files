import java.util.*;
public class MinHeap
{
 public static void main(String[] args)
 {
 	ArrayList<String> operation = new ArrayList<String>();
 	Scanner scan = new Scanner(System.in);
	
	               int k = Integer.parseInt(scan.nextLine());
                   MinHeapOp hp= new MinHeapOp(k);
                    int n = Integer.parseInt(scan.nextLine());
                    for(int i=0;i<n;i++)
                    {
                    	int a = Integer.parseInt(scan.nextLine());
                    		//System.out.println(st.nextToken());
                    		hp.insert(a);
                    		//hp.print();
                    		//System.out.println();
                    }
                    hp.display();
                    
                    hp.print(k);
			//}
		//}
 }
}
class MinHeapOp
{
	int i,j;
	int[] heapArray ;
	int size;
	int current;
	int FRONT;
    ArrayList<Integer> orderedEle;
	public MinHeapOp(int size)
	{
		FRONT =0;
		current=0;
		i =0;
        j=0;
		this.size =size;
		heapArray = new int[size];
        orderedEle = new ArrayList<Integer>();
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
		
		if(i<size)
		{
            //System.out.println(i+"  "+size);
			heapArray[i] = element;
            //System.out.println(i+"   "+heapArray[i]);
			current = i;
			//size++;
			//heapArray = Arrays.copyOf(heapArray,size);
			while((heapArray[current])>(heapArray[parent(current)]))
			{
				swap(current,parent(current));
				current = parent(current);
			}
			i++;
		}
        else
        {
            //current = j;
            //System.out.println(element);
            //System.out.println(heapArray[0]);
            for(int i=0;i<heapArray.length;i++)
            {
               if(element>heapArray[i])
                {
                    //System.out.println(element+"  "+heapArray[0]);
                    int temp;
                    temp = element;
                    element =heapArray[i];
                    heapArray[i] = temp;
                }
            }
            //System.out.println(heapArray[0]);
            //j++;
        }
        	
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
        System.out.println(heapArray[index-1]);
    }
    public void display()
    {
    	//int count =0 ;
        for (int i = 0; i <heapArray.length; i++ )
        {
        	//if(count==index)
        	{
        		System.out.print(heapArray[i]+" ");
        		//break;
        	}
            //else count++;
        }
        System.out.println();
    }
}
