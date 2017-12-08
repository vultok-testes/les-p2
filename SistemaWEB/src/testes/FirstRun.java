package testes;

import java.util.List;

import model.User;
import services.ResourceManager;

public class FirstRun {
	public static void main(String[] args) {
		ResourceManager rs = ResourceManager.getInstance();
		List<User> users = rs.getList();
//		
//		Empresa e = new FactoryEmpresa().getEmpresa();
//		e.setNome("Eltons & Eltuns");
//		
//		for(int i = 0; i < 10; i++) {
//			Funcionario f = new FactoryFuncionario().getFuncionario();
//			f.setNome("Fulano #" + i);
//			
//			e.adicionarFuncionario(f);
//		}
		
		for(User user : users) {
			System.out.println(user.getEmpresa().getSaldo());
		}
	}
}
