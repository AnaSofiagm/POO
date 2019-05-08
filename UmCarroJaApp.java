import java.lang.*;
import Exceptions.*;
import java.io.*;
import java.util.*;
import java.awt.geom.Point2D;


public class UmCarroJaApp
{
    // variáveis de instância
    private static UmCarroJa atual;
    private static int comando;
    
    /**
     * Não interessa o construtor de UmCarroJaApp
     */
    private UmCarroJaApp() {}
    
    public static UmCarroJa getAtual() {
        return atual;
    }
    
    /**
     * Função responsável por fazer correr o programa
     */
    public static void main(String[] args) {
        carregarDados();
        atual.setOnline(false);
        runApp();
        saida();
    }
    
     private static void carregarDados() {
        try {
            atual = UmCarroJa.leObj("estado.tabemp");
        }
        catch (IOException e) {
            System.out.println("Não consegui ler os dados!\nErro de leitura.");
            atual = initApp();
        } 
        catch (ClassNotFoundException e) {
            System.out.println("Não consegui ler os dados!\nFicheiro com formato desconhecido.");
            atual = initApp();
        }
        catch (ClassCastException e) {
            System.out.println("Não consegui ler os dados!\nErro de formato."); 
            atual = initApp();
        }
    }
    
     /**
     * Função que insere utilizadores na aplicação
     */
    public static UmCarroJa initApp() {
        UmCarroJa nova = new UmCarroJa();
        Proprietario admin = (Proprietario)nova.getAdmin();
        int i;
        try {
            nova.registarUtilizador(admin);
            // email,nome, password, morada,data de nascimento
            Date d1 = new Date(10,11,1996);
            Proprietario p1 = new Proprietario("esmeralda@email.com","Esmeralda Fernandes", "esmeralda", "Rua da Universidade, N.º 1",d1, 10);
            nova.registarUtilizador(p1);
            Date d2 = new Date (03,02,2000);
            Proprietario p2 = new Proprietario("diogo@email.com","Diogo Machado","diogo", "Rua do Paraíso, N.º 2", d2, 29);
            nova.registarUtilizador(p2);
            Date d3 = new Date (24,05,2001);
            Proprietario p3 = new Proprietario("miguel@email.com", "Miguel Miranda", "miguel", "Travessa dos Machados, N.º 3", d3, 54);
            nova.registarUtilizador(p3);
            Date d4 = new Date (29,07,1994);
            Proprietario p4 = new Proprietario("rui@email.com", "Rui Leite", "rui", "Rua dos Peões, N.º4", d4, 99);
            nova.registarUtilizador(p4);
            Date d5 = new Date (23,06,1995);
            Point2D po1;
            Cliente c1 = new Cliente("maria@email.com", "Maria Almeida", "maria", "Rua das Árvores, N.º5", d5, po1);
            nova.registarUtilizador(c1);
            Point2D po2;
            Date d6 = new Date (14,05,1996);
            Cliente c2 = new Cliente("anamarques@email.com" , "Ana Marques", "ana", "Rua das Árvores, N.º4", d6,po2);
            nova.registarUtilizador(c2);
            Point2D po3;
            Date d7 = new Date (11,01,1993);
            Cliente c3 = new Cliente("nadine@email.com" , "Nadine Oliveira", "nadine", "Rua dos Outeiros, N.º15", d7,po3);
            nova.registarUtilizador(c3);
            Point2D po4;
            Date d8 = new Date (02,04,1994);
            Cliente c4 = new Cliente("nira@email.com", "Nira Fernandes", "nira", "Avenida de Brasil, N.º7", d8,po4);
            nova.registarUtilizador(c4);
            
            nova.fechaSessao();
            nova.iniciaSessao("rui@email.com", "rui");
           
            nova.fechaSessao();
            nova.iniciaSessao("diogo@email.com", "diogo");
            
            nova.fechaSessao();
            nova.iniciaSessao("nira@email.com", "nira");
           
            for (i = 0; i < 100; i++) {
                Proprietario a = new Proprietario("@email.com " + Integer.toString(i), "proprietario" + Integer.toString(i), "p" + Integer.toString(i), "Rua " + Integer.toString(i), 12 + Integer.toString(i));
                nova.registarUtilizador(a);
                Cliente b = new Cliente("Cliente " + Integer.toString(i), "c" + Integer.toString(i) + "@email.com", "c" + Integer.toString(i), "Rua " + Integer.toString(i), Integer.toString(i));
                nova.registarUtilizador(b);
               
                nova.fechaSessao();
                nova.iniciaSessao(b.getEmail(), b.getPassword());
               
            }
        }
        catch(UtilizadorExisteException e) {
            System.out.println(e.getMensagem());
        }
       
        catch(SemAutorizacaoException e) {
            System.out.println(e.getMensagem());
        }
        
        return nova;
    }
    
    /**
     * Funções de impressão de cabeçalhos e menus
     */
    private static void cabecalho() {
        System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("|                                                                            |");
        System.out.println("|                                UmCarroJa                                   |");
        System.out.println("|                                                                            |");
        System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
    }
    private static void saida() {
        limpaTerminal();
        System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
        System.out.println("|                                                                           |");
        System.out.println("| Ana Sofia Gomes Marques                                                   |");
        System.out.println("|                                                                           |");
        System.out.println("|                              PROGRAMA ENCERRADO                           |");
        System.out.println("|                                                                           |");
        System.out.println("  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
    }
    
    /**
     * Função que verifica se um email é válido, sintaticamente
     */
    private static boolean emailValido(String email) {
        if (!email.contains("@") || !email.contains(".")) return false;
        return true;
    }
    
    /**
     * Função responsável por passar os parâmetros de inicio de sessão (verifica se o email é válido)
     */
    private static boolean iniciaSessaoIO() throws SemAutorizacaoException {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.print("Email: ");
        String email = input.next();
        if (!emailValido(email)) return false;
        if (!atual.getUtilizadores().containsKey(email)) return false;
        System.out.print("Password: ");
        String password = input.next();
        atual.iniciaSessao(email, password);
        return true;
    }
    
    /**
     * Função responsável por passar os parâmetros de registo de utilizador
     */
    private static void registoUserIO() throws UtilizadorExisteException {
        limpaTerminal();
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.println("REGISTO DE UTILIZADOR\n");
        Utilizador novo;
        
        String tipo, nome, email, password, morada;
        Date dataN;
        int classif;
        Point2D loc = new Point2D();
        
        System.out.println("Pretende registar-se como Proprietario(P) ou Cliente(C)?");
        tipo = input.next();
        
        System.out.print("Nome: ");
        nome = input.next();
        
        System.out.print("Email: ");
        email = input.next();
        
        System.out.print("Password: ");
        password = input.next();
        
        System.out.print("Morada: ");
        morada = input.next();
        
        int ano, mes, dia;
        System.out.print("Data de nascimento: Ano :");
        ano = input.nextInt();
        System.out.print("Data de nascimento: Mes :");
        mes = input.nextInt();
        System.out.print("Data de nascimento: Dia :");
        dia = input.nextInt();
        dataN = new Date(ano, mes, dia);
        
        System.out.print("Classificação: ");
        classif = input.nextInt();
        
        int x, y;
        System.out.print("Localização: X : ");
        x = input.nextInt();
        System.out.print("Localização: Y : ");
        y = input.nextInt();
        loc.setLocation(x, y); 
        
        if (tipo.equals("P")) novo = new Proprietario(nome, email, password, morada, dataN, classif);
        else novo = new Cliente(nome, email, password, morada, dataN,loc);
        atual.registarUtilizador(novo);
    }
    
 
    
    /**
     * Função responsável por criar um novo comando inteiro
     */
    private static int novoComandoInt() {
        System.out.print("-- Insira o comando: ");
        Scanner input = new Scanner(System.in);
        return (input.nextInt());
    }
    
    private static void voltar() {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.print("-- Insira 0 para voltar. ");
        if (input.nextInt() == 0) return;
    }
    
    /**
     * Função de impressão do menu principal
     */
    private static void menu_principal() {
        System.out.println("(1) - Iniciar sessão");
        System.out.println("(2) - Fazer registo\n");
        System.out.println("(3) - Mais opções\n");
        System.out.println("(4) - Guardar estado do programa");
        System.out.println("(0) - Sair\n");
    }
    
    /**
     * Função responsável por lançar o menu principal
     */
    private static void runApp() {
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        boolean run = true;
        while (run) {
            limpaTerminal();
            cabecalho();
            menu_principal();
            try {
                comando = novoComandoInt();
                switch (comando) {
                    case 0: // sair
                        run = false;
                        break;
                    case 1: // iniciar sessão
                        boolean result = iniciaSessaoIO();
                        while (!result) {
                            System.out.println("A autenticação falhou. Verifique se introduziu um email válido.\n Pretende tentar de novo?     S | N");
                            String d = input.next();
                            if (d.equals("S")) result = iniciaSessaoIO();
                            else break;
                        }
                        /*if (result) {
                            if (atual.temAutorizacao("Vendedor")) interpretadorC();
                            else interpretadorV();
                        }*/
                        break;
                    case 2: // registar um utilizador
                        registoUserIO();
                        break;
       
                    case 4: // guardar estado do programa
                        atual.gravaObj("estado.tabemp");
                        atual.log("log.txt", true);
                        voltar();
                        break;
                }
            }
            catch(SemAutorizacaoException e) {
                System.out.println(e.getMensagem());
                voltar();
            }
            catch(UtilizadorExisteException e) {
                System.out.println(e.getMensagem());
                voltar();
            }
            catch (ClassNotFoundException e) {
                System.out.println(e.getCause());
                voltar();
            }
            catch (InputMismatchException e) {
                System.out.println(e.getCause());
                voltar();
            }
            catch (EstadoInvalidoException e) {
                System.out.println(e.getMensagem());
                voltar();
            }
            catch (IOException e) {
                System.out.println("Não consegui gravar os dados!");
                voltar();
            }
            // por viagem terminada ou aluguer terminado
        }
    }
    
    
    
    
    
    /**
     * Função responsável por limpar o terminal
     */
    public static void limpaTerminal() {
        for (int i = 0; i < 20; i++) System.out.println("");
    }

}
