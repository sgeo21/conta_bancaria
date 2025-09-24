package conta_bancaria.model;

public class ContaCorrente extends Conta { // java não herda mais de uma classe.
		// TODO Auto-generated constructor stub

// o extends a classe conta em herança.
	private float limite;
	//o tipo de ação expesifica deste tipo de copnta
	// precisa receber as ações da herança antes de dar certo!// para criar passar o 
	//o mouse sobre a class (no caso contacorrente) e addatributos.
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {   //não esquececer de colocar o novo parametro aqui
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
		// nesta etapa tem que adicionar o atributo desta classe. 
		//fazer os getsets em "- source -> generate getters setters."
		//assim repete o código sem necessáriamente precisar repetir. 
      }

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	@Override
	public boolean sacar(float valor) {
		if(this.getSaldo() + this.getLimite() <valor) { //se o saldo for insuficiente com a conta corrente
			System.out.println("\nSaldo insulficiente");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor); // se o saldo for suficiente
		return true; //para retornar em saque 
		}
	
	@Override //dizendo que este metodo é uma sobescrita do método. (pegando algo que ja existe e colocado aqui)
	public void visualizar() { // criar o vizualizar quando o objeto é de cc
		super.visualizar(); // trazer a estrutura do método pra ca. Atraves de polimorfismo
		System.out.printf("Limite da conta: R$ %.2f%n", this.limite); // adiciona uma nova saída de dados
	}
	
}