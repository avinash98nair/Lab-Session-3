package com.gl.problem1;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BalancingBrackets {

	public static void main(String[] args) {
		String input = "{[()]}";
		System.out.println(isBalancedBracket(input));
	}
	public static boolean isBalancedBracket(String input) {
		if(input == null || input.isEmpty()) {
			System.out.println("Empty input string");
			return false;
		}
		Stack<Character> stack = new Stack<>();
		Set<Character> acceptedChars = new HashSet<Character>();
		acceptedChars.add('(');
		acceptedChars.add('[');
		acceptedChars.add('{');
		for(Character ch: input.toCharArray()) {
			if(!acceptedChars.contains(ch)) {
				System.out.println("Invalid character in input string");
				return false;
			}
			if(ch == '{' || ch == '(' || ch == '[') {
				stack.push(ch);
				continue;
			}
			if(stack.isEmpty()) {
				return false;
			}
			switch(ch) {
			case '}' :
				if(stack.pop()!='{') {
					return false;
				}
				break;
			case ']' :
				if(stack.pop()!='[') {
					return false;
				}
				break;
			case ')' :
				if(stack.pop()!='(') {
					return false;
				}
				break;
			}
		}
		return stack.isEmpty();
	}
}
