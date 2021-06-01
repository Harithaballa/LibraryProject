package com.redshift.LibrarApplicationn.Repo;

import java.util.List;

import com.redshift.LibrarApplicationn.Model.Address;

public interface IAddressDao {
	public List<Address> getByLocation(String location);

}
