import java.util.Stack;

public class MinStack155 {
    class Pair{
        Integer first;
        Integer second;
        public Pair(Integer value, Integer min){
            this.first = value;
            this.second = min;
        }
    }
    private Stack<Pair> stack;
    public MinStack155(){
        this.stack = new Stack<>();
    }
    void push(Integer value){
        if (stack.isEmpty()){
            stack.push(new Pair(value,value));
        } else {
            stack.push(new Pair(value, Math.min(value, stack.peek().second)));
        }
    }
    Integer top(){
        return stack.peek().first;
    }
    void pop(){
        stack.pop();
    }
    Integer getMin(){
        return stack.peek().second;
    }
    public static void main(String[] args) {
        MinStack155 minStack = new MinStack155();
        minStack.push(2);
        minStack.push(3);
        minStack.push(4);
        minStack.push(8);
        System.out.println("min element is : "+minStack.getMin());
        System.out.println("top element is : "+minStack.top());
        minStack.pop();
        System.out.println("after 1 pop, min is : "+minStack.getMin());
        System.out.println("top element is : "+minStack.top());
    }
}
