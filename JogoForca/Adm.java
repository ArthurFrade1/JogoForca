import java.io.IOException;
import java.util.Random;

public class Adm {
    private String[] str;
    private String[] a= new String[7];
    private String[] palavras;
    private Random rand= new Random();

    public Adm() throws IOException {
        Leitor l= new Leitor();
        String strin= l.abrirArquivoLeitura();
        palavras = strin.split(" ");
        sorteia();
    }

    public boolean verifica(int pos, String letra){    
        if(str[pos].equals(letra)){
            a[pos]=letra;
            return true;
        }
        return false;
    }

    public int olhaFim(){
        boolean trava=true;
        for(int cont=0; cont<7; cont++){
            if(a[cont]==null){
                return 0;//EMPATE
            }
        }
        if(trava){
            //VERIFICA VITORIA
            for(int cont=0; cont<7; cont++){
                if(a[cont].equals(str[cont])==false){
                    return -1;//DERROTA
                }
            }
        }
        
        return 1;//VITÓRIA
    }
    public String confere(int pos){
        return str[pos];
    }
    public void limpar(int pos){
        sorteia();
        a[pos]=null;
    }
    public void sorteia(){
        String s=palavras[rand.nextInt(palavras.length)].toUpperCase();
        str=s.split("");
    }
}
