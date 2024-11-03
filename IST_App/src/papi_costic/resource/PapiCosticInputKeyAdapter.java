package papi_costic.resource;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PapiCosticInputKeyAdapter extends KeyAdapter {
    private final JTextField inputField;
    private final char key;
    private final boolean isTopRow;
    private final JPanel panel;
    private final JButton button;
    private final JLabel label;

    public PapiCosticInputKeyAdapter(JTextField inputField, char key, boolean isTopRow, JPanel panel, JButton button,
            JLabel label) {
        this.inputField = inputField;
        this.key = key;
        this.isTopRow = isTopRow;
        this.panel = panel;
        this.button = button;
        this.label = label;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        PapiCosticResource.handleIntegerInput(inputField, key, isTopRow, panel, button);
        label.setText("" + (isTopRow ? PapiCosticResource.getTopRowSum() : PapiCosticResource.getBottomRowSum()));
    }
}
