public class BinarySearchTreeTester {
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        System.out.println("Successfully created bst");

        Node n1 = new Node(5);
        Node n2 = new Node(3);
        Node n3 = new Node(8);
        Node n4 = new Node(2);
        Node n5 = new Node(4);
        Node n6 = new Node(12);
        Node n7 = new Node(10);

        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n2.setParent(n1);
        n3.setParent(n1);
        n3.setRight(n6);
        n6.setLeft(n7);
        n6.setParent(n3);
        n7.setParent(n6);

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n6);
    }
}
