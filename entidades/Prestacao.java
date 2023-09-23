package entidades;

import java.util.Date;

public class Prestacao {

	private Date dataPagamento;
	private double valorPrestacao;

	public Prestacao(Date dataPagamento, double valor) {
		this.dataPagamento = dataPagamento;
		this.valorPrestacao = valor;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public double getValor() {
		return valorPrestacao;
	}

}
