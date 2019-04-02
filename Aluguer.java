

public class Aluguer
{
    private Veiculo veiculo;
    private Cliente cliente;
    private Proprietario proprietario;
    private Viagem viagemCarro;
    private Viagem viagemCliente;
    
    private double custoTotal;
    
    public Aluguer (Point2D localizacaoCliente, Point2D localizacaoInicial, Point2D localizacaoDestino,Veiculo v){
        this.viagemCliente = new Viagem (localizacaoCliente, localizacaoInicial , Cliente.VELOCIDADE);
        this.viagemCarro = new Viagem (localizacaoInicial, localizacaoDestino , v.getVelocidade());
    }
}
