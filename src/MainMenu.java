package src;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class MainMenu extends JFrame implements MouseListener {

    int window_width = 406, window_height = 682;
    int menu_button_width = 174, menu_button_height = 61;

    boolean isMouseEntered = false;

    ImageIcon backgroundImg = new ImageIcon("res/background.jpg");
    ImageIcon smallIcon = new ImageIcon("res/small_icon.png");
    ImageIcon icon = new ImageIcon("res/icon.png");

    ImageIcon[] defaultState = new ImageIcon[4];
    ImageIcon[] glowState1 = new ImageIcon[4];
    ImageIcon[] glowState2 = new ImageIcon[4];

    JPanel panel;

    JLabel background;
    JLabel logo;
    JButton[] button = new JButton[4];

    public MainMenu() {

        setTitle("Kwazam Chess - Main Menu");
        setIconImage(icon.getImage());
        setResizable(false);

        add(getPanel());

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel getPanel() {

        defaultState[0] = new ImageIcon("res/main_menu_ui/new_game_button_default.png");
        defaultState[1] = new ImageIcon("res/main_menu_ui/load_game_button_default.png");
        defaultState[2] = new ImageIcon("res/main_menu_ui/options_button_default.png");
        defaultState[3] = new ImageIcon("res/main_menu_ui/quit_button_default.png");

        glowState1[0] = new ImageIcon("res/main_menu_ui/new_game_button_glow.png");
        glowState1[1] = new ImageIcon("res/main_menu_ui/load_game_button_glow.png");
        glowState1[2] = new ImageIcon("res/main_menu_ui/options_button_glow.png");
        glowState1[3] = new ImageIcon("res/main_menu_ui/quit_button_glow.png");

        glowState2[0] = new ImageIcon("res/main_menu_ui/new_game_button_glow_red.png");
        glowState2[1] = new ImageIcon("res/main_menu_ui/load_game_button_glow_red.png");
        glowState2[2] = new ImageIcon("res/main_menu_ui/options_button_glow_red.png");
        glowState2[3] = new ImageIcon("res/main_menu_ui/quit_button_glow_red.png");

        panel = new JPanel();
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(window_width, window_height));

        background = new JLabel(backgroundImg);
        background.setBounds(0, 0, window_width, window_height);
        
        logo = new JLabel(smallIcon);
        logo.setText("<html>Kwazam Chess</html>");
        logo.setFont(new Font("Garamond", Font.PLAIN, 45));
        logo.setForeground(Color.WHITE);
        logo.setIconTextGap(20);
        logo.setBounds(81, 121, 244, 98);

        int posX = (window_width / 2) - (menu_button_width / 2);
        int posY = (window_height / 2) - (menu_button_height / 2);

        for (int i = 0; i < 4; i++) {
            button[i] = new JButton(defaultState[i]);
            button[i].setBounds(posX, posY, menu_button_width, menu_button_height);
            button[i].setFocusable(false);
            button[i].setFocusPainted(false);
            button[i].setContentAreaFilled(false);
            button[i].setBorderPainted(false);
            button[i].setOpaque(false);
            button[i].addMouseListener(this);

            panel.add(button[i]);
            
            posY += 80;
        }

        panel.add(logo);
        panel.add(background);

        return panel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == button[0]) {
            dispose();
            new BoardView();
        } else if (e.getSource() == button[1]) {
            //
        } else if (e.getSource() == button[2]) {
            //
        } else if (e.getSource() == button[3]) {
            dispose();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < 4; i++)
            if (e.getSource() == button[i])
                button[i].setIcon(glowState2[i]);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (int i = 0; i < 4; i++)
            if (e.getSource() == button[i]) {
                if (isMouseEntered)
                    button[i].setIcon(glowState1[i]);
                else
                    button[i].setIcon(defaultState[i]);
            }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        isMouseEntered = true;
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        for (int i = 0; i < 4; i++)
            if (e.getSource() == button[i])
                button[i].setIcon(glowState1[i]);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        isMouseEntered = false;
        setCursor(Cursor.getDefaultCursor());
        for (int i = 0; i < 4; i++)
            if (e.getSource() == button[i]) 
                button[i].setIcon(defaultState[i]);
    }
}