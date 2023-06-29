# Complicated Conditional Expression

## Exercise 
> Exercise branch: **exercise3**
> 
> Solution branch: **exercise4**
> 
> **Preparation**
> * Extract two variables for the delta between x coordinates and y coordinates. Use the automated refactoring “extract variable” (see cheat sheet). 
> * Extract a new private method to square variables. Use this method everywhere where variables are multiplied with themselves. Use the automated refactoring “extract method”. Don’t forget to rename square’s parameter to e.g. “number”. 
> 
> The method “countContainedPoints” iterates over all passed points and counts the number of points that are contained within the circle. However, there is no method defined for checking if a point is contained within the circle! A “contains(int x, int y)” method seems reasonable to be part of a Circle class. Thus, 
> * within “countContainedPoints(..)”, create a method “contains(int x, int y)” that checks if a point with x and y coordinates is within the Circle or not. 
> * Use automated refactorings “extract variable”, “extract method”, and “inline variable” to achieve this without breaking code.
> * Note: inline is the reverse of “extract variable” or “extract method”. If you inline a variable or method, its content will be duplicated and pasted where the variable or method was. 
> * A method that is composed of other methods is known as a “composed method”. It’s goal is to increase readability, understanding, and align abstraction levels.
