import java.io.*;
import java.time.LocalDateTime;


public class Failas extends Biudzetas {

    String pavadinimas;
    public void ivesti(){
        System.out.println("Sukurkite failo pavadinima:");
        pavadinimas =sc.next();
    }


    public void issaugotiDuomenis(String irasas) throws IOException {


        File file = new File("src/"+pavadinimas+".csv");

        FileWriter writer = new FileWriter(file);
        writer.write(irasas);
        writer.flush();

    }

    public void gautiDuomenis() {

        System.out.println("Parasykite failo pavadinima is kurio gauti duomenis:");
        String pavadinimasF=sc.next();

        String line = "";
        BufferedReader buferis = null;
        try {
            buferis = new BufferedReader(new FileReader("src/"+pavadinimasF+".csv"));
            while ((line = buferis.readLine()) != null) {
                String[] gauta = line.split(",");
                int countas = Integer.parseInt(gauta[0]);
                String tipas = gauta[1];
                float suma = Float.parseFloat(gauta[3]);
                String info = gauta[4];
                boolean bankas = Boolean.parseBoolean(gauta[5]);
                LocalDateTime data = LocalDateTime.parse(gauta[6]);

                if (gauta[1].equals("Pajamos")) {
                    PajamuKategorija pajamuKategorija = PajamuKategorija.valueOf(gauta[2]);
                    Irasas pjI = new PajamuIrasas(suma, info, bankas, countas, data, pajamuKategorija, tipas);
                    list.add(pjI);


                } else if (gauta[1].equals("Islaidos")) {
                    IslaiduKategorija islaiduKategorija = IslaiduKategorija.valueOf(gauta[2]);
                    Irasas islI = new IslaiduIrasas(suma, info, bankas, countas, data, islaiduKategorija, tipas);
                    list.add(islI);

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void gautiFailus(){
        String failoDirektorija = "/Users/jonas/Desktop/biudzetas4/src";
        File[] failaiDirektorijoje = new File(failoDirektorija).listFiles();
        for(File f : failaiDirektorijoje){
            String filePath = f.getAbsolutePath();
            String fileExtenstion = filePath.substring(filePath.lastIndexOf(".") + 1,filePath.length());
            if("csv".equals(fileExtenstion)){
                System.out.println("Sukurti failai-> " + filePath);
            }
        }
        System.out.println("");

    }

}
