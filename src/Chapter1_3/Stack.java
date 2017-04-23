package Chapter1_3;

import java.util.Iterator;

/**
 * Created by xie on 2017/4/8.
 */
//数组方式实现Stack
class ResizingArrayStack<Item>  {
    private int N=0;//数组大小
    public boolean isEmpty(){return N==0;}
    public int size(){return N;}
    private Item[] a = (Item[])new Object[1];//初始数组

    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];//将原数组移到一个新的大小为max的新数组中
        for(int i=0;i<N;i++){
            temp[i]=a[i];
        }
        a=temp;//新数组给a
    }
    //新增元素，先判断是否满了，满了就新建一个原来两倍大小的数组
    public void push(Item item){
        if(N==a.length) resize(2*a.length);
        a[N++]=item;
    }
    //取出元素，判断元素个数是否太少，是的话移动到一个较小的数组中，节省内存
    public Item pop( ){
        Item item = a[--N];
        a[N]=null;  //防止游离，由于元素被弹出了，但是还是被数组引用，所以不会被回收，需要手动将引用指向null
        if(N>0 && N<a.length/4) resize(a.length/2);
        return item;
    }
    //返回该类型的迭代器
    public Iterator<Item> iterator(){
        return new ReverseArrayIterator();
    }
        //迭代器实现Iterator接口，实现了后进先出的迭代(和外部的pop方法实现一样)
        //内部类形式定义该迭代器，这样就可以直接使用外部类的属性N，进行弹出操作就不会影响实际的数组
        //remove方法视情况决定是否提供
        private class ReverseArrayIterator implements Iterator<Item>{
            private int i=N;
            public boolean hasNext(){ return i>0;}
            public Item next(){ return a[--i];}
            public void remove(){}
        }
}

//链表实现Stack
//优点：1.可以处理任意类型的数据
//      2.所需空间与集合大小成正比
//      3.操作所需时间为常数，与集合的大小无关
class LinkStack<Item>{
    private Node first;
    private int N;

    private class Node{    //链表的结点，基本组成
        Item item;
        Node next;
    }
    public boolean isEmpty(){return N==0;}
    public int size(){return N;}
    public void push(Item item){    //向表头添加新结点，先保存老的表头结点，然后用新的指向它
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop(){      //弹出表头元素，直接取出对应的item，并将first结点指向下一个即可
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    //迭代器
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
