class MaxHeap {
    int[] a;
    int maxsize, currsize;

    MaxHeap(int maxsize) {
        this.maxsize = maxsize;
        this.currsize = 0;
        this.a = new int[maxsize];
    }

    int parent(int i) {
        return (i - 1) / 2;
    }

    int lchild(int i) {
        return 2 * i + 1;
    }

    int rchild(int i) {
        return 2 * i + 2;
    }

    void insert(int key) {
        if (currsize == maxsize) {
            System.out.println("Heap overflow");
            return;
        }
        int i = currsize;
        a[i] = key;
        currsize++;
        while (i != 0 && a[parent(i)] < a[i]) {
            int temp = a[parent(i)];
            a[parent(i)] = a[i];
            a[i] = temp;
            i = parent(i);
        }
    }

    void heapify(int i) {
        int largest = i;
        int l = lchild(i);
        int r = rchild(i);

        if (l < currsize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < currsize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            heapify(largest);
        }
    }

    void remove() {
        if (currsize <= 0) {
            System.out.println("Heap underflow");
            return;
        }
        if (currsize == 1) {
            currsize--;
            return;
        }
        a[0] = a[currsize - 1];
        currsize--;
        heapify(0);
    }

    int Max() {
        if (currsize > 0) {
            return a[0];
        }
        throw new IllegalStateException("Heap is empty");
    }

    int cur() {
        return currsize;
    }

    public static void main(String[] args) {
        MaxHeap h = new MaxHeap(15);
        int[] elements = {3, 10, 12, 8, 2, 14};

        for (int e : elements) {
            h.insert(e);
        }

        for (int i = 0; i < h.cur(); i++) {
            System.out.print(h.a[i] + " ");
        }
        System.out.println();

        System.out.println("The current size of the heap is " + h.cur());
        System.out.println("The current maximum element is " + h.Max());

        h.remove();

        System.out.println("The current size of the heap is " + h.cur());

        h.insert(15);
        h.insert(5);

        System.out.println("The current size of the heap is " + h.cur());
        System.out.println("The current maximum element is " + h.Max());
    }
}
