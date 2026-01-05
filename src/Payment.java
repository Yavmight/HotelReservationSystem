import java.time.LocalDateTime;

public class Payment {

    public enum PaymentMethod {CASH, CARD}

    private PaymentMethod paymentMethod;
    private double amount;
    private boolean isPaid;
    private LocalDateTime paidAt;


    public Payment(PaymentMethod paymentMethod, double amount) {
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.isPaid = false;
        this.paidAt = null;
    }


    public PaymentMethod getMethod() {
        return paymentMethod;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }


    public void pay() {
        if (isPaid) throw new IllegalStateException("Payment already completed.");
        isPaid = true;
        paidAt = LocalDateTime.now();
        System.out.println("Payment Successful");
    }


    public void showReceipt() {
        System.out.println("*** PAYMENT RECEIPT ***");
        System.out.println("Method : " + getMethod());
        System.out.println("Amount : " + getAmount());
        System.out.println("Paid   : " + isPaid());
        System.out.println("Paid At: " + getPaidAt());
        System.out.println("***********************");
    }
}