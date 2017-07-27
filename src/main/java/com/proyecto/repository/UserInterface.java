package com.proyecto.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.entity.Contact;
import com.proyecto.entity.User;

@Repository("userRepository")
public interface UserInterface extends JpaRepository<User, Serializable> {
	public abstract User findByUsername(String username);
}
