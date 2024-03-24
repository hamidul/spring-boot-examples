package com.example.demo.repo;

import org.springframework.stereotype.Repository;

@Repository
public class SomeRepo {
	public void doSomethingInRepo(String arg) {
			System.out.println("Doing something in repo....."+arg);
	}
}
