import java.awt.geom.Point2D;

public class Viagem
{
    private Point2D localizacaoInicial;
    private Point2D localizacaoDestino;
    private double velocidade;
    
    
    public Viagem (Point2D localizacaoInicial, Point2D localizacaoDestino, double velocidade){
        
    }
    
    public double getDistancia(){
        
    }
    
    public double tempoViagem(){
        return getDistancia()/velocidade;
    }
}
