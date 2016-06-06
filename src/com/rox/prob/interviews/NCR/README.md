#NCR

It comes with unit tests to test.  Main class is [ExpressionParser](https://github.com/rossdrew/programmingproblems/blob/master/src/com/rox/prob/interviews/NCR/ExpressionParser.java) with it's test at [ExpressionParserTest](https://github.com/rossdrew/programmingproblems/blob/master/test/com.rox/prob/interviews/NCR/ExpressionParserTest.java)

## Description

Write a text-based console application to perform simple natural language calculations.

For example, if the user enters the text ‘```two plus four```’ the program would output the value ‘```6```’.

#### Supported Input Values

 - The supported input values are the whole numbers between zero and nine inclusive.
 - Input values must be expressed as text, e.g. ‘```one```’, ‘```five```’, etc
 - Input values are not case-sensitive. Both ‘```two and```’ ‘```TWO```’ are equally valid.

#### Supported Arithmetic Operators

 - The supported arithmetic operators and the permitted natural language aliases for these commands are detailed in the table below.
 - Aliases are not case-sensitive. Both ‘```add```’ and ‘```ADD```’ are equally valid.

| Operator            | Permitted Aliases     |
| ------------------- |:---------------------:|
| Add (```+```)       | ```add```, ```plus```             |
| Subtract (```-```)  | ```subtract```, ```minus```, ```less``` |
| Multiply (```*```)  | ```multiply-by```, ```times```    |
| Divide (```/```)    | ```divide-by```, ```over```       |


#### Operation Chaining
 
 - Any number of operations may be chained together
   - For example, these calculations are all valid
      - ‘```one plus two```’
      - ‘```seven times eight minus nine```’
      - ‘```four times five subtract six over one plus nine```’
 
#### Operator Precedence
 
 - When two or more operations are chained together, any multiply or divide operation must take precedence over any add or subtract operation, similar to how a real calculator works.
    - For example, the calculation ‘```one plus two times three```’ will give the result ‘```7```’ not ‘```9```’.
 - The examples section contains further examples to illustrates operator precedence.
 - Note that there is no requirement to support the use of brackets to alter operator precedence.
 
