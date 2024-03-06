package id.ac.ui.cs.advprog.eshop.service;
import id.ac.ui.cs.advprog.eshop.enums.PaymentMethodFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import id.ac.ui.cs.advprog.eshop.enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        String eightNumericalPattern = "\\d{8}"; //Contains 8 numerical character
        Pattern eightNumericalPatterntest = Pattern.compile(eightNumericalPattern); //Create pattern instance
        Matcher resultPattern = eightNumericalPatterntest.matcher(paymentData.get("voucherCode"));

        if (method.equals(PaymentMethodFeature.VOUCHER_CODE.getFeature()) && paymentData.get("voucherCode") != null) {
            if (paymentData.get("voucherCode").length() == 16 && paymentData.get("voucherCode").startsWith("ESHOP") && resultPattern.find()) {
                Payment payment = new Payment(String.valueOf(paymentRepository.findAll().size()+1), method, paymentData, OrderStatus.SUCCESS.getValue());
                paymentRepository.save(payment);
                return payment;
            } else {
                Payment payment = new Payment(String.valueOf(paymentRepository.findAll().size()+1), method, paymentData, OrderStatus.REJECTED.getValue());
                paymentRepository.save(payment);
                return payment;
            }
        } else if (method.equals(PaymentMethodFeature.BANK_TRANSFER.getFeature()) || (method.equals(PaymentMethodFeature.CASH_ON_DELIVERY.getFeature()))) {
            if (!paymentData.keySet().isEmpty() || !paymentData.values().isEmpty()) {
                Payment payment = new Payment(String.valueOf(paymentRepository.findAll().size()+1), method, paymentData, OrderStatus.SUCCESS.getValue());
                paymentRepository.save(payment);
                return payment;
            } else {
                Payment payment = new Payment(String.valueOf(paymentRepository.findAll().size()+1), method, paymentData, OrderStatus.REJECTED.getValue());
                paymentRepository.save(payment);
                return payment;
            }
        } else {
            return null;

        }
    }

    @Override
    public Payment setStatus(Payment payment, String status) {
        Payment result = paymentRepository.findById(payment.getId());
        if (result != null) {
            Payment newPayment = new Payment(payment.getId(), payment.getMethod(), payment.getPaymentData(), status);
            paymentRepository.save(newPayment);
            return newPayment;
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public Payment getPayment(String id) {
        return paymentRepository.findById(id);
    }

    @Override
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }
}
