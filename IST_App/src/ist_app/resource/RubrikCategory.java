/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package ist_app.resource;

/**
 *
 * @author nicol
 */
public enum RubrikCategory {
    TARAF_KECERDASAN("Taraf Kecerdasan"),
    BERPIKIR_KOMPREHENSIF("Kemampuan berpikir komprehensif"),
    BERPIKIR_FLEKSIBEL("Kemampuan berpikir fleksibel"),
    MENGOLAH_ANGKA("Kemampuan berhitung / mengolah angka"),
    DAYA_INGAT("Daya ingat / konsentrasi"),
    KREATIVITAS("Kreativitas"),
    MENILAI("Kemampuan menilai / judgement"),
    ANALISIS("Kemampuan analisis"),
    MENGAMBIL_KEPUTUSAN("Kemampuan mengambil keputusan"),
    BERBAHASA("Kemampuan berbahasa"),
    CORAK_BERPIKIR("Cara / corak berpikir"),
    JENIS_KECERDASAN("Jenis kecerdasan");
    
    private final String label;
    
    RubrikCategory(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return label;
    }
}
