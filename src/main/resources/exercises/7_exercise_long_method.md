# Long Method / Function

> **Exercise part 1**
> 
> Exercise branch: **exercise6**
>
> Solution branches: **exercise7part1**
> 
> The ```contains``` method still uses primitive x and y int coordinates instead of the stronger ```Point``` class! 
>However, if we introduce a parameter for it in ```contains```, we end up with two unrelated concerns in the loop of ```countContainedPoints```:
> * Concern 1: validation of point input values and creation of points
> * Concern 2: counting the number of points contained within the circle.
> 
> Thus, 
> * Wrap the parameters x and y of the ```contains``` method in the existing ```Point``` class. 
> * Split the loop into two separate loops:
>  * Loop 1 creates a list of ```Point```s with a Point for each ```xCoords[i]``` and ```yCoords[i]```
>  * Loop 2 iterates over this list of points and counts points contained within the circle.
> 
> 
>  *Side note*: you can also try out “Duplicate & Reduce” to split the loop in two.



> **Exercise part 2**
> 
> Exercise branch: **exercise7part1**
>
> Solution branches: **exercise7**
> 
> Creation of points (including validation of inputs) should happen outside of “countContainedPoints” as it is not in the responsibility of that method.
> 
> *Side note*: use the "Parallel Change" refactoring for the following
> * Create a new ```Points``` class with a constructor ```Points(List<Point> points)``` and one public method ```public List<Point> asList()``` that returns the list passed to the constructor.
> * Instantiate ```Points points2 = new Points(points)``` right after creation of the ```points``` list.
> * Replace the ```points``` variable within the second loop with ```points2.asList()```. Make sure to run the tests. 
> * wrap validation logic for coordinates, creation of the points array, and creation of the Points object into a static method ```Points from(xCoordinates, yCoordinates)```.
> * Move this method to the ```Points``` class. 
> 
> 
> *Separating creation of points from counting contained points*
> * Wrap the second loop for counting points into a public method ```int countContainedPoints(Points points)``` 
> * Remove ```Points.from(xCoordinates, yCoordinates)``` from this method (either use inline refactoring or extract parameter), 
> such that only the test calls ```Points.from(xCoordinates, yCoordinates)``` and passes the ```Points``` to ```countContainingPoints``` in the test.
> * Simplify any code, make it more readable using the Composed Method refactoring where useful.
