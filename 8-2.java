public class 8-2 {
    
}
import java.io.*;
import java.util.Scanner;

class MaxHeap {
		
	private int size = 0;	// MaxHeap에 저장된 데이터 갯수. p.336에서는 변수 n으로 표현
	private int[] heap; // MaxHeap
	
	/**
	 * @param capacity 힙 배열의 크기
	 */
	public MaxHeap(int capacity) {
		heap = new int[capacity];
	}
	
	public void print() {
		for(int i = 1; i <= size; i++)
			System.out.print(heap[i] + " ");
	}
	
	// 아래 2개의 메소드(insert, delete)를 작성하시오.
	
	/**
	 * 교재 p.336 참조
	 * @param x 삭입하고자 하는 데이터
	 */
	public void insert(int x) {
		heap[++size] = x;
		int current = size;
		while (current > 1 && heap[current] > heap[current / 2]) {
			int temp = heap[current];
			heap[current] = heap[current / 2];
			heap[current / 2] = temp;
			current /= 2;
		}
	}

	public int delete() {
		int root = heap[1];
		heap[1] = heap[size--];
		heapify(1);
		return root;
	}

	private void heapify(int i) {
		int l = 2 * i;
		int r = 2 * i + 1;
		int largest = i;
		if (l <= size && heap[l] > heap[largest]) {
			largest = l;
		}
		if (r <= size && heap[r] > heap[largest]) {
			largest = r;
		}
		if (largest != i) {
			int temp = heap[i];
			heap[i] = heap[largest];
			heap[largest] = temp;
			heapify(largest);
		}
	}
}
	
class Main {
	
	// 아래 main 메소드는 수정하지 마시오.
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		MaxHeap heap = new MaxHeap(100);
		
		while (scan.hasNext()) {
			String command = scan.next();
			
			if (command.equals("I")) {
				int data = Integer.parseInt(scan.next());
				heap.insert(data);
			} else if (command.equals("D")) {
				heap.delete();
			} else if (command.equals("P")) {
				heap.print();
			} else if (command.equals("E")) {
				break;
			}
		}
		scan.close();
	}
	
}