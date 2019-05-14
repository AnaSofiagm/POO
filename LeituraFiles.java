import java.awt.geom.Point2D;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeituraFiles {

    public static void main(String[] args) throws FileNotFoundException {

        File ficheiro = new File("src/logsPOO_carregamentoInicial.bak");
        FileReader fr = new FileReader(ficheiro);
        String[] campos;
        String[] camposaux;

        List<Veiculo> lv = new ArrayList<>();

        try {
            BufferedReader inStream = new BufferedReader(fr);
            String st;
            while ((st = inStream.readLine()) != null) {
                campos = st.split(":");
                if (campos[0].equals("NovoCarro")){
                    camposaux = campos[1].split(",");
                    Veiculo v = new Veiculo();
                    v.setTipo(stringToTipo(camposaux[0]));
                    v.setMarca(camposaux[1]);
                    v.setMatricula(camposaux[2]);
                    v.setNif(Integer.parseInt(camposaux[3]));
                    v.setVelocidadeKm(Double.parseDouble(camposaux[4]));
                    v.setPrecoBaseKm(Double.parseDouble(camposaux[5]));
                    v.setConsumoKm(Double.parseDouble(camposaux[6]));
                    v.setAutonomiaMaxima(Double.parseDouble(camposaux[7]));
                    v.setAutonomiaAtual(Double.parseDouble(camposaux[7]));
                    v.setLocalizacao(Point2D.Double(Double.parseDouble(camposaux[8]),Double.parseDouble(camposaux[9])));
                    System.out.println(camposaux[0]); //tipo
                    System.out.println(camposaux[1]); //marca
                    System.out.println(camposaux[2]); //matricula
                    System.out.println(camposaux[3]); //nif
                    System.out.println(camposaux[4]); //velocidade media
                    System.out.println(camposaux[5]); //preço por km
                    System.out.println(camposaux[6]); //consumo por km
                    System.out.println(camposaux[7]); //autonomia
                    System.out.println(camposaux[8]); //X
                    System.out.println(camposaux[9]); //Y
                    lv.add(v);
                }
            }
            for (Veiculo v : lv){
                System.out.println(v);
            }
            System.out.println(lv);
        }
        catch (IOException e){
            System.out.println(e);
        }
    }
}
