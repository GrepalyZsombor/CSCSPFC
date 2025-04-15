public class Dataset {

    // Year	Maximum	Upper quartile	Average	Lower quartile	Minimum the rows
    private int[][] data;

    public Dataset(int[][] data) {
        this.data = data;
    }


    public static double[] score(double[] data, boolean type){
        double[] score = new double[data.length];
        if (type) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] < 100) {
                    score[i] = 10.0;
                } else if (data[i] < 200) {
                    score[i] = 5.0;
                } else {
                    score[i] = 0.0;
                }
            }
        } else {
            for (int i = 0; i < data.length; i++) {
                if (data[i] < 3) {
                    score[i] = 10.0;
                } else if (data[i] < 50) {
                    score[i] = 5.0;
                } else if (data[i] < 100) {
                    score[i] = 10.0;
                }
            }
        }
        return score;
    }



    public int[][] getData() {
        return data;
    }
    public void setData(int[][] data) {
        this.data = data;
    }



}
