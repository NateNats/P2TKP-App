package pauli.resource;

public class PauliResource {
    public static int tingkatPercayaDiri;
    public static int kemampuanKerja;
    public static int kemampuanAdaptasi;
    public static int ketekunan;
    public static int konsentrasi;
    public static int manajemenEmosi;
    public static int motivasiBerprestasi;

    static {
        resetValues();
    }

    public static void resetValues() {
        kemampuanKerja = 0;
        kemampuanAdaptasi = 0;
        ketekunan = 0;
        konsentrasi = 0;
        manajemenEmosi = 0;
        motivasiBerprestasi = 0;
    }

        
}
