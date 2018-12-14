import java.util.Random;

public class Rowerzysta implements Comparable<Rowerzysta>{
    public String name;
    public Double time;
    public Integer poczatkowy_time;
    public Rowerzysta(String name,Integer time) {
        this.time =(double)time;
        this.name = name;
        this.poczatkowy_time = time;
    }

    public String getName(){
        return name;
    }

    public Double getTime(){
        return time;
    }

    public Integer getPoczatkowy_time(){
        return poczatkowy_time;
    }

    public void delayTime(Double time){
        this.time -= time;
    }


    @Override
    public String toString() {
        return getName()+getPoczatkowy_time();
    }

    @Override
    public int compareTo(Rowerzysta o) {
        if(this.poczatkowy_time>o.poczatkowy_time){
            return 1;
        }
        if(this.poczatkowy_time<o.poczatkowy_time){
            return -1;
        }
        return 0;
    }
}
