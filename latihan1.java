import javax.swing.*;
import java.awt.*;

public class latihan1 extends JFrame {

    JTextField txtNama;
    JTextField txtEmail;
    JPasswordField txtSandi;

    JRadioButton rbLaki;
    JRadioButton rbPerempuan;

    JComboBox<String> cbProdi;

    JCheckBox cb1;
    JCheckBox cb2;
    JCheckBox cb3;

    JButton btnDaftar;

    public latihan1() {

        super("Form Registrasi");

        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenu menuBantuan = new JMenu("Bantuan");

        JMenuItem menuKeluar = new JMenuItem("Keluar");
        JMenuItem menuTentang = new JMenuItem("Tentang");

        menuKeluar.addActionListener(e -> {
            System.exit(0);
        });

        menuTentang.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                this,
                "Aplikasi Form Registrasi Mahasiswa",
                "Tentang",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        menuFile.add(menuKeluar);
        menuBantuan.add(menuTentang);

        menuBar.add(menuFile);
        menuBar.add(menuBantuan);

        setJMenuBar(menuBar);

        JPanel panel = new JPanel(new GridBagLayout());

        panel.setBackground(Color.WHITE);

        panel.setBorder(
            BorderFactory.createTitledBorder("Data Registrasi")
        );

        GridBagConstraints g = new GridBagConstraints();

        g.insets = new Insets(6, 5, 6, 5);
        g.anchor = GridBagConstraints.WEST;

        g.gridx = 0;
        g.gridy = 0;

        panel.add(new JLabel("Nama:"), g);

        txtNama = new JTextField(18);

        g.gridx = 1;
        panel.add(txtNama, g);

        g.gridx = 0;
        g.gridy = 1;

        panel.add(new JLabel("Email:"), g);

        txtEmail = new JTextField(18);

        g.gridx = 1;
        panel.add(txtEmail, g);

        g.gridx = 0;
        g.gridy = 2;

        panel.add(new JLabel("Sandi:"), g);

        txtSandi = new JPasswordField(18);

        g.gridx = 1;
        panel.add(txtSandi, g);

        g.gridx = 0;
        g.gridy = 3;

        panel.add(new JLabel("Gender:"), g);

        JPanel panelGender = new JPanel(
            new FlowLayout(FlowLayout.LEFT, 3, 0)
        );

        panelGender.setBackground(Color.WHITE);

        rbLaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");

        rbLaki.setBackground(Color.WHITE);
        rbPerempuan.setBackground(Color.WHITE);

        ButtonGroup grupGender = new ButtonGroup();

        grupGender.add(rbLaki);
        grupGender.add(rbPerempuan);

        rbLaki.setSelected(true);

        panelGender.add(rbLaki);
        panelGender.add(rbPerempuan);

        g.gridx = 1;
        panel.add(panelGender, g);

        g.gridx = 0;
        g.gridy = 4;

        panel.add(new JLabel("Prodi:"), g);

        cbProdi = new JComboBox<>(
            new String[]{
                "Informatika",
                "Sistem Informasi",
                "Manajemen",
                "Akuntansi",
                "Teknik Kimia",
                "Ekonomi Syariah"
            }
        );

        cbProdi.setPreferredSize(new Dimension(175, 25));

        g.gridx = 1;
        panel.add(cbProdi, g);

        g.gridx = 0;
        g.gridy = 5;

        panel.add(new JLabel("Hobi:"), g);

        JPanel panelHobi = new JPanel(
            new FlowLayout(FlowLayout.LEFT, 3, 0)
        );

        panelHobi.setBackground(Color.WHITE);

        cb1 = new JCheckBox("Olahraga");
        cb2 = new JCheckBox("Maen Game");
        cb3 = new JCheckBox("Membaca");

        cb1.setBackground(Color.WHITE);
        cb2.setBackground(Color.WHITE);
        cb3.setBackground(Color.WHITE);

        panelHobi.add(cb1);
        panelHobi.add(cb2);
        panelHobi.add(cb3);

        g.gridx = 1;
        panel.add(panelHobi, g);

        btnDaftar = new JButton("Daftar");

        g.gridx = 1;
        g.gridy = 6;
        g.fill = GridBagConstraints.HORIZONTAL;

        panel.add(btnDaftar, g);

        btnDaftar.addActionListener(e -> daftar());

        add(panel);

    }

    public void daftar() {

        String nama = txtNama.getText().trim();
        String email = txtEmail.getText().trim();

        char[] sandi = txtSandi.getPassword();


        if (nama.isEmpty() || email.isEmpty() || sandi.length == 0) {

            JOptionPane.showMessageDialog(
                this,
                "Semua data harus diisi!",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String gender;

        if (rbLaki.isSelected()) {
            gender = "Laki-laki";
        } else {
            gender = "Perempuan";
        }

        String prodi = (String) cbProdi.getSelectedItem();

        String hobi = "";

        if (cb1.isSelected()) {
            hobi += "Olahraga, ";
        }

        if (cb2.isSelected()) {
            hobi += "Maen Game, ";
        }

        if (cb3.isSelected()) {
            hobi += "Membaca, ";
        }

        if (hobi.isEmpty()) {
            hobi = "Tidak ada";
        } else {
            hobi = hobi.substring(0, hobi.length() - 2);
        }

        String hasil =
            "REGISTRASI BERHASIL!\n\n" +
            "Nama       : " + nama + "\n" +
            "Email      : " + email + "\n" +
            "Gender     : " + gender + "\n" +
            "Prodi      : " + prodi + "\n" +
            "Hobi       : " + hobi;

        JOptionPane.showMessageDialog(
            this,
            hasil,
            "Ringkasan Registrasi",
            JOptionPane.INFORMATION_MESSAGE
        );

        java.util.Arrays.fill(sandi, '\0');
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new latihan1().setVisible(true);
        });

    }
}