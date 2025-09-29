package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {
	private static final Scanner leia = new Scanner(System.in); // para que ele não seja
	// modificado e que seja uma constante
	// e será usado por todos os métodos usados dentro da classe
	private static final ContaController contaController = new ContaController();

	public static void main(String[] args) {

		int opcao;

		criarContasTeste();

		while (true) {

			System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_WHITE_BACKGROUND + "*********************************");
			System.out.println("                Sagitauros             ");
			System.out.println("          Banco amigo de todos         ");
			System.out.println("*****************************************");
			System.out.println("                                         ");
			System.out.println("      1- Criar conta                     ");
			System.out.println("      2- Listar todas as contas          ");
			System.out.println("      3- Buscar conta por número         ");
			System.out.println("      4- Atualizar dados                 ");
			System.out.println("      5- Apagar conta                    ");
			System.out.println("      6- Sacar                           ");
			System.out.println("      7- Depositar                       ");
			System.out.println("      8- Transferir valores              ");
			System.out.println("      9- Procurar conta por nome titular ");
			System.out.println("      0- Sair                            ");
			System.out.println("*****************************************");
			System.out.println(" Selecione a opção desejada:             ");

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("Digite um número entre 0 e 8");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println("banco Sagitaurus agradece a preferencia! ");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println("Criar uma conta\n\n");
				cadastrarConta();
				KeyPress();
				break;
			case 2:
				System.out.println("A listagem das contas é:\n\n");

				listarContas(); // adicionado la no final do código com o void

				KeyPress();
				break;
			case 3:
				System.out.println("Buscar conta por número\n\n");

				procurarContaPorNumero();

				KeyPress();
				break;
			case 4:
				System.out.println("Atualizar dados\n\n");
				
				atualizarConta();
				
				KeyPress();
				break;
			case 5:
				System.out.println("Apagar conta\n\n");

				deletarConta();

				KeyPress();
				break;
			case 6:
				System.out.println("Saque\n\n");
				
				sacar();

				KeyPress();
				break;
			case 7:
				System.out.println("Deposito\n\n");
				
				depositar();

				KeyPress();
				break;
			case 8:
				System.out.println("Transferir entre contas\n\n");
				transferir();

				KeyPress();
				break;
			case 9:
				System.out.println("Procurar pelo titular da conta\n\n");
				
				procurarPorTitular();

				KeyPress();
				break;
			default:
				System.out.println("Opção invalida!");
				KeyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println(Cores.TEXT_PURPLE + Cores.ANSI_WHITE_BACKGROUND + "*********************************");
		System.out.println("Projeto desenvolvido por:        ");
		System.out.println("Geovana Cazali da Silva          ");
		System.out.println("*********************************");
	}

	public static void KeyPress() {
		System.out.println(Cores.TEXT_RESET + "\n Pressione enter para continuar...");
		leia.nextLine();
	}

	private static void criarContasTeste() {
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController
				.cadastrar(new ContaPoupanca(contaController.gerarNumero(), 280, 2, "Geovana Cazali", 1500000.00f, 24));
	}

	private static void listarContas() {
		contaController.listarTodas();
	}

	private static void cadastrarConta() {// metodo do cadastro de conta
		System.out.println("Digite o número da Agência: ");
		int agencia = leia.nextInt();

		System.out.println("Digite o nome do titular: ");
		leia.skip("\\R");
		String titular = leia.nextLine();

		System.out.println("Digite o tipo da conta(1- CC | 2- CP): ");
		int tipo = leia.nextInt();

		System.out.println("Digite o saldo inicial: ");
		float saldo = leia.nextFloat();

		switch (tipo) {
		case 1 -> {
			System.out.println("Digite o limite inicial: ");
			float limite = leia.nextFloat();
			leia.nextLine();
			contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 -> {
			System.out.println("Digite o dia do aniversário da conta: ");
			int aniversario = leia.nextInt();
			leia.nextLine();
			contaController.cadastrar(
					new ContaPoupanca(contaController.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		}
		default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválido" + Cores.TEXT_RESET);
		}
	}

	private static void procurarContaPorNumero() { // para exibir os dados da conta pelo número
		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		contaController.procurarPorNumero(numero);
	}

	private static void deletarConta() { // para excluir os dados da conta pelo número
		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		Conta conta = contaController.buscarNaCollection(numero);
		if (conta != null) {// aqui já abre a opção para checar se a conta existe,. caso ela não exista ela
							// nem passa pelos dados após.

			System.out.print("\nTem certeza que deseja excluir esta conta? (S/N): ");
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S")) {// confirmar se a pessoa quer excluir ou não, não precisa
													// necessariamente
				contaController.deletar(numero);
			} else {
				System.out.println("\nOperação cancelada!"); // se der não ou outra tecla não executa o deletar.
			}
		} else { // essa parte é parte da verificação se a conta existe ou não, se não existe
					// essa é a saída
			System.out.printf("\nO número da conta %d não encontrado!", numero);
		}
	}

	private static void atualizarConta() {
		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		Conta conta = contaController.buscarNaCollection(numero);
		
		if (conta != null) {
			

			int agencia =conta.getAgencia();
			String titular = conta.getTitular();
			int tipo = conta.getTipo();
			float saldo = conta.getSaldo();
			
			System.out.printf("A agencia atual: %d\nNova Agência (Precione ENTER para manter a agência atual)", agencia);
			String entrada = leia.nextLine();
			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada); // a interrogação é como se fosse um if o que diz que vai mudar ou não se não for vazio
	     //isto é a conversão de dados î // if ternario é a interrogação
		
			System.out.printf("O titular atual é: %s%nNovo titular: (Precione ENTER para manter o limite atual)", titular);
			entrada = leia.nextLine();
			titular = entrada.isEmpty() ? titular : entrada; 


			System.out.printf("Digite o saldo atual é: %.2f%nNovo saldo (Precione ENTER para manter o limite atual)", saldo);
			entrada = leia.nextLine();
			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada); 
		
			switch (tipo) {
			case 1 -> {
				float limite = ((ContaCorrente) conta).getLimite(); // precisa fazer isso para concetar a conta corrente aqi, mas precisa ser herdado de conta.
				System.out.printf("Digite o limite atual é: %.2f%nNovo limite (Precione ENTER para manter o limite atual)", limite);
				entrada = leia.nextLine();
				limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada);
				contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
			}
			case 2 -> {
				
				int aniversario = ((ContaPoupanca) conta).getAniversario();
				
				System.out.println("O dia atual do aniversário da conta é: %.2f%nNovo aniversario (Precione ENTER para manter o limite atual)" + aniversario);
				entrada = leia.nextLine();
				aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada);
				contaController.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
			}
			default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválido" + Cores.TEXT_RESET);
			}
			
		}else {
			System.out.printf("\nO número da conta %d não encontrado!", numero);
		}
	}
	private static void sacar() {
		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		System.out.println("Digite o valor do saque: ");
		float valor = leia.nextFloat();
		leia.nextLine();
		contaController.sacar(numero, valor);
	}
	private static void depositar() {
		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();
		
		System.out.println("Digite o valor do depósito: ");
		float valor = leia.nextFloat();
		leia.nextLine();
		contaController.depositar(numero, valor);
	}
	private static void transferir() {
		System.out.println("Digite o número da conta de origem: ");
		int numeroOrigem = leia.nextInt();
		leia.nextLine();
		
		System.out.println("Digite o número da conta de destino: ");
		int numeroDestino = leia.nextInt();
		leia.nextLine();
		
		System.out.println("Digite o valor da tranferência: ");
		float valor = leia.nextFloat();
		leia.nextLine();
		
		contaController.transferir(numeroOrigem, numeroDestino, valor);
	}
	private static void procurarPorTitular() { // aqui pode ser fiderente do nome abaixo, importante que esse será usado no menu
		System.out.println("Digite o nome do titular da conta: ");
		String titular = leia.nextLine();
		contaController.listarPorTitular(titular);
	}
}
