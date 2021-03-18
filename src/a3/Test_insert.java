package a3;

public class Test_insert {
    BSTImpl bst;
    BSTImpl t2;
    final int MAX = 10;

    Test_insert (){
        bst = new BSTImpl();
        t2 = new BSTImpl();
    }

    public void run(){
        bst.insert("h");
        bst.insert("w");
        bst.insert("c");
        bst.insert("t");
        bst.insert("b");
        bst.insert("g");
        bst.insert("z");
        bst.insert("a");
        bst.show();
        /*

        bst = new BSTImpl();
        for(int i = 0; i<MAX; i++){
            bst.insert(mrst.nextString());
        }
        bst.show();
         */
    }
}
