------------------------------------------------
Programming Assignment 05 - Due 11/19
------------------------------------------------

## Description

Be sure to finish lab 9 before you start this project, as it will provide some background information and give you the source files necessary to complete the project. This repository is **very** large and contains almost everything you could need to complete this project.
I recommend looking at all of the provided `.md` files in the `examples` directory as you work through the project, as they will guide you along nicely.

## Starting source Files

To start this project, copy your files from lab 9 into this repository, as those will be the files you are working on. The majority (basically all) of this project will be implementing the remaining functions inside `BinarySearchTree.java`. Later this week I will provide you with a suite of programs to test your project on.
We will discuss this in class as well.

### Interfaces
These are the same interfaces we had from lab 9, and they are linked below in case you need them

[Node](examples/Node_Interface.md)

[BinarySearchTree](examples/BinarySearchTree_Interface.md)

## Planning Your Implementation - How I would tackle it

My advice would be to implement the BST in the following order:

1. Before we can do anything meaningful with constructing the BST itself:
    - We need to make sure our building block is solid. 
    - So, I recommend fully implementing all the details of the `Node` class first.
    - Once you have the `Node` class solid, we can start building our BST.
2. The getters and setters involving the root, `getRoot` / `setRoot` should be the easiest to implement.

**The above should have been completed in lab, so this is where the project begins**

3. Next, I recommend implementing the `insertNode` method. 
    - Read [here](examples/Insert.md) for details how to implement `insertNode()`
    - This will allow you to start building up BSTs
    - Once the `insertNode` is building up BSTs, we have a few options from there.
        - Honestly, 4/5/6/7 below can be done in whichever order you prefer in my opinion.
        - Steps 8/9/10 I do think should be done in ***sequential order***, and probably ***saved for last***.
4. The traversal methods, `preOrderWalk`, `inOrderWalk`, `postOrderWalk` should be relatively straightforward to implement next.
   - We will implement at least one of these in class, but you can look at them [here](examples/Traversal.md) as well.
6. The `getNode` method should be somewhat similar to the high level logic involved in our `insertNode` method.
    - You can look at the details [here](examples/Searching.md) for more information.
    - High level, we will need to try to find the `Node` we seek in the left or right subtree, based on the key values.
    - This is similar to how the `insertNode` chooses where a new `Node` will be inserted.
7. The `getMax` and `getMin` methods should be a few lines of code.
    - More information for both of these methods is provided [here](examples/MinMax.md).
    - These will be useful for the `getSuccessor` and `getPredecessor` methods.
    - Definitely implement these before those are started.
8. The `getHeight` method is almost standalone as far as implementation details go.
    - Definitely think you should tackle it after you can build up meaningful examples of BSTs (ie after `insertNode`).
    - You can find help towards your implementation [here](examples/Height.md).
    - You could also circle back around to test the height decreases as Nodes are deleted from the BST
        - Luckily, we can at least start testing `getHeight` before the `deleteNode` method is fully implemented.
9. The `getSuccessor` and `getPredecessor` methods will probably be the next to be done since:
    - This method is difficult, I recommend reading [this](examples/Successor.md) and [this](examples/Predecessor.md)first.
    - we need to leverage the `getMax` and `getMin` methods in some cases
    - these will be needed in some of our deletion logic
    - these also have a few tricky edge cases
10. Once the `getSuccessor` and `getPredecessor` seem good, you probably want to implement `shiftNode` next.
    - Details on implementing `shiftNode()` can be found [here](examples/Shift.md).
    - It is a helper method leveraged by the `deleteNode` function.
    - Want to make sure it is also solid before moving on.
11. We saved the best for last, I highly recommend implementing `deleteNode` after everything else is done.
    - This may be the most tricky method to implement, but there is help [here](examples/Delete.md).
    - It will be relying on various different methods
        - `shiftNode`, `getSuccessor` for instance.
        - some of these methods rely on other methods as well, `getMax` for example.
        - We can't meaningfully delete nodes from a BST that hasn't been built up yet (ie indirectly dependent on `insertNode` being correct.)

**Disclaimer:** This is just my advice, you can feel free to implement the BST in whatever order you see fit.

### Some example trees

These trees all get created and changed in a valid manner, so if your implementation has the same final result as these, then you are most likely correct.

[Example 1](examples/example1.md)

[Example 2](examples/example2.md)

[Example 3](examples/example3.md)

## Testing

When I test your program, I'll be testing all of the BST functions that we covered and are included in the `BinarySearchTreeFunctions` interface.

The testing will be something along the following:

1. Add a collection of keys to an initially empty tree, including duplicate keys (the duplicate keys should cause the corresponding Nodes to have counts greater than one.)
2. Verify that the tree is correct
3. Check the tree height
4. Check the max and min
5. Check the in order walk
6. Check the pre order walk
7. Check the post order walk
8. Check if some keys can be found in the tree
9. Check some predecessors of nodes in the tree
10. Check some successors of nodes in the tree
11. Delete some nodes from the tree
12. Verify the tree is correct
13. Add a collection of keys to the tree
14. Verify the tree is correct
15. Verify the count is correct for all of the nodes in the tree.

When I test your BST, I will be using my own copy of `Node.java`, so make sure that you are using the getters and setters to access the fields. The fields of your `Node` class should all be ***private*** and should not be accessed directly by any code outside of the `Node` class.

If each of your BST functions works properly, then they should work together without any issues. The three functions that require the most testing are `insertNode`, `deleteNode`, and `shiftNode`. (`shiftNode` should get tested via `deleteNode` testing).

**FRIENDLY REMINDER:** This one will probably be hard to implement and get all the details nailed. I recommend starting this particular assignment early. Come to office hours if you get lost in the implementation details.

## Submission

As usual, be sure to push your code up to GitHub, and post your latest commit hash on BrightSpace.

```
git add -A
git commit -m "finished Programming Assignment 5"
git push 
git rev-parse HEAD
```
