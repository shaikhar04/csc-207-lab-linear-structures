linear-structures
=================

Partial implementations of some linear structures, intended for use
in Grinnell's CSC 207 (and, perhaps, elsewhere).

### @author Samuel A. Rebelsky
### @author Arsal Shaikh
### @author Pranav Bhandari

Exercise 5:
The implementations of put, get, peek, isEmpty were as we expected. However,
the implementation of isFull was not as we expected where size = capacity, as this
exercise refers to a LinkedList version of the stack where isFull returns false by default.

Exercise 6:
The implementations of peek, isEmpty, isFull were as we expected. Implementing get 
was also achieved in one go. However, we first struggled with handling the case where the 
queue is empty, and how to update the front and back values in this case. Upon trial and error, 
we were able to discern that in the case that the queue is empty, both the front and the back values 
of this object are made equal to a new node with the given value. If the queue is not empty, 
we simply make a new node with the given value, have the previous this.back point to this new node, 
and assign the new node to this.back. 
