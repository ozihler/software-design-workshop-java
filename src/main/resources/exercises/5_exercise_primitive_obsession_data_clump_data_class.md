# Primitive Obsession, Data Clump, Data Class, Parallel Change

> Exercise branch: **exercise4**
> 
> Solution branch: **exercise5**
>
> Currently, points are represented as primitive integers x and y. This is the so-called “Primitive Obsession” smell. Because x and y are interrelated, it is a special case called “Data Clump”. Because of the data clump, the parameter list of the Circle class and its methods is longer than it could be, meaning that these parameter lists are actually “Long Parameter Lists”, another Code Smell. In this exercise, we systematically replace x and y with a stronger Point value domain object.
> 
> **Exercise**
>* introduce a new Point class in the Circle’s constructor. 
>* You can add this new Point class e.g. using “Introduce Parameter Object”. 
>* Alternatively, create the new Point within the constructor and apply “extract parameter” to inject the point into the circle. 
>* Assign this new “center” Point to a field (e.g. called “center”). 
>* Use parallel change to replace this.x and this.y with this.center.x() and this.center.y(). 
>* Make sure you run tests after each step
