/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myproject;

import java.util.Stack;

/**
 *
 * @author Admin
 */
public class PostFix {
    Stack<Character> stack = new Stack<Character>();
    StringBuffer sbuff = new StringBuffer();
    
    
    public String InfixToPostfix(String str){
        int n = str.length();
        
        for (int i = 0; i<n; i++){
            char c = str.charAt(i);
            
            if (IsOperand(c))
                sbuff.append(c);
            else if (IsOperator(c)){
                while (!stack.empty() && Priority(c) <= Priority(stack.peek())){
                    sbuff.append(stack.pop());
                }
                stack.push(c);
            }
            else if (c == '(')
                stack.push(c);
            else if (c == ')')
            {
                while (!stack.empty() && stack.peek() != '(')
                    sbuff.append(stack.pop());
                if (stack.empty())
                    return "null";
                else
                    stack.pop();
            }          
        }
        while (!stack.empty())
            sbuff.append(stack.pop());
        return sbuff.toString();
    }
    
    public int Priority(char x){
        switch (x){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }  
        return -1;
    }
    
    public boolean IsOperator(char x){
        switch (x){
            case '+':
            case '*':
            case '-':
            case '/':
            case '^':
                return true;
            default:
                return false;
        }
    }
    
    public boolean IsOperand(char x ){
        return ((x >= 'a' && x <= 'z') || (x >= '0' && x <= '9'));
    }
}

