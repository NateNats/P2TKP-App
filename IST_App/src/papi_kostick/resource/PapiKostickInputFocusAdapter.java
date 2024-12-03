package papi_kostick.resource;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * this class is used to handle the input focus adapter for PAPI Costic values
 * in
 * PAPI Costic form
 * 
 * @author <a href="https://github.com/Trustacean">Edward</a>
 */

public class PapiKostickInputFocusAdapter extends FocusAdapter {
    private final JTextField inputField;
    private final char key;
    private final boolean isTopRow;
    private final JPanel panel;
    private final JButton button;
    private final JLabel label;
    private final java.awt.Color RED = new java.awt.Color(255, 153, 153);
    private final java.awt.Color GREEN = new java.awt.Color(153, 255, 153);

    public PapiKostickInputFocusAdapter(JTextField inputField, char key, boolean isTopRow, JPanel panel, JButton button,
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
        PapiKostickResource.handleIntegerInput(inputField, key, isTopRow, panel, button);
        label.setText("" + (isTopRow ? PapiKostickResource.getTopRowSum() : PapiKostickResource.getBottomRowSum()));
        label.setBackground(
                (isTopRow ? PapiKostickResource.isTopRowValueValid() : PapiKostickResource.isBottomRowValueValid())
                        ? GREEN
                        : RED);
    }
}
