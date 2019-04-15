import java.awt.geom.Point2D;
import java.util.Date;

public class Viagem
{
    private Point2D localizacaoInicial;
    private Point2D localizacaoDestino;
    private double velocidade;
    
    
    public Viagem (Point2D localizacaoInicial, Point2D localizacaoDestino, double velocidade){
        
    }
    
    public double getDistancia(){
        
    }
    
    public Date tempoViagem(){
        return getDistancia()/velocidade;
    }
}
