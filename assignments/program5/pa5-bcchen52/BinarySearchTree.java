public class BinarySearchTree implements BinarySearchTree_I
{
    private Node root;

    public BinarySearchTree()
    {
        root = null;
    }

    public Node getRoot()
    {
        return root;
    }

    public void setRoot(Node root)
    {
        this.root = root;
    }

    public void insertNode(Node z)
    {
        Node existingNode = getNode(root, z.getKey());
        if( existingNode == null)
        {
            if( root == null )
            {
                root = z;
            } else {
                Node current = root;
                Node next = null;
                boolean found = false;

                while( !found )
                {
                    if( z.getKey() < current.getKey() )
                    {
                        next = current.getLeft();
                    } else {
                        next = current.getRight();
                    }

                    if( next != null)
                    {
                        current = next;
                    } else {
                        found = true; 
                    }
                }

                if( z.getKey() < current.getKey() )
                {
                    current.setLeft(z);
                } else {
                    current.setRight(z);
                }
            

            }


        } else {
            existingNode.changeCount(existingNode.getCount() + 1) ;
        }

    }

    public void preOrderWalk(Node x)
    {

    }

    public void preOrderWalk(Node x, java.util.ArrayList<String> list)
    {

    }

    public void inOrderWalk(Node x)
    {

    }

    public void inOrderWalk(Node x, java.util.ArrayList<String> list)
    {

    }

    public void postOrderWalk(Node x)
    {

    }

    public void postOrderWalk(Node x, java.util.ArrayList<String> list)
    {

    }

    public Node getMax(Node x)
    {
        return null;
    }

    public Node getMin(Node x)
    {
        return null;
    }
   
    public Node getSuccessor(Node x)
    {
        return null;
    }
   
    public Node getPredecessor(Node x)
    {
        return null;
    }

    public Node getNode(Node x, int key)
    {
        if( x == null){
            return null;
        }

        if( x.getKey() == key)
        {
            return x;
        }

        if( key < x.getKey() ){
            getNode(x.getLeft(), key);
        }

        if( key > x.getKey() ){
            getNode(x.getRight(), key);
        }
        return null;
    }

    public int getHeight(Node x)
    {
        return 0;
    }

    public void shiftNode(Node u, Node v)
    {

    }

    public void deleteNode(Node z)
    {
 
    }

    public void print() {
        System.out.println("Printing Tree");
        printHelper(root, 0);
    }

    private void printHelper(Node current, int spaces) {
        //base case - we've reached beyond a leaf node
        if (current == null) {
            return;
        }

        //this explicitly makes each depth of the tree 8 spaces away from its parent
        //changing this value changes the width of the printed tree
        final int COUNT = 8;
        spaces += COUNT;

        //we are doing a right-to-left inOrder traversal for better readability
        printHelper(current.getRight(), spaces);

        //print current Node
        System.out.println(); //puts Node on a new line
        String whitespace = ""; //will build up the depth of whitespace for each node
        for (int i = COUNT; i < spaces; i++) {
            whitespace += " ";
        }
        System.out.println(whitespace + current.getKey()); //prints data for current Node
        
        //Now go to the left child
        printHelper(current.getLeft(), spaces);
    }
}