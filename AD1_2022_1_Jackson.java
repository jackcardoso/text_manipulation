/* ******************************************** */
// Curso de Tecnologia em Sistemas de Computação
// Disciplina: Programação Orientada a Objetos
// AD1 1° semestre de 2022.

// Aluno: Jackson Cardoso de Oliveira
/* ********************************************/


import java.util.Random;

class Texto{
    int TAM_MAX = 1000;
    private Frase[] frases = new Frase[TAM_MAX];
    private int pos_livre = 0;
    private String texto = "";
    public Texto() {

    }

    public Texto(String texto) throws InterruptedException {
        String array[];
        array = texto.split("\\.");
        for (String frase : array) {
            this.adicionaFrase(frase+".");
        }
    }
    public Texto adicionaFrase(String frase) {
        frases[pos_livre++] = new Frase(frase);
        return this;
    }
    public Texto adicionaFrase(Frase frase) {
        frases[pos_livre++] = frase;
        return this;
    }

    public String toString() {
        for (int i = 0; i < pos_livre; i++) {
            texto += frases[i];
        }
        return texto.strip();
    }

    public void substitui(String string, String string2) {
        for(int i = 0; i < pos_livre; i++ ){
            frases[i]= new Frase(frases[i].toString().replace(string, string2));
        }
    }

    public int getQuantidadePalavras() {
        int var = 0;
        for (int i = 0; i < pos_livre; i++) {
            var += frases[i].toString().split(" ", -1).length -1;
        }
        return var;
    }

    public String getFraseAleatoria() {
        // create random object
        Random random = new Random();

        // generating integer
        int nxt = random.nextInt(pos_livre);
        String frase = frases[nxt].toString();

        return frase;
    }

    public String getFrasesCom(String string) {
        String f ="";
        for(int i = 0; i < pos_livre; i++ ){
            int result = frases[i].toString().indexOf(string);
            if(result > 0){
                f += frases[i].toString();
            }
        }
        return f;
    }

    public String getTempoEstimadoLeitura() {
        float a = getQuantidadePalavras()/200f;
        int minutos = (int)Math.ceil(a);

        return minutos + " ";
    }
}

class Frase{
    private String frase;

    public Frase(){

    }
    public Frase(String string) {
        this.adicionaFrase(string);
    }

    public String adicionaFrase(String f){
        this.frase = (f).strip()+ " "; return frase;
    }
    public String toString() {
        return frase;
    }
}


public class AD1_2022_1_Jackson {
    public static void main(String[] args) throws InterruptedException {
        Texto teste = new Texto("Diz a sabedoria popular que um homem só tem uma vida completa quando planta uma árvore, escreve um livro e tem um filho. Ao meu ver, não se diz isso pensando de forma literal, mas sim na importância abstrata destes feitos. Ao plantar uma árvore, demonstramos preocupação com o ambiente onde vivemos. Ao ter um filho, amamos ao próximo incondicionalmente. Ao escrever um livro, desejamos compartilhar e \"eternizar\" o conhecimento adquirido.");
        teste.substitui("popular", "do povo");
        teste.adicionaFrase(new Frase("Claramente conseguimos realizar estes feitos abstratos de diferentes maneiras.")).adicionaFrase("O importante é ter consciência da importância destes.");
        System.out.println("Qtd: " + teste.getQuantidadePalavras());
        System.out.println("Tempo: " + teste.getTempoEstimadoLeitura() + "minuto(s)");
        System.out.println("Texto recuperado: " + teste);
        System.out.println("Frases com:\n" + teste.getFrasesCom("livro"));
        System.out.println("Aleatória:\n" + teste.getFraseAleatoria());

    }
}
