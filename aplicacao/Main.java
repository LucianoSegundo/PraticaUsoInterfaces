package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Contrato;
import excessoes.CronologiaException;
import servico.ServicoContrato;
import servico.ServiçoPaypal;

public class Main {
	
	public static void main(String[] args) throws ParseException, CronologiaException {
		try {
			
		Scanner entrada = new Scanner(System.in);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o Numero do contrato: ");
		int numeroContrato = entrada.nextInt();
		entrada.nextLine();
		
		System.out.print("Entre com a data do contrato no formado DD/MM/YYYY:");
		Date dataContrato = formato.parse(entrada.next());
		entrada.nextLine();
		
		System.out.print("Entre com o valor do contrato: ");
		double Valor = entrada.nextDouble();
		entrada.nextLine();
		
		System.out.print("Entre com o Número de parcelas: ");
		int numeroParcelas = entrada.nextInt();
		entrada.nextLine();
		
		Contrato contrato = new Contrato(numeroContrato, dataContrato,Valor);
		
		ServicoContrato sericoContrato = new ServicoContrato(new ServiçoPaypal());
		
		sericoContrato.processarContrato(contrato, numeroParcelas);
		System.out.println("parcelas: ");
		
		System.out.println(contrato.toString());
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
