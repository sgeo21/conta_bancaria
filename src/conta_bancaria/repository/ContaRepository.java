package conta_bancaria.repository;

import conta_bancaria.model.Conta;

public interface ContaRepository {

	//Métodos do CRUD
	//métodods de consulta ( primeiras opções dp menu)
	public void listarTodas(); //1
	public void cadastrar(Conta conta); //2
	public void atualizar(Conta conta); //3
	public void procurarPorNumero (int numero); //4
	public void deletar(int numero); //5
	public void listarPorTitular(String titular);
	
	//Metodos Bancários, fazer as operações bancárias
	public void sacar(int numero, float valor); //6
	public void depositar(int numero, float valor); //7
	public void transferir(int numeroOrigem, int numeroDestino, float valor); //8
	
	//foram criados então precisam ser implementados
	//criar uma classe de controle - class controler
	
}
