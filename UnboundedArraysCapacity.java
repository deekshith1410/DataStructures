import java.util.*;

class Node {
	int data ;
	Node link;

	Node(int d, Node n) {
		data = d;
		link = n;
	}

	public void setData(int d) {
		data = d;
	}

	public void setLink(Node n) {
		link = n;
	}

	public Node getLink() {
		return link;
	}

	public int getData() {
		return data;
	}
}


class LinkedStack {
	Node top = null;
	
	public void push(int e) {
		Node nptr = new Node(e , null);
		if(top == null) {
			top = nptr;
		} else {
			nptr.setLink(top);
			top = nptr;
		}
	}

	public int top() {
		if(isEmpty()) 
			return 0;
		return top.getData();

	}

	public void pop() {
		if(!isEmpty()) {
			top = (top.getLink());
		} else {
			System.out.println("stack is empty to pop");
		}
	}

	public boolean isEmpty() {
		if(top == null)
			return true;
		else
			return false;
	}

	public void splitStack(LinkedStack newStack) {
		Node ptr = top;
		while(ptr.getLink() != null) {
			if(ptr.getData()<0) {
				newStack.push(ptr.getData());
			}
			ptr = ptr.getLink();
		}
		if(ptr.getData()<0) {
			newStack.push(ptr.getData());
		}

		ptr = top;
		while(ptr.getLink() != null) {
			if(ptr.getData()>0) {
				newStack.push(ptr.getData());
			}
			ptr = ptr.getLink();
		}
		if(ptr.getData()>0) {
			newStack.push(ptr.getData());
		}

	}

	public void display() {
		if(top == null) {
			System.out.println("empty to print");
			return ;
		}
		if(top.getLink() == null) {
			System.out.println(top.getData());
			return;
		}
		Node ptr = top;
		System.out.print(top.getData() + " ");
		ptr = top.getLink();

		while (ptr.getLink() != null) {
			System.out.print(ptr.getData() + " ");
			ptr = ptr.getLink();
		}
		System.out.println(ptr.getData());
	}
}

class UnboundedArraysCapacity{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		str=str.trim();
		String[] array = str.split(",");
		LinkedStack ls = new LinkedStack();
		LinkedStack newStack = new LinkedStack();
		for(int i=0; i<array.length; i++) {
			array[i] = array[i].trim();
			String[] operation = array[i].split(" ");
			ls.push(Integer.parseInt(operation[1]));  
		}
		ls.splitStack(newStack);
		newStack.display();
	}
}