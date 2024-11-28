/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ist_app.resource;

/**
 *
 * @author EddHard
 */
public class KomponenPenilaian {

    private String variabel;
    private String nilai;
    private String kategori;
    private String deskripsi;

    public KomponenPenilaian() {
    }

    public KomponenPenilaian(String variabel, String nilai, String kategori, String deskripsi) {
        this.variabel = variabel;
        this.nilai = nilai;
        this.kategori = kategori;
        this.deskripsi = deskripsi;
    }

    public String getVariabel() {
        return variabel;
    }

    public void setVariabel(String variabel) {
        this.variabel = variabel;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String toString() {
        return this.getVariabel() + " " + this.getNilai() + " " + this.getKategori() + " " + this.getDeskripsi();
    }
}
