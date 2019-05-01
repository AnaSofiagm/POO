import java.awt.geom.Point2D;
import java.util.TreeSet;
import java.util.Set;

public class Veiculo
{
    /** Variaveis de Instância */
    //Tipo do veiculo(Gasolina,eletrico ou hibrido)
    private TipoVeiculo tipo;
    //velocidade média do carro por KIlometro
    private double velocidadeKm;
    //Preço a pagar por cada kilometro
    private double precoBaseKm;
    //Consumo médio do carro por Kilometro
    private double consumoKm;
    //Set com um historico de aluguers realizados
    private Set<Aluguer> alugueresRealizados;
    //Classificao dada ao carro pelo Cliente
    private int classificacao;
    //localizacao do carro
    private Point2D localizacao;
    //Autonomia maxima do carro
    private double autonomiaMaxima;
    //Autonomia atual do carro
    private double autonomiaAtual;
    //Identifica se o carro encontra-se disponivel para um novo aluguer
    private boolean disponibilidade;
    //Proprietario do carro
    private Proprietario proprietario;

    /**
     * Cria uma instância de cliente
     *
     */
    public Veiculo(){
        super();
        this.tipo = Gasolina;
        this.velocidadeKm = 0;
        this.precoBaseKm = 0;
        this.consumoKm = 0;
        this.alugueresRealizados = new TreeSet<Aluguer>();
        this.classificacao = 0;
        this.localizacao = Point2D.Double(0,0); //iniciliaza nas coordenadas (0,0)
        this.autonomiaMaxima = 0;
        this.autonomiaAtual = 0;
        this.disponibilidade = false;
        this.proprietario = new Proprietario();
    }

    /**
     * Construtor por cópia.
     * @param v
     */
    public Veiculo(Veiculo v){
        super(v);
        this.tipo = v.getTipo();
        this.velocidadeKm = v.getVelocidadeKm();
        this.precoBaseKm = v.getPrecoBaseKm();
        this.consumoKm = v.getConsumoKm();
        this.alugueresRealizados = getAlugueresRealizados();
        this.classificacao = v.getClassificacao();
        this.localizacao = v.getLocalizacao();
        this.autonomiaMaxima = v.getAutonomiaMaxima();
        this.autonomiaAtual = v.getAutonomiaAtual();
        this.disponibilidade = v.getDisponibilidade();
        this.proprietario = v.getProprietario();

    }

    /**
     * Construtor por parametro
     * @param tipo
     * @param velocidadeKm
     * @param precoBaseKm
     * @param consumoKm
     * @param alugueresRealizados
     * @param classificacao
     * @param localizacao
     * @param autonomiaMaxima
     * @param autonomiaAtual
     * @param disponibilidade
     * @param prop
     */
    public Veiculo(TipoVeiculo tipo, double velocidadeKm, double precoBaseKm, double consumoKm, Set<Aluguer> alugueresRealizados, int classificacao, Point2D localizacao, double autonomiaMaxima, double autonomiaAtual, boolean disponibilidade, Proprietario proprietario) {
        this.tipo = tipo;
        this.velocidadeKm = velocidadeKm;
        this.precoBaseKm = precoBaseKm;
        this.consumoKm = consumoKm;
        this.alugueresRealizados = alugueresRealizados;
        this.classificacao = classificacao;
        this.localizacao = localizacao;
        this.autonomiaMaxima = autonomiaMaxima;
        this.autonomiaAtual = autonomiaAtual;
        this.disponibilidade = disponibilidade;
        this.proprietario = proprietario;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public double getVelocidadeKm() {
        return velocidadeKm;
    }

    public void setVelocidadeKm(double velocidadeKm) {
        this.velocidadeKm = velocidadeKm;
    }

    public double getPrecoBaseKm() {
        return precoBaseKm;
    }

    public void setPrecoBaseKm(double precoBaseKm) {
        this.precoBaseKm = precoBaseKm;
    }

    public double getConsumoKm() {
        return consumoKm;
    }

    public void setConsumoKm(double consumoKm) {
        this.consumoKm = consumoKm;
    }

    public Set<Aluguer> getAlugueresRealizados(){
        Set<Aluguer> copia = new TreeSet<Aluguer>();
        for(Aluguer r: this.alugueresRealizados) copia.add(r);
        return copia;
    }

    public int getClassificacao() {
        return this.classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public Point2D getLocalizacao() {
        return this.localizacao;
    }

    public void setLocalizacao(Point2D localizacao) {
        this.localizacao = localizacao;
    }

    public double getAutonomiaMaxima() {
        return this.autonomiaMaxima;
    }

    public void setAutonomiaMaxima(double autonomiaMaxima) {
        this.autonomiaMaxima = autonomiaMaxima;
    }

    public double getAutonomiaAtual() {
        return this.autonomiaAtual;
    }

    public void setAutonomiaAtual(double autonomiaAtual) {
        this.autonomiaAtual = autonomiaAtual;
    }

    public boolean getDisponibilidade() {
        return this.disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Proprietario getProprietario() {
        return this.proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    /**
     * Devolve uma cópia desta instância
     * @return
     */
    public Veiculo clone() {
        return new Veiculo(this);
    }

    /**
     * Compara a igualdade com outro objecto
     * @param obj
     * @return
     */
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;

        Veiculo v = (Veiculo) object;
        return (this.alugueresRealizados.equals(v.getAlugueresRealizados()) && 
                this.velocidadeKm == v.getVelocidadeKm() && this.precoBaseKm == v.getPrecoBaseKm() && this.consumoKm == v.getConsumoKm() &&
                this.localizacao.equals(v.getLocalizacao()) && this.autonomiaAtual == v.getAutonomiaAtual() && 
                this.autonomiaMaxima == v.getAutonomiaMaxima() && this.disponibilidade == v.getDisponibilidade() && 
                this.proprietario.equals(proprietario) && this.tipo == v.getTipo() && this.classificacao == v.getClassificacao());
    }

    /**
     * Devolve uma representação no formato textual
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tipo:").append(tipo).append("'\n");
        sb.append("Velocidade media:").append(velocidadeKm).append("'\n");
        sb.append("Preco por Kilometro:").append(precoBaseKm).append("'\n");
        sb.append("Consumo do carro por Kilometro:").append(consumoKm).append("'\n");
        sb.append("Alugueres realizados:").append(alugueresRealizados).append("'\n");
        sb.append("Classificacao:").append(classificacao).append("'\n");
        sb.append("Localizacao:").append(localizacao).append("'\n");
        sb.append("Autonomia Maxima:").append(autonomiaMaxima).append("'\n");
        sb.append("Autonomia Atual:").append(autonomiaAtual).append("'\n");
        sb.append("Disponibilidade do carro:").append(disponibilidade).append("'\n");
        sb.append("Proprietario do Carro:").append(proprietario).append("'\n");
        return sb.toString();
    }
}