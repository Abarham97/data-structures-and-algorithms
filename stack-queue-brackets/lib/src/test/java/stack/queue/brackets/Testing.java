package stack.queue.brackets;

public class Testing {
    public static void main(String[] args) {
        testBracketValidation("{}");
        testBracketValidation("{}(){}");
        testBracketValidation("()[[Extra Characters]]");
        testBracketValidation("(){}[[]]");
        testBracketValidation("{}{Code}[Fellows](())");
        testBracketValidation("[({}]");
        testBracketValidation("(](");
        testBracketValidation("{(})");
    }

    private static void testBracketValidation(String input) {
        boolean result = BracketValidator.validateBrackets(input);
        System.out.println(input + "\t" + result);
    }
}
