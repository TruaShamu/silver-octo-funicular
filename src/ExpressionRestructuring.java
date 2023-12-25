import java.util.Stack;

public class ExpressionRestructuring {
	/*
	 * Convert a numerical infix expression (string) (w/h parenthesis) to postfix form (string).
	 */
	public static String infixToPostfix(String infixStr) {
		char[] input = infixStr.toCharArray();
		StringBuilder postfix = new StringBuilder();
		Stack<Character> operatorStack = new Stack<>();

		for (int i = 0; i < infixStr.length(); i++) {
			char curOp = input[i];

			// Numerical (operand)
			if (Character.isDigit(curOp)) {
				postfix.append(curOp);
				continue;
			}

			// Parenthesis left (push to stack)
			if (curOp == '(') {
				operatorStack.push(curOp);
				continue;
			}
			// Right parenthesis (pop all the operators in the parenthesis scope)
			if (curOp == ')') {
				while (!operatorStack.isEmpty() && operatorStack.peek()!= '(') {
					postfix.append(operatorStack.pop());
				}
				// pop the left parenthesis
				operatorStack.pop();
				continue;
			}
			// Regular operator.
			if (isOperator(curOp)) {
				// Remove all operators with higher precedence
				while (!operatorStack.isEmpty() && calcPrecedence(operatorStack.peek()) > calcPrecedence(curOp)) {
					postfix.append(operatorStack.pop());
				}
				// Push the current operator
				operatorStack.push(curOp);
			}
		}
		// Remove remaining operator
		while (!operatorStack.isEmpty()) {
			postfix.append(operatorStack.pop());
		}
		return postfix.toString();

	}

	// Returns the operator precedence (lesser priority corresponds to lesser value returned)
	public static int calcPrecedence(char op) {
		if (op == '+' || op == '-') {
			return 0;
		}
		if (op == '*' || op == '/') {
			return 1;
		}
		if (op == '^') {
			return 2;
		}
		return -1;
	}
	public static boolean isOperator(char op) {
		return op == '+' || op == '-' || op == '*' || op == '/' || op == '^';
	}
}
