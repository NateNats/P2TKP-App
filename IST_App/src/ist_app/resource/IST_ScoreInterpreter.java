/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ist_app.resource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author nicol
 */
public class IST_ScoreInterpreter {

    private final List<Range> ranges;
    private String filename;
    private LinkedList<String> link;
    private double[] upperVal;
    private double[] lowerVal;
    private String[] kategori;

    public IST_ScoreInterpreter(String filename, double[] upperVal, double[] lowerVal, String[] kategori) {
        this.ranges = new ArrayList<>();
        this.link = new LinkedList<>();
        this.filename = filename;
        this.upperVal = upperVal;
        this.lowerVal = lowerVal;
        this.kategori = kategori;
        
        this.initializeDefaultInterpretations();
    }

    private void AddRange(double lowerBound, double upperBound, String deskripsi, String kategori) {
        ranges.add(new Range(lowerBound, upperBound, deskripsi, kategori));
    }

    public Result interpret(double score) {
        for (Range range : ranges) {
            if (range.isInRange(score)) {
                return new Result(score, range.deskripsi, range.kategori);
            }
        }

        throw new IllegalArgumentException("nilai tidak ada pada score.");
    }

    public static class Range {

        private final double lowerBound;
        private final double upperBound;
        private final String kategori;
        private final String deskripsi;

        public Range(double lowerBound, double upperBound, String deskripsi, String kategori) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
            this.kategori = kategori;
            this.deskripsi = deskripsi;
        }

        public boolean isInRange(double value) {
            return value >= this.lowerBound && value <= this.upperBound;
        }

        @Override
        public String toString() {
            return "Range{" + "lowerBound=" + lowerBound + ", upperBound=" + upperBound + ", kategori=" + kategori + ", deskripsi=" + deskripsi + '}';
        }

    }

    public static class Result {
        private double nilai;
        private String deskripsi;
        private String kategori;

        public Result(double nilai, String deskripsi, String kategori) {
            this.nilai = nilai;
            this.deskripsi = deskripsi;
            this.kategori = kategori;
        }

        @Override
        public String toString() {
            return "Result{" + "nilai=" + nilai + ", deskripsi=" + deskripsi + ", kategori=" + kategori + '}';
        }
        
        
    }

    void loadRubrikFile(String filename, LinkedList<String> ll) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String docs;
            StringBuilder fullcontent = new StringBuilder();

            while ((docs = br.readLine()) != null) {
                String teks = br.toString();
                String[] oneLine = docs.split(";");

                for (int i = 0; i < oneLine.length; i++) {
                    ll.add(oneLine[i]);
                }
            }

        } catch (Exception e) {
            System.out.println("error");
        }
    }

    private void initializeDefaultInterpretations() {
        loadRubrikFile(this.filename, this.link);
        
        for (int i = 0; i < this.link.size(); i++) {
            try {
                this.AddRange(this.lowerVal[i], this.upperVal[i], this.link.get(i), this.kategori[i]);
                System.out.println("batas bawah: " + this.lowerVal[i] + ", batas atas: " + this.upperVal[i] + ", deskripsi: " + this.link.get(i) + " Kategori: " + this.kategori[i]);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

//    public static void main(String[] args) {
//        // Contoh nilai untuk rentang
//        double[] lowerVal = {0.0, 84.0, 90.0, 99.0, 110.0, 120.0, 130.0};
//        double[] upperVal = {83.0, 89.0, 98.0, 109.0, 119.0, 129.0, Double.MAX_VALUE};
//        String[] kategori = {"KS", "K", "C-", "C", "C+", "B", "BS"};
//
//        // Inisialisasi interpreter
//        IST_ScoreInterpreter interpreter = new IST_ScoreInterpreter(
//        "./src/ist_app/resource/rubrik/kemampuan mengambil keputusan.txt", upperVal, lowerVal, kategori
//        );
//        interpreter.initializeDefaultInterpretations();
//        double scoreIQ = 95.0; // Contoh skor
//        Result result = interpreter.interpret(scoreIQ);
//        System.out.println(result);
//    }
}
