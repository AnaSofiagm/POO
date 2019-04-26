import java.util.Date;

public abstract class Ator
{
    // variáveis de instância 
    // email do ator
    private String email;
    // nome do ator
    private String nome;
    // password do ator
    private String password;
    // morada do ator
    private String morada;
    // data de nascimento do ator
    private Date datanascimento;
    
     /**
     * Cria uma instância de hotel
     */
    public Ator(){
        this.email = "n/a";
        this.nome = "n/a";
        this.password = "n/a";
        this.morada = "n/a";
        this.datanascimento = new Date();
    }
    
    /**
     * Construtor por cópia.
     * @param a 
     */
    public Ator(Ator a) {
        this.email = a.getEmail();
        this.nome = a.getNome();
        this.password = a.getPassword();
        this.morada = a.getMorada();
        this.datanascimento = a.getDataNascimento();
    }
     /**
     * Construtor por parametro
     * @param email
     * @param nome
     * @param password
     * @param morada
     * @param datanascimento
     */
    public Ator(String email, String nome, String password,String morada,Date datanascimento){
        this.email = email;
        this.nome = nome;
        this.password = password;
        this.morada = morada;
        this.datanascimento = datanascimento;
    }
    
    /**
     * Obter o email do ator
     * @return 
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * Definir o email do ator
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obter o nome do ator
     * @return 
     */
    public String getNome() {
        return nome;
    }

    /**
     * Definir o nome do ator
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
      /**
     * Obter a password do ator
     * @return 
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * Definir a passowrd do ator
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
     /**
     * Obter a morada do ator
     * @return 
     */
    public String getMorada() {
        return morada;
    }
    
    /**
     * Definir a morada do ator
     * @param morada
    */
    public void setMorada(String morada) {
        this.morada = morada;
    }
    
    /**
     * Obter a data de nascimento do ator
     * @return 
    */
    public Date getDataNascimento() {
        return datanascimento;
    }
    
    /**
     * Definir a data de nascimento do ator
     * @param datanascimento
    */
    public void setDataNascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }
    
    
    /**
     * Compara a igualdade com outro objecto
     * @param obj
     * @return 
    */
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Ator a = (Ator) obj;
        return a.getEmail().equals(email) && a.getNome().equals(nome) && 
                a.getPassword().equals(password) && a.getDataNascimento() == datanascimento;
    }
    
    /**
     * Devolve uma representação no formato textual
     * @return 
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ator:").append(nome).append("'\n");
        sb.append("Email:").append(email).append("'\n");
        sb.append("Password:").append(password).append("'\n");
        sb.append("Morada:").append(morada).append("'\n");
        sb.append("Data de Nascimento:").append(datanascimento).append("'\n");
        return sb.toString();
    }
    
    /**
     * Devolve uma cópia desta instância
     * @return 
     */
    public abstract Ator clone();

   
}

