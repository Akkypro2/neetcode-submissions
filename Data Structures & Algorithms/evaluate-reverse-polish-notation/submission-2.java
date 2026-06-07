

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || 
                token.equals("*") || token.equals("/")) {

                int b = stack.pop(); // second operand
                int a = stack.pop(); // first operand

                if (token.equals("+")) stack.push(a + b);
                else if (token.equals("-")) stack.push(a - b);
                else if (token.equals("*")) stack.push(a * b);
                else stack.push(a / b); // division truncates toward 0

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}