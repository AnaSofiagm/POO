import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.Set;
import java.util.Date;

public class Proprietario extends Utilizador
{
    /** Variaveis de Instância */
    // lista de veiculos dos quais é propriétário
    private List<Veiculo> veiculos;
    // set que guarda a historico dos alugueres realizados por cada proprietario
    private Set<Aluguer> historicoAlugados;
    // classificação geral de cada proprietario
    private int classificacao;
    
    /**
     * Cria uma instância de proprietario
     * 
     */
    public Proprietario(){
        super();
        this.veiculos = new ArrayList<Veiculo>();
        this.historicoAlugados = new TreeSet<Aluguer>();
        this.classificacao = 0;
    }
   
    /**
     * Construtor por cópia.
     * @param p 
     */
    public Proprietario(Proprietario p) {
        super(p);
        this.veiculos = p.getVeiculos();
        this.historicoAlugados = p.getHistoricoAlugados();
        this.classificacao = p.getClassificacao();
    }
    
    /**
     * Construtor por parametro
     * @param classificacao
     */
    public Proprietario(String email, String nome, String password, String morada, Date datanascimento, int classificacao){
        super(email, nome, password, morada, datanascimento);
        this.veiculos = new ArrayList<Veiculo>();
        this.historicoAlugados = new TreeSet<Aluguer>();
        this.classificacao = classificacao;
    }
    
    public int getClassificacao(){
        return this.classificacao;
    }
    
    public void setClassificacao(int classificacao){
        this.classificacao = classificacao;
    }
    
    public Set<Aluguer> getHistoricoAlugados() {
        Set<Aluguer> copia = new TreeSet<Aluguer>();
        for (Aluguer r: this.historicoAlugados) copia.add(r);
        return copia;
    }
    
    public List<Veiculo> getVeiculos() {
        List<Veiculo> copia = new ArrayList<Veiculo>();
        for (Veiculo r: this.veiculos) copia.add(r);
        return copia;
    }
   
    /**
     * Devolve uma cópia desta instância
     * @return 
     */
    public Proprietario clone() {
        return new Proprietario(this);
    }
    
     /**
     * Compara a igualdade com outro objecto
     * @param obj
     * @return 
    */ 
    public boolean equals (Object obj) {
        boolean result = super.equals(obj);
        if (result == false) return false;
        Proprietario p = (Proprietario)obj;
        return (this.veiculos.equals(p.veiculos) && this.historicoAlugados.equals(p.historicoAlugados) && this.classificacao == classificacao);
   }
   
   
}