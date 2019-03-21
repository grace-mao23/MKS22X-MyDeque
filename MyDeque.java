public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
  }

  public int size(){
    return size;
  }

  public String toString(){
    String result = "{";
    for (int i = start; i <= end; i++) {
      result += data[start] + " ";
    }
    return result + "}";
  }

  public void addFirst(E element){

  }

  public void addLast(E element){

  }

  public E removeFirst(E element){
    return element;
  }

  public E removeLast(E element){
    return element;
  }

  public E getFirst(E element){
    return data[start];
  }

  public E getLast(E element){
    return data[end];
  }
}
