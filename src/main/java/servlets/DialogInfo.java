package servlets;

import javax.swing.*;

public class DialogInfo {
    static JFrame f;

    public void openPopup(String text) {
        f = new JFrame("frame");
        JPanel p = new JPanel();
        f.add(p);
        f.setSize(400, 400);
        f.show();

        JDialog d = new JDialog(f, "dialog Box");

        // create a label
        JLabel l = new JLabel("this is a dialog box");

        d.add(l);

        // setsize of dialog
        d.setSize(100, 100);

        // set visibility of dialog
        d.setVisible(true);
    }
}
