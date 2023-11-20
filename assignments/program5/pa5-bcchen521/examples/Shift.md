# Replacing one node with another node

`shiftNode(Node u, Node v)`

This function replaces Node u with Node v. 
- This is a helper function used by the `deleteNode()` function.

## Explanation

- The `shiftNode` function is used to replace one node with another node
  - It is only used by the `deleteNode` function
  - `shiftNode` does not restructure the whole tree, it just groups some of the steps in a separate method
- The function takes two parameters, `Node u` and `Node v`
- The function replaces Node `u` with Node `v`
- There are two cases
  - `u` is the root
    - Make `v` the root
    - Set `v`'s parent to be `u`'s parent
  - `u` is not the root
    - If `u` is the left child, make `v` the left child of `u`'s parent
    - If `u` is the right child, make `v` the right child of `u`'s parent
    - Set `v`'s parent to be `u`'s parent
- Pseudo code for `shiftNode(Node u, Node v)`

## Implementation

``` java
if(u.getParent() == null) // ...................u is the root
      setRoot(v) // ............................make v the root
else
      if(u == u.getParent().getLeft())
              u.getParent().setLeft(v) // ......u is left child
      else
              u.getParent().setRight(v) // .....u is right child

if(v != null)
      v.setParent(u.getParent()) // ............set v's parent
```
