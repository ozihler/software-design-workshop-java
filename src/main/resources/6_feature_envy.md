# Feature Envy
> Exercise branch: **exercise5**
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

### Explanation
- Defined as a situation where one class appears to be "envious" of the features of another, often signified by a method in one class sequentially invoking several methods of another class.

### Example
```java
public class UserProfileController { 
    @PostMapping
    public ResponseEntity post(@RequestBody UserProfile userProfile) { 
        if (!isComplete(userProfile)) {
            return ResponseEntity.badRequest().build(); 
        }
    }

    private boolean isComplete(UserProfile userProfile) { 
        //Feature Envy
        return userProfile != null &&
               userProfile.getUserName() != null &&
               userProfile.getFullName() != null &&
               userProfile.getScreenName() != null &&
               userProfile.getEmailAddress() != null;
    } 
}

public class UserProfile {
    public boolean isComplete() {
        return getUserName() != null &&
               getFullName() != null &&
               getScreenName() != null &&
               getEmailAddress() != null;
    } 
}

// Refactored code
public class UserProfileController { 
    @PostMapping
    public ResponseEntity post(@RequestBody UserProfile userProfile) { 
        if (userProfile == null || !userProfile.isComplete()) {
            return ResponseEntity.badRequest().build(); 
        }
    }
}

public class UserProfile {
	public boolean isComplete() {
		return getUserName() != null && 
                getFullName() != null &&
                getScreenName() != null && 
                getEmailAddress() != null;
	}
}
```

### Issues
- Creates high coupling and low cohesion between two abstractions.
- Often a sign that certain abstractions are missing, especially if the accessed methods return primitive data types.

### Solutions
- General rule of thumb: when a sequence of at least 3 calls is made to another class.
- However, even 1 call may already be too much. It depends on the semantics of the code.

### Origin
- This smell usually surfaces from procedural as opposed to object-oriented programming, and when the logic is not moved in proximity to the related state/data.

### Exceptions
- in functional programming, functions need to access the data from types. These functions should therefore be closely related to the data they access, similarly to how methods in classes operate on the class's data.
- tests, being inherently procedural, should thoroughly inspect the class under test. Therefore, multiple calls to public methods of the class being tested within the tests are acceptable.

### Separation of Concerns

- The principle of Separation of Concerns (SoC) seeks to decouple layers and systems, delineating precisely how different concerns can interact.
- At times, what seems like Feature Envy might actually be an exemplification of SoC, especially when keeping a decoupled and maintainable system architecture is a priority.
- A typical example is layering or clean architecture, where presentation logic may access data multiple times from lower layers like the domain to format some presentation, yet the presentation logic should not be moved to the lower domain layer as it is very specific to the presentation layer.

## Refactoring technique: extract, wrap, move
Basic idea: bring data and functionality on that data closer together
1. Extract some logic as method or function
2. Wrap data passed to that method in new class or type
3. Move extracted method/function either into newly created class (OOP) or a file close to that type (FP)

1 and 2 may be exchanged. If there exists already a suitable class or type, 2 may be omitted.
