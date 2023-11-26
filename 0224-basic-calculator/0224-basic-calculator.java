class Solution {
    public int calculate(String s) {
        Deque<Object> stack = new ArrayDeque<>();
        for (int i = s.length()-1; i >= 0; i--) {
            char currChar = s.charAt(i);
            if (currChar == ' ') continue;
            if (currChar != '(') {
                stack.offerLast(currChar);
            } else {
                String computedValue = String.valueOf(compute(stack));
                for (int j = computedValue.length()-1; j >= 0; j--) {
                    stack.offerLast(computedValue.charAt(j));
                }
            }
        }
        return compute(stack);
    }

    private int compute(final Deque<Object> stack) {
        int digit = 0, result = 0, prev = 0;
        char operand = '+';
        while (!stack.isEmpty()) {
            char ch = (char) stack.pollLast();
            if (isTwoConsecutiveOperands(ch, stack)) {
                ch = getCorrectOperand(ch, stack);
            }
            if (Character.isDigit(ch)) {
                digit = digit * 10 + (ch - '0');

            }
            if (!Character.isDigit(ch) && ch != ' ' || stack.isEmpty()) {
                if (operand == '+' || operand == '-') {
                    result += prev;
                    prev = operand == '+' ? digit : -digit;
                } else if (operand == '*') {
                    prev *= digit;
                } else if (operand == '/') {
                    prev /= digit;
                }
                operand = ch;
                digit = 0;
            }
            if (operand == ')') break;
        }
        return result + prev;
    }

    private char getCorrectOperand(char charOperand, Deque<Object> stack) {
        char stackOperand = (char) stack.pollLast();
        if (charOperand == '+' && stackOperand == '-' ||
                charOperand == '-' && stackOperand == '+') {
            return '-';
        }
        return '+';
    }

    private boolean isTwoConsecutiveOperands(char ch, Deque<Object> stack) {
        Set<Character> operands = Set.of('+', '-', '*', '/');
        if (stack.isEmpty()) {
            return false;
        }
        return operands.contains(ch) && operands.contains((char) stack.peekLast());
    }
}