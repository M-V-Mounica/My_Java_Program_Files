import java.util.Scanner;
class BalancedParanthesis
{
	int size;
	char[] c;
	int TOP;
	boolean status;
	public BalancedParanthesis()
	{
		this.size = 10;
		c = new char[size];
		TOP = -1;
		status = true;

	}
	public String getBalance(String string)
	{
		//char ch;
		int len = string.length();

        for (int i = 0; i < len; i++) {
			char ch = string.charAt(i);
			if (ch == '[' || ch == '(' || ch == '{') {
				//System.out.println(ch);
				push(ch);
			} 
			if ((ch == ']' || ch == '}' || ch == ')')) {
				if ((top() == '(' && ch == ')')|| ( top() == '{' && ch == '}')|| (top() == '[' && ch == ']')) {
					pop();
				}
			} 
		}
		if (isEmpty())
			return "Balanced Parenthisis";
		else
			return "Not Balanced";

    }
    

	public char pop()
	{
		char temp=' ';
			if(TOP==-1)
			System.out.println("Stack is empty");
		else
		{
			temp = c[TOP];
			TOP=TOP-1;
		}
		return temp;

	}
	public void push(char ch)
	{
		if(TOP<size)
			{
				TOP = TOP+1;
				c[TOP] = ch;
			}
		else if(TOP==size)
		{
			System.out.println("Stack is full");
		}
	}
	
	public char top()
	{
		return c[TOP];
	}
	public boolean isEmpty()
	{
		if(TOP==-1)
		{
			status = true;
			return status;
		}
		else
		{
			status = false;
			return status;
		}
	}
}
public class SBP{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		BalancedParanthesis bp = new BalancedParanthesis();
		System.out.println("Enter string:");
		String input = scan.next();
		System.out.println(bp.getBalance(input));
		//bp.display();
	}
}
