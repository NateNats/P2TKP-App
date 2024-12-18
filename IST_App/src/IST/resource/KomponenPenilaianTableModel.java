/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package IST.resource;

import IST.resource.KomponenPenilaian;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EddHard
 */
public class KomponenPenilaianTableModel extends AbstractTableModel {

    private List<KomponenPenilaian> nilai = new ArrayList<>();

    public KomponenPenilaianTableModel(List<KomponenPenilaian> nilai) {
        this.nilai = nilai;
    }

    @Override
    public int getRowCount() {
        return nilai.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        KomponenPenilaian data = nilai.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return data.getVariabel();
            case 1:
                return data.getNilai();
            case 2:
                return data.getKategori();
            case 3:
                return data.getDeskripsi();
            default:
                return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Variabel";
            case 1:
                return "Nilai";
            case 2:
                return "Kategori";
            case 3:
                return "Deskripsi";
            default:
                return "";
        }
    }
}
