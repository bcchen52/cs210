# Traversals

## In order tree walk

`inOrderWalk(Node x)`

This function will visit each node in the BST, utilizing an ***in order traversal***.
- Node x specifies which node to view as the root while doing the in order traversal
- Based on the construction of the BST, we will need to visit:
	1. the nodes of our left subtree,
	2. the root of the tree, ie Node x,
	3. the nodes of our right subtree last.

## Pre order tree walk

`preOrderWalk(Node x)`

This function will visit each node in the BST, utilizing a ***pre order traversal***.
- Node x specifies which node to view as the root while doing the pre order traversal.
- **Note:** Pre order traversals could be used to ***create a copy*** of our BST.
- Based on the construction of the BST, we will need to visit:
	1. the root of the tree, ie Node x,
	2. the nodes of our left subtree,
	3. the nodes of our right subtree

## Post order tree walk

`postOrderWalk(Node x)`

This function will visit each node in the BST, utilizing a ***post order traversal***.
- Node x specifies which node to view as the root while doing the post order traversal.
- **Note:** Post order traversal could be used to **delete** our BST.
- Based on the construction of the BST, we will need to visit:
	1. the nodes of our left subtree,
	2. the nodes our our right subtree,
	3. the root of the tree, ie Node x.

## Implementation

The three tree walk methods are recursive and very simple to implement, to walk the entire tree, use the tree root as the parameter

**inOrderWalk(Node x)**
``` java
if(x != null)
    inOrderWalk(x.getLeft())
    Visit Node `x` // for us, this will equate to `System.out.println(x)`
    inOrderWalk(x.getRight())
```
**preOrderWalk(Node x)**
``` java
if(x != null)
  	Visit Node `x` // for us, this will equate to `System.out.println(x)`
  	preOrderWalk(x.getLeft())
  	preOrderWalk(x.getRight())
```
**postOrderWalk(Node x)**
``` java
if(x != null)`
    postOrderWalk(x.getLeft())
    postOrderWalk(x.getRight())
    Visit Node `x` // for us, this will equate to `System.out.println(x)`
```

## Alternate Implementation
- These three functions are second versions of the tree walks that fill in an `ArrayList<String>` of the String representation of the Node in the walk order instead of printing the String representation to the screen
- Since the tree walks are recursive, we don't see a reasonable way to have them return the appropriate information as a return value
- So, we will pass them an initially empty `ArrayList<String>`, and instead of doing `System.out.println()` for the current Node, we will do `ArrayList.add()` for the current Node
- The initial call to the tree walks will pass the starting Node, the root for a full tree walk, and an initialized `ArrayList<String>`
- The second three tree walk methods pseudo is below

``` java
inOrderWalk(Node x, ArrayList<String> nodeList)
    if( x != null )
        inOrderWalk(x.getLeft(), nodeList)
        Visit Node x // for us, this will equate to nodeList.add(x.toString())
        inOrderWalk(x.getRight(), nodeList)

preOrderWalk(Node x, ArrayList<String> nodeList)
    if( x != null )
        Visit Node x // for us, this will equate to nodeList.add(x.toString())
        preOrderWalk(x.getLeft(), nodeList)
        preOrderWalk(x.getRight(), nodeList)

postOrderWalk(Node x, ArrayList<String> nodeList)
    if( x != null )
        postOrderWalk(x.getLeft(), nodeList)
        postOrderWalk(x.getRight(), nodeList)
        Visit Node x // for us, this will equate to nodeList.add(x.toString())    
```
