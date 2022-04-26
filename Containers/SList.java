package cyc.Containers;

public class SList {
    static class Node
    {
        Node(Integer data)
        {
            this.data=data;
            next=null;
        }
        Integer data;
        Node next;
    }
    // head node.
    private Node head=new Node(null);
    private Node index=head;
    class SListIterator
    {
        void insert(Integer data)
        {
           Node newNode=new Node(data);
           index.next=newNode;
           index=newNode;
        }

        void remove()
        {
            index.data=null;
        }
        void show()
        {
            Node temp=head;
            while(temp.next!=null)
            {
                System.out.println(temp.data);
                temp=temp.next;
            }
        }
    }
    SListIterator iterator()
    {
        return new SListIterator();
    }
    public static void main(String[]args)
    {
        SList sList=new SList();
        SListIterator sListIterator= sList.iterator();
        for(int i=0;i<10;i++)
        {
            sListIterator.insert(i);
        }
        sListIterator.show();
    }
}
