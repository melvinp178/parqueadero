package com.home.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.home.demo.entity.Usuario;


@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@Rollback(true)
public class UsuarioRepositoryTest {
	@Autowired
	IUsuarioRepositorio repoUsuario;

	@Autowired
	IRolRepositorio repoRol;

	@Autowired
	TestEntityManager entityManager;

	@Test
	void createUsuario() {
		Usuario user = repoUsuario.save(new Usuario("test@test.com", "test"));
		assertEquals(user.getEmail(), "test@test.com");
	}

	@Test
	void crearRoles() {
		Rol1 rolAdmin = new Rol1("Administrador");
		Rol1 rolEditor = new Rol1("Editor");
		Rol1 rolAnonimo = new Rol1("Anonimo");

		assertEquals(repoRol.save(rolAdmin).getNombre(), "Administrador");
		assertEquals(repoRol.save(rolEditor).getNombre(), "Editor");
		assertEquals(repoRol.save(rolAnonimo).getNombre(), "Anonimo");
	}

	@Test
	void crearUsuarioConRol() {
		Rol1 rolAdmin = new Rol1("Administrador");
		Rol1 rolEditor = new Rol1("Editor");
		Usuario user = new Usuario("test@test.com", "test");
		user.anhadirRol(rolAdmin);
		user.anhadirRol(rolEditor);

		assertThat(repoUsuario.save(user).getRoles().toString().contains("Administrador"));
	}
}
