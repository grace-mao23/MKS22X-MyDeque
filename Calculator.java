public class Calculator{

    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      String[] tokens = s.split(" ");
      /*for (String reg : tokens) {
        System.out.println(reg);
      }*/
      MyDeque<Double> stack = new MyDeque<Double>();
      for (String t : tokens) {
        // + - * / %
        if (t.equals("+")) {
          double second = stack.removeLast();
          double first = stack.removeLast();
          stack.addLast(first + second);
        } else if (t.equals("-")) {
          double second = stack.removeLast();
          double first = stack.removeLast();
          stack.addLast(first - second);
        } else if (t.equals("*")) {
          double second = stack.removeLast();
          double first = stack.removeLast();
          stack.addLast(first * second);
        } else if (t.equals("/")) {
          double second = stack.removeLast();
          double first = stack.removeLast();
          stack.addLast(first / second);
        } else if (t.equals("%")) {
          double second = stack.removeLast();
          double first = stack.removeLast();
          stack.addLast(first % second);
        } else {
          double d = Double.parseDouble(t);
          stack.addLast(d);
        }
      }
      return stack.getFirst();
    }

    public static void main(String[] args) {
      System.out.println(Calculator.eval("3 4 +")); // 7.0
      System.out.println(Calculator.eval("9 3 4 + -")); //2.0
      System.out.println(Calculator.eval("11 3 4 + - 2 % 8 + 2 / 3 *")); // 12.0
      System.out.println(Calculator.eval("1 1 + 2 3 4 + - *")); // -10.0
    }

}
