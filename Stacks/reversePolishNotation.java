public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack =  new Stack<Integer>();
        String ops = "+-*/";
        
        for(String s : tokens){
            if(!ops.contains(s)){
                stack.push(Integer.parseInt(s));
            }else{
                int a = stack.pop();
                int b = stack.pop();
                switch(s){
                    case "+":
                        stack.push(b+a);
                        break;
                    case "-":
                        stack.push(b-a);
                        break;
                    case "*":
                        stack.push(a*b);
                        break;    
                    case "/":
                        stack.push(b/a);
                        break;    
                }
            }                        
        }
        return stack.pop();
    }
}