public class StudentStack {
    private Student[] stack; // Mảng để lưu trữ các phần tử của stack
    private int top;         // Con trỏ chỉ vị trí phần tử trên cùng của stack
    private int capacity;    // Sức chứa tối đa của stack

    // Constructor
    public StudentStack(int capacity) {
        this.capacity = capacity;
        stack = new Student[capacity];
        top = -1; // Stack ban đầu rỗng
    }

    // Thêm một Student vào stack
    public void push(Student student) {
        if (top == capacity - 1) {
            System.out.println("Stack is full! Cannot push.");
            return;
        }
        stack[++top] = student; // Tăng top và thêm phần tử
    }

    // Lấy và loại bỏ phần tử trên cùng của stack
    public Student pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot pop.");
            return null;
        }
        return stack[top--]; // Lấy phần tử tại top và giảm top
    }

    // Lấy phần tử trên cùng mà không loại bỏ
    public Student peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot peek.");
            return null;
        }
        return stack[top]; // Trả về phần tử tại top
    }

    // Kiểm tra stack có rỗng không
    public boolean isEmpty() {
        return top == -1;
    }

    // Kiểm tra stack có đầy không
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Lấy kích thước của stack
    public int size() {
        return top + 1;
    }
}
