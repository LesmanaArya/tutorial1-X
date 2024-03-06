package id.ac.ui.cs.advprog.eshop.model;

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
        String[] statusList = {"WAITING_PAYMENT", "FAILED", "SUCCESS", "CANCELLED"};
        if (Arrays.stream(statusList).noneMatch(item -> (item.equals(status)))) {
            throw new IllegalArgumentException();
        } else {
            this.status = status;
        }
    }
    public Payment(String id, String method, Map<String, String> paymentData,  String status) {
        this(id, method, paymentData);
        this.setStatus(status);
    }
}
