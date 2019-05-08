import java.awt.geom.Point2D;
import java.util.TreeSet;
import java.util.Set;
import java.util.Date;


public class Cliente extends Utilizador
{
    /** Variaveis de Instância */
    // velocidade a que uma pessoa se desloca a pé, definimos como uma variavel estática com valor 4km/hora
    public static final int VELOCIDADE = 4;
    // localização do cliente
    private Point2D localizacao;
    // Set com o histórico de alugueres realizados pelo cliente
    private Set<Aluguer> alugueres;
    
     /**
     * Cria uma instância de cliente
     * 
     */
    public Cliente(){
        super();
        this.alugueres = new TreeSet<Aluguer>();
    }
    
    /**
     * Construtor por cópia.
     * @param c 
     */
    public Cliente(Cliente c) {
        super(c);
        this.localizacao = c.getLocalizacao();
        this.alugueres = c.getAlugueres();
    
    }
    
    /**
     * Construtor por parametro
     * @param localizacao
     */
    public Cliente(String email, String nome, String password, String morada, Date datanascimento, Point2D localizacao){
        super(email, nome, password, morada, datanascimento);
        this.localizacao = localizacao;
        this.alugueres = new TreeSet<Aluguer>();
    }
    
    public Set<Aluguer> getAlugueres() {
        Set<Aluguer> copia = new TreeSet<Aluguer>();
        for (Aluguer r: this.alugueres) copia.add(r);
        return copia;
    }
    
    public Point2D getLocalizacao(){
        return this.localizacao;
    }
    
    public void setLocalizacao(){
        this.localizacao = localizacao;
    }
    
    /**
     * Devolve uma cópia desta instância
     * @return 
     */
    public Cliente clone() {
        return new Cliente(this);
    }
     
    /**
     * Compara a igualdade com outro objecto
     * @param obj
     * @return 
    */ 
    public boolean equals (Object obj) {
        boolean result = super.equals(obj);
        if (result == false) return false;
        Cliente c = (Cliente)obj;
        return (this.alugueres.equals(c.alugueres) && this.localizacao == localizacao);
   }
}
