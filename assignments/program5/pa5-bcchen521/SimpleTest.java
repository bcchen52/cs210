public class SimpleTest {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insertNode(new Node(5));
        bst.insertNode(new Node(3));
        bst.insertNode(new Node(8));
        bst.insertNode(new Node(1));
        bst.insertNode(new Node(6));
        bst.insertNode(new Node(4));
        bst.insertNode(new Node(9));
        bst.print();
    }
}
