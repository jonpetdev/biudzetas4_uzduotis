
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IslaiduIrasas extends Irasas {
    private IslaiduKategorija islaiduKategorija;
    private String tipas;


    IslaiduIrasas(float suma, String info, boolean bankas, int counter, LocalDateTime data, IslaiduKategorija islaiduKategorija, String tipas) {
        super(suma, info, bankas, counter, data);
        this.islaiduKategorija = islaiduKategorija;
        this.tipas = tipas;

    }


    public IslaiduKategorija getIslaiduKategorija() {
        return islaiduKategorija;
    }

    public void setIslaiduKategorija(IslaiduKategorija islaiduKategorija) {
        this.islaiduKategorija = islaiduKategorija;
    }

    public String getTipas() {
        return tipas;
    }

    public void setTipas(String tipas) {
        this.tipas = tipas;
    }

    @Override
    public String toString() {

        DateTimeFormatter formatas = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


        return " ID:" + this.getCounter() + " Tipas:" + this.getTipas() + " Kategorija:" + this.getIslaiduKategorija()
                + " Suma:" + this.getSuma() + " Info:" + this.getInfo() + " Bankas:" + this.getBankas()
                + " Data:" + formatas.format(this.getData());
    }
}
