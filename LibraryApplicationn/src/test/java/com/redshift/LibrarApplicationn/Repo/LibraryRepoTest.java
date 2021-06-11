package com.redshift.LibrarApplicationn.Repo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.redshift.LibrarApplicationn.Model.Library;
import com.redshift.LibrarApplicationn.Model.Member;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class LibraryRepoTest {
	
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	LibraryRepo repo;
	
	@Test
	void getMembersUsingIdTest()
	{
		Member member1=null;entityManager.find(Member.class,8);
		Member member2=entityManager.find(Member.class,9);
		Member member3=entityManager.find(Member.class,12);
		Library library=entityManager.find(Library.class,7);
        List<Object> list=repo.getMembersUsingId(library.getId());
		assertThat(list.size()).isEqualTo(2);
	}
}
