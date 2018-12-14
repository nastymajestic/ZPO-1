
public class Colours {
    int R;
    int G;
    int B;
    String label;

    public Colours(String label, int R, int G, int B){
        this.label = label;
        this.R = R;
        this.G = G;
        this.B = B;
    }

    public int getRedColour(){
        return R;
    }

    public int getGreenColour(){
        return G;
    }

    public int getBlueColour(){
        return B;
    }
    public String getColourLabel(){
        return label;
    }
    @Override
    public String toString(){
        return label + " " + R + " " + G + " " + B;
    }

}
