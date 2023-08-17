package linkedlist;


    import java.net.SocketOption;

    public class Main {
        public static void main (String[]args){
            LinkedList list = new LinkedList();
            list.insert(2);
            list.insert(4);
            list.insert(6);
            list.insert(10);
            list.insert(22);

            System.out.println("Linked List " + list.toString());
            System.out.println("Has" + list.contain(15));
            System.out.println("Has" + list.contain(22 ));

        }
    }

