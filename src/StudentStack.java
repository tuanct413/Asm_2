import java.util.Stack;

public class StudentStack {
    private Stack<Student> stack;

    public StudentStack() {
        stack = new Stack<>();
    }

    public void push(Student student) {
        stack.push(student);
    }

    public Student pop() {
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return null;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public Stack<Student> getStack() {
        return stack;
    }
}
