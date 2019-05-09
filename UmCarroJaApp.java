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
            atual = UmCarroJa.leObj("logsPOO_carregamentoInicial");
        }
        catch (IOException e) {
            System.out.println("Não consegui ler os dados!\nErro de leitura.");
        } 
        catch (ClassNotFoundException e) {
            System.out.println("Não consegui ler os dados!\nFicheiro com formato desconhecido.");
        }
        catch (ClassCastException e) {
            System.out.println("Não consegui ler os dados!\nErro de formato."); 
        }
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
        
        System.out.println("Pretende registar-se como Proprietario(P) ou Cliente(C)?");
        tipo = input.next();
        
        System.out.print("Nome: ");
        nome = input.next();
        
        System.out.print("Nif: ");
        int nif = input.nextInt();
        
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
        
        double x, y;
        System.out.print("Localização: X : ");
        x = input.nextDouble();
        System.out.print("Localização: Y : ");
        y = input.nextDouble();
        Point2D loc = new Point2D.Double();
        loc.setLocation(x,y); 
        
        if (tipo.equals("P")) novo = new Proprietario(nome,nif, email, password, morada, dataN, classif);
        else novo = new Cliente(nome,nif, email, password, morada, dataN,loc);
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
            /*catch (ClassNotFoundException e) {
                System.out.println(e.getCause());
                voltar();
            }*/
            catch (InputMismatchException e) {
                System.out.println(e.getCause());
                voltar();
            }
            /*catch (EstadoInvalidoException e) {
                System.out.println(e.getMensagem());
                voltar();
            }*/
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
