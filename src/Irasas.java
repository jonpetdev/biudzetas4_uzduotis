import java.time.LocalDateTime;

public class Irasas {
    private float suma;
    private String info;
    private boolean bankas;
    static int countas;
    private int counter;
    private LocalDateTime data;


    Irasas(float suma, String info, boolean bankas, int counter, LocalDateTime data) {
        this.suma = suma;
        this.info = info;
        this.bankas = bankas;
        this.counter = counter;
        this.data = data;


    }


    public float getSuma() {
        return suma;
    }

    public void setSuma(float suma) {
        this.suma = suma;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean getBankas() {
        return bankas;
    }

    public void setBankas(boolean bankas) {
        this.bankas = bankas;
    }

    public int getCounter() {
        return counter;
    }


    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
