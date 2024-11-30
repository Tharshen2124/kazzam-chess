import javax.swing.*;
import java.awt.*;

public class BoardView extends JFrame {
    /**
     * sets the Board View's Frame of the Page.
     */
    public BoardView() {
        setLayout(new BorderLayout(0, 0));
        add(getChessPanel(), BorderLayout.CENTER);
        add(getControlPanel(), BorderLayout.SOUTH);

        setResizable(false);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
// hi
lksdflkdsfosadjfilsjfojfiojfojasdoifj sif jds
sd fsdlfjn saofd aspf
sdnj fndsjof nao
    /**
     *  returns the panel of the chess board of the Board View Page.
     */
    public JPanel getChessPanel() {
        int boardColumn = 5;
        int boardRow = 8;
        int squareSize = 80;

        JPanel chessPanel = new JPanel(new GridLayout(boardRow, boardColumn, 0, 0));

        chessPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));

        JButton[] chessGridButtons = new JButton[40];
        for (int x = 0; x < 40; x++) {
            chessGridButtons[x] = new JButton();
            chessGridButtons[x].setPreferredSize(new Dimension(squareSize, squareSize));
            chessGridButtons[x].setBackground(Color.WHITE);
            chessGridButtons[x].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            chessPanel.add(chessGridButtons[x]);
        }

        return chessPanel;
    }

    /**
     *  returns the panel with the save and exit buttons of the Board View Page.
      */
    public JPanel getControlPanel() {
        JPanel controlPanel = new JPanel(new FlowLayout());

        JButton saveButton = new JButton("Save");
        JButton exitButton = new JButton("Exit");
        controlPanel.add(saveButton);
        controlPanel.add(exitButton);

        return controlPanel;
    }

    public static void main(String[] args) {
        new BoardView();
    }
}
