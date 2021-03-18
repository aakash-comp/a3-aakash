package a3;

public class Test_maxmin {
    BSTImpl bst;
    BSTImpl t2;
    final int MAX = 10;

    Test_maxmin() {
        bst = new BSTImpl();
        t2 = new BSTImpl();
    }

    public void run() {
        bst.insert("h");
        bst.insert("w");
        bst.insert("c");
        bst.insert("t");
        bst.insert("b");
        bst.insert("g");
        bst.insert("z");
        bst.insert("a");
        bst.show();
        System.out.print(bst.findMax());
        System.out.print(bst.findMin());
    }
}
