# Complicated Conditional Expression

## Exercise 
> Exercise branch: **exercise3**
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

# Complicated Boolean Expression

## Explanation
* Complicated boolean expressions involve the combination of various logical operations into a single expression. 
* This makes it difficult to read and understand, especially when negations are nested or logical values are encoded into method or variable names.

## Example

Consider these complex boolean expressions in Java:

```java
if (x == y && k == z || xIsNotLessThan3 != false && k != z) {
    // ...
}

if (element instanceof Rect || element instanceof Curve && !(element instanceof Line)) {
// ...
}
```
## Reason
* The sequence in which logical operators are evaluated is not known by everyone. 
* Expressions involving negations or double negations can be hard to comprehend. 
* This could potentially lead to bugs, especially in corner cases.

## Solutions
* Introduce explaining parentheses to clarify the sequence of operations.
* Extract parts of the expressions that belong together into separate variables.
* Extract parts of the expressions that belong together into methods (similar to Deeply-Nested Control Flow). 
* Eliminate negations and double negations. Instead, use "positively" formulated names with semantic meaning. For example, instead of !node.hasNoChildren(), you could use !node.isLeaf() or node.hasChildren(). 
* Try to simplify the expression by applying De Morgan's laws:
```java
!a && !b = !(a || b)
!a || !b = !(a && b)
```

## Cause
* Such smells typically occur when expressions grow with new requirements.

## Exceptions
* Complex boolean expressions might be necessary in technical domains where complex equations are developed by domain experts, and the equations in the code must match those in the domain. 
* It might be justifiable when the business insists on using a predefined equation. However, such cases should be challenged if possible.
