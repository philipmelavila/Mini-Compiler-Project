# Mini Expression Compiler Project
Author: Philip Melavila

This project takes an expression from input. Then it will print out a tree showing the order of operations and evaluates the expression.

## Project Summary / Setup Instructions

Main.java: Main Function that takes expression and runs through the Lexer, Parser, Evaluator, and Tree Printer
Lexer.java: Takes Input and Creates Tokens
Parser.java: Creates nodes based on the tokens and creates the heirarchy
Evaluator.java: Takes the nodes and evaluates the whole expression
TreePrinter.java: Creates a tree, indented based on depth, and prints it out

## How to Run, Example Inputs

Once you run the main.java file, you can input any expression you want through terminal
Some example inputs:

Valid Input: (3 + 4) * 6 / 3
```
Enter an expression: (3 + 4) * 6 / 3
Input: (3 + 4) * 6 / 3
Tokens: [(, 3, +, 4, ), *, 6, /, 3, ]

Parse Tree:
/
    *
        +
            3.0
            4.0
        6.0
    3.0

Evaluation Result: 14.0
```

Valid Input With Negative Numbers: 3 + -4
```
Enter an expression: 3 + -4 
Input: 3 + -4
Tokens: [3, +, -, 4, ]

Parse Tree:
+
    3.0
    -
        4.0

Evaluation Result: -1.0
```

Invalid Input: 3 ++
```
Enter an expression: 3 ++
Input: 3 ++
Tokens: [3, +, +, ]
Error: Unexpected token: +
```

