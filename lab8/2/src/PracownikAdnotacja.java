import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class PracownikAdnotacja {
    private String imie;
    private int id;
    private double pensja;
    private boolean plec;

    PracownikAdnotacja(String im, int idd, double cash, boolean sex) {
        this.imie = im;
        this.id = idd;
        this.pensja = cash;
        this.plec = sex;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Adnotacja
    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    public boolean getPlec() {
        return plec;
    }

    public void setPlec(boolean plec) {

        this.plec = plec;
    }

    @Override
    public boolean equals(Object o) {
        Class klasa = this.getClass();
        boolean czyRowne = true;
        Method[] methods = klasa.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.getAnnotation(Adnotacja.class) == null) {
                try {
                    if (!method.invoke(o).equals(method.invoke(this))) {
                        czyRowne = false;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
            return czyRowne;
        }


}
