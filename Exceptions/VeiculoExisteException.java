package Exceptions;


public class VeiculoExisteException extends Exception
{
    /**
     * Construtores
     */
    public VeiculoExisteException(){
        super();
    }
    public VeiculoExisteException(String mensagem){
        super(mensagem);
    }
    public String getMensagem() {
        return "Este veiculo já existe!\n";
    }
}
