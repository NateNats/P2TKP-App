package pauli.resource;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * This class is a resource class for Pauliform. It contains the data and
 * methods needed to handle user interactions the form.
 * 
 * @author <a href="https://github.com/Trustacean">Edward</a>
 */

public class PauliResource {
    public static String nama;
    public static int tingkatPercayaDiri;
    public static int kemampuanKerja;
    public static int kemampuanAdaptasi;
    public static int ketekunan;
    public static int konsentrasi;
    public static int manajemenEmosi;
    public static int motivasiBerprestasi;

    private final static String REPORT_PATH = "./src/pauli/resource/report/PauliReport_v2.jasper";

    // Initialize
    static {
        resetValues();
    }

    public static void resetValues() {
        nama = "";
        tingkatPercayaDiri = 0;
        kemampuanKerja = 0;
        kemampuanAdaptasi = 0;
        ketekunan = 0;
        konsentrasi = 0;
        manajemenEmosi = 0;
        motivasiBerprestasi = 0;
    }

    public static void produceReport() {
        File file = new File(REPORT_PATH);

        if (file.exists()) {
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("name", nama);
            parameters.put("tingkatPercayaDiri", PauliScoreInterpreter.getInterpretation(PauliCategory.HA_VS_RATA_RATA, tingkatPercayaDiri));
            parameters.put("kemampuanKerja", PauliScoreInterpreter.getInterpretation(PauliCategory.JUMLAH, kemampuanKerja));
            parameters.put("kemampuanAdaptasi", PauliScoreInterpreter.getInterpretation(PauliCategory.POSISI_KOLOM, kemampuanAdaptasi));
            parameters.put("ketekunan", PauliScoreInterpreter.getInterpretation(PauliCategory.KESALAHAN, ketekunan));
            parameters.put("konsentrasi", PauliScoreInterpreter.getInterpretation(PauliCategory.PEMBENARAN, konsentrasi));
            parameters.put("manajemenEmosi", PauliScoreInterpreter.getInterpretation(PauliCategory.PENYIMPANGAN, manajemenEmosi));
            parameters.put("motivasiBerprestasi", PauliScoreInterpreter.getInterpretation(PauliCategory.TINGGI, motivasiBerprestasi));
            parameters.put("ketelitian", PauliScoreInterpreter.getKetelitianInterpretation(ketekunan, konsentrasi));

            try {
                JasperPrint jasperPrint = JasperFillManager.fillReport(REPORT_PATH, parameters,
                        new JREmptyDataSource());
                JasperViewer.viewReport(jasperPrint, false);
            } catch (JRException e) {
                System.err.println("Could not produce report.");
            }
        } else {
            System.err.println("Report file not found.");
        }
    }
}
