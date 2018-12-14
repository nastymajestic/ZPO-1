import javax.swing.JFrame;


class ColorValueSliderControl extends JFrame {
    public ColorValueSliderControl() {
        getContentPane().add(new TColor());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 700);
        setVisible(true);
    }

    public static void main(String arg[]) {
        new ColorValueSliderControl();
    }
}
