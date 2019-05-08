package Exceptions;


public class UtilizadorExisteException extends Exception
{
    /**
     * Construtores
     */
    public UtilizadorExisteException(){
        super();
    }
    public UtilizadorExisteException(String mensagem){
        super(mensagem);
    }
    public String getMensagem() {
        return "Esse utilizador já existe!\n";
    }
}
