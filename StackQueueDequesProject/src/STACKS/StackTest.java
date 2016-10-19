package STACKS;

import java.util.Stack;

/**
 * Created by christianhasselstrom on 18/05/2016.
 */
public class StackTest
{
    public static void main(String[] args)
    {
        Stack<Integer> stack = new Stack();

        int array[] =
                {
                        1,2,3,4,5
                };

        for(int i = 0; i < array.length; i++)
        {
            stack.push(array[i]);
        }
        System.out.println("Stack: " + stack);
        stack.pop();
        System.out.println("Stack efter pop: " + stack);
        stack.push(10);
        System.out.println("Stack efter push: " + stack);
        System.out.println("Stack peek: " + stack.peek());
    }
}
