package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {
	private static final Scanner leia = new Scanner (System.in); // para que ele não seja 
	//modificado e que seja uma constante 
	//e será usado por todos os métodos usados dentro da classe 
	private static final ContaController contaController = new ContaController();
	
	public static void main(String[] args) {
	
		
		int opcao;
		
		criarContasTeste();
		
		while (true) {
		
		System.out.println("*********************************");
		System.out.println("            Sagitauros           ");
		System.out.println("        Banco amigo de todos     ");
		System.out.println("*********************************");
		System.out.println("                                 ");
		System.out.println("      1- Criar conta             ");
		System.out.println("      2- Listar todas as contas ");
		System.out.println("      3- Buscar conta por número ");
		System.out.println("      4- Atualizar dados         ");
		System.out.println("      5- Apagar conta            ");
		System.out.println("      6- Sacar                   ");
		System.out.println("      7- Depositar               ");
		System.out.println("      8- Transferir valores      ");
		System.out.println("      0- Sair                    ");
		System.out.println("*********************************");
		System.out.println(" Selecione a opção desejada:     ");
	
		try {
			opcao = leia.nextInt();
			leia.nextLine();
		}catch (InputMismatchException e) {
			opcao = -1;
			System.out.println("Digite um número entre 0 e 8");
			leia.nextLine();
		}
		
		if (opcao == 0) {
			System.out.println("banco Sagitaurus agradece  ");
			sobre();
			leia.close();
			System.exit(0);
		}
		
			switch (opcao) {
		case 1:
			System.out.println("Criar uma conta \n\n");
			
			KeyPress();
			break;
		case 2:
			System.out.println("A listagem das contas é: \n\n");
			
			listarContas(); //adicionado la no0 final do código com o void
			
			KeyPress();
			break;
		case 3:
			System.out.println("Buscar conta por número \n\n");
			
			KeyPress();
			break;
		case 4:
			System.out.println("Atualizar dados \n\n");
			
			KeyPress();
			break;
		case 5:
		    System.out.println("Apagar conta \n\n");
		    
		    KeyPress();
			break;	
		case 6:
			System.out.println("Sacar \n\n");
			
			KeyPress();
			break;
		case 7:
			System.out.println("Depositar \n\n");
			
			KeyPress();
			break;
		case 8:
			System.out.println("Transferir valores \n\n");
			
			KeyPress();
			break;
			default:
			System.out.println("Opção invalida!");
			KeyPress();
			break;
			}
		}
    }
	public static void sobre(){
		System.out.println("*********************************");
		System.out.println("Projeto desenvolvido por:        ");
		System.out.println("Geovana Cazali da Silva          ");
		System.out.println("*********************************");
	}
	public static void KeyPress() {
		System.out.println(Cores.TEXT_RESET + "\n Pressione enter para continuar...");
		leia.nextLine();
	}
	
	private static void criarContasTeste() {
	contaController.cadastrar(new ContaCorrente(1, 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
	contaController.cadastrar(new ContaPoupanca(4, 280, 2, "Geovana Cazali", 1500000.00f, 24));
	}
	
	private static void listarContas() {
	contaController.listarTodas();
	
	}
}
