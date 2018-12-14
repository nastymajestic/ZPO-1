
import javafx.scene.layout.VBox;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

class TColor extends JPanel {
    DrawingCanvas canvas = new DrawingCanvas();
    JLabel nameColour = new JLabel("");

    JSlider sliderR, sliderG, sliderB;
    ArrayList<Colours> colourArray = new ArrayList<>();
    public String countDistance(int R, int G, int B){

        String colorFoundLabel = "gray";
        int min = R+G+B;

        for(Colours c : colourArray){
            int m;
            m = Math.abs(c.getRedColour()-R) + Math.abs(c.getGreenColour()-G) + Math.abs(c.getBlueColour()-B);
            if(m <= min){
                min = m;
                colorFoundLabel = c.getColourLabel();
            }
        }
        return colorFoundLabel;
    }

    public TColor() {
        sliderR = getSlider(0, 255, 130, 50);
        sliderG = getSlider(0, 255, 130, 50);
        sliderB = getSlider(0, 255, 130, 50);
        BorderLayout borderLayout = new BorderLayout();
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JLabel rgbLabel = new JLabel("R-G-B Sliders");
        JLabel R = new JLabel("R");
        JLabel G = new JLabel("G");
        JLabel B = new JLabel("B");
        JCheckBox xd = new JCheckBox("Show color name");
        setLayout(borderLayout);
        panel.add(rgbLabel);
        panel2.add(R);
        panel2.add(sliderR);
        panel2.add(G);
        panel2.add(sliderG);
        panel2.add(B);
        panel2.add(sliderB);
// reflections
        Field [] fields = java.awt.Color.class.getFields();
        Class c = java.awt.Color.class;
        Color color = null;

        Method[] methods = c.getDeclaredMethods();
        for(int i=0; i<fields.length; i++) {
            String label = "";
            int red = 0, green = 0, blue = 0;

            if(fields[i].toString().contains("public static final java.awt.Color") && Character.isUpperCase(fields[i].getName().charAt(0))) {
                try {
                    color = (Color) fields[i].get(fields[i]);
                    label = fields[i].getName();
                    for (Method m : methods) {
                        if(m.getName().contains("getRed")){
                            red = (int)m.invoke(color);
                        }
                        if(m.getName().contains("getGreen")){
                            green = (int)m.invoke(color);
                        }
                        if(m.getName().contains("getBlue")){
                            blue = (int)m.invoke(color);
                        }
                    }


                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

                colourArray.add(new Colours(label,red,green,blue));
            }
        }

        xd.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                System.out.println("Checked? " + xd.isSelected());
                if(xd.isSelected()){
                panel2.add(nameColour);
                revalidate();
                }else {
                    panel2.remove(nameColour);
                    revalidate();
                }
            }
        });

 //koniec tabeli kolorow
        panel2.add(xd);
        add(panel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);


    }
    public JSlider getSlider(int minVal, int maxVal, int initVal, int mjrTkSp) {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, minVal, maxVal, initVal);
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(mjrTkSp);
        slider.setPaintLabels(true);
        slider.addChangeListener(new SliderListener());
        return slider;
    }



    class DrawingCanvas extends Canvas {
        Color color;
        int redValueSliderR = 130;
        int greenValueSliderG = 130;
        int blueValueSliderB= 130;
        int alphaValue = 255;
        public DrawingCanvas() {
            setSize(350, 350);
            setBackgroundColor();
        }
        public void setBackgroundColor() {
            color = new Color(redValueSliderR, greenValueSliderG, blueValueSliderB, alphaValue);
            setBackground(color);
        }


    }

    class SliderListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            JSlider slider = (JSlider) e.getSource();// fajny przyklad dzialania tego jest tu https://hajsoftutorial.com/actionevent-getsource/
             if (slider == sliderR) {
                canvas.redValueSliderR = slider.getValue();

                canvas.setBackgroundColor();


            } else if (slider == sliderG) {
                canvas.greenValueSliderG = slider.getValue();
                 canvas.setBackgroundColor();
            } else if (slider == sliderB) {
                canvas.blueValueSliderB = slider.getValue();
                 canvas.setBackgroundColor();
            }
            nameColour.setText(countDistance(sliderR.getValue(),sliderG.getValue(),sliderB.getValue()));
            canvas.repaint();

        }

    }
}