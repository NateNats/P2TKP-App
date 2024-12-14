/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IST.resource;

/**
 *
 * @author nicol
 */
public class NilaiRubrik {
    private String nilai;
    private String nama;

    public NilaiRubrik(String nama, String nilai) {
        this.nilai = nilai;
        this.nama = nama;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public String toString() {
        return "Nilai " + nama + ": " + nilai;
    }
    
    
}
