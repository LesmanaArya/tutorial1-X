package id.ac.ui.cs.advprog.eshop.enums;

import lombok.Getter;

@Getter
public enum PaymentMethodFeature {
    VOUCHER_CODE("voucherCode"),
    ESHOP("ESHOP"),
    BANK_TRANSFER("Bank Transfer");

    private final String feature;

    private PaymentMethodFeature(String feature) {
        this.feature = feature;
    }
}
