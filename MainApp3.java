package com.example.bankapp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BankConfig.class);
        BankService service = context.getBean(BankService.class);
        service.transfer(1, 2, 1000);
        context.close();
    }
}
