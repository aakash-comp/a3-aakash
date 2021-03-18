package a3;

public class Test_show {
    BSTImpl bst = new BSTImpl();

    public void run(){
       /* bst.insert("a");
        bst.insert("d");
        bst.insert("g");
        bst.insert("h");
        bst.insert("e");
        bst.insert("n");
        bst.show();
        */
        Node n1 =new NodeImpl("heels");
        Node n2 =new NodeImpl("duke");
        Node n3 =new NodeImpl("zoo");
        Node n4 =new NodeImpl("apple");
        Node n5 =new NodeImpl("march");
        Node n6 =new NodeImpl("tarheel");
        n1.setRight(n6);
        n1.setLeft(n2);
        n2.setLeft(n4);
        n6.setRight(n3);
        n6.setLeft(n5);
        bst = new BSTImpl();
        bst.setRoot(n1);
        bst.show();

    }
}
