package services;

import java.util.LinkedList;
import java.util.List;

import model.User;

/**
 * Classe serve como uma 'substituta' para o acesso ao banco de dados,
 * caso este esteja indisponível.
 * @author elton
 *
 */
public class ResourceManager {
	private static ResourceManager ref;
	private List<User> users;
	
	private ResourceManager() {
		users = new LinkedList<User>();
	}
	
	public static ResourceManager getInstance() {
		if(ref == null) {
			ref = new ResourceManager();
		}
		
		return ref;
	}
	
	public List<User> getList() {
		return users;
	}
	
	public User getUserByName(String uname) {
		for(User tmp : users) {
			if(tmp.getUname().equalsIgnoreCase(uname)) {
				return tmp;
			}
		}
		return null;
	}
}
