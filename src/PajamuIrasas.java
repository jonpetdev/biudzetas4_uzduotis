
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class PajamuIrasas extends Irasas {
    PajamuKategorija pajamuKategorija;
    String tipas;


    PajamuIrasas(float suma, String info, boolean bankas, int counter, LocalDateTime data, PajamuKategorija pajamuKategorija, String tipas) {
        super(suma, info, bankas, counter, data);
        this.pajamuKategorija = pajamuKategorija;
        this.tipas = tipas;

    }

    public PajamuKategorija getPajamuKategorija() {
        return pajamuKategorija;
    }

    public void setPajamuKategorija(PajamuKategorija pajamuKategorija) {
        this.pajamuKategorija = pajamuKategorija;
    }

    public String getTipas() {
        return tipas;
    }

    public void setTipas(String tipas) {
        this.tipas = tipas;
    }

    @Override
    public String toString() {

        DateTimeFormatter formatas = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        return " ID:" + this.getCounter() + " Tipas:" + this.getTipas() + " Kategorija:" + this.getPajamuKategorija()
                + " Suma:" + this.getSuma() + " Info:" + this.getInfo() + " Bankas:" + this.getBankas()
                + " Data:" + formatas.format(this.getData());
    }


}
