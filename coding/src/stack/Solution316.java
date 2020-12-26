package stack;

import java.util.HashMap;
import java.util.Stack;

public class Solution316 {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("abacb"));
    }


    private static String removeDuplicateLetters(String s) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            Character ch = s.charAt(i);
            if (!stack.contains(ch)) {
                while (!stack.isEmpty() && ch < stack.peek() && map.get(stack.peek()) > 0) {
                    stack.pop();
                }
                stack.add(ch);
            }
            map.put(ch, map.get(ch) - 1);
        }
        StringBuffer buffer = new StringBuffer();
        while (!stack.isEmpty()) {
            buffer.append(stack.remove(0));
        }
        return buffer.toString();
    }
}

