import java.lang.*;
import java.util.*;
import java.io.*;
import Exceptions.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.joining;

public class UmCarroJa implements Serializable
{
    // variáveis de instância
    private Map<String, Utilizador> utilizadores; // Chave == email
    private String atualUser;
    private boolean online;
    private int count;
    private Proprietario admin;
    /**
     * Construtores para objetos da classe UmCarroJa
     */
    public UmCarroJa() {
        this.utilizadores = new TreeMap<>();
        this.atualUser = "admin@email.com";
        this.online = false;
        this.count = 0;
        Date d = new Date(12,12,1992);
        this.admin = new Proprietario("admin@email.com", "admin", "a123", "n/a", d, 12);
    }
    
    /**
     * Método que permite saber se o utilizador atual ainda está online
     */
    public boolean estaOnline() {
        return this.online;
    }
    
  
    public void setOnline(boolean e) {
        this.online = e;
    }
    
    
      /**
     * Método de aceder ao utilizador atual
     */
    public String getAtualUser() {
        return this.atualUser;
    }
    
    /**
     * Métodos de instância da classe UmCarroJá
     */
    public Map<String, Utilizador> getUtilizadores() {
        Map<String, Utilizador> copia = new TreeMap<>();
        for (Map.Entry<String, Utilizador> e: utilizadores.entrySet())
            copia.put(e.getKey(), e.getValue().clone()); 
        return copia;
    }
    
    public int getCount() {
        return this.count;
    }
    
    public Utilizador getAdmin() {
        return this.admin;
    }
    
    public Utilizador getUtilizador(String email) {
        return this.utilizadores.get(email);
    }
    
    
    
    /**
     * Método que permite saber se o atual utilizador tem permissões de um dado tipo ("Vendedor" ou "Comprador")
     */
    public boolean temAutorizacao(String nomeClasse) {
        return (this.utilizadores.get(atualUser).getClass().getName().equals(nomeClasse));
    }
    
    public boolean existeUtilizador(Utilizador utilizador) {
        return (this.utilizadores.containsValue(utilizador));
    }
    public boolean existeUtilizador(String email) {
        return (this.utilizadores.containsKey(email));
    }
    
    
    /**
     * Função que inicia a sessao de um utilizador (o email que recebe é válido)
     */
    public void iniciaSessao(String email, String password) throws SemAutorizacaoException {
        if (password == null) throw new SemAutorizacaoException();
        Utilizador aux = getUtilizadores().get(email);
        if (!aux.getPassword().equals(password)) throw new SemAutorizacaoException();
        else {
            this.atualUser = email;
            this.online = true;
        }
    }
    
    /**
     * Função responsável por fechar a sessão do utilizador atual
     */
    public void fechaSessao() {
        this.online = false;
    }
    
    public void registarUtilizador(Utilizador utilizador) throws UtilizadorExisteException {
        if (existeUtilizador(utilizador)) throw new UtilizadorExisteException();
        this.utilizadores.put(utilizador.getEmail(), utilizador);
        System.out.println(utilizador.getNome() + ", " + utilizador.getClass().getName() + " registado com sucesso!");
    }
    
        public void gravaObj(String fich) throws IOException { 
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fich)); 
        oos.writeObject(this); 
        oos.flush(); 
        oos.close(); 
    } 

    public static UmCarroJa leObj(String fich) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fich));
        UmCarroJa te = (UmCarroJa)ois.readObject();
        ois.close();
        return te;
    }
    
     public void log(String f, boolean ap) throws IOException {
        FileWriter fw = new FileWriter(f, ap);
        fw.write("\n----------- LOG - LOG - LOG - LOG - LOG ----------------\n");
        fw.write(this.toString());
        fw.write("\n----------- LOG - LOG - LOG - LOG - LOG ----------------\n");
        fw.flush();
        fw.close();
    }
}
