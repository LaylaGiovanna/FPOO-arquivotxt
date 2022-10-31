package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Arquivos {

    public static void main(String[] args) {

        Calculo c = new Calculo();
        c.dividendo = 10;
        c.divisor = 0;

        try {
            System.out.println(c.getResultado());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Precisamos do caminho do arquivo que vamos manipular
        String caminho = "C:\\Users\\22282096\\java_projeto\\teste.txt";

        //Abrir o arquivo em modo escrita
        Path path = Paths.get(caminho);

//        try {
//            //Criar buffer de escrita
//            BufferedWriter bw = Files.newBufferedWriter(
//                    path,
//                    StandardOpenOption.APPEND,
//                    StandardOpenOption.WRITE);
//
//            bw.write("Olá, conteúdo gravado!");
//            bw.newLine();
//            bw.write("Olá, conteúdo gravado!");
//            bw.newLine();
//            bw.close();
//
//        } catch (IOException erro) {
//            JOptionPane.showMessageDialog(null, "O arquivo não existe");
//        }

        
        
        //Mudar arquivo para leitura
        try {
            //Abrir o arquivo para leitura
            BufferedReader br = Files.newBufferedReader(path);

            String linha = "";

            //Ler uma linha do arquivo e armazenar na variável linha
            linha = br.readLine();

            while (linha != null) {
                String[] linhaVetor = linha.split(";");
                System.out.println(linhaVetor[0]);
                System.out.println(linhaVetor[1]);
                System.out.println(linhaVetor[2]);
                System.out.println("-------------------");
                linha = br.readLine();
            }
            System.out.println("Fim do arquivo");
            
            br.close();

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro");
        }

    }

}
