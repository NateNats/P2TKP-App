package papi_kostick.resource;

public enum PapiKostickCategory {
    LEADERSHIP_ROLE("L = PERAN – PEMIMPIN (Leadership Role)", 1),
    NEED_TO_CONTROL_OTHERS("P = KEBUTUHAN – MENGATUR ORANG LAIN (Need to Control Others)", 2),
    EASE_IN_DECISION_MAKING("I = PERAN – MEMBUAT KEPUTUSAN (Ease in Decision Making)", 3),
    NEED_TO_SUPPORT_AUTHORITY("F = KEBUTUHAN – MENDUKUNG OTORITAS PEMEGANG KEKUASAAN (Need to Support Authority)", 4),
    NEED_FOR_RULES_AND_SUPERVISION("W = KEBUTUHAN MENGIKUTI ATURAN DAN PENGAWASAN (Need for Rules and Supervision)", 5),
    PACE("T = PERAN SIBUK (Pace)", 6),
    VIGOROUS_TYPE("V = PERAN PENUH SEMANGAT (Vigorous Type)", 7),
    THEORETICAL_TYPE("R = PERAN ORANG YANG TEORITIS (Theoretical Type)", 8),
    INTEREST_IN_WORKING_WITH_DETAILS("D = PERAN BEKERJA DENGAN HAL – HAL RINCI (Interest in Working With Details)", 9),
    ORGANIZED_TYPE("C = PERAN MENGATUR (Organized Type)", 10),
    NEED_TO_BE_NOTICED("X = KEBUTUHAN UNTUK DIPERHATIKAN (Need to be Noticed)", 11),
    NEED_TO_BELONG_TO_GROUPS("B = KEBUTUHAN DITERIMA DALAM KELOMPOK (Need to Belong to Groups)", 12),
    NEED_FOR_CLOSENESS_AND_AFFECTION("O = KEBUTUHAN KEDEKATAN DAN KASIH SAYANG (Need for Closeness and Affection)", 13),
    SOCIAL_EXTENSION("S = PERAN HUBUNGAN SOSIAL (Social Extension)", 14),
    NEED_TO_FINISH_TASK("N = KEBUTUHAN MENYELESAIKAN TUGAS SECARA MANDIRI (Need to Finish Task)", 15),
    NEED_TO_ACHIEVE("A = KEBUTUHAN BERPRESTASI (Need to Achieve)", 16),
    HARD_INTENSE_WORKED("G = PERAN PEKERJA KERAS (Hard Intense Worked)", 17),
    NEED_FOR_CHANGE("Z = KEBUTUHAN UNTUK BERUBAH (Need for Change)", 18),
    NEED_TO_BE_FORCEFUL("K = KEBUTUHAN UNTUK AGRESIF (Need to be Forceful)", 19),
    EMOTIONAL_RESISTANT("E = PERAN PENGENDALIAN EMOSI (Emotional Resistant)", 20);

    private final String label;
    private final int index;

    PapiKostickCategory(String label, int index) {
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
