import static org.junit.Assert.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.junit.Test;

public class valid_parentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid3(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.addFirst(')');
            } else if (c == '[') {
                stack.addFirst(']');
            } else if (c == '{') {
                stack.addFirst('}');
            } else if (stack.isEmpty() || stack.removeFirst() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid4(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.addFirst(map.get(c));
            } else {
                if (stack.isEmpty() || stack.removeFirst() != c) {
                    return false;
                }
                
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void testParentheses() {
        assertEquals(true, isValid("(){}[]"));
        assertEquals(true, isValid("()"));
        assertEquals(false, isValid("(]"));
        assertEquals(true, isValid2("(){}[]"));
        assertEquals(true, isValid2("()"));
        assertEquals(false, isValid2("(]"));
        assertEquals(true, isValid3("(){}[]"));
        assertEquals(true, isValid3("()"));
        assertEquals(false, isValid3("(]"));
        assertEquals(true, isValid4("(){}[]"));
        assertEquals(true, isValid4("()"));
        assertEquals(false, isValid4("(]"));
    }
}

/*
Explanation

A simple stack problem, if it is (,[ or { then push it onto the stack. Then if it is ), ], } peek the stack and if they match then pop it out. Finally, see if the stack is empty

Method 2: if you see (, [, { push these onto the stack },],) then pop them and check it with the current to see if it matches

You can just exist early if the length of the string is odd

Time: O(n) 
Space: O(n)

For Java: Using Stack shows that you're not as familiar with language as the interviewer probably wants you to be.
Stack is a rather old collection that extends Vector, has performance issues due to each method in it being synchronized, 
and violates some best practices around interfaces, so it is considered legacy nowadays.

https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html
Use Deque instead https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html
*/