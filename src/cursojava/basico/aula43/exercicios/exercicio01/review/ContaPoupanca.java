package cursojava.basico.aula43.exercicios.exercicio01.review;

import java.util.Calendar;

public class ContaPoupanca extends ContaBancaria{

	private int diaRendimento;

	public int getDiaRendimento() {
		return diaRendimento;
	}
	public void setDiaRendimento(int diaRendimento) {
		this.diaRendimento = diaRendimento;
	}
	
	@Override
	public String toString() {
		return "ContaPoupanca [diaRendimento=" + diaRendimento + ", getNomeCliente()=" + getNomeCliente()
				+ ", getNumConta()=" + getNumConta() + ", getSaldo()=" + getSaldo() + "]";
	}
	
	public boolean calcularNovoSaldo (double taxaRendimento) {
		Calendar hoje = Calendar.getInstance();
		if(diaRendimento == hoje.get(Calendar.DAY_OF_MONTH)) {
			super.setSaldo(super.getSaldo()+(super.getSaldo()*taxaRendimento));
			return true;
		}
		return false;
	}
}
