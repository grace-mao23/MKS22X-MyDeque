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

        } else if (t.equals("-")) {

        } else if (t.equals("*")) {

        } else if (t.equals("/")) {

        } else if (t.equals("%")) {

        } else {
          double d = Double.parseDouble(t);
          stack.addLast(d);
          System.out.println(stack.toString());
        }
      }
      return -1.0;
    }

    public static void main(String[] args) {
      Calculator.eval("3 4 +");
    }

}
