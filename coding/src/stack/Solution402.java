package stack;

import java.util.Stack;

public class Solution402 {
    public static void main(String[] args) {
        System.out.println(removeKdigits("120", 2));
        System.out.println(removeKdigits("1111111", 3));
        System.out.println(removeKdigits("112", 1));
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
    }


    private static String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        //加入哨兵
        Stack<Character> stack = new Stack<>();
        int maxPop = 0;
        for (int i = 0; i < num.length(); i++) {

            while (!stack.isEmpty() && num.charAt(i) < stack.peek() && maxPop++ < k) {
                stack.pop();
            }
            //哨兵不进行数据处理
                stack.add(num.charAt(i));
        }

        StringBuffer buffer = new StringBuffer();
        int maxRetain = 0;
        //可能stack中的递增数组的数量大于num.length()-k,则只取前num.length()-k个
        while (!stack.isEmpty() && maxRetain++ < num.length() - k ) {
            Character ele = stack.remove(0);
            if (ele == '0' && buffer.length() == 0) {
                continue;
            }
            buffer.append(ele);
        }
        return buffer.length() == 0 ? "0" : buffer.toString();
    }
}
