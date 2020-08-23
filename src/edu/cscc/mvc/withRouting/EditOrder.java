package edu.cscc.mvc.withRouting;

import edu.cscc.mvc.withRouting.framework.ApplicationView;
import edu.cscc.mvc.withRouting.framework.MVCContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class EditOrder extends ApplicationView {
    private UUID orderId;

    public EditOrder(MVCContext context, UUID orderId) {
        super(context);
        this.orderId = orderId;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        Map params = new HashMap<>();
        params.put("orderId", orderId);

        System.out.print("Customer name: ");
        String customerName = scanner.nextLine();
        params.put("customerName", customerName);

        System.out.print("Order total: ");
        Double orderTotal = scanner.nextDouble();
        params.put("orderTotal", orderTotal);

        System.out.print("Order Item Count: ");
        Integer itemCount = scanner.nextInt();
        params.put("itemCount", itemCount);

        route("Orders", "save", params);
    }
}
