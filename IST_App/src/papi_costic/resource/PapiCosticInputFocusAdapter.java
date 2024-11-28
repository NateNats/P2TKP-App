package papi_costic.resource;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * this class is used to handle the input focus adapter for PAPI Costic values in
 * PAPI Costic form
 * 
 * @author <a href="https://github.com/Trustacean">Edward</a>
 */

public class PapiCosticInputFocusAdapter extends FocusAdapter {
    private final JTextField inputField;
    private final char key;
    private final boolean isTopRow;
    private final JPanel panel;
    private final JButton button;
    private final JLabel label;

    public PapiCosticInputFocusAdapter(JTextField inputField, char key, boolean isTopRow, JPanel panel, JButton button,
            JLabel label) {
        this.inputField = inputField;
        this.key = key;
        this.isTopRow = isTopRow;
        this.panel = panel;
        this.button = button;
        this.label = label;
    }

    @Override
    public void focusLost(FocusEvent e) {
        PapiCosticResource.handleIntegerInput(inputField, key, isTopRow, panel, button);
        label.setText("" + (isTopRow ? PapiCosticResource.getTopRowSum() : PapiCosticResource.getBottomRowSum()));
    }
}
