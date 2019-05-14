import java.util.ArrayList;
import java.util.List;

public class ListVeiculos {

    private List<Veiculo> listveiculo;

    /**
     * Cria uma instância de ListVeiculos
     */
    ListVeiculos() {
        this.listveiculo = new ArrayList<>();
    }

    /**
     * Construtor por cópia.
     * @param lv
     */
    ListVeiculos(ListVeiculos lv) {
        this.listveiculo = lv.getListveiculo();
    }

    /**
     * Construtor por parametro
     * @param lv
     */
    ListVeiculos(List<Veiculo> lv){
        this.listveiculo = lv;
    }

    public List<Veiculo> getListveiculo() {
        return listveiculo;
    }

    /**
     * Adiciona um veículo à Lista de veículos
     * @param v
     */
    public void addtoListVeiculos(Veiculo v) {
        this.listveiculo.add(v);
    }
}