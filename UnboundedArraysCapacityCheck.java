import java.util.*;
import java.util.Random;

class Uarray {
	int alpha;
	int beta ;
	int flag ;
	Uarray(int a, int b) {
		beta = b;				
		alpha = a;
		flag = 0;	
	}			

	int w = 1;					
	int n = 0;					

	int[] b = new int[w];

	public void push(int e) {
		if( n == w ) {
			reallocate(beta * n);
		}
		b[n] = e ;
		n++;
	}

	public void pop() {
		if (n > 0) {
			n--;
		}
		if( (alpha*n) <= w  ) {
			reallocate(beta * n);
			
		}
 	}

 	public void reallocate(int w1) {
 		if(flag == 0)
 			System.out.print(getCapacity());
 		else if(flag ==1)
 			System.out.print(","+getCapacity());
 		w = w1;
 		flag = 1;
 		int[] b1 = new int[w1];
 		for(int i=0; i<n; i++) {
 			b1[i] = b[i];
 		}
 		b = b1;
 	}

 	public void printArray() {
 		for (int i=0; i<n ; i++ ) {
 			System.out.println(b[i]);
 		}
 	}

 	public int getCapacity() {
 		return w;
 	}

 	public int getSize() {
 		return n;
 	}
}

class UnboundedArraysCapacityCheck{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String numbers = scan.nextLine();
		String[] number = numbers.split(",");
		number[0] = number[0].trim();
		number[1] = number[1].trim();
		int count=0;
		int beta = Integer.parseInt(number[0]);;
		int alpha = Integer.parseInt(number[1]);
		Uarray iArray =new Uarray(alpha, beta);
		if(beta < alpha) {
			String str = scan.nextLine();
			str=str.trim();
			String[] array = str.split(",");
			Random rand = new Random();
			for(int i=0; i<array.length; i++) {
				array[i] = array[i].trim();
				if(array[i].equals("push")){
					int randomNum = rand.nextInt(10);
					iArray.push(randomNum);
					count++;
				}
				else if(array[i].equals("pop")) {
					iArray.pop();
				}
			}
			if(count != 1) {
				System.out.print(","+iArray.getCapacity());
			}
		}
	}
}