import java.util.*;

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
    if (size() == 0) {
      return "{}";
    }
    if (start <= end) {
      for (int i = start; i <= end; i++) {
        result += data[i]+" ";
      }
    } else { // start is larger than end
      for (int i = start; i < data.length; i++) {
        result += data[i] + " ";
      }
      for (int i = 0; i <= end; i++) {
        result += data[i] + " ";
      }
    }
    return result +"}";
  }

  public String toDebug(){
    String result = "{";
    for (int i = 0; i < data.length; i++) {
      result += data[i] + " ";
    }
    return result+"}";
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    E[] newData = (E[])new Object[data.length * 2 + 1];
    int index = 0;
    if (start <= end) {
      for (int i = start; i <= end; i++) {
        newData[index] = data[i];
        index++;
      }
    } else { // start is larger than end
      for (int i = start; i < data.length; i++) {
        newData[index] = data[i];
        index++;
      }
      for (int i = 0; i <= end; i++) {
        newData[index] = data[i];
        index++;
      }
    }
    data = newData;
    start = 0;
    end = size - 1;
  }

  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException("Cannot add null");
    }
    // special cases:
    // no more room at start, but still room after end
    // no more room in general (resize)
    if (start == 0 && end != data.length - 1) {
      start = data.length - 1;
      data[start] = element;
    } else if (data.length - 1 == size()) {
      resize();
      start = data.length - 1;
      data[start] = element;
    } else {
      // NO SPECIAL CASES
      start -= 1;
      data[start] = element;
    }
    size++;
    if (size() == 1) {
      end = start;
    }
  }

  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException("Cannot add null");
    }
    // special cases:
    // no more room at end, but still room before start
    // no more room in general (resize)
    if (end == data.length - 1 && start != 0) {
      end = 0;
      data[end] = element;
    } else if (data.length - 1 == size()) {
      int prevSize = data.length-1;
      resize();
      end = prevSize+1;
      data[end] = element;
    } else {
      // NO SPECIAL CASES
      end += 1;
      data[end] = element;
    }
    size++;
    if (size() == 1) {
      start = end;
    }
  }

  // set to null
  public E removeFirst(){
    if (size() == 0) {
      throw new NoSuchElementException("This Deque is empty");
    }
    // special case:
    // start is the last element in data
    E result = data[start];
    data[start] = null;
    if (start == data.length - 1) {
      start = 0;
    } else {
      // NO SPECIAL CASE
      start += 1;
    }
    size--;
    return result;
  }

  // set to null
  public E removeLast(){
    if (size() == 0) {
      throw new NoSuchElementException("This Deque is empty");
    }
    // special case:
    // end is the first element
    E result = data[end];
    data[end] = null;
    if (end == 0) {
      end = data.length - 1;
    } else {
      // NO SPECIAL CASE
      end -= 1;
    }
    size--;
    return result;
  }

  public E getFirst(){
    if (size() == 0) {
      throw new NoSuchElementException("This Deque is empty");
    }
    return data[start];
  }

  public E getLast(){
    if (size() == 0) {
      throw new NoSuchElementException("This Deque is empty");
    }
    return data[end];
  }

  public int getStart(){
    return start;
  }

  public int getEnd() {
    return end;
  }

  public static void main(String[] args) {
    MyDeque<String> m = new MyDeque<String>(2);
  //  System.out.println(m.toString() + m.getStart());
  //  System.out.println(m.toDebug() + m.getEnd());
    m.addFirst("My");
  //  System.out.println(m.toString() + m.getStart());
  //  System.out.println(m.toDebug() + m.getEnd());
    m.addFirst("Hi");
  //  System.out.println(m.toString() + m.getStart());
  //  System.out.println(m.toDebug() + m.getEnd());
    m.addLast("Name");
  //  System.out.println(m.toString() + m.getStart());
  //  System.out.println(m.toDebug() + m.getEnd());
    System.out.println(m.removeFirst());
  //  System.out.println(m.toString() + m.getStart());
  //  System.out.println(m.toDebug() + m.getEnd());
    m.addFirst("Hello");
  //  System.out.println(m.toString() + m.getStart());
  //  System.out.println(m.toDebug() + m.getEnd());
    System.out.println(m.removeLast());
//    System.out.println(m.toString() + m.getStart());
//    System.out.println(m.toDebug() + m.getEnd());
    m.addLast("Birthday");
//    System.out.println(m.toString() + m.getStart());
//    System.out.println(m.toDebug() + m.getEnd());
    System.out.println(m.toString());
    System.out.println(m.getFirst());
    System.out.println(m.getLast());
  }
}
