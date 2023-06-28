# Bad names

## Exercise
> Package: **exercise1**
>
> Rename anything you think needs a better name, e.g. variables, methods, classes, and files. 
> 
> Use the automated “rename” refactoring (see cheat sheet).


### Explanation
* Incorrect, incomplete, or misguiding names of variables, methods, classes, constants, or packages.

### Example
* XYHelper, XYManager, XYData, XYTools, XYUtils.
* Generic terms like length, time. 
* Constant names like ZERO, ONE.
* Abbreviations like DTE, PSE, AE, DBC.
* Overly verbose identifiers like CustomerServiceManagementRepository, DatabaseConnectionManager.

### Reasons
* A name that doesn't accurately convey its intent or meaning can lead to misunderstandings. 
* This forces other developers to refer to documentation or, in a worst-case scenario, the entire codebase to comprehend the program. 
* If the name implies a function different from its actual purpose, it can inadvertently introduce bugs.
* The units of a numerical value may be ambiguous (for instance, 'time' could refer to seconds, milliseconds, or nanoseconds). 

### Solution
* Apply [Rename](https://refactoring.guru/rename-method) Refactoring technique.
* Break up classes, methods, or packages
* Introduce a new variable when an existing one is being reused
* Organize classes into appropriate packages or namespaces.
* Above all, avoid justifying poor code through documentation - rename it instead.

### Cause
* This issue often stems from neglecting principles like the Single Responsibility Principle (SRP) and the Separation of Concerns (SoC).
* Persistently adding new functionality to existing code.
* Designing in a non-object-oriented manner (where data and the methods that operate on that data are bundled in a class).

### Exceptions
* Never - always strive for clear, unambiguous naming conventions.

### Additional Resources
* [Naming as a process](https://www.digdeeproots.com/articles/naming-process)
