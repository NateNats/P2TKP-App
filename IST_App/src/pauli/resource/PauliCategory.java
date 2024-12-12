package pauli.resource;

public enum PauliCategory {
    HA_VS_RATA_RATA("Ha vs Rata-rata (Tingkat Percaya Diri & Inisiatif)", 1),
    JUMLAH("Jumlah (Kemampuan Kerja & Motivasi Kerja)", 2),
    POSISI_KOLOM("Posisi Kolom (Kemampuan Adaptasi)", 3),
    KESALAHAN("Kesalahan (Ketekunan)", 4),
    PEMBENARAN("Pembenaran (Konsentrasi)", 5),
    PENYIMPANGAN("Penyimpangan (Manajemen Emosi)", 6),
    TINGGI("Tinggi (Motivasi Berprestasi & Kemauan Mengembangkan Diri)", 7),
    KETEKUNAN_KONSENTRASI("Ketekunan & Konsentrasi (Ketelitian)", 8);

    private final String label;
    private final int index;

    PauliCategory(String label, int index) {
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