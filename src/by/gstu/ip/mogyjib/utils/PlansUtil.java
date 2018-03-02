package by.gstu.ip.mogyjib.utils;


public class PlansUtil {
    public static final double[][] X ={
            {-1,-1,-1} ,
            {1,-1,-1} ,
            {-1,1,-1} ,
            {1,1,-1} ,
            {-1,-1,1} ,
            {1,-1,1} ,
            {-1,1,1} ,
            {1,1,1}
    };

    public static final double[][] eX = expandX();

    private static double[][] expandX(){
        double[][] newX = new double[X.length][7];

        for(int i=0; i<newX.length; i++){
            newX[i][3] = X[i][0]* X[i][1];
            newX[i][4] = X[i][0]* X[i][2];
            newX[i][5] = X[i][1]* X[i][2];
            newX[i][6] = X[i][0]* X[i][1]* X[i][2];
        }
        for(int i=0; i<newX.length; i++){
            for(int j=0; j<3; j++)
                newX[i][j] = X[i][j];
        }
        return newX;
    }

    public static double[] getAverageVector(double[][] matrix){
        double[] vector = new double[matrix.length];

        for(int i=0; i<matrix.length; i++){
            double sum = 0;
            for(double number : matrix[i])
                sum+=number;
            vector[i] = sum/(matrix[i].length);
        }
        return vector;
    }

    public static double[] countBcoeff(double[] y,double[][]x, int n){
        double[] b = new double[n];

        for(int i=0;i<b.length; i++){
            b[i] = 0;
        }

        for(int j=0;j<b.length;j++){
            for(int i=0; i<y.length; i++){
                if(j==0)
                    b[j] += y[i];
                else
                    b[j] += x[i][j-1]*y[i];
            }
        }

        for(int i=0;i<b.length; i++){
            b[i] /= y.length;
        }

        return b;
    }

    public static double[] countYmodel(double[] b,double[][] x){
        double[] y = new double[X.length];
        for(int i = 0; i< X.length; i++){
            y[i] =0;
            for(int j=0; j<b.length;j++){
                if(j==0)
                    y[i] += b[j];
                else
                    y[i] += x[i][j-1]*b[j];
            }
        }
        return y;
    }



    public static double countW(double[]y, double[]q){
        double w =0;
        double tmp = Double.MIN_VALUE;
        for(int i=0; i<y.length;i++){
            tmp = Math.abs(y[i]-q[i]);
            if(tmp > w)
                w = tmp;
        }

        return w;
    }

    public static double getMax(double[] arr){
        double max = Double.MIN_VALUE;
        for(double n : arr){
            if(n>max)
                max = n;
        }
        return max;
    }
}
