package behavorial;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a language, define a representation for its grammar along with an
 * interpreter that uses the representation to interpret sentences in the
 * language.
 */
interface Expression {
	public int interpret(HashMap<String, Integer> variables);
}

class Number implements Expression {
	private int number;

	public Number(int number) {
		this.number = number;
	}

	public int interpret(HashMap<String, Integer> variables) {
		return number;
	}
}

class Plus implements Expression {
	Expression leftOperand;
	Expression rightOperand;

	public Plus(Expression left, Expression right) {
		leftOperand = left;
		rightOperand = right;
	}

	public int interpret(HashMap<String, Integer> variables) {
		return leftOperand.interpret(variables) + rightOperand.interpret(variables);
	}
}

class Minus implements Expression {
	Expression leftOperand;
	Expression rightOperand;

	public Minus(Expression left, Expression right) {
		leftOperand = left;
		rightOperand = right;
	}

	public int interpret(HashMap<String, Integer> variables) {
		return leftOperand.interpret(variables) - rightOperand.interpret(variables);
	}
}

class Variable implements Expression {
	private String name;

	public Variable(String name) {
		this.name = name;
	}

	public int interpret(HashMap<String, Integer> variables) {
		return variables.get(name);
	}
}

// While the interpreter pattern does not address parsing[2] a parser is
// provided for completeness.

class Evaluator {
	private Expression syntaxTree;

	public Evaluator(String expression) {
		Stack<Expression> expressionStack = new Stack<Expression>();
		for (String token : expression.split(" ")) {
			if (token.equals("+")) {
				Expression subExpression = new Plus(expressionStack.pop(), expressionStack.pop());
				expressionStack.push(subExpression);
			} else if (token.equals("-")) {
				Expression subExpression = new Minus(expressionStack.pop(), expressionStack.pop());
				expressionStack.push(subExpression);
			} else
				expressionStack.push(new Variable(token));
		}
		syntaxTree = expressionStack.pop();
	}

	public int evaluate(HashMap<String, Integer> context) {
		return syntaxTree.interpret(context);
	}
}

// Finally evaluating the expression "w x z - +" with w = 5, x = 10, and z = 42.

public class Interpreter {
	public static void main(String[] args) {
		String expression = "w x z - +";
		Evaluator sentence = new Evaluator(expression);
		HashMap<String, Integer> variables = new HashMap<String, Integer>();
		variables.put("w", 5);
		variables.put("x", 10);
		variables.put("z", 42);
		int result = sentence.evaluate(variables);
		System.out.println(result);
	}
}