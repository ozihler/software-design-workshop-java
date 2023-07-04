# Long Method / Function
> Exercise branch: **exercise6**
>
> Solution branches: **exercise7part1, exercise7**
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
> * wrap the "points" variable within the second loop into an "asList(points)" method
> * introduce a new parameter object "Points" to wrap the "asList(points)" method to "asList(new Points(points))"
> * move asList(new Points(points)) to the Points class as a non-static method
> * extract a variable for new Points(points)
> * move it close to the creation of the points list
> * wrap validation logic for coordinates, creation of the points array, and creation of a new Points object into an own static method "from(xCoordinates, yCoordinates)".
> * Move this method to points.
> * Wrap the loop for counting points into a public method “countContainedPoints(List<Point>)” 
> * Remove Points.from(xCoordinates, yCoordinates) from this method (either use inline refactoring or extract parameter)
