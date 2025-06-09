package easy.q225;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> dataq;

    public MyStack() {
        dataq = new LinkedList<>();
    }

    public void push(int x) {
        dataq.add(Integer.valueOf(x));
        if (dataq.size() > 1) {
            for (int i = 1; i < dataq.size(); i++) {
                dataq.add(dataq.remove());
            }
        }
    }

    public int pop() {
        return dataq.remove().intValue();
    }

    public int top() {
        return dataq.peek().intValue();
    }

    public boolean empty() {
        return dataq.isEmpty();
    }
}
