package com.latihan.mvc;

import java.sql.SQLException;
import java.util.List;

public class Tester {

	public static void main(String[] args) {
		ProductRepositoryMySQL repo = new ProductRepositoryMySQL();
		try {
			List<Integer> kumpulanId = repo.getAllId();
			System.out.println(kumpulanId.get(0));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
