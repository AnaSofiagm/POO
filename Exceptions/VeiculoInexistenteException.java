package Exceptions;


public class VeiculoInexistenteException extends Exception{

    /**
     * Construtores
     */
    public VeiculoInexistenteException(){
        super();
    }
    public VeiculoInexistenteException(String mensagem){
        super(mensagem);
    }
    public String getMensagem() {
        return "Este veiculo não existe!\n";
    }
}

