package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    private int[] array;
    private Stack<Integer> stack;
    private Map<Integer, Integer> hashMap;

    public NextGreaterElement(int[] array) {
        this.array = array;
        stack = new Stack<>();
        hashMap = new HashMap<>();
    }

    public Map<Integer, Integer> nextGreatestElements() {
        stack.push(array[0]);
        for (int i = 1; i < array.length; i++) {
            int next = array[i];
            if (stack.isEmpty() == false) {
                int element = stack.pop();

                while (element < next) {
                    hashMap.put(element, i);
                    if (stack.isEmpty()) {
                        break;
                    }
                    element = stack.pop();
                }

                if (element > next) {
                    stack.push(element);
                }
            }

            stack.push(next);
        }

        while (!stack.isEmpty()) {
            hashMap.put(stack.pop(), 0);
        }

        return hashMap;
    }

    public static void main(String args[]) {
        NextGreaterElement nge = new NextGreaterElement(new int[] { 11, 13, 21, 3 });
        nge.nextGreatestElements();
    }
}
