import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Leitor {
    private FileReader fr;
    private BufferedReader br;

    public String abrirArquivoLeitura() throws IOException {
        fr = new FileReader("C:/Users/rosse/OneDrive/Área de Trabalho/palavras7letras.txt");
        br = new BufferedReader(fr);

        String manda ="";
        while (br.ready())
            manda=br.readLine();

        fr.close();
        return manda;
    }
}