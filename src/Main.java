import java.util.*;
public class Main{
    private static int getOp(String exp, int cur){
        Scanner s = new Scanner(exp.substring(cur));
        s.useDelimiter("[^0-9]");
        return s.nextInt();
    }
    public static void main(String args[]) throws Exception{

        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        Scanner s = new Scanner(System.in);
        while(true) {
            System.out.println("Please enter a new expression: ");
            String exp = s.nextLine();

            if(exp.equals("DONE")) {
                break;
            }
//            int result = 0;
//            boolean add = true;//if false, means subtract
            for(int cur = 0; cur < exp.length();cur++) {
                char current = exp.charAt(cur);

                if(current == '+') { // Adds + to operators
//                    add = true;
                    operators.push(current);

                } else if (current == '-') { // Adds - to operators
//                    add = false;
                    operators.push(current);
                } else if (current == '(') {
                    operators.push(current);
                } else if (current == ')') {
                    operators.push(current);
                } else if (Character.isSpaceChar(current)) {
                    continue;
                }
                else if (Character.isDigit(exp.charAt(cur))){
                    int operand = getOp(exp, cur);
                    operands.push(operand); // Adds current operand onto the operands stack

                    while(cur < exp.length() && Character.isDigit(exp.charAt(cur))) {
                        cur++;
                    }
                    cur--;
                } else // Error handling
                    throw new Exception("Error: bad input");
            }
//            System.out.println("The result is " + result);
            System.out.println("Number Stack: " + operands);
            System.out.println("Operator Stack" + operators);
        }
    }
}