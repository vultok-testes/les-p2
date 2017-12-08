package services;

public class IdListenerConcrete implements IdListener {

	@Override
	public int getId(int tipo) {
		int id = 0;
		
		switch(tipo) {
		case 1:
			id = getIdEmpresa();
			break;
		}
		
		return id;
	}
	
	private int getIdEmpresa() {
		return 1;
	}
	
}
