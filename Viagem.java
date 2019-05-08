import java.awt.geom.Point2D;
import java.util.Date;
import java.lang.Math;

public class Viagem
{
    /** Variaveis de Instância */
    //Localizacao inicial da viagem
    private Point2D localizacaoInicial;
    //Localizacao do destino da viagem
    private Point2D localizacaoDestino;
    //Velocidade media da viagem
    private double velocidade;
    //Preco a pagar pela viagem
    private double precoviagem;

    /**
     * Cria uma instância de cliente
     *
     */
    public Viagem(){
        this.localizacaoInicial = new Point2D.Double(0,0);//incia a 0
        this.localizacaoDestino = new Point2D.Double(0,0);//inicia a 0
        this.velocidade = 0;
        this.precoviagem = 0;
    }

    /**
     * Construtor por cópia.
     * @param v
     */
    public Viagem(Viagem v) {
        this.localizacaoInicial = v.getLocalizacaoInicial();
        this.localizacaoDestino = v.getLocalizacaoDestino();
        this.velocidade = v.getVelocidade();
        this.precoviagem = v.getPrecoviagem();
    }

    /**
     * Construtor por parametro
     * @param localizacaoInicial
     * @param localizacaoDestino
     * @param velocidade
     * @param precoviagem
     */
    public Viagem(Point2D localizacaoInicial, Point2D localizacaoDestino, double velocidade, double precoviagem) {
        this.localizacaoInicial = localizacaoInicial;
        this.localizacaoDestino = localizacaoDestino;
        this.velocidade = velocidade;
        this.precoviagem = precoviagem;
    }

    public Point2D getLocalizacaoInicial() {
        return localizacaoInicial;
    }

    public void setLocalizacaoInicial(Point2D localizacaoInicial) {
        this.localizacaoInicial = localizacaoInicial;
    }

    public Point2D getLocalizacaoDestino() {
        return localizacaoDestino;
    }

    public void setLocalizacaoDestino(Point2D localizacaoDestino) {
        this.localizacaoDestino = localizacaoDestino;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getPrecoviagem() {
        return precoviagem;
    }

    public void setPrecoviagem(double precoviagem) {
        this.precoviagem = precoviagem;
    }

    /**
     * Compara a igualdade com outro objecto
     * @param obj
     * @return
     */
    public boolean equals (Object obj) {
        boolean result = super.equals(obj);
        if (result == false) return false;
        Viagem v = (Viagem)obj;
        return (this.localizacaoInicial.equals(v.getLocalizacaoInicial()) && this.localizacaoDestino.equals(v.getLocalizacaoDestino()) && this.precoviagem == v.getPrecoviagem() && this.velocidade == v.getVelocidade());
    }

    /**
     * Devolve uma cópia desta instância
     * @return
     */
    public Viagem clone(){
        return new Viagem(this);
    }


    /**
     * Devolve uma representação no formato textual
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Incio da Viagem:").append(localizacaoInicial).append("'\n");
        sb.append("Destino da Viagem:").append(localizacaoDestino).append("'\n");
        sb.append("Velocidade media:").append(velocidade).append("'\n");
        sb.append("Preco da viagem:").append(precoviagem).append("'\n");
        return sb.toString();
    }

/* funcoes por fazer

    public Viagem (Point2D localizacaoInicial, Point2D localizacaoDestino, double velocidade){
        
    }*/
    
    public double getDistancia(){
        double x1 = localizacaoInicial.getX();
        double x2 = localizacaoDestino.getX();
        double y1 = localizacaoInicial.getY();
        double y2 = localizacaoDestino.getY();
        double distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return distancia;
    }
    
    public double tempoViagem(){
        return getDistancia()/velocidade;
    }
}