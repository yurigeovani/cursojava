package cursojava.basico.aula33.exercicios.exercicio02;

public class ContaCorrente {

	private int numero;
	private int agencia;
	private double saldo;
	private double chequeEspecial;
	private double limite;
	private int operacao;
	private boolean validarOperacao;
	private boolean especial;
	
	public ContaCorrente() {
		this.especial = true;
		this.chequeEspecial = 1000;
		setLimite(getChequeEspecial()+getSaldo());
	}

	public ContaCorrente(int numero, int agencia, double saldo, boolean especial, double chequeEspecial,
			double limite) {
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = saldo;
		this.especial = especial;
		this.chequeEspecial = chequeEspecial;
		this.limite = limite;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getOperacao() {
		return operacao;
	}

	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}

	public boolean isValidarOperacao() {
		return validarOperacao;
	}

	public void setValidarOperacao(boolean validarOperacao) {
		this.validarOperacao = validarOperacao;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean isEspecial() {
		return especial;
	}

	public void setEspecial(boolean especial) {
		this.especial = especial;
	}

	public double getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	//lista as operações
	public void mostrarOperacao () {
		System.out.println("Operações disponíveis: ");
		System.out.println("1) Realizar saque");
		System.out.println("2) Realizar depósito");
		System.out.println("3) Verificar saldo");
		System.out.println("4) Verificar limite especial");
		System.out.println("5) Sair");
		
	}
	
	//valida a operação escolhida
	public void validarOperacao(int escolhaOperacao) {
		if(escolhaOperacao<1 || escolhaOperacao>5) {
			System.out.println("Operação indisponível!");
			setValidarOperacao(false);
		} else {
			setOperacao(escolhaOperacao);
			setValidarOperacao(true);
		}
	}
	
	public boolean realizarSaque(double valorSaque) {
		//verifica se tem saldo na conta
		if(valorSaque<=getSaldo()) {
			setSaldo(getSaldo()-valorSaque);
			System.out.println("Saque realizado com sucesso!"); // saque realizado
			return true;
		} else {
			//verifica se tem saldo em cheque especial
			if(isEspecial()) {
				if(valorSaque<=getLimite()) {
					setSaldo(getSaldo()-valorSaque);
					setLimite(getChequeEspecial()+getSaldo());
					System.out.println("Saque realizado com sucesso!"); // saque realizado
					System.out.println("Saldo: R$ " + getSaldo());
					System.out.println("Limite Especial: R$ " + getLimite());
					return true; // saque utilizando cheque especial
				} else {
					System.out.println("Operação não realizada! Saldo insuficiente!");
					System.out.println("Saldo: R$ " + getSaldo() );
					System.out.println("Limite Especial: R$ " + getLimite());
					return false; // não possui saldo em cheque especial
				}
			} else {
				System.out.println("Operação não realizada!");
				System.out.println("Saldo insuficiente e não possui cheque especial!");
				return false; // saque não realizado
			}
		}
	}

	public void realizarDeposito(double valorDeposito) {
		setSaldo(getSaldo()+valorDeposito);
	}
	
	public void consultarSaldo(){
		System.out.println("Saldo atual: R$ " + getSaldo());
	}
	
	public void verificarLimite() {
		if(isEspecial()) {
			setLimite(getChequeEspecial()+getSaldo());
			System.out.println("Limite Especial: R$ " + getLimite());
		} else {
			System.out.println("Não possui limite especial!");
		}
	}
}