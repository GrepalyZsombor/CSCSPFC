import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import scala.collection.mutable.HashMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.sh0nk.matplotlib4j.PythonConfig;
import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;
import scala.collection.mutable.Map;

public class Main {


    public static void main(String[] args) throws PythonExecutionException, IOException {
        /*
        List<Double> x = NumpyUtils.linspace(-Math.PI, Math.PI, 256);
        List<Double> C = x.stream().map(xi -> Math.cos(xi)).collect(Collectors.toList());
        List<Double> S = x.stream().map(xi -> Math.sin(xi)).collect(Collectors.toList());

        Plot plt = Plot.create(PythonConfig.pythonBinPathConfig("C:///////Users///////grepaly.zsombor///////AppData///////Local///////Programs///////Python///////Python313///////python.exe"));
        plt.plot().add(x, C).color("blue").linewidth(2.5).linestyle("-");
        plt.plot().add(x, S).color("red").linewidth(2.5).linestyle("-");
        plt.xlim(Collections.min(x) * 1.1, Collections.max(x) * 1.1);
        plt.ylim(Collections.min(C) * 1.1, Collections.max(C) * 1.1);
        plt.show();
        */

        double[] yeararray = {
                1979, 1980, 1981, 1982, 1983, 1984, 1985, 1986, 1987, 1988,
                1989, 1990, 1991, 1992, 1993, 1994, 1995, 1996, 1997, 1998,
                1999, 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008,
                2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018,
                2019, 2020, 2021
        };

        double[][] japan_data = {
            {1979, 3300.00, 1100.00, 350, 93, 18},
            {1980, 1700.00, 790.00, 290.00, 140, 33},
            {1981, 1700.00, 605.00, 330, 160, 38.6},
            {1982, 1400.00, 790.00, 330, 110, 23},
            {1983, 2200.00, 790.00, 330.00, 140, 43},
            {1984, 2100.00, 790.00, 240, 79, 20},
            {1985, 2340.00, 920.00, 340, 79, 9},
            {1986, 3300.00, 900.00, 300.00, 110, 8.44},
            {1987, 2360.00, 790.00, 330, 100, 21.2},
            {1988, 1100.00, 490.00, 220.00, 94.5, 33},
            {1989, 1000.00, 332.50, 170, 49, 19.1},
            {1990, 1700.00, 350.00, 135, 46, 16.08},
            {1991, 1230.00, 490.00, 220, 57.25, 14},
            {1992, 1100.00, 345, 130, 21.75, 2},
            {1993, 852.00, 275, 62, 5, 2},
            {1994, 490.00, 141.25, 50.50, 2, 1.7},
            {1995, 240.00, 122.50, 49, 2, 1},
            {1996, 298.00, 155.00, 24.50, 2, 0},
            {1997, 460, 140, 23, 2, 1},
            {1998, 773, 187.5, 40, 2, 1},
            {1999, 412, 100, 14, 2, 0},
            {2000, 763, 42.25, 8.5, 2, 0},
            {2001, 286, 93, 8, 2, 0},
            {2002, 240, 54.5, 4.5, 2, 0},
            {2003, 522, 115, 2, 2, 0},
            {2004, 52, 5.4, 2, 2, 2},
            {2005, 2.7, 2, 2, 2, 2},
            {2006, 2, 2, 2, 2, 2},
            {2007, 2, 2, 2, 2, 2},
            {2008, 2, 2, 2, 2, 2},
            {2009, 74.4, 32, 2, 2, 2},
            {2010, 118, 41.25, 2, 2, 2},
            {2011, 59.5, 17.5, 2, 2, 2},
            {2012, 230, 16.75, 2, 2, 2},
            {2013, 64.5, 15.75, 2, 2, 2},
            {2014, 47, 14.75, 2, 2, 2},
            {2015, 88.5, 31.5, 2, 2, 2},
            {2016, 235, 21.25, 2, 2, 2},
            {2017, 195, 53.5, 2, 2, 2},
            {2018, 100, 41.75, 2, 2, 2},
            {2019, 120, 19.25, 2, 2, 2},
            {2020, 110, 33, 2, 2, 2},
            {2021, 125, 42.75, 2, 2, 2}
        };

        List<Double> year = new ArrayList<>();
        List<Double> average = new ArrayList<>();
        List<Double> max = new ArrayList<>();
        List<Double> min = new ArrayList<>();
        List<Double> limit = new ArrayList<>();

        for (double[] row : japan_data) {
            year.add(row[0]); // year
            max.add(row[1]); // max
            average.add(row[3]); // average
            min.add(row[5]); // min
            limit.add(200.0);

        }

        double[] averagearrayJapanFecal = new double[43];
        double[] maxarrayJapanFecal = new double[43];
        double[] minarrayJapanFecal = new double[43];

        for (int i = 0; i < 43; i++) {
            averagearrayJapanFecal[i] = japan_data[i][2];
            maxarrayJapanFecal[i] = japan_data[i][1];
            minarrayJapanFecal[i] = japan_data[i][4];
        }

        Graph.graph3y(yeararray, Dataset.score(averagearrayJapanFecal, true), Dataset.score(maxarrayJapanFecal, true), Dataset.score(minarrayJapanFecal, true), "Score FECAL COLIFORM JAPAN", "FECAL COLIFORM", "Year");


        Plot plt1 = Plot.create(PythonConfig.pythonBinPathConfig("C:///////Users///////grepaly.zsombor///////AppData///////Local///////Programs///////Python///////Python313///////python.exe"));
        plt1.plot().add(year, average).label("average").color("black");
        plt1.plot().add(year, max).label("maximum").color("blue");
        plt1.plot().add(year, min).label("minimum").color("red");
        plt1.plot().add(year, limit).label("recommended limit for recreational use").color("orange");
        plt1.xlim(Collections.min(year), Collections.max(year));
        plt1.ylim(Collections.min(max), Collections.max(max));
        plt1.xlabel("Year");
        plt1.ylabel("Fecal coliform 1/100ml");
        plt1.title("Yearly Fecal coliform rivers Japan");
        plt1.legend();
        plt1.show();

// Biochemical Oxygen Demand

        double[][] Japan_oxygen = {
                {1979, 2.70, 1.95, 1.30, 0.70, 0.40},
                {1980, 2.48, 1.90, 1.10, 0.70, 0.50},
                {1981, 2.70, 1.90, 1.20, 0.80, 0.68},
                {1982, 2.93, 2.00, 1.30, 0.70, 0.50},
                {1983, 2.70, 1.85, 1.10, 0.80, 0.50},
                {1984, 3.00, 1.90, 1.10, 0.70, 0.50},
                {1985, 2.65, 1.90, 1.10, 0.70, 0.40},
                {1986, 2.63, 1.70, 1.10, 0.70, 0.50},
                {1987, 2.80, 1.70, 1.20, 0.60, 0.40},
                {1988, 2.60, 1.65, 1.00, 0.70, 0.50},
                {1989, 2.22, 1.30, 1.00, 0.60, 0.40},
                {1990, 2.37, 1.63, 1.00, 0.50, 0.30},
                {1991, 2.20, 1.65, 1.10, 0.50, 0.40},
                {1992, 2.10, 2.00, 1.00, 0.70, 0.50},
                {1993, 2.00, 2.00, 1.00, 0.60, 0.50},
                {1994, 2.32, 2.00, 1.00, 0.80, 0.50},
                {1995, 2.10, 2.00, 1.00, 0.70, 0.50},
                {1996, 2.00, 1.40, 1.00, 0.70, 0.50},
                {1997, 2.00, 1.50, 0.90, 0.60, 0.50},
                {1998, 2.00, 1.22, 0.80, 0.50, 0.50},
                {1999, 2.00, 1.20, 0.90, 0.50, 0.50},
                {2000, 2.00, 1.10, 0.80, 0.50, 0.50},
                {2001, 2.00, 1.20, 0.90, 0.50, 0.50},
                {2002, 2.00, 1.37, 1.00, 0.60, 0.50},
                {2003, 1.90, 1.20, 0.80, 0.50, 0.50},
                {2004, 2.00, 1.40, 0.80, 0.50, 0.50},
                {2005, 1.70, 1.00, 0.80, 0.50, 0.50},
                {2006, 1.71, 1.10, 0.80, 0.50, 0.50},
                {2007, 1.60, 1.20, 0.80, 0.50, 0.50},
                {2008, 1.40, 1.00, 0.70, 0.50, 0.50},
                {2009, 1.20, 0.90, 0.60, 0.50, 0.50},
                {2010, 1.34, 0.90, 0.60, 0.50, 0.50},
                {2011, 1.20, 1.00, 0.60, 0.50, 0.50},
                {2012, 1.30, 1.00, 0.70, 0.50, 0.50},
                {2013, 1.30, 0.90, 0.70, 0.50, 0.50},
                {2014, 1.40, 0.90, 0.60, 0.50, 0.50},
                {2015, 1.31, 0.80, 0.60, 0.50, 0.49},
                {2016, 1.40, 0.90, 0.60, 0.50, 0.47},
                {2017, 1.13, 0.80, 0.60, 0.50, 0.40},
                {2018, 1.30, 1.10, 0.70, 0.50, 0.50},
                {2019, 1.20, 0.90, 0.60, 0.50, 0.40},
                {2020, 1.00, 0.70, 0.50, 0.50, 0.50},
                {2021, 1.20, 0.80, 0.60, 0.50, 0.50}
        };


        List<Double> year2 = new ArrayList<>();
        List<Double> average2 = new ArrayList<>();
        List<Double> max2 = new ArrayList<>();
        List<Double> min2 = new ArrayList<>();
        List<Double> clean = new ArrayList<>();
        List<Double> severep = new ArrayList<>();
        List<Double> moderatep = new ArrayList<>();

        for (double[] row : Japan_oxygen) {
            year2.add(row[0]); // year
            average2.add(row[3]); // average
            max2.add(row[1]); // max
            min2.add(row[5]); // min
            clean.add(3.0);
            severep.add(100.0);
            moderatep.add(50.0);
        }


        double[] averagearray = {
                1.95, 1.90, 1.90, 2.00, 1.85, 1.90, 1.90, 1.70, 1.70, 1.65,
                1.30, 1.63, 1.65, 2.00, 2.00, 2.00, 2.00, 1.40, 1.50, 1.22,
                1.20, 1.10, 1.20, 1.37, 1.20, 1.40, 1.00, 1.10, 1.20, 1.00,
                0.90, 0.90, 1.00, 1.00, 0.90, 0.90, 0.80, 0.90, 0.80, 1.10,
                0.90, 0.70, 0.80
        };

        double[] maxarray = {
                2.70, 2.48, 2.70, 2.93, 2.70, 3.00, 2.65, 2.63, 2.80, 2.60,
                2.22, 2.37, 2.20, 2.10, 2.00, 2.32, 2.10, 2.00, 2.00, 2.00,
                2.00, 2.00, 2.00, 2.00, 1.90, 2.00, 1.70, 1.71, 1.60, 1.40,
                1.20, 1.34, 1.20, 1.30, 1.30, 1.40, 1.31, 1.40, 1.13, 1.30,
                1.20, 1.00, 1.20
        };

        double[] minarray = {
                0.70, 0.70, 0.80, 0.70, 0.80, 0.70, 0.70, 0.70, 0.60, 0.70,
                0.60, 0.50, 0.50, 0.70, 0.60, 0.80, 0.70, 0.70, 0.60, 0.50,
                0.50, 0.50, 0.50, 0.60, 0.50, 0.50, 0.50, 0.50, 0.50, 0.50,
                0.50, 0.50, 0.50, 0.50, 0.50, 0.50, 0.50, 0.50, 0.50, 0.50,
                0.50, 0.50, 0.50
        };




        Graph.graph3y(yeararray, Dataset.score(averagearray, false), Dataset.score(maxarray, false), Dataset.score(minarray, false), "Score BOD JAPAN", "BOD", "Year");



        Plot plt3 = Plot.create(PythonConfig.pythonBinPathConfig("C:///////Users///////grepaly.zsombor///////AppData///////Local///////Programs///////Python///////Python313///////python.exe"));
        plt3.plot().add(year2, average2).label("average").color("black");
        plt3.plot().add(year2, max2).label("maximum").color("blue");
        plt3.plot().add(year2, min2).label("minimum").color("red");
        plt3.plot().add(year2, clean).label("upper boundary of cleanliness").color("orange");
        plt3.plot().add(year2, severep).label("lower boundary of moderately severe pollution").color("brown");
        plt3.xlim(Collections.min(year2), Collections.max(year2));
        plt3.ylim(Collections.min(min2), Collections.max(clean) + 0.1);
        plt3.xlabel("Year");
        plt3.ylabel("Biochemical Oxygen Demand");
        plt3.title("Yearly Biochemical Oxygen Demand rivers Japan");
        plt3.legend();
        plt3.show();






        double[][] india_data = {
                {1979, 3650999.70, 5775.00, 80, 13.75, 0},
                {1980, 1750.00, 175, 13, 4, 0},
                {1981, 427, 225, 35, 0.75, 0},
                {1982, 1530.00, 447.5, 21.7, 2, 0},
                {1983, 1800.00, 900, 110, 7, 4},
                {1984, 1800.00, 1800.00, 130, 4, 0.85},
                {1985, 21300.00, 920, 150, 11.25, 3},
                {1986, 2820.00, 1600.00, 70, 7, 2},
                {1987, 24000.00, 1850.00, 350, 14.75, 4},
                {1988, 4120.00, 1600.00, 430, 49, 7},
                {1989, 16000.00, 2400.00, 300, 49, 0},
                {1990, 16000.00, 2400.00, 140, 0, 0},
                {1991, 10400.00, 1450.00, 290, 13, 0},
                {1992, 9000.00, 1700.00, 400, 35, 0},
                {1993, 7750.00, 1600.00, 300, 30, 0},
                {1994, 7900.00, 2500.00, 550, 100, 100},
                {1995, 14200.00, 2120.00, 170, 9, 3},
                {1996, 2000.00, 900, 100, 7, 0},
                {1997, 3860.00, 1100.00, 220, 4.5, 0},
                {1998, 8000.00, 1600.00, 430, 7, 2},
                {1999, 6500.00, 2725.00, 300, 7, 4},
                {2000, 3020.00, 1000.00, 170, 9, 4},
                {2001, 2724.00, 790, 70, 8, 2},
                {2002, 3040.00, 800, 90, 9, 4.8},
                {2003, 2200.00, 760, 90, 11, 4},
                {2004, 1650.00, 500, 100, 9, 3},
                {2005, 4000.00, 500, 70, 10.25, 2},
                {2006, 4580.00, 755, 100, 7, 0},
                {2007, 2200.00, 600, 130, 14, 2},
                {2008, 1700.00, 430, 170, 9, 0.52},
                {2009, 1920.00, 300, 190, 60, 38},
                {2010, 1950.00, 150, 60, 18.5, 4},
                {2011, 3400.00, 1000.00, 400, 100, 12.8},
                {2012, 1800.00, 1275.00, 800, 200, 7},
                {2013, 23000.00, 2487.50, 750, 230, 7},
                {2014, 51000.00, 2950.00, 1200.00, 210, 18},
                {2015, 140000.00, 17500.00, 2100.00, 445, 200},
                {2016, 330000.00, 26000.00, 10100.00, 1375.00, 101},
                {2017, 414000.00, 23000.00, 2200.00, 135, 20},
                {2018, 6100.00, 1350.00, 140, 14, 2},
                {2019, 17000.00, 2600.00, 170, 14, 2},
                {2020, 34800.00, 2800.00, 150, 20.75, 3},
                {2021, 71300.00, 6000.00, 700, 73.75, 16.1}
        };

        List<Double> year1 = new ArrayList<>();
        List<Double> average1 = new ArrayList<>();
        List<Double> max1 = new ArrayList<>();
        List<Double> min1 = new ArrayList<>();

        for (double[] row : india_data) {
            year1.add(row[0]); // year
            max1.add(row[1]); // max
            average1.add(row[3]); // average
            min1.add(row[5]); // min

        }

        int rows = india_data.length;
        double[] averagearrayIndiaFecal = new double[rows];
        double[] maxarrayIndiaFecal = new double[rows];
        double[] minarrayIndiaFecal = new double[rows];

        for (int i = 0; i < rows; i++) {
            averagearrayIndiaFecal[i] = india_data[i][2];
            maxarrayIndiaFecal[i] = india_data[i][1];
            minarrayIndiaFecal[i] = india_data[i][4];
        }

        Graph.graph3y(yeararray, Dataset.score(averagearrayIndiaFecal, true), Dataset.score(maxarrayIndiaFecal, true), Dataset.score(minarrayIndiaFecal, true), "Score FECAL COLIFORM INDIA", "FECAL COLIFORM", "Year");



        Plot plt2 = Plot.create(PythonConfig.pythonBinPathConfig("C:///////Users///////grepaly.zsombor///////AppData///////Local///////Programs///////Python///////Python313///////python.exe"));
        plt2.plot().add(year1, average1).label("average").color("black");
        plt2.plot().add(year1, max1).label("maximum").color("blue");
        plt2.plot().add(year1, min1).label("minimum").color("red");
        plt2.plot().add(year1, limit).label("recommended limit for recreational use").color("orange");
        plt2.xlim(Collections.min(year1), Collections.max(year1));
        plt2.ylim(Collections.min(min1), Collections.max(max1));
        plt2.xlabel("Year");
        plt2.ylabel("Fecal coliform 1/100ml");
        plt2.title("Yearly Fecal coliform India rivers");
        plt2.legend();
        plt2.show();

        double[][] india_oxygen = {
                {1979, 18.75, 5.33, 2.15, 1.10, 0.40},
                {1980, 6.40, 3.90, 2.00, 1.00, 0.96},
                {1981, 4.93, 3.20, 2.00, 1.02, 1.00},
                {1982, 11.04, 4.17, 2.30, 1.00, 1.00},
                {1983, 7.94, 4.82, 2.50, 1.00, 0.98},
                {1984, 6.06, 3.60, 2.00, 1.00, 1.00},
                {1985, 7.58, 4.00, 2.00, 1.10, 0.80},
                {1986, 6.00, 3.00, 2.00, 1.20, 1.00},
                {1987, 4.71, 3.00, 1.60, 1.00, 0.80},
                {1988, 4.60, 2.60, 1.50, 1.00, 0.30},
                {1989, 3.97, 2.63, 1.45, 1.00, 0.43},
                {1990, 4.28, 2.50, 1.50, 1.00, 0.60},
                {1991, 5.14, 2.80, 1.80, 1.00, 0.46},
                {1992, 5.00, 2.50, 1.50, 1.00, 0.40},
                {1993, 6.20, 3.00, 1.30, 1.00, 0.50},
                {1994, 3.02, 2.00, 1.32, 0.89, 0.50},
                {1995, 5.70, 2.88, 1.30, 0.60, 0.40},
                {1996, 5.00, 2.70, 1.50, 0.60, 0.40},
                {1997, 5.49, 2.80, 1.48, 0.70, 0.40},
                {1998, 5.00, 3.00, 1.50, 1.00, 0},
                {1999, 6.00, 2.90, 1.20, 0.60, 0.20},
                {2000, 5.00, 2.17, 1.00, 0.40, 0.20},
                {2001, 5.00, 3.80, 1.30, 0.60, 0.40},
                {2002, 5.50, 3.02, 1.20, 0.60, 0.31},
                {2003, 5.00, 2.40, 1.40, 1.00, 0.58},
                {2004, 5.00, 2.50, 1.50, 1.00, 0.53},
                {2005, 8.00, 3.60, 1.80, 1.00, 0.50},
                {2006, 5.00, 2.50, 1.40, 0.90, 0.50},
                {2007, 9.56, 3.54, 1.70, 1.00, 0.50},
                {2008, 16.25, 4.45, 1.85, 1.00, 0.40},
                {2009, 44.20, 22.20, 3.38, 1.34, 0.79},
                {2010, 49.49, 6.09, 1.90, 1.11, 0.50},
                {2011, 27.72, 5.91, 2.23, 1.20, 0.59},
                {2012, 42.48, 11.52, 2.51, 1.13, 0.60},
                {2013, 31.81, 15.30, 2.42, 1.20, 0.79},
                {2014, 34.46, 19.20, 2.80, 1.40, 0.70},
                {2015, 18.99, 4.15, 2.00, 1.28, 0.91},
                {2016, 25.80, 12.90, 2.50, 1.28, 0.87},
                {2017, 24.20, 12.30, 2.65, 1.30, 0.80},
                {2018, 8.00, 3.60, 2.30, 1.60, 1.20},
                {2019, 7.65, 3.02, 2.20, 1.60, 1.20},
                {2020, 4.00, 2.60, 1.80, 1.10, 0.54},
                {2021, 3.80, 2.28, 1.56, 1.10, 0.65}
        };

        List<Double> year3 = new ArrayList<>();
        List<Double> average3 = new ArrayList<>();
        List<Double> max3 = new ArrayList<>();
        List<Double> min3 = new ArrayList<>();

        for (double[] row : india_oxygen) {
            year3.add(row[0]); // year
            average3.add(row[3]); // average
            max3.add(row[1]); // max
            min3.add(row[5]); // min
        }

        double[] averagearrayIndia = new double[rows];
        double[] maxarrayIndia = new double[rows];
        double[] minarrayIndia = new double[rows];

        for (int i = 0; i < rows; i++) {
            averagearrayIndia[i] = india_oxygen[i][2];
            maxarrayIndia[i] = india_oxygen[i][1];
            minarrayIndia[i] = india_oxygen[i][4];
        }

        Graph.graph3y(yeararray, Dataset.score(averagearrayIndia, false), Dataset.score(maxarrayIndia, false), Dataset.score(minarrayIndia, false), "Score BOD INDIA", "BOD", "Year");

        Plot plt4 = Plot.create(PythonConfig.pythonBinPathConfig("C:///////Users///////grepaly.zsombor///////AppData///////Local///////Programs///////Python///////Python313///////python.exe"));
        plt4.plot().add(year3, average3).label("average").color("black");
        plt4.plot().add(year3, max3).label("maximum").color("blue");
        plt4.plot().add(year3, min3).label("minimum").color("red");
        plt4.plot().add(year3, clean).label("upper boundary of cleanliness").color("orange");
        plt4.plot().add(year3, moderatep).label("lower boundary of moderately severe pollution").color("brown");
        plt4.xlim(Collections.min(year3), Collections.max(year3));
        plt4.ylim(Collections.min(min3), Collections.max(moderatep) + 1);
        plt4.xlabel("Year");
        plt4.ylabel("Biochemical Oxygen Demand");
        plt4.title("Yearly Biochemical Oxygen Demand rivers India");
        plt4.legend();
        plt4.show();






        // Dataset India = new Dataset();

        FileInputStream file = new FileInputStream(new File("C:///////Users///////grepaly.zsombor///////Desktop///////New folder (7)///////Indiafecalcoliform.xlsx"));
        // FileInputStream file2 = new FileInputStream(new File("C:///////Users///////grepaly.zsombor///////Desktop///////New folder (7)///////Japanfecalcoliform.xlsx"));
        Workbook workbook = new XSSFWorkbook(file);
        // Workbook workbook2 = new XSSFWorkbook(file2);

        Sheet sheet = workbook.getSheetAt(0);

        Map<Integer, int[]> Indiadata = new HashMap<>();
        int i = 0;
        for (Row row : sheet) {
            // Indiadata.put(i, new ArrayList<String>());
            for (Cell cell : row) {
                //Indiadata.get(i).add(cell.getNumericCellValue() + "");

            }
            i++;
        }

    }
}