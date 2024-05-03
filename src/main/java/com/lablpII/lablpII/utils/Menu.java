package com.lablpII.lablpII.utils;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lablpII.lablpII.entities.Customer;
import com.lablpII.lablpII.projections.CustumerMinProjection;
import com.lablpII.lablpII.services.CustomerService;

@Component
public class Menu {


    @Autowired
    private CustomerService customerService;

    public void show(){
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        do {
            System.out.println("1. Fazer cadastro");
            System.out.println("2. Fazer login");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 0:
                    System.out.println("Encerrando...");
                    break;
                case 1:
                    //Cadastrar
                    break;
                case 2:
                    System.out.println("Email: ");
                    String email = sc.nextLine();
                    System.out.println("Senha: ");
                    String password = sc.nextLine();
                    List<CustumerMinProjection> result = customerService.authenticate(email, password);
                    if (result.isEmpty()) {
                        System.out.println("Usuário Inválido");
                    }else{
                        Customer customer = new Customer();
                        for(CustumerMinProjection obj : result){
                            if (obj.getEmail().equals(email) && obj.getPassword().equals(password)) {
                                customer.setId(obj.getId());
                                customer.setName(obj.getName());
                                customer.setEmail(obj.getEmail());
                                customer.setPassword(obj.getPassword());
                            }
                        }
                        //Customer.login()
                    }
                    break;
                default:
                    System.out.println("Valor inválido");
                    break;
            }
        }while(opt != 0);
        sc.close();
    }
}
