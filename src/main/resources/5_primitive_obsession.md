# Primitive Obsession, Data Clump, Data Class, Parallel Change

> Exercise branch: **exercise4**
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

## Primitive Obsession
### Explanation
- Primitive Obsession refers to overuse of primitive types and existing data structures, instead of employing high-level abstraction classes.
### Example
- Primitive types such as int, String, etc. and collections like List<...>, Set<...> are employed instead of domain-specific objects like a PhoneNumber. 
### Reason
- low type safety
- complex code 
- poor testability 
- lack of domain language in the code.
### Solution
- Encapsulate primitive state within useful domain-specific abstractions and shift associated logic into these classes.
### Origin
- procedural programming instead of OOP or FP
- lack of design knowledge and skills
- absence of a shared language between developers and stakeholders
### Exceptions
- It may be acceptable for data transfer without any logic.

## Data Clump
### Explanation
- Data Clump is a subcategory of Primitive Obsession, occurring when several interrelated primitive data types are combined as fields or parameters in various code locations.
### Example
- A Circle class having separate int fields for centerX and centerY.
### Reason
- D.R.Y. violations likely
- micro duplications due to missing high-level class
- domain language hidden in procedural code
### Solution
- Data clumps should be encapsulated within an own class / type. 
- Then extract and shift the logic operating on the data either into the new class (OOP) or closer to the type as own functions (FP).
### Origin
- Originates from procedural programming
- lack of design knowledge and skills
- absence of shared language with users/domain experts
- extending code without modifying the design
### Exceptions
- Possibly flat db entries.

## Data Class

### Explanation
- A Data Class is merely a data container without any associated logic.
### Reason
- when a Data Class is employed, the logic that operates on the data is often scattered across the application, leading to missing encapsulation and duplicated code.
### Solution
- logic should be extracted from Manager, Controller, Helper, and Service classes, and moved to the data class as methods.
### Origin
- comes from procedural programming
- as intermediary step from procedural code to a richer domain model with behavior on the classes or type.
### Exceptions
Exceptions include:
- Data Transfer Objects (DTOs) at system, layer or component boundaries
- types in functional programming 
- database entities

## Parallel Change
**Steps for transitioning from an old to a new structure:**
1. **Preparation:** Create and test the new structure (such as a class or type) that you plan to introduce.
2. **Initialization:** Create an instance of the new structure alongside the existing one.
3. **Writing to New Structure:** Gradually incorporate write operations to the new structure, concurrent with write operations to the old one.
4. **Reading from New Structure:** Gradually switch read operations from the old structure to the new one. Ensure to run tests after each modification.
5. **Removing Old Write Operations:** Gradually eliminate write operations to the old structure. Remember to run tests after each change.
6. **Removal of Old Structure:** Finally, eliminate the old structure.
