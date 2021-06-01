package com.redshift.LibrarApplicationn.Repo;

import java.util.List;

public interface Dao<T> {
 //   void create(T t);
    T get(int id);
    List<T> list();
    //void update(T t,int id);
    ///void delete(int id);
	//void update(Library library, int id);
}
