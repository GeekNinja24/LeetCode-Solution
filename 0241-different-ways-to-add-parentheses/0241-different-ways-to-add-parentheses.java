class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if(c == '-' || c == '+' || c == '*'){
                String part1 = expression.substring(0, i);
                String part2 = expression.substring(i + 1);

                List<Integer> part1Results = diffWaysToCompute(part1);
                List<Integer> part2Results = diffWaysToCompute(part2);

                for (int num1 : part1Results) {
                    for (int num2 : part2Results) {
                        switch (c) {
                            case '+':
                                result.add(num1 + num2);
                                break;
                            case '-':
                                result.add(num1 - num2);
                                break;
                            case '*':
                                result.add(num1 * num2);
                                break;
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        return result;
    }
}