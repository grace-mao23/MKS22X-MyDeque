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

        } else if (t.equals("*")) {

        } else if (t.equals("/")) {

        } else if (t.equals("%")) {

        } else {
          double d = Double.parseDouble(t);
          stack.addLast(d);
        }
      }
      return stack.getFirst();
    }

    public static void main(String[] args) {
      System.out.println(Calculator.eval("3 4 +"));
    }

}
