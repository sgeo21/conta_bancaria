package conta_bancaria.model;

public class Conta {

	
		// Atributos de class
// 5 atribustos da classe conta - quando for usar aa conta sempre vai
	//precisar passar por essas 5 caracteristicas basicas da conta.
	
		private int numero;
		private int agencia;
		private int tipo;
		private String titular;
		private float saldo;
		
		//implementar método construtor da classe - parametros são os 
				//5 parametros anteriores
		public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
			this.numero = numero;
			this.agencia = agencia;
			this.tipo = tipo;
			this.titular = titular;
			this.saldo = saldo;
			//î aqui o código diz que cada coisa que o usuário digitar ele vai guardar
		}
		// Métodos Get e Set - para permitir que de outras classes eu consiga acessar o valor que esta em um atributo
				//set é para alterar o que esta dentro do objeto

		public Conta() {} //criar um parametro vazio, isso é uma 'sobrecarga de método'
		//poderia ser utilizado para caso queira adicionar um objeto dele depois
		//quando quer ter opções para situações que pedem variações do método
		
		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public int getAgendia() {
			return agencia;
		}

		public void setAgendia(int agencia) {
			this.agencia = agencia;
		}

		public int getTipo() {
			return tipo;
		}

		public void setTipo(int tipo) {
			this.tipo = tipo;
		}

		public String getTitular() {
			return titular;
		}

		public void setTitular(String titular) {
			this.titular = titular;
		}

		public float getSaldo() {
			return saldo;
		}

		public void setSaldo(float saldo) {
			this.saldo = saldo;
			// se não criar esse metodo não consegue alterar os dados.
		}
		//aqui é para criar os dados de saque
		public boolean sacar(float valor) {
			if(this.saldo<valor) { //se o saldo for insuficiente
				System.out.println("\nSaldo insulficiente");
				return false;
			}
			this.saldo = this.saldo - valor; // se o saldo for suficiente
			return true; //para retornar em saque 
			}
		public void depositar(float valor) {
			this.saldo = this.saldo + valor; // se o saldo for suficiente//para retornar em saque 
			}
		public void visualizar() {
           String tipo = " ";
			
			switch(this.tipo) {
			case 1 -> tipo = "conta corrente";
			case 2 -> tipo = "conta poupança";
			default -> tipo = "Desconhecido";
			
			}
			
			System.out.printf("\n*********************");
			System.out.printf("Dados da conta");
			System.out.printf("*********************\n");
			System.out.printf("Número da conta: %d%n", this.numero);
			System.out.printf("Número da Agencia: %d%n", this.agencia);
			System.out.printf("Número do tipo: %s%n", tipo);
			System.out.printf("Nome da titular: %s%n", this.titular);
			System.out.printf("Saldo da conta: %.2f%n", this.saldo);
		
			
			}
		

		}
		
	
