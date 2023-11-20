# Minimum and Maximum Node

## Maximum

`getMax(Node x)`

This function will find and return some descendant node of Node x, which holds the largest key value of all Node x's descendants.
- Based on the construction of the BST, this can be done by ***continually taking the right child*** of the current node, until the right child is null.
- The leaf node found will hold the largest key value of all the descendants in this ***right subtree***.

**Note:** Calling `getMax()` on the BST's root node will find the node with the largets key value in the entire BST.

### Implementation

- The getMax function simply continues taking the right child of the current node until the right child is null
- Here is pseudo code for `public Node getMax(Node x)`
   - Since it takes a Node as a parameter, it can be used to get the maximum Node for any subtree
   - To get the maximum for the entire tree, use the root for x

```java
while(x.getRight() != null) // if x has no right child, done
    x = x.getRight() // .......update x to the right child of x
return x
```

## Minimum

`getMin(Node x)`

This function will find and return some descendant node of Node x, which holds the ***smallest key value*** of all Node x's descendants.
- Based on the construction of the BST, this can be done by ***continually taking the left child*** of the current node until the left child is null
- The leaf node found will hold the smallest key value of all the descendants in this ***left subtree***.

**Note:** Calling `getMin()` on the BST's root node will find the node with the smallest key value in the entire BST.

### Implementation

- Just change `getRight` to `getLeft` in the loop in the pseudocode for `getMax(Node x)`.
