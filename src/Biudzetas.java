import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Biudzetas {

    static ArrayList<Irasas> list = new ArrayList<Irasas>();

    Scanner sc = new Scanner(System.in);

    String irasas = "";

    Biudzetas() {


    }

    public void gautiVisusIrasus() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof IslaiduIrasas) {

                System.out.println(list.get(i));


            } else if (list.get(i) instanceof PajamuIrasas) {

                System.out.println(list.get(i));

            }
        }
    }

    public void gautiIrasaFailui() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof IslaiduIrasas) {

                irasas = irasas + "" + list.get(i).getCounter() + "," + ((IslaiduIrasas) list.get(i)).getTipas()
                        + "," + ((IslaiduIrasas) list.get(i)).getIslaiduKategorija()
                        + "," + list.get(i).getSuma() + "," + list.get(i).getInfo()
                        + "," + list.get(i).getBankas() + "," + list.get(i).getData() + "\n";


            } else if (list.get(i) instanceof PajamuIrasas) {

                irasas = irasas + "" + list.get(i).getCounter() + "," + ((PajamuIrasas) list.get(i)).getTipas()
                        + "," + ((PajamuIrasas) list.get(i)).getPajamuKategorija()
                        + "," + list.get(i).getSuma() + "," + list.get(i).getInfo()
                        + "," + list.get(i).getBankas() + "," + list.get(i).getData() + "\n";

            }
        }
    }

    public void balansas() {
        float pajamuSuma = 0;
        float islaiduSuma = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof PajamuIrasas) {
                pajamuSuma = pajamuSuma + list.get(i).getSuma();
            } else if (list.get(i) instanceof IslaiduIrasas) {
                islaiduSuma = islaiduSuma + list.get(i).getSuma();
            }
        }
        float balansas = pajamuSuma - islaiduSuma;
        System.out.println("\nBalansas:" + balansas);
    }

    public void pridetiIrasa() {
        System.out.println("Pasirinkite: \n" +
                "[1]-Pridėti išlaidas-[1] \n" +
                "[2]-Pridėti pajamas-[2] ");
        tikrintiInt();
        int pasIrasas = sc.nextInt();
        if (pasIrasas == 1) {
            IslaiduKategorija islaiduKategorija = null;
            System.out.println("Pasirinkite kategorija: Maistas -[1],Pramogos -[2], Butas -[3], Komunaliniai -[4], Kuras -[5]");
            tikrintiInt();
            int pasirink1 = sc.nextInt();
            switch (pasirink1) {
                case 1:
                    islaiduKategorija = IslaiduKategorija.MAISTAS;
                    break;
                case 2:
                    islaiduKategorija = IslaiduKategorija.PRAMOGOS;
                    break;
                case 3:
                    islaiduKategorija = IslaiduKategorija.BUTAS;
                    break;
                case 4:
                    islaiduKategorija = IslaiduKategorija.KOMUNALINIAI;
                    break;
                case 5:
                    islaiduKategorija = IslaiduKategorija.KURAS;
                    break;
                default:
                    System.out.println("nera tokio pasirinkimo");
                    break;

            }
            System.out.println("Iveskite suma:");
            tikrintiFloat();
            float suma = sc.nextFloat();
            LocalDateTime data = LocalDateTime.now();
            System.out.println("pasirinkite tipa:");

            tikrintiBoolean();
            boolean bankas = sc.nextBoolean();
            System.out.println("info:");
            sc.nextLine();
            while (!sc.hasNextLine()) {
                sc.next();
            }
            String info = sc.nextLine();
            System.out.println("tipas:");
            while (!sc.hasNext()) {
                sc.next();
            }
            String tipas = sc.next();
            int counter = IslaiduIrasas.countas++;
            Irasas iir = new IslaiduIrasas(suma, info, bankas, counter, data, islaiduKategorija, tipas);
            list.add(iir);
        } else if (pasIrasas == 2) {

            PajamuKategorija pajamuKategorija = null;
            System.out.println("Pasirinkite kategorija:Atlyginimas -[1],Vokelis -[2], Chalturke -[3]");
            tikrintiInt();
            int pasirink1 = sc.nextInt();
            switch (pasirink1) {
                case 1:
                    pajamuKategorija = PajamuKategorija.ATLYGINIMAS;
                    break;
                case 2:
                    pajamuKategorija = PajamuKategorija.VOKELIS;
                    break;
                case 3:
                    pajamuKategorija = PajamuKategorija.CHALTURKE;
                    break;
                default:
                    System.out.println("nera tokio pasirinkimo");
                    break;

            }
            System.out.println("Iveskite suma:");
            tikrintiFloat();
            float suma = sc.nextFloat();
            LocalDateTime data = LocalDateTime.now();
            System.out.println("pasirinkite tipa:");
            tikrintiBoolean();
            boolean bankas = sc.nextBoolean();
            System.out.println("info:");
            sc.nextLine();
            while (!sc.hasNextLine()) {
                sc.next();
            }
            String info = sc.nextLine();
            System.out.println("Tipas:");
            while (!sc.hasNext()) {
                sc.next();
            }
            String tipas = sc.next();
            int counter = Irasas.countas++;
            Irasas pir = new PajamuIrasas(suma, info, bankas, counter, data, pajamuKategorija, tipas);
            list.add(pir);
        }


    }

    public Irasas redaguotiIrasus() {
        System.out.println("Pasirinkite ID įrašo kurį norite redaguoti:");
        tikrintiInt();
        int counter = sc.nextInt();
        int pas2 = 0;
        int pas3 = 0;

        for (Irasas i : list) {
            if (i instanceof PajamuIrasas && counter == i.getCounter()) {
                System.out.println("Redaguoti suma-[1] Testi-[2]");

                tikrintiInt();
                int pas = sc.nextInt();
                if (pas == 1) {
                    System.out.println("Dabartine suma: " + i.getSuma());

                    tikrintiFloat();
                    float suma1 = sc.nextFloat();
                    i.setSuma(suma1);
                    System.out.println("Redaguoti info-[1] Testi-[2]");
                    tikrintiInt();
                    pas2 = sc.nextInt();

                } else if (pas == 2) {
                    System.out.println("Redaguoti info-[1] Testi-[2]");
                    tikrintiInt();
                    pas2 = sc.nextInt();

                } else {
                    System.out.println("Blogai pasirinkta");
                }

                if (pas2 == 1) {

                    sc.nextLine();
                    System.out.println("Dabartinis info: " + i.getInfo());
                    while (!sc.hasNextLine()) {
                        sc.next();
                    }
                    String info1 = sc.nextLine();
                    i.setInfo(info1);
                    System.out.println("Redaguoti kategorija-[1] Testi-[2]");
                    tikrintiInt();
                    pas3 = sc.nextInt();
                } else if (pas2 == 2) {
                    System.out.println("Redaguoti kategorija-[1] Testi-[2]");
                    tikrintiInt();
                    pas3 = sc.nextInt();
                } else {
                    System.out.println("Blogai pasirinkta");
                }
                /////////////////////
                if (pas3 == 1) {
                    System.out.println("Dabartinis kategorija: " + ((PajamuIrasas) i).getPajamuKategorija());
                    System.out.println("Kategorija:");
                    System.out.println("[1]- Atlyginimas - [1]");
                    System.out.println("[2]- Vokelis - [2]");
                    System.out.println("[3]- Chalturke - [3]");

                    tikrintiInt();
                    int pajkat = sc.nextInt();
                    sc.nextLine();
                    PajamuKategorija pajamuKategorija1 = null;
                    switch (pajkat) {
                        case 1:
                            pajamuKategorija1 = PajamuKategorija.ATLYGINIMAS;
                            break;
                        case 2:
                            pajamuKategorija1 = PajamuKategorija.VOKELIS;
                            break;
                        case 3:
                            pajamuKategorija1 = PajamuKategorija.CHALTURKE;
                            break;
                        case 4:

                            break;
                        default:
                            System.out.println("Blogai pasirinkta kategorija");

                    }

                    ((PajamuIrasas) i).setPajamuKategorija(pajamuKategorija1);
                    System.out.println("Redagavimas baigtas!!!");
                    return (PajamuIrasas) i;

                } else if (pas3 == 2) {
                    System.out.println("Redagavimas baigtas!!!");
                } else {
                    System.out.println("Blogai pasirinkta");
                }


            } else if (i instanceof IslaiduIrasas && counter == i.getCounter()) {
                System.out.println("Redaguoti suma-[1] Testi-[2]");

                tikrintiInt();
                int pas = sc.nextInt();
                if (pas == 1) {
                    System.out.println("Dabartine suma: " + i.getSuma());
                    float suma1;
                    tikrintiFloat();
                    suma1 = sc.nextFloat();
                    i.setSuma(suma1);
                    System.out.println("Redaguoti info-[1] Testi-[2]");
                    tikrintiInt();
                    pas2 = sc.nextInt();

                } else if (pas == 2) {
                    System.out.println("Redaguoti info-[1] Testi-[2]");
                    tikrintiInt();
                    pas2 = sc.nextInt();

                } else {
                    System.out.println("Blogai pasirinkta");
                }

                //////////////////
                if (pas2 == 1) {

                    sc.nextLine();
                    System.out.println("Dabartinis info: " + i.getInfo());
                    while (!sc.hasNextLine()) {
                        sc.next();
                    }
                    String info1 = sc.nextLine();
                    i.setInfo(info1);
                    System.out.println("Redaguoti kategorija-[1] Testi-[2]");
                    tikrintiInt();
                    pas3 = sc.nextInt();
                } else if (pas2 == 2) {
                    System.out.println("Redaguoti kategorija-[1] Testi-[2]");
                    tikrintiInt();
                    pas3 = sc.nextInt();
                } else {
                    System.out.println("Blogai pasirinkta");
                }
                /////////////////////
                if (pas3 == 1) {
                    System.out.println("Dabartinis kategorija: " + ((IslaiduIrasas) i).getIslaiduKategorija());
                    System.out.println("Kategorija:");
                    System.out.println("[1]- Kaistas - [1]");
                    System.out.println("[2]- Pramogos - [2]");
                    System.out.println("[3]- Butas - [3]");
                    System.out.println("[4]- Komunaliniai - [4]");
                    System.out.println("[5]- Kuras - [5]");

                    int iskat = 0;
                    tikrintiInt();
                    iskat = sc.nextInt();
                    sc.nextLine();
                    IslaiduKategorija islaiduKategorija1 = null;
                    switch (iskat) {
                        case 1:
                            islaiduKategorija1 = IslaiduKategorija.MAISTAS;
                            break;
                        case 2:
                            islaiduKategorija1 = IslaiduKategorija.PRAMOGOS;
                            break;
                        case 3:
                            islaiduKategorija1 = IslaiduKategorija.BUTAS;
                            break;
                        case 4:
                            islaiduKategorija1 = IslaiduKategorija.KOMUNALINIAI;
                            break;
                        case 5:
                            islaiduKategorija1 = IslaiduKategorija.KURAS;
                            break;
                        default:
                            System.out.println("nera tokio pasirinkimo");
                            break;

                    }

                    ((IslaiduIrasas) i).setIslaiduKategorija(islaiduKategorija1);
                    System.out.println("Redagavimas baigtas!!!");
                    return (IslaiduIrasas) i;

                } else if (pas3 == 2) {
                    System.out.println("Redagavimas baigtas!!!");
                } else {
                    System.out.println("Blogai pasirinkta");
                }
            }
        }


        return null;

    }

    public void gautiVisusPajamuIrasus() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof PajamuIrasas) {
                System.out.println(list.get(i));
            }
        }
    }

    public void gautiVisusIslaiduIrasus() {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof IslaiduIrasas) {
                System.out.println(list.get(i));
            }
        }
    }


    public void trintiIrasa() {
        System.out.println("Pasirinkite įrašo ID kurį norite ištrinti:");
        tikrintiInt();
        int pasTrinti = sc.nextInt();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCounter() == pasTrinti) {
                list.remove(list.get(i));
            } else {
                System.out.println("nera tokio iraso!");
            }
        }
    }

    public void tikrintiInt() {
        while (!sc.hasNextInt()) {
            System.out.println("Irasykite skaiciu!!!");
            sc.next();
        }
    }

    public void tikrintiBoolean() {
        while (!sc.hasNextBoolean()) {
            System.out.println("Irasykite 'true' arba 'false' !!!");
            sc.next();
        }
    }

    public void tikrintiFloat() {
        while (!sc.hasNextFloat()) {
            System.out.println("Irasykite skaiciu, gali buti su kableliu !!!");
            sc.next();
        }
    }


}


