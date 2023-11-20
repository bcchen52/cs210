# Height

## Explanation

- The height of a tree is the maximum number of steps from the root of the tree to any of the leaves of the tree
	- An empty tree has height -1
	- A tree consisting of just the root has height 0
- The `getHeight(Node x)` method returns the height of the subtree rooted at x by recursively calculating the height of x's left and right subtrees
- To get the height of the tree, we get the height of the root of the tree
- Here is the pseudo code for getHeight(Node x)

## Implementation

``` java
if( x == null )
		return -1

leftHeight  = getHeight(x.getLeft())
rightHeight = getHeight(x.getRight())

if( leftHeight > rightHeight )
		return leftHeight + 1

return rightHeight + 1
```
