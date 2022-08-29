package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;
import java.util.List;

public class Registry {
	private static List<Integer> personsRegistered = new ArrayList<Integer>();

	public RegisterResult registerVoter(Person p) {
		RegisterResult result = RegisterResult.VALID;
		int edad = p.getAge();
		if (edad < 18 && edad >= 0)
			result = RegisterResult.UNDERAGE;
		else if (!p.isAlive())
			result = RegisterResult.DEAD;
		else if (this.existPerson(p))
			result = RegisterResult.DUPLICATED;
		else if (edad < 0)
			result = RegisterResult.INVALID_AGE;
		else
			personsRegistered.add(p.getId());
		return result;
	}

	private boolean existPerson(Person p) {
		boolean exist = false;
		for (Integer id : personsRegistered) {
			if (p.getId() == id)
				exist = true;
		}
		return exist;
	}
}
