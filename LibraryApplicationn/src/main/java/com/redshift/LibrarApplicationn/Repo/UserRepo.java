package com.redshift.LibrarApplicationn.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redshift.LibrarApplicationn.Model.User;


public interface UserRepo extends JpaRepository<User, Integer> {

	User  findByUsername(String username);
}
