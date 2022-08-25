package edu.eci.cvds.tdd.registry;

import org.junit.jupiter.api.Test;
import junit.framework.Assert;
import junit.framework.TestCase;

public class RegistryTest{
	private Registry registry = new Registry();
    
	@Test
	public void validateRegistryResult() {
		Person person = new Person("Arnoldo", 0, 19, Gender.MALE, true);
		RegisterResult result = registry.registerVoter(person);
		Assert.assertEquals(RegisterResult.VALID, result);
	}

	@Test
	public void shouldBeInvalidAgeRegister() {
		Person person = new Person("Pablito", 1, -40, Gender.MALE, true);
		RegisterResult result = registry.registerVoter(person);
		Assert.assertEquals(RegisterResult.INVALID_AGE, result);
	}

	@Test
	public void shouldBeUnderAgeRegister() {
		Person person = new Person("Juanita", 2, 17, Gender.FEMALE, true);
		RegisterResult result = registry.registerVoter(person);
		Assert.assertEquals(RegisterResult.UNDERAGE, result);
	}

	@Test
	public void shouldBeDeadRegister() {
		Person person = new Person("Santiago", 3, 21, Gender.FEMALE, false);
		RegisterResult result = registry.registerVoter(person);
		Assert.assertEquals(RegisterResult.DEAD, result);
	}

	@Test
	public void shouldBeDuplicatedRegister() {
		Person person = new Person("Santiago", 3, 21, Gender.FEMALE, true);
		registry.registerVoter(person);
		RegisterResult result = registry.registerVoter(person);
		Assert.assertEquals(RegisterResult.DUPLICATED, result);
	}
}
