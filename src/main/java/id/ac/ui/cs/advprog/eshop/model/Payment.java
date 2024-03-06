package id.ac.ui.cs.advprog.eshop.model;

import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Map;

@Getter
public class Payment {
    String id;
    String method;

    String status;

    Map<String, String> paymentData;
    public Payment(String id, String method, Map<String, String> paymentData) {
        this.id = id;
        this.method = method;
        if (paymentData.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            this.paymentData = paymentData;
        }
        this.status = "WAITING_PAYMENT";
    }
    public void setStatus(String status) {
            if (OrderStatus.contains(status)) {
                this.status = status;
            } else {
                throw new IllegalArgumentException();
            }
    }
    public Payment(String id, String method, Map<String, String> paymentData,  String status) {
        this(id, method, paymentData);
        this.setStatus(status);
    }
}
