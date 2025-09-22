package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;

public class Menu {

	public static void main(String[] args) {
	
		Scanner leia = new Scanner (System.in);
		int opcao;
		
		//Instanciador objetos da classe Conta
		
		Conta c1 = new Conta(1, 123, 1, "Cintia Dourado", 500000.00f);
		System.out.println("O saldo da conta é: " + c1.getSaldo());
		Conta c2 = new Conta(1, 124, 1, "Priscila Maia", 30000.00f);
		c1.setSaldo(600000.00f);
		System.out.println("O Saldoda conta é: " + c1.getSaldo());
		//visualizar para visualizar dados de uma forma completa incluido la no "conta". 
		c1.visualizar();
		c2.visualizar();
		
		System.out.println(c1.sacar(1000));
		System.out.println("O Saldoda conta é: " + c1.getSaldo());
		System.out.println(c2.sacar(50000));
		System.out.println("O Saldoda conta é: " + c2.getSaldo());
		
		c1.depositar(5000); //preciso criar
		System.out.println("O Saldoda conta é: " + c1.getSaldo());
		

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
		
		opcao = leia.nextInt();
		
			switch (opcao) {
		case 1:
			System.out.println("Criar uma conta \n\n");
			break;
		case 2:
			System.out.println("Listar todas as contas \n\n");
			break;
		case 3:
			System.out.println("Buscar conta por número \n\n");
			break;
		case 4:
			System.out.println("Atualizar dados \n\n");
			break;
		case 5:
		    System.out.println("Apagar conta \n\n");
			break;	
		case 6:
			System.out.println("Sacar \n\n");
			break;
		case 7:
			System.out.println("Depositar \n\n");
			break;
		case 8:
			System.out.println("Transferir valores \n\n");
			break;
		case 0:
			System.out.println("O banco Sagitauros agradece a sua preferencia \n\n");
			sobre();
			break;
			default:
			System.out.println("Opção invalida!");
			}
		
		
		leia.close();
  }}
	public static void sobre(){
		System.out.println("*********************************");
		System.out.println("Projeto desenvolvido por:        ");
		System.out.println("Geovana Cazali da Silva          ");
		System.out.println("*********************************");
	}
}
