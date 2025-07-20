package domain.ui.custom.input;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import domain.models.Cell;

public class NumberText extends JTextField {
    private final Cell cell;

    public NumberText(final Cell cell) {
        this.cell = cell;
        var dimension = new Dimension(50, 50);
        this.setSize(dimension);
        this.setPreferredSize(dimension);
        this.setVisible(true);
        this.setFont(getFont());
        this.setHorizontalAlignment(CENTER);
        this.setDocument(new NumberTextLimit());
        this.setEnabled(!cell.isPlaced());
        if (cell.isPlaced()) {
            this.setText(cell.getNum().toString());
        }
        this.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                changeCell();
            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                changeCell();
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                changeCell();
            }

            private void changeCell() {
                if (getText().isEmpty()) {
                    cell.clear();
                    return;
                }
                cell.setNum(Integer.parseInt(getText()));
            }

        });
    }
}
