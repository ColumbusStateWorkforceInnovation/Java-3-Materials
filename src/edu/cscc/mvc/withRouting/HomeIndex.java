package edu.cscc.mvc.withRouting;

import edu.cscc.mvc.withRouting.framework.ApplicationView;
import edu.cscc.mvc.withRouting.framework.ExitRequest;
import edu.cscc.mvc.withRouting.framework.MVCContext;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeIndex extends ApplicationView {
    public HomeIndex(MVCContext context) {
        super(context);
    }

    @Override
    public void show() {
        System.out.println("Welcome to the Order Management System!");
        System.out.println("1. View orders.");
        System.out.println("2. Exit");
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    route("Orders", "index");
                    break;
                case 2:
                    context.setRequest(new ExitRequest());
                    break;
            }
        } catch (InputMismatchException ex) {
            this.show();
        }
    }
}
