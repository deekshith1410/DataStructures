import java.util.*;

@SuppressWarnings("unchecked")
class Heap<E extends Comparable<E>> {

	int beta = 2;
	int alpha = 4;

	int capacity = 1;
	int size= 0;
	E[] heap = (E[])new Comparable<?>[capacity];
	public void insert(E e) {
		size++;
		if( size == capacity ) {
			reallocate(beta * size);
		}
		heap[size] = e;
		siftup(size);
	}

	public void siftup(int i) {	
		if((i == 1) || heap[i/2].compareTo(heap[i]) <= 0 ) {
			return ;
		}
 		 	swap(i,i/2);
			siftup(i/2);

	}

	public E remove() {
		E result =null;
		if(size>0) {
			result = heap[1];
			heap[1] = heap[size];
			size--;
			siftDown(1);
		}
		return result; 
	}

	public void siftDown(int i) {
		int m=0;
		
		if(2*i <= size) {
			if((2*i + 1)>size || heap[2*i].compareTo(heap[2*i + 1]) <= 0)
				m = 2*i;
			else
				m=2*i + 1;
			if(heap[i].compareTo(heap[m]) >0) {
				swap(i,m);
				siftDown(m);
			}
		}
	}

	public void sort() {
		E[] temp = (E[])new Comparable<?>[size+1]; 
		int p = size;
		for(int i=1; i<=p; i++) {
			 temp[i] = remove();
		}
		 for (int i=1 ; i<=p; i++) {
		 	insert(temp[i]);
		 }
	}

	public void swap(int i, int m) {
		E temp=null;
		temp = heap[i];
		heap[i] = heap[m];
		heap[m] = temp;
	}

	public void reallocate(int w1) {
 		capacity = w1;
 		E[] b1 = (E[])new Comparable<?>[w1];
 		for(int i=0; i<size; i++) {
 			b1[i] = heap[i];
 		}
 		heap = b1;
 	}

 	public void modify(int i , E element) {
 		heap[i] = element;
 		siftDown(i);
 		siftup(i);
 	}


	public void display() {
		for (int i=1; i<size ; i++ ) {
			System.out.print(heap[i] + " ");
		}
		System.out.println(heap[size]);
	}
}

class Test3 {
	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<Integer>();
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		String[] operations = input.split(",");
		for (int i=0; i<operations.length ;i++ ) {
			operations[i]=operations[i].trim();
			System.out.println(operations[i]);
		}
		for(int i=0; i<operations.length; i++) {
			String[] command = operations[i].split(" "); 
			if(command[0].equals("i")) {
				heap.insert(Integer.parseInt(command[1]));
				heap.display();
			} 
			else if(command[0].equals("d")) {
				heap.remove();
				heap.display();
			}
			else if(command[0].equals("mo")) {
				heap.modify(Integer.parseInt(command[1]) , Integer.parseInt(command[2]));
				heap.display();
			} 
			else if(command[0].equals("end")) {
				break;
			}
		}





		
		/*
		heap.display();
		heap.insert(17);
		heap.display();
		heap.insert(18);
		heap.display();
		heap.modify(1,19);
		heap.display();*/
	}
}