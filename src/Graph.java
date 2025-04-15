import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonConfig;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Graph {

    // y2 should be the biggest to ensure it is graphed correctly
    public static void graph3y(double[] tx, double[] ty1, double[] ty2, double[] ty3, String title, String ytitle, String xtitle) throws PythonExecutionException, IOException {

        List<Double> x = new ArrayList<>();
        List<Double> y1 = new ArrayList<>();
        List<Double> y2 = new ArrayList<>();
        List<Double> y3 = new ArrayList<>();

        for (int i = 0; i < tx.length; i++) {
            x.add(tx[i]);
            y1.add(ty1[i]);
            y2.add(ty2[i]);
            y3.add(ty3[i]);
        }

        Plot plt = Plot.create(PythonConfig.pythonBinPathConfig("C:///////Users///////grepaly.zsombor///////AppData///////Local///////Programs///////Python///////Python313///////python.exe"));
        plt.plot().add(x, y1).label("average").color("black");
        plt.plot().add(x, y2).label("maximum").color("blue");
        plt.plot().add(x, y3).label("minimum").color("red");
        plt.xlim(Collections.min(x), Collections.max(x));
        plt.ylim(0, 10.1);
        plt.xlabel(xtitle);
        plt.ylabel(ytitle);
        plt.title(title);
        plt.legend();
        plt.show();
    }



}
