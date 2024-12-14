/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package IST.resource;

/**
 *
 * @author nicol
 */
public enum RubrikCategory {
    TARAF_KECERDASAN("Taraf Kecerdasan", 1),
    BERPIKIR_KOMPREHENSIF("Kemampuan berpikir komprehensif", 2),
    BERPIKIR_FLEKSIBEL("Kemampuan berpikir fleksibel", 3),
    MENGOLAH_ANGKA("Kemampuan berhitung / mengolah angka", 4),
    DAYA_INGAT("Daya ingat / konsentrasi", 5),
    KREATIVITAS("Kreativitas", 6),
    MENILAI("Kemampuan menilai / judgement", 7),
    ANALISIS("Kemampuan analisis", 8),
    MENGAMBIL_KEPUTUSAN("Kemampuan mengambil keputusan", 9),
    BERBAHASA("Kemampuan berbahasa", 10),
    CORAK_BERPIKIR("Cara / corak berpikir", 11),
    JENIS_KECERDASAN("Jenis kecerdasan", 12);
    
    private final String label;
    private final int index;
    
    RubrikCategory(String label, int index) {
        this.label = label;
        this.index = index;
    }
    
    public String getLabel() {
        return label;
    }
    
    public int getIndex() {
        return index;
    }
}
