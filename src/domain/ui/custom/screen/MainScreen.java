package domain.ui.custom.screen;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

import javax.swing.JPanel;

import domain.services.Board;
import domain.ui.custom.button.FinishGameButton;
import domain.ui.custom.button.ResetButton;
import domain.ui.custom.frame.MainFrame;
import domain.ui.custom.panel.MainPanel;

public class MainScreen {
    private final static Dimension dimension = new Dimension(600, 600);

    private JButton checkGameStatusButton;

    public MainScreen() {

    }

    public void buildMainScreen() {
        JPanel mainPanel = new MainPanel(dimension);
        JFrame mainFrame = new MainFrame(dimension, mainPanel);
        addResetButton(mainPanel);
        addGameStatusButton(mainPanel);
        addFinishGameButton(mainPanel);

        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void addFinishGameButton(final JPanel mainPanel) {
        JButton finishButton = new FinishGameButton(e->{
            Board.reset();
            JOptionPane.showMessageDialog(null, "Jogo Finalizado!");
        });
        mainPanel.add(finishButton);
    }

    private void addGameStatusButton(final JPanel mainPanel) {
        mainPanel.add(checkGameStatusButton);
    }

    private void addResetButton(final JPanel mainPanel) {
        JButton resetButton = new ResetButton(e -> {
            var dialogResul = JOptionPane.showConfirmDialog(null, "Reiniciar Jogo?", "Limpar Jogo",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (dialogResul == 0) {
                Board.reset();
            }
        });

        mainPanel.add(resetButton);

    }

}
