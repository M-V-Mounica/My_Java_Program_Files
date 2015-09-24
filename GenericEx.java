import java.util.*;
class MyList <E> {
	private E[] array;
	boolean found;
	int size;
	int i;
	int entryCount;
	public MyList()
	{
		size = 2;
		i=0;
		entryCount = 0;
		array = (E[]) new Object[size];
		//array = new int[size];
		found = false;
	}
	public void add(E e)
	{
		if(i<size)
		{
			array[i] = e;
			entryCount++;
			i++;
		}
		
		if(i==size)
		{
			size = size * 2;

			array = Arrays.copyOf(array,size);

		}
	}
	public E readIndex(int index)
	{
		for(int i=0;i<array.length;i++)
		{
			//System.out.println(i + "   " + index);
			if(i==index)
			{
				return array[index];
				
			}
			else continue;
		}
		return array[index];
	}
	public void removeIndex(int index)
	{
		if(array.length==0)
			System.out.println("\"List is Empty\"");
		else
		{
		for(int i=0;i<array.length-1;i++)
			
        {
            if(i==index)
            {
                for(int j = i;j<array.length-1;j++)
                {
                    array[j] = array[j+1];
                }
                //
                array[array.length-1] = null;
                entryCount--;
                //array--;
            }
        }
	}
}
	public void removeElement(E e)
	{
		for(int i=0;i<array.length-1;i++)
			
        {
            if(e.equals(array[i]))
            {
            	found = true;
                for(int j = i;j<array.length-1;j++)
                {
                    array[j] = array[j+1];
                }
                //
                array[array.length-1] = null;
                entryCount--;
                //array--;
            }
            
        }
        if(found==false)
        {
        	System.out.println("\"Element is not found\"");
        }

	}
	public void modifyAtIndex(int index,E e)
	{
		for(int i=0;i<array.length;i++)
		{
			if(i==index)
			{
				array[i] = e;
			}
		}
	}
	public void modifyElement(E e1,E e2)
	{
		for(int i=0;i<array.length;i++)
		{
			if(e1.equals(array[i]))
			{
				array[i] = e2;
			}
		}
	}
	public void display()
	{
		if(entryCount==0)
			System.out.println("\"List is empty\"");
		else 
		{
		for(int i=0;i<array.length;i++)
		{
			if(array[i]!=null)
			System.out.println(array[i]);
		}
	}
}
}

public class GenericEx
{
	public static void main(String[] args)
	{
		//System.out.println("Enter the generic type:");
		Scanner scan = new Scanner(System.in);
		//Scanner input = new Scanner(System.in);
		char generic = scan.next().charAt(0);
		if(generic == 'I')
		{
			MyList<Integer> intList = new MyList<Integer>();
		do{
			//System.out.println("Enter commands: add \n removeElement \n removeIndex \n read \n modifyIndex \n modifyElement \n print \n exit");
			String cmd = scan.next();
			switch(cmd)
			{
				
				case "add" : //System.out.println("Enter number to add:");
						int num = scan.nextInt();
						intList.add(num);
						break;
				case "removeElement": //System.out.println("Enter element:");
						int element = scan.nextInt();
						intList.removeElement(element);
						break;
				case "removeIndex": //System.out.println("Enter index to be removed:");
						int index1 = scan.nextInt();
						intList.removeIndex(index1);
						break;
				case "read": //System.out.println("Enter index to read:");
						int index2 = scan.nextInt();
						System.out.println(intList.readIndex(index2));
						break;
				 case "modifyIndex": //System.out.println("Enter index to modify:");
						int index3 = scan.nextInt();
						//System.out.println("Enter element to be modified:");
						int element1 = scan.nextInt();
						intList.modifyAtIndex(index3,element1);
						break;
				case "modifyElement": //System.out.println("Enter element to be modified:");
						int element2 = scan.nextInt();
						//System.out.println("Enter element to be modified:");
						int element3 = scan.nextInt();
						intList.modifyElement(element2,element3);
						break;
				case "print": intList.display();
						break;
				case "end":System.exit(0);
			}
		}while(true);

		}
		else if(generic == 'S')
		{
			MyList<String> strList = new MyList<String>();
		do{
			//System.out.println("Enter commands: add \n removeElement \n removeIndex \n read \n modifyIndex \n modifyElement \n print \n exit");
			String cmd = scan.next();
			switch(cmd)
			{
				
				case "add" : //System.out.println("Enter String to add:");
						String str = scan.next();
						strList.add(str);
						break;
				case "removeElement": //System.out.println("Enter element to be removed:");
						String element = scan.next();
						strList.removeElement(element);
						break;
				case "removeIndex": //System.out.println("Enter index to be removed:");
						int index1 = scan.nextInt();
						strList.removeIndex(index1);
						break;
				case "read": //System.out.println("Enter index to read:");
						int index2 = scan.nextInt();
						System.out.println(strList.readIndex(index2));
						break;
				 case "modifyIndex": //System.out.println("Enter index to modify:");
						int index3 = scan.nextInt();
						//System.out.println("Enter element to be modified:");
						String element1 = scan.next();
						strList.modifyAtIndex(index3,element1);
						break;
				case "modifyElement": //System.out.println("Enter element to be modified:");
						String element2 = scan.next();
						//System.out.println("Enter element to be modified:");
						String element3 = scan.next();
						strList.modifyElement(element2,element3);
						break;
				case "print": strList.display();
						break;
				case "end":System.exit(0);
			}
		}while(true);

		}
		else if(generic=='C')
		{
			MyList<Character> charList = new MyList<Character>();
			do{
			//System.out.println("Enter commands: add \n removeElement \n removeIndex \n read \n modifyIndex \n modifyElement \n print \n exit");
			String cmd = scan.next();
			switch(cmd)
			{
				
				case "add" : //System.out.println("Enter Charcter to add:");
						char c = scan.next().charAt(0);
						charList.add(c);
						break;
				case "removeElement": //System.out.println("Enter element to be removed:");
						char element = scan.next().charAt(0);
						charList.removeElement(element);
						break;
				case "removeIndex": //System.out.println("Enter index to be removed:");
						int index1 = scan.nextInt();
						charList.removeIndex(index1);
						break;
				case "read": //System.out.println("Enter index to read:");
						int index2 = scan.nextInt();
						System.out.println(charList.readIndex(index2));
						break;
				 case "modifyIndex": //System.out.println("Enter index to modify:");
						int index3 = scan.nextInt();
						//System.out.println("Enter element to be modified:");
						char element1 = scan.next().charAt(0);
						charList.modifyAtIndex(index3,element1);
						break;
				case "modifyElement": //System.out.println("Enter element to be modified:");
						char element2 = scan.next().charAt(0);
						//System.out.println("Enter element to be modified:");
						char element3 = scan.next().charAt(0);
						charList.modifyElement(element2,element3);
						break;
				case "print": charList.display();
						break;
				case "end":System.exit(0);
			}
		}while(true);
		}
		else if(generic=='F')
		{
			MyList<Float> floatList = new MyList<Float>();
			do{
			//System.out.println("Enter commands: add \n removeElement \n removeIndex \n read \n modifyIndex \n modifyElement \n print \n exit");
			String cmd = scan.next();
			switch(cmd)
			{
				
				case "add" : //System.out.println("Enter float value to add:");
						float f = scan.nextFloat();
						floatList.add(f);
						break;
				case "removeElement": //System.out.println("Enter element to be removed:");
						float element = scan.nextFloat();
						floatList.removeElement(element);
						break;
				case "removeIndex": //System.out.println("Enter index to be removed:");
						int index1 = scan.nextInt();
						floatList.removeIndex(index1);
						break;
				case "read": //System.out.println("Enter index to read:");
						int index2 = scan.nextInt();
						System.out.println(floatList.readIndex(index2));
						break;
				 case "modifyIndex": //System.out.println("Enter index to modify:");
						int index3 = scan.nextInt();
						//System.out.println("Enter element to be modified:");
						float element1 = scan.nextFloat();
						floatList.modifyAtIndex(index3,element1);
						break;
				case "modifyElement": //System.out.println("Enter element to be modified:");
						float element2 = scan.nextFloat();
						//System.out.println("Enter element to be modified:");
						float element3 = scan.nextFloat();
						floatList.modifyElement(element2,element3);
						break;
				case "print": floatList.display();
						break;
				case "end":System.exit(0);
			}
		}while(true);
		}
		}
	}
