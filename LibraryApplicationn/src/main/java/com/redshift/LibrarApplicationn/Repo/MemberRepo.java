package com.redshift.LibrarApplicationn.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redshift.LibrarApplicationn.Model.Member;

public interface MemberRepo extends JpaRepository<Member,Integer> {

}
