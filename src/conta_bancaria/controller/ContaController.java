package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository{ // vai reclamar no ContaController
	//e vai vamos trazer ele através da primeira sugestão, ->addunimplementedmetods.
	
	//Precisa fazer isso para 
    private List<Conta> listaContas = new ArrayList<Conta>();
    int numero =0;
	
	@Override
	public void listarTodas() {// para dar essa opção la no menu precisa deste 
		for(var conta: listaContas) {
			conta.visualizar();
		}
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("Conta Cadastrada com sucesso!");
		
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub
		
	}
	
	

}
