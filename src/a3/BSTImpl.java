package a3;

public class BSTImpl implements BST {

    private Node root;
    private int size;

    public BSTImpl() {
        root = null;
        size = 0;
    }

    public BSTImpl(String s) {
        root = new NodeImpl(s);
        size = 0;
    }
    public void setRoot(Node n){
        this.root = n;
    }

    public void show() {
        int off = 4;
        int lev = 0;
        for (int k = 0; k < 10; k++) {
            System.out.print("+");
            for (int kk = 0; kk < off - 1; kk++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
        show_r(this.root, lev, off);
        for (int k = 0; k < 10; k++) {
            System.out.print("+");
            for (int kk = 0; kk < off - 1; kk++) {
                System.out.print("-");
            }

        }
    }

    private void show_r(Node n, int lev, int off) {
        if (n == null) return;
        show_r((n.getRight()), lev + off, off);
        for (int b = 0; b < lev; b++) {
            System.out.print(" ");
        }
        System.out.println(n.getValue());
        show_r(n.getLeft(), lev + off, off);
    }

    // The implementation of "height" is given to you below
    // it is here to illustrate for you how to set up
    // the method implementation as recursion.
    // You should follow this pattern for implementing the other recursive methods
    // by adding your own private recursive methods

    @Override
    public int height() { // public interface method signature
        // this method is the public interface method
        // it is not recursive, but it calls a recursive
        // private method and passes it access to the tree cells
        return height_recursive(this.root);
    }
    private int height_recursive(Node c) {
        // inner method with different signature
        // this helper method uses recursion to traverse
        // and process the recursive structure of the tree of cells
        if (c==null) return -1;
        int lht = height_recursive(c.getLeft());
        int rht = height_recursive(c.getRight());
        return Math.max(lht,rht) + 1;
    }

    @Override
    public Node getRoot() {
        return this.root;
    }

    @Override
    public String insert(String value) {
        insert_r(value, this.root);
        return value;
    }
    private Node insert_r(String value, Node c) {
        if(root == null){
            root = new NodeImpl(value);
        }
        if (c == null) {
            c = new NodeImpl(value);
            size++;
            return c;
        } else {
            int comp = value.compareTo(c.getValue());


            if (comp < 0) {
                c.setLeft(insert_r(value, c.getLeft()));
                return c;
            } else if (comp > 0) {
                c.setRight(insert_r(value, c.getRight()));
            } else {
                return c;
            }
        }
        return c;
    }


    // remove implementation given to you, do NOT change
    @Override
    public void remove(String value) {
        remove_r(value,this.root);
        size--;
    }
    private Node remove_r(String k, Node c) {
        if (c==null) return null; // item not found, nothing to do

        // now we know we have a real node to examine
        int cflag = k.compareTo(c.getValue());

        if (cflag<0) { // k is smaller than node
            c.setLeft(remove_r(k,c.getLeft()));
            return c;
        }
        else
        if (cflag>0) { // k is larger than node
            c.setRight(remove_r(k,c.getRight()));
            return c;
        }
        else //cflag==0
        { // found it... now figure out how to rearrange

            // cases
            if (c.getLeft()==null && c.getRight()==null) { c = null; } // leaf
            else if (c.getLeft()==null && c.getRight()!=null) { c = c.getRight(); } // RC only
            else if (c.getLeft()!=null && c.getRight()==null) { c = c.getLeft(); } // LC only
            else { // 2 children
                Node max = maxCell(c.getLeft());
                c.setValue(max.getValue());
                c.setLeft(remove_r(c.getValue(), c.getLeft()));   // recurse
            }
            return c;
        }

    }

    private Node maxCell(Node c) { // this is used in remove too
        if (c.getRight()==null) return c;
        return maxCell(c.getRight());
    }

    @Override
    public boolean isFull() {
        return this.isFull_r(this.root);
    }
    private boolean isFull_r(Node c){
        if(root == null){
            return true;
        }
        if(c.getRight() == null && c.getLeft() == null){
            return true;
        }
        else if(c.getLeft() != null && c.getRight() == null){
            return false;
        }
        else if(c.getLeft() == null && c.getRight() != null){
            return false;
        }
        else{
            return(isFull_r(c.getRight()) && isFull_r(c.getLeft()));
        }
    }

    @Override
    public String findMin() {
        return this.findMin_r(this.root);
    }
    private String findMin_r(Node c){
        if(root == null){
            return null;
        }
        if(c.getLeft()==null){
            return c.getValue();
        }
        else{
            return findMin_r(c.getLeft());
        }
    }

    @Override
    public String findMax() {
        return this.findMax_r(this.root);
    }
    private String findMax_r(Node c){
        if(root == null){
            return null;
        }
        if(c.getRight()==null){
            return c.getValue();
        }
        else{
            return findMax_r(c.getRight());
        }
    }

    @Override
    public boolean contains(String s) {
        return contains_r(s, this.root);
    }
    private boolean contains_r(String s, Node c){
        if(root == null){
            return false;
        }
        if(c == null){
            return false;
        }
        if(c.getValue().compareTo(s) == 0){
            return true;
        }
        else if(c.getValue().compareTo(s) > 0){
            return contains_r(s, c.getLeft());
        }
        else if(c.getValue().compareTo(s) < 0){
            return contains_r(s, c.getRight());
        }
        return false;
    }

    @Override
    public Node get(String s) {
        return get_r(s, this.root);
    }
    private Node get_r(String s, Node c){
        if(root == null){
            return null;
        }
        if(c == null){
            return null;
        }
        if(c.getValue().compareTo(s) == 0){
            return c;
        }
        else if(c.getValue().compareTo(s) > 0){
            return get_r(s, c.getLeft());
        }
        else if(c.getValue().compareTo(s) < 0){
            return get_r(s, c.getRight());
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
}
