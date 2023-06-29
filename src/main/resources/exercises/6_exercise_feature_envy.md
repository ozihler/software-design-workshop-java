# Feature Envy
> Exercise branch: **exercise5**
> 
> Solution branch: **exercise6**
> 
> **Exercise part 1**
> 
> * in Circle of exercise5, find the feature envy code smell!
> 
>
> **Exercise part 2**
> 
> Circle::format() formats both point (x, y) as well as radius as a string. However, in this case, point could actually provide an own format() method to separate that concern from circle.
>
>* Extract a variable for the part of the string that formats a point “(x, y)” within Circle::format()
>* Wrap the right side of the variable in an own “format()” method 
>* Move this method to the Point class with an automatic refactoring
>* Clean up and inline any unused parameters and variables
