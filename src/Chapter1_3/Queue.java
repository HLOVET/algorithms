package Chapter1_3;
import java.util.Iterator;
/**
 * Created by xie on 2017/4/9.
 * 先进先出的队列  需要多一个last节点记录链表的末端
 */
public class Queue<Item> {
    private class Node{
        Item item;
        Node next;
    }
    private Node first;
    private Node last;
    private int N;
    public boolean isEmpty(){return N==0;}
    public int size(){return N;}
    public void add(Item item){ //添加元素时移动last标记而已
        Node oldlast = last;
        last = new Node();
        last.item = item;
        if(isEmpty()) first = last;  //如果为空则first和last都指向同一个
        else oldlast.next = last;   //不然就将原来最后的元素指向新增的last
        N++;
    }

    public Item remove(){  //移除元素时，从表头开始
        Item item = first.item;
        first = first.next;   //表头向后移动
        if(isEmpty()) last = null; //移除玩最后一个，将last指向null
        N--;
        return item;
    }

    //迭代器  依靠first节点实现先进的先进行遍历
    public Iterator<Item> iterator(){ //返回一个迭代器对象
        return new ListIterator();
    }
    private class ListIterator implements Iterator<Item>{
        private Node current = first;//当前节点总是指向第一个
        @Override
        public boolean hasNext() {
            return current!=null;
        }
        @Override
        public Item next() {        //依次返回链表元素，实现遍历
            Item item = current.item;
            current = current.next;
            return item;
        }
        @Override
        public void remove() {
            //视具体情况决定是否在迭代器中提供移除的方法
        }
    }

}
