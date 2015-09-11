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


	public void display() {
		for (int i=1; i<=size ; i++ ) {
			System.out.println(heap[i]);
		}
	}
}

class IH043_Heap{
	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<Integer>();
		heap.insert(4);
		heap.insert(4);
		heap.insert(8);
		heap.insert(9);
		heap.insert(4);
		heap.insert(12);
		heap.insert(9);
		heap.insert(11);
		heap.insert(13);
		heap.display();
		System.out.println("************");
		heap.sort();
		heap.display();

	}
}