package Exceptions;



public class UtilizadorInexistenteException extends Exception
{

    /**
     * Construtores
     */
    public UtilizadorInexistenteException(){
        super();
    }
    public UtilizadorInexistenteException(String mensagem){
        super(mensagem);
    }
    public String getMensagem() {
        return "Esse utilizador não existe!\n";
    }

}
