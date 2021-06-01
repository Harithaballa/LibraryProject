package com.redshift.LibrarApplicationn.Repo;

import java.util.List;

import com.redshift.LibrarApplicationn.Model.Library;

public interface LibraryRepoCustom {
	   List<Library> getFirstNamesLike(String firstName);
}
