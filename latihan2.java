import javax.swing.*;
import java.awt.*;

public class latihan2 extends JFrame {
    JPanel panelTombol;

    public latihan2() {

        setTitle("Tugas 2 - Layout Manager");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panelTombol = new JPanel(new FlowLayout());

        JButton tombol1 = new JButton("Tombol 1");
        JButton tombol2 = new JButton("Tombol 2");
        JButton tombol3 = new JButton("Tombol 3");

        panelTombol.add(tombol1);
        panelTombol.add(tombol2);
        panelTombol.add(tombol3);

        add(panelTombol, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuLayout = new JMenu("Layout");

        JMenuItem flow = new JMenuItem("FlowLayout");
        JMenuItem grid = new JMenuItem("GridLayout 1 x 3");

        flow.addActionListener(e -> {
            panelTombol.setLayout(new FlowLayout());

            panelTombol.revalidate();
            panelTombol.repaint();
        });

        grid.addActionListener(e -> {
            panelTombol.setLayout(new GridLayout(1, 3, 5, 5));

            panelTombol.revalidate();
            panelTombol.repaint();
        });

        menuLayout.add(flow);
        menuLayout.add(grid);

        menuBar.add(menuLayout);

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new latihan2().setVisible(true);
        });

    }
}
