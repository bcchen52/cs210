public class Node implements Node_I
{
    private final int key;
    private Node parent;
    private Node left;
    private Node right;
    private int count;

    public Node(int key)
    {
        this.key = key;
        parent = null;
        left = null;
        right = null;
        count = 0;
    }

    public int getKey()
    {
        return key;
    }

    public Node getParent()
    {
        return parent;
    }

    public Node getLeft()
    {
        return left;
    }

    public Node getRight()
    {
        return right;
    }
    
    public int getCount()
    {
        return count;
    }

    public void changeCount(int c)
    {
        count = c;
    }

    public void setLeft(Node n)
    {
        left = n;
    }

    public void setRight(Node n)
    {
        right = n;
    }

    public void setParent(Node n)
    {
        parent = n;
    }

    /**
     * Returns a string representation of the current Node's state, of the form "(x,y,z,w,c)", where:
     * 
     *  - x is the current Node's key value.
     *  - y is the parent Node's key value.
     *  - z is the left child Node's key value.
     *  - w is the right child Node's key value.
     *  - c is the count of the Node's held key value.
     * 
     * If any of the Nodes are null, then its key value should be reprented via an empty String
     * 
     * Example: "(10,,3,14,2)" 
     * - represents Node with key value 10
     * - whose parent Node is null
     * - whose left child Node has key value 3
     * - whose right child Node has key value 14
     * - whose count is 2, indicating 10 occurs twice 
     *
     * @return String representation of the current Node
     */
    public String toString()
    {
        String str = "(" + key + ",";

        if (parent != null)
        {
            str += parent.getKey();
        } 
        str += ",";
        if (left != null)
        {
            str += left.getKey();
        } 
        str += ",";
        if (right != null)
        {
            str += right.getKey();
        } 
        str += "," + count + ")";

        return str;
    }

    public boolean equals(Node n)
    {
        return this.key == n.key;
    }
}