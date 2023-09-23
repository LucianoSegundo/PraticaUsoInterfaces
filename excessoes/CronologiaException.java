package excessoes;

public class CronologiaException extends Exception {
 
 private static final long serialVersionUID = 1L;

@Override
public String getMessage() {
	// TODO Auto-generated method stub
	return "Não foi possivel adicionar a prestação, a data não pode ser anterior"
			+ " a data da ultima prestação ou do contrato";
}
}