import java.awt.geom.Point2D;
import java.util.TreeSet;
import java.util.Set;

public class Veiculo
{
    private TipoVeiculo tipo;
    private double velocidade;
    private double precoBaseKm;
    private double consumoKm;
    private Set<Aluguer> alugueresRealizados;
    private int classificacao;
    private Point2D localizacao;
    private double autonomiaMaxima;
    private double autonomiaAtual;
    private boolean disponibilidade;
    private Proprietario prop;
}