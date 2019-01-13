package GUI.assets;

import javax.swing.*;
import java.awt.*;

public class FlatCombo<T> extends JComboBox<T> {
    /**
     * Creates a <code>JComboBox</code> with a default data model.
     * The default data model is an empty list of objects.
     * Use <code>addItem</code> to add items.  By default the first item
     * in the data model becomes selected.
     *
     * @see DefaultComboBoxModel
     */
    public FlatCombo() {
        super();
        this.setBackground(new Color(0xc1c6ff));
    }
}
