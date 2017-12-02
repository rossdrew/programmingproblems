package com.rox.prob.adventofcode.y2017;


/**
 * --- Day 2: Corruption Checksum ---
 *
 * As you walk through the door, a glowing humanoid shape yells in your direction. "You there! Your state appears to
 * be idle. Come help us repair the corruption in this spreadsheet - if we take another millisecond, we'll have to
 * display an hourglass cursor!"
 *
 * The spreadsheet consists of rows of apparently-random numbers. To make sure the recovery process is on the right
 * track, they need you to calculate the spreadsheet's checksum. For each row, determine the difference between the
 * largest value and the smallest value; the checksum is the sum of all of these differences.
 *
 * For example, given the following spreadsheet:
 *
 * 5 1 9 5
 * 7 5 3
 * 2 4 6 8
 *
 * The first row's largest and smallest values are 9 and 1, and their difference is 8.
 * The second row's largest and smallest values are 7 and 3, and their difference is 4.
 * The third row's difference is 6.
 * In this example, the spreadsheet's checksum would be 8 + 4 + 6 = 18.
 *
 * What is the checksum for the spreadsheet in your puzzle input?
 */
public class Day2 {
    public static long solution(String spreadsheetDataAsString){
        final String[] rows = spreadsheetDataAsString.split("\\R");

        String[] columnsOfThisRow = rows[0].split("\\s+");
        int[][] spreadsheetData = new int[columnsOfThisRow.length][rows.length];
        for (int row=1; row<rows.length; row++){

            for (int column=0; column<columnsOfThisRow.length; column++){
                //XXX This doesn't make sense
                spreadsheetData[row-1][column] = Integer.parseInt(columnsOfThisRow[column]);
            }

            columnsOfThisRow = rows[row].split("\\s+");
        }

        //Debug output
//        for (int col=0; col<spreadsheetData[0].length; col++) {
//            for (int row = 0; row < rows.length; row++){
//                System.out.print(spreadsheetData[col][row] + " ");
//            }
//            System.out.print("\n");
//        }


        return solution(spreadsheetData);
    }

    public static long solution(int[][] spreadsheetData){
        int sum = 0;

        for (int column = 0; column < spreadsheetData.length; column++){
            int rowMax = spreadsheetData[column][0];
            int rowMin = spreadsheetData[column][0];

            for (int row = 1; row < spreadsheetData[column].length; row++){
                rowMax = Math.max(rowMax, spreadsheetData[column][row]);
                rowMin = Math.min(rowMin, spreadsheetData[column][row]);
            }

            sum += (rowMax - rowMin);
        }
        return sum;
    }
}
