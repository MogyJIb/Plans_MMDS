package by.gstu.ip.mogyjib.utils;


/**
 * Utility which contain some static
 * methods to process string data.
 *
 * @author Evgeniy Shevtsov
 * @version 1.0
 */
public class StringUtil {
    public static String changeDots(String expression){
        return expression.replaceAll(",",".");
    }

    public static double[][] parseMatrix(String expression){
        String[] sentence = expression.split("\n");
        double[][] matrix = new double[sentence.length][];

        for(int i=0; i<matrix.length; i++){
            String[] numbers = sentence[i].split(" |\t");
            matrix[i] = new double[numbers.length];
            for(int j=0; j<matrix[i].length;j++){
                matrix[i][j] = Double.parseDouble(numbers[j]);
            }
        }
        return matrix;

    }
}
