package com.rox.prob.adventofcode.y2017;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * --- Day 8: I Heard You Like Registers ---
 *
 * You receive a signal directly from the CPU. Because of your recent assistance with jump instructions, it would like
 * you to compute the result of a series of unusual register instructions.
 *
 * Each instruction consists of several parts: the register to modify, whether to increase or decrease that register's
 * value, the amount by which to increase or decrease it, and a condition. If the condition fails, skip the instruction
 * without modifying the register. The registers all start at 0. The instructions look like this:
 *
 * b inc 5 if a > 1
 * a inc 1 if b < 5
 * c dec -10 if a >= 1
 * c inc -20 if c == 10
 *  These instructions would be processed as follows:
 *
 * Because a starts at 0, it is not greater than 1, and so b is not modified.
 * a is increased by 1 (to 1) because b is less than 5 (it is 0).
 * c is decreased by -10 (to 10) because a is now greater than or equal to 1 (it is 1).
 * c is increased by -20 (to -10) because c is equal to 10.
 * After this process, the largest value in any register is 1.
 *
 * You might also encounter <= (less than or equal to) or != (not equal to). However, the CPU doesn't have the bandwidth
 * to tell you what all the registers are named, and leaves that to you to determine.
 *
 *  What is the largest value in any register after completing the instructions in your puzzle input?
 */
public class Day8 {
    enum Operation {
        INCREMENT("inc", (a,b) -> a+b),
        DECREMENT("dec", (a,b) -> a-b);

        final String representation;
        private final MutationOperation operation;

        public Integer resultOf(Integer a, Integer b){
            return operation.perform(a,b);
        }

        Operation(String representation, MutationOperation operation){
            this.representation = representation;
            this.operation = operation;
        }
    }

    enum Condition {
        GREATER_THAN(">", (a,b)->a>b),
        LESS_THAN("<", (a,b)->a<b),
        EQUAL_TO("==", (a,b)->a==b),
        LESS_THAN_OR_EQUAL_TO("<=", (a,b)->a<=b),
        GREATER_THAN_OR_EQUAL_TO(">=", (a,b)->a>=b),
        NOT_EQUAL_TO("!=", (a,b)->a!=b);

        public final String representation;
        private final Comparison comparison;

        public boolean trueFor(Integer a, Integer b){
            return comparison.perform(a,b);
        }

        Condition(String representation, Comparison comparison){
            this.representation = representation;
            this.comparison = comparison;
        }
    }

    @FunctionalInterface
    interface Comparison {
        boolean perform(Integer a, Integer b);
    }

    @FunctionalInterface
    interface MutationOperation {
        Integer perform(Integer a, Integer b);
    }

    class Command {
        final String register;
        final Operation operation;
        final Integer modifyValue;
        final String testRegister;
        final Condition condition;
        final Integer testValue;

        Command(String commandString){
            final String[] commandElements = commandString.split("\\s");
            register = commandElements[0];
            operation = Arrays.stream(Operation.values()).filter(o -> o.representation.equalsIgnoreCase(commandElements[1].trim()))
                                                         .findFirst()
                                                         .orElseThrow(() -> new RuntimeException("Unknown operation " + commandElements[1]));
            modifyValue = Integer.parseInt(commandElements[2]);
            testRegister = commandElements[4];
            condition = Arrays.stream(Condition.values()).filter(c -> c.representation.equalsIgnoreCase(commandElements[5].trim()))
                                                         .findFirst()
                                                         .orElseThrow(() -> new RuntimeException("Unknown comparison " + commandElements[5]));
            testValue = Integer.parseInt(commandElements[6]);
        }

        @Override
        public String toString() {
            return operation + " '" + register + "' by " + modifyValue + " if '" + testRegister + "' " + condition + " " + testValue;
        }
    }

    public int part1Solution(final String program){
        final String commands[] = program.split("\\R");

        final Map<String, Integer> registers = new HashMap<>();

        for (int commandIndex = 0; commandIndex < commands.length; commandIndex++){
            Command command = new Command(commands[commandIndex]);

            int registerValue = registers.containsKey(command.register) ? registers.get(command.register) : 0;
            int testRegisterValue = registers.containsKey(command.testRegister) ? registers.get(command.testRegister) : 0;

            if (command.condition.trueFor(testRegisterValue, command.testValue)){
                registerValue = command.operation.resultOf(registerValue, command.modifyValue);
                System.out.println("(" + commands[commandIndex] + ") " + format(commands[commandIndex]) + command.register + " -> " + registerValue + "\t[" + command.testRegister + "=" + testRegisterValue + "] ... " + command);
            }else{
                System.out.println("\t(" + commands[commandIndex] + ") No operation. [" + command.testRegister + "=" + testRegisterValue + "]");
            }

            registers.put(command.register, registerValue);
        }

        int max = Integer.MIN_VALUE;
        for (String registerName : registers.keySet()) {
            //System.out.println(registerName + " = " + registers.get(registerName));
            max = Math.max(registers.get(registerName), max);
        }

        return max;
    }

    String format(String output){
        if (output.length() < 17)
            return "\t\t\t\t";
        else if (output.length() < 21)
            return "\t\t\t";
        else if (output.length() < 25)
            return "\t\t";
        else
            return "\t";
    }
}
