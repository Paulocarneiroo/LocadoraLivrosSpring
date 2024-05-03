package com.lablpII.lablpII;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lablpII.lablpII.entities.Customer;
import com.lablpII.lablpII.services.BookService;
import com.lablpII.lablpII.services.CustomerService;
import com.lablpII.lablpII.utils.Menu;
import com.lablpII.lablpII.projections.BookMinProjection;
import com.lablpII.lablpII.projections.CustumerMinProjection;

@SpringBootApplication
public class LablpIiApplication implements CommandLineRunner {

	@Autowired
	private Menu menu;

	@Autowired
	private BookService bookService;

	@Autowired
	private CustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(LablpIiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{

		menu.show();


	}
}
