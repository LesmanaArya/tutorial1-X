package id.ac.ui.cs.advprog.eshop.enums;

import lombok.Getter;

@Getter
public enum PaymentMethodFeature {
    VOUCHER_CODE("voucherCode"),
    CASH_ON_DELIVERY("Cash On Delivery"),
    BANK_TRANSFER("Bank Transfer");

    private final String feature;

    private PaymentMethodFeature(String feature) {
        this.feature = feature;
    }
}
