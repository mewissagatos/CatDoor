import java.util.Scanner;
public class CatDoor {
    public static void main(String[] args){
        boolean p = false, q = false, r = false, s = true;
        // coleira detectada? esta no horario? dono abriu? gato dentro?
        Scanner sc = new Scanner(System.in);
        boolean rodando = true;
        while(rodando){
            System.out.println("\n•┈୨ Porta Inteligente para Gatos ୧┈•");
            System.out.println("[1] Simular chegada do gatinho!");
            System.out.println("[2] Ligar/Desligar horario permitido.");
            System.out.println("[3] Dono abre/fecha manualmente... ");
            System.out.println("[4] Estado atual.");
            System.out.println("[5] Sair\n");
            int opcao = 0;
            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
            } else {
                sc.next(); // descarta o texto invalido, se nao quebrava o programa
                System.out.println("Digite apenas numeros de 1 a 5!");
            }
            switch (opcao){
                case 1:
                    p = true; //gato chegou!
                    boolean pEntra = r || (p && !s && q); //proposiçao de entrada
                    boolean pSai = r || (p && s && q); //proposiçao de saida
                    if (pEntra && !s) {
                        s = true;
                        System.out.println("ฅ₍ᓀ‸ᓂマ ੭♪ \nGatinho Dentro!");
                        if (r) System.out.println("(Porta aberta pelo dono!)");
                    } else if (pSai && s) {
                        s = false;
                        System.out.println("Gatinho foi explorar! \n(ˆつ⩊⊂ˆ)੭ Tchau Gatinho!");
                        if (r) System.out.println("(Porta aberta pelo dono!)");
                    } else {
                        System.out.println("Porta Negada.");
                        if (!q) System.out.println("Fora do horario permitido.");
                        }
                    p = false; //sensor reseta
                    break;
                case 2:
                    q = !q; //inverte o horario
                    if(q){
                        System.out.println("ꕤ HORARIO PERMITIDO LIGADO! \nGatinho pode passear.");
                    }else{
                        System.out.println("ꕤ HORARIO PERMITIDO DESLIGADO! \nPorta bloqueada para Gatinho.");
                    }
                    break;
                case 3:
                    r = !r; //abre se estava fechado, fecha se estava aberto
                    if(r){
                        System.out.println("Dono ABRIU a porta! \nGatinho livre. =^.^=");
                    }else{
                        System.out.println("Dono FECHOU a porta! \nVoltando ao automatico...");
                    }
                    break;
                case 4:
                    System.out.println("\n•┈୨ Estado Atual ୧┈•");
                    System.out.println("꩜ Coleira detectada {p}: " + p);
                    System.out.println("꩜ Horario permitido {q}: " + q);
                    System.out.println("꩜ Dono abriu {r}:        " + r);
                    System.out.println("꩜ Gato dentro {s}:       " + s);
                    break;
                case 5:
                    rodando = false;
                    System.out.println("Encerrando...Tchau! =^.^= ");
                    break;
                default:
                    System.out.println("Invalida.");
            }
        }
    }
}
