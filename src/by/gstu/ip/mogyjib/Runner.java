package by.gstu.ip.mogyjib;


import by.gstu.ip.mogyjib.utils.FileHandler;
import by.gstu.ip.mogyjib.utils.PlansUtil;
import by.gstu.ip.mogyjib.utils.StringUtil;

import java.io.IOException;
import java.util.Arrays;

public class Runner {

    public static void main(String[] args){
        String fileName = "files/input.txt";
        String text ="";
        try {
            text = FileHandler.read(fileName);
            text = StringUtil.changeDots(text);
        } catch (IOException e) {
            System.out.println("Can't open file!");
        }

        double[][] matrix = StringUtil.parseMatrix(text);

        double[] y = PlansUtil.getAverageVector(matrix);
        double[] b = PlansUtil.countBcoeff(y,PlansUtil.X,4);

        double[] q = PlansUtil.countYmodel(b,PlansUtil.X);

        double W = PlansUtil.countW(y,q);
        double w = W*100/PlansUtil.getMax(y);



        System.out.println("B = "+Arrays.toString(b));
        System.out.println("Y = "+Arrays.toString(y));
        System.out.println("Q = "+Arrays.toString(q));
        System.out.println("W = "+W+"  w = "+w);


        double[] exB = PlansUtil.countBcoeff(y,PlansUtil.eX,8);

        double[] exQ = PlansUtil.countYmodel(exB,PlansUtil.eX);

        double exW = PlansUtil.countW(y,exQ);
        double exw = exW*100/PlansUtil.getMax(y);

        System.out.println("\n\n"+"B = "+Arrays.toString(exB));
        System.out.println("Y = "+Arrays.toString(y));
        System.out.println("Q = "+Arrays.toString(exQ));
        System.out.println("W = "+exW+"  w = "+exw);
    }

}
