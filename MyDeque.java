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

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] newData = (E[])new Object[data.length * 2 + 1];
    for (int i = 0; i < size(); i++) {
      newData[i] = data[i];
    }
    data = newData;
  }

  public void addFirst(E element){
    // special cases:
    // no more room at start, but still room after end
    // no more room in general (resize)
    if (start == 0 && end != data.length - 1) {
      start = data.length - 1;
      data[start] = element;
    } else if (start == 0 && end == data.length - 1) {

    } else {
      // NO SPECIAL CASES
      start -= 1;
      data[start] = element;
    }
    size++;
  }

  public void addLast(E element){

  }

  // set to null
  public E removeFirst(){
    return null;
  }

  // set to null
  public E removeLast(){
    return null;
  }

  public E getFirst(E element){
    return data[start];
  }

  public E getLast(E element){
    return data[end];
  }
}
