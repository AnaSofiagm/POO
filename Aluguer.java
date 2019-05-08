import java.awt.geom.Point2D;

public class Aluguer
{
    /** Variaveis de Instância */
    //Veiculo alugado
    private Veiculo veiculo;
    //Cliente que realizou o aluguer
    private Cliente cliente;
    //Viagem que o carro fez no aluguer
    private Viagem viagemCarro;
    //Viagem que o Cliente fez ate ao carro
    private Viagem viagemCliente;
    //Custo total do aluguer
    private double custoTotal;
    // true se for maisPerto
    private boolean preferencia;
    /**
     * Cria uma instância de cliente
     */
    public Aluguer(){
        this.veiculo = new Veiculo();
        this.cliente = new Cliente();
        this.viagemCarro = new Viagem();
        this.viagemCliente = new Viagem();
        this.custoTotal = 0;
    }

    /**
     * Construtor por cópia.
     * @param a
     */
    public Aluguer(Aluguer a) {
        this.veiculo = a.getVeiculo();
        this.cliente = a.getCliente();
        this.viagemCarro = a.getViagemCarro();
        this.viagemCliente = a.getViagemCliente();
        this.custoTotal = a.getCustoTotal();
    }
    /**
     * Construtor por parametro
     * @param veiculo
     * @param cliente
     * @param viagemCarro
     * @param viagemCliente
     * @param custoTotal
     */
    public Aluguer(Cliente cliente, Point2D destino, T) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.viagemCarro = viagemCarro;
        this.viagemCliente = viagemCliente;
        this.custoTotal = custoTotal;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Viagem getViagemCarro() {
        return viagemCarro;
    }

    public void setViagemCarro(Viagem viagemCarro) {
        this.viagemCarro = viagemCarro;
    }

    public Viagem getViagemCliente() {
        return viagemCliente;
    }

    public void setViagemCliente(Viagem viagemCliente) {
        this.viagemCliente = viagemCliente;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }
    
    public boolean getPreferencia(){
        return this.preferencia;
    }
    
    public void setPreferencia(boolean preferencia){
        this.preferencia = preferencia;
    }

    /**
     * Compara a igualdade com outro objecto
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Aluguer a = (Aluguer) obj;
        return (a.getVeiculo().equals(this.veiculo) && a.getCliente().equals(this.cliente) &&
                 a.getViagemCarro().equals(this.viagemCarro)
                    && a.getCliente().equals(this.viagemCliente) && a.getCustoTotal() == this.custoTotal);
    }

    /**
     * Devolve uma cópia desta instância
     * @return
     */
    public Aluguer clone() {
        return new Aluguer(this);
    }

    /**
     * Devolve uma representação no formato textual
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Veiculo:").append(veiculo).append("'\n");
        sb.append("Cliente:").append(cliente).append("'\n");
        sb.append("Viagem do Carro:").append(viagemCarro).append("'\n");
        sb.append("Viagem do Cliente:").append(viagemCliente).append("'\n");
        return sb.toString();
    }

    public Aluguer (Point2D localizacaoCliente, Point2D localizacaoInicial, Point2D localizacaoDestino,Veiculo v){
        this.viagemCliente = new Viagem (localizacaoCliente, localizacaoInicial , Cliente.VELOCIDADE, 0 );
        this.viagemCarro = new Viagem (localizacaoInicial, localizacaoDestino , v.getVelocidadeKm(), 0);
    }
}
