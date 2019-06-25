import java.io.IOException;
import java.util.Scanner;

public class Menu {

    Scanner sc = new Scanner(System.in);
    Biudzetas biudzetas = new Biudzetas();
    Failas fl = new Failas();

    Menu() throws IOException {
        while (true) {

            menuOptions();

            while (!sc.hasNextInt()) {
                sc.next();
            }
            int pas = sc.nextInt();

            switch (pas) {
                case 1:
                    biudzetas.gautiVisusPajamuIrasus();
                    System.out.println("");
                    break;
                case 2:
                    biudzetas.gautiVisusIslaiduIrasus();
                    System.out.println("");
                    break;
                case 3:
                    biudzetas.pridetiIrasa();
                    System.out.println("");
                    break;
                case 4:
                    biudzetas.gautiVisusIrasus();
                    System.out.println("");
                    break;
                case 5:
                    biudzetas.trintiIrasa();
                    System.out.println("");
                    break;
                case 6:
                    biudzetas.balansas();
                    System.out.println("");
                    break;
                case 7:
                    biudzetas.redaguotiIrasus();
                    System.out.println("");
                    break;
                case 8:
                    biudzetas.irasas = "";
                    biudzetas.gautiIrasaFailui();
                    fl.ivesti();
                    fl.issaugotiDuomenis("");
                    fl.issaugotiDuomenis(biudzetas.irasas);
                    System.out.println("Duomenys įrašyti į failą\n");
                    break;
                case 9:
                    fl.gautiFailus();
                    System.out.println("");
                    fl.gautiDuomenis();
                    System.out.println("Duomenys gauti iš failo\n");
                    break;
                case 10:
                    fl.gautiFailus();
                    System.out.println("");
                    break;
                default:
                    System.out.println("Nėra tokio pasirinkimo!!!");
                    break;
            }


        }
    }


    public void menuOptions() {
        System.out.println("Pasirinkite norimą atlikti veiksmą:" +
                "\n[1]-Gauti pajamų įrašus-[1]" +
                "\n[2]-Gauti išlaidu įrašus-[2]" +
                "\n[3]-Pridėti įrašą-[3]" +
                "\n[4]-Gauti visus įrašus-[4]" +
                "\n[5]-Trinti įrašą-[5]" +
                "\n[6]-Balansas-[6]" +
                "\n[7]-Redaguoti įrašą-[7]" +
                "\n[8]-Įrašyti įrašus į Failą-[8]" +
                "\n[9]-Gauti įrašus iš Failų-[9]" +
                "\n[10]-Visi failai-[10]");
    }

}
