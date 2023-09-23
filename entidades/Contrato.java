package entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import excessoes.CronologiaException;
public class Contrato {
	
private int numeroContrato;
private Date dataContrato;
private double valorTotal;
List<Prestacao> listaPrestacoes = new ArrayList<>();

public Contrato() {
	
}

public Contrato(int numeroContrato, Date dataContrato,double valorTotal ){
	this.numeroContrato = numeroContrato;
	this.dataContrato = dataContrato;
	this.valorTotal = valorTotal;
}

public int getNumeroContrato() {
	return numeroContrato;
}

public Date getDataContrato() {
	return dataContrato;
}

public double getValorTotal() {
	return valorTotal;
}

public void addPrestacao(Prestacao parcela) throws CronologiaException {
	
		//tratando datas, impedindo que parcelas anteriores a data do contrato, parcelas anteriores a parcelas já adicionadas
		//e  que parcelas se acumulem em um mesmmo mes;
		int indice =listaPrestacoes.size();
		
		if(dataContrato.after(parcela.getDataPagamento())) throw new CronologiaException();		
		if(indice>0) {
			if(listaPrestacoes.get(indice-1).getDataPagamento().after(parcela.getDataPagamento())) throw new CronologiaException();
			if(0== listaPrestacoes.get(indice-1).getDataPagamento().compareTo(parcela.getDataPagamento())) throw new CronologiaException();
		}
		
		//Adicionando a parcela a lista;
		this.listaPrestacoes.add(parcela);
	
}

@Override
	public String toString() {
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	String saida="";
		for (Prestacao prestacao : listaPrestacoes) {
			saida += formato.format(prestacao.getDataPagamento()) + " - " + prestacao.getValor() +"\n";	
			}
		return saida;
	}}
