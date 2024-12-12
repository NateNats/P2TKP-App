/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package msdt.resource;

/**
 *
 * @author nicol
 */
public enum MSDTCategory {
    DESERTER("Deserter", 1),
    COMPROMISER("Compromiser", 2),
    MISSIONARY("Missionary", 3),
    BUEREAUCRAT("Buereaucrat", 4),
    AUTOCRAT("Autocrat", 5),
    BENEVOLENT_AUTOCRAT("Benevolent Autocrat", 6),
    DEVELOPER("Developer", 7),
    EXECUTIVE("Executive", 8);

    private final String label;
    private final int index;

    MSDTCategory(String label, int index) {
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
