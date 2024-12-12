/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package msdt.resource;

/**
 *
 * @author nicol
 */
public class AspectScore {
    private String aspek;
    private String uraian;
    private String skor;

    public AspectScore(String aspek, String uraian, String skor) {
        this.aspek = aspek;
        this.uraian = uraian;
        this.skor = skor;
    }

    public String getAspek() {
        return aspek;
    }

    public void setAspek(String aspek) {
        this.aspek = aspek;
    }

    public String getUraian() {
        return uraian;
    }

    public void setUraian(String uraian) {
        this.uraian = uraian;
    }

    public String getSkor() {
        return skor;
    }

    public void setSkor(String skor) {
        this.skor = skor;
    }

    @Override
    public String toString() {
        return "AspectScore{" + "aspek=" + aspek + ", uraian=" + uraian + ", skor=" + skor + '}';
    }
}
