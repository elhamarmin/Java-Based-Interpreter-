
# Project - Java-Based Interpreter for Custom Language `X`

This project is a Java-based interpreter for a custom programming language named `X`. The interpreter reads and executes programs written in this language according to defined rules and syntax.

## **Features**
- **Variable Declaration and Initialization**: Supports integer (`int`) and floating-point (`float`) variables with optional initial values.
- **Arithmetic Operations**: Implements addition, subtraction, multiplication, and division operations on both variables and constants.
- **Print Functionality**: Outputs variable values and expressions to the console.
- **Control Structures**: Supports a simplified `for` loop for repetitive execution of instructions.
- **Graphical User Interface (GUI)**: Contains a JavaFX-based UI for user interaction, allowing code input and execution.

## **Getting Started**

### **Prerequisites**
- Java SE Development Kit 8 or higher
- JavaFX (included in JDK 11+ or requires separate installation for JDK 8)

### **Installation**
1. Clone the repository:
   ```sh
   git clone https://github.com/elhamarmin/Java-Based-Interpreter-.git
   cd Java-Based-Interpreter-
   ```
2. Ensure you have JavaFX set up in your IDE or environment if using JDK 8.

## **Project Structure**
- **`src/com/example/xlang/`**: Main source directory for the interpreter code.
  - **`data/`**:
    - `Value.java`: Represents a value (either integer or float) with methods for type checking and conversion.
    - `Variable.java`: Extends `Value` to add a name attribute, representing named variables.
  - **`operator/`**:
    - `Operator.java`: Interface for defining basic arithmetic operations.
    - `SumOperator.java`: Implementation of addition.
    - `SubtractOperator.java`: Implementation of subtraction.
    - `MultiplyOperator.java`: Implementation of multiplication.
    - `DivisionOperator.java`: Implementation of division.
  - **`CommandInterpreter.java`**: Handles variable declaration, updates, and the execution of print and control statements.
  - **`Executor.java`**: Coordinates the reading and parsing of code files and manages the execution of commands.
  - **`Memory.java`**: Manages the storage and retrieval of declared variables.
  - **`PatternMatcher.java`**: Contains regular expressions for parsing and validating different language constructs.
  - **`Processor.java`**: Routes operations to the appropriate `Operator` class based on the provided operator character.
  - **`fx.java`**: A JavaFX-based class providing the GUI for user interaction and code execution.

- **`examples/`**: Contains example programs written in language `X` to demonstrate how the interpreter works.
  - `example1.txt`: Example program showing variable declaration, assignment, and printing.
  - `example2.txt`: Example demonstrating the use of loops and arithmetic operations.

## **Code Descriptions**
- **`CommandInterpreter.java`**:
  - Handles variable declaration and updates.
  - Contains methods for printing variable values and executing control flow (`for` loops).
  - Uses `PatternMatcher` to validate input syntax.
- **`Executor.java`**:
  - Reads and processes input files.
  - Differentiates between variable declaration and command execution phases.
- **`PatternMatcher.java`**:
  - Provides regular expressions for matching identifiers, numbers, assignments, and other components.
  - Validates syntax to prevent runtime errors.
- **`Memory.java`**:
  - Stores variables using a `HashMap` for quick retrieval and updates.
- **`fx.java`**:
  - Implements the JavaFX user interface for inputting and executing code.

## **Running the Interpreter**
1. Compile the Java files and ensure all dependencies are set up (e.g., JavaFX libraries).
2. Run the main class `fx.java` to start the GUI.
3. Type your `X` language code in the provided text area and press the execute button.

### **Example Code**
Example of a simple program in the custom language `X`:
```java
int x = 10
int y = 30
int sum
%%
sum = x + y
print sum
```
This code declares two integers `x` and `y`, adds their values, and prints the result.

## **Running from Command Line**
### **Compile the code:**
```sh
javac -d out src/*.java src/data/*.java src/operator/*.java
```

### **Run the program:**
```sh
java -cp out src.fx
```

## **Running Tests**
Unit tests can be added in a dedicated `test/` directory using JUnit.

## **Contact**
For any inquiries, contact [elhmarmin@gmail.com].
