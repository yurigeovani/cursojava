package cursojava.basico.aula43.exercicios.exercicio01;

public class ContaPoupanca extends ContaBancaria {
	
	private double diaRendimento;
	private boolean existe = false;
	
	public ContaPoupanca(double diaRendimento) {
		super();
		this.diaRendimento = diaRendimento;
	}
	
	public ContaPoupanca() {
		super();
	}
	public ContaPoupanca(String nomeCliente, int numConta, double saldo) {
		super(nomeCliente, numConta, saldo);
	}

	public double getDiaRendimento() {
		return diaRendimento;
	}
	public void setDiaRendimento(double diaRendimento) {
		this.diaRendimento = diaRendimento;
	}
	public boolean isExiste() {
		return existe;
	}
	public void setExiste(boolean existe) {
		this.existe = existe;
	}
	
	public void calcularNovoSaldo() {
		super.setSaldo(super.getSaldo()*getDiaRendimento());
	}
}