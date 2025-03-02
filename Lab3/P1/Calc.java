public class Calc {
    public static void main(String[] args) {
		 if (args.length != 3) {
            System.out.println(" Invalid ");
            return;
        }
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[2]);
            String operator = args[1];

            int result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "x":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        System.out.println("Division by zero is not allowed in java");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid operator");
                    return;
            }

            System.out.println("Result: " + result);
      
    }
}
