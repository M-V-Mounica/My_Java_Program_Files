import java.util.*;
public class UnBoundedArraySample{
	public static void main(String args[])
	{
		//System.out.println("Enter the generic type:");
		Scanner scan = new Scanner(System.in);
		//Scanner input = new Scanner(System.in);
		char generic = scan.next().charAt(0);
		if(generic == 'I')
		{
		UnBoundedArray<Integer> intList = new UnBoundedArray<Integer>();
		//Scanner scan = new Scanner(System.in);
		do{
				//System.out.println("Enter commands : push \n pop \n size \n reallocate \n capacity \n print \n end");
				String choice = scan.next();
				switch(choice)
				{
					
					case "push" : //System.out.println("Enter number to add:");
								int num = scan.nextInt();
								intList.pushBack(num);
								break;
					case "pop": intList.popBack();
								break;
					case "size": System.out.println(intList.size());
					         	break;
					 case "reallocate": //System.out.println("Enter size:");
					 					int size = scan.nextInt();
					 					intList.reallocate(size);
					 					break;
					 case "capacity" : System.out.println(intList.capacity());
					 					break;
					 case "print":intList.display();
					 				break;
					 case "end": System.exit(0);
				}
		}while(true);
	}
	if(generic == 'S')
		{
		UnBoundedArray<String> strList = new UnBoundedArray<String>();
		//Scanner scan = new Scanner(System.in);
		do{
				//System.out.println("Enter commands : push \n pop \n size \n reallocate \n capacity \n print \n end");
				String choice = scan.next();
				switch(choice)
				{
					
					case "push" : //System.out.println("Enter String to add:");
								String str = scan.next();
								strList.pushBack(str);
								break;
					case "pop": strList.popBack();
								break;
					case "size": System.out.println(strList.size());
					         	break;
					 case "reallocate": //System.out.println("Enter size:");
					 					int size = scan.nextInt();
					 					strList.reallocate(size);
					 					break;
					 case "capacity" : System.out.println(strList.capacity());
					 					break;
					 case "print":strList.display();
					 				break;
					 case "end": System.exit(0);
				}
		}while(true);
	}
	if(generic == 'C')
		{
		UnBoundedArray<Character> charList = new UnBoundedArray<Character>();
		//Scanner scan = new Scanner(System.in);
		do{
				//System.out.println("Enter commands : push \n pop \n size \n reallocate \n capacity \n print \n end");
				String choice = scan.next();
				switch(choice)
				{
					
					case "push" : //System.out.println("Enter String to add:");
								char c = scan.next().charAt(0);
								charList.pushBack(c);
								break;
					case "pop": charList.popBack();
								break;
					case "size": System.out.println(charList.size());
					         	break;
					 case "reallocate": //System.out.println("Enter size:");
					 					int size = scan.nextInt();
					 					charList.reallocate(size);
					 					break;
					 case "capacity" : System.out.println(charList.capacity());
					 					break;
					 case "print":charList.display();
					 				break;
					 case "end": System.exit(0);
				}
		}while(true);
	}
	if(generic == 'F')
		{
		UnBoundedArray<Float> floatList = new UnBoundedArray<Float>();
		//Scanner scan = new Scanner(System.in);
		do{
				//System.out.println("Enter commands : push \n pop \n size \n reallocate \n capacity \n print \n end");
				String choice = scan.next();
				switch(choice)
				{
					
					case "push" : //System.out.println("Enter String to add:");
								float f = scan.nextFloat();
								floatList.pushBack(f);
								break;
					case "pop": floatList.popBack();
								break;
					case "size": System.out.println(floatList.size());
					         	break;
					 case "reallocate": //System.out.println("Enter size:");
					 					int size = scan.nextInt();
					 					floatList.reallocate(size);
					 					break;
					 case "capacity" : System.out.println(floatList.capacity());
					 					break;
					 case "print":floatList.display();
					 				break;
					 case "end": System.exit(0);
				}
		}while(true);
	}
}
}
class UnBoundedArray <E>
{
	int n;
	//int size;
	int w;
	int beta;
	private E[] array;
	int alpha;
	public UnBoundedArray()
	{
		n = 0;
		w = 1;
		beta = 2;
		alpha = 4;
		array = (E[]) new Object[w];
	}
	public void pushBack(E e)
	{
		if(n==w)
		{
			reallocate(n*beta);
			//System.out.println("n")
		}

			//System.out.println(n+"     "+w);
			array[n] = e;
			n++;
			//System.out.println(entryCount);
			//i++;
		
		
	}
public void popBack()
{
				if(n==0)
                {
                	System.out.println("\"Array is empty\"");
                }
                else if((w>=(alpha*n))&&(n>0))
                {
                	//System.out.println("Entered");
                	reallocate(beta*n);
            	}
                else
                {
                	for(int i=array.length-1;i>=0;i--)
                	{
                		if(array[i]!=null)
                		{
                		array[i] = null;
                		n--;
                		break;
                		}
                		
            		}
            	}
                
 			
}
public void display()
{
				if(n==0)
                {
                	System.out.println("\"Array is empty\"");
                }
                else
                {
				for(int i=0;i<n;i++)
					{
						 	if(i < n-1)
								System.out.print(array[i]+ " ");
							else
								System.out.println(array[i]);
					}
					//System.out.println(array[array.length]);
				}
}
public int size()
{
	return n;
}
public void reallocate(int newSize)
{
	array = Arrays.copyOf(array,newSize);
	System.out.println(capacity());
	w = newSize;
}
public int capacity()
{
	return w;
}
}
