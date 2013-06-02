package priorityqueue;

public class Heap {
	int heap[];
	int size = 0;

	void Heap() {
		heap = new int[100];
	}

	void push(int x) {
		int i = size++;
		while (i > 0) {
			int parent = (i - 1) / 2;
			if (heap[parent] <= x) {
				break;
			} else {
				heap[i] = heap[parent];
				i = parent;
			}
		}
		heap[i] = x;
	}

	int pop() {
		int ret = heap[0];
		int last = heap[--size];
		int pointer = 0;
		while (true) {
			int left = pointer * 2 + 1;
			int right = pointer * 2 + 2;
			if (heap[right] < heap[left]) {
				left = right;
			}
			if (heap[left] >= last) {
				break;
			} else {
				heap[pointer] = heap[left];
				pointer = left;
			}
		}
		heap[pointer] = last;
		return ret;
	}
}
