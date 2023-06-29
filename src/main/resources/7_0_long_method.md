# Long Method / Function
> Exercise branch: **exercise6**
>
> Solution branch: **exercise7**
>
> **Exercise part 1**
> 
> The “contains” method still uses x and y coordinates instead of the Point class! However, if we introduce a parameter for it in “contains”, we end up with two unrelated concerns in the loop of countContainedPoints:
> * Concern 1: validation of point input values and creation of points
> * Concern 2: counting the number of points contained within the circle.
> 
> Thus, 
> * Wrap the parameters x and y of the “contains” method in the existing Point record. 
> * Split the loop into two separate loops:
>  * Loop 1 creates a list of Points with a Point for each xCoords[i] and yCoords[i]
>  * Loop 2 iterates over this list of points and counts points contained within the circle.
> 
> 
>  *Side note*: you can also try out “Duplicate & Reduce” to split the loop in two.
> 
> **Exercise part 2**
> 
> Creation of points (including validation of inputs) should happen outside of “countContainedPoints” as it is not in the responsibility of that method.
> * Wrap the loop for creating points into a static method “createPoints(xCoords, yCoords)” 
> * Make this method public and move it to a new class PointsFactory 
> * Wrap the loop for counting points into a public method “countContainedPoints(List<Point>)” 
> * Remove PointsFactory.createPoints(xCoords, yCoords) from this method (either use inline refactoring or extract parameter)

### Explanation
- a Long Method / Function is difficult to scan, read, understand or name accurately.

### Example
- too limited space :)

### Reason
- The method might be so lengthy that it requires scrolling or places a cognitive load on the reader who has to remember various parts of the method to fully comprehend it.
- The method often violates the Single Responsibility Principle (SRP) and the "as it tries to perform several unrelated but entangled tasks at once. This typically leads to non-descriptive or general names that do not encompass all the responsibilities of the method.

### Solutions
- Create a consolidated method with a single level of abstraction by segregating several sub-methods with meaningful names that reflect their functions.
- Comments in the code often suggest potential segments for segregation.
- The process of extracting parts of the method can provide benefits such as facilitating the transfer of parts to other/new classes, enabling unit testing, and promoting reuse.

### Origins
- Over time, existing methods were continuously extended to accommodate new requirements without adding new abstractions.
- The absence of proper understanding of object-oriented design often leads to procedural programming on basic data structures.

### Exceptions
- Long Methods / Functions containing simple, direct logic without any branching (for example, mappings or protocol filling) are generally acceptable.
