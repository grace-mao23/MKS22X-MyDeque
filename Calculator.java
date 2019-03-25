public class Calculator{

    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      String[] tokens = s.split(" ");
      for (String reg : tokens) {
        System.out.println(reg);
      }
      return -1.0;
    }

    public static void main(String[] args) {
      Calculator.eval("3 4 +");
    }

}
