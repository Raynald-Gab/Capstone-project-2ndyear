package entities;

public class TuitionFeePayment {

    private String paymentId;
    private String studentId;
    private double amountPaid;
    private double totalFee;

    public TuitionFeePayment(String paymentId, String studentId, double amountPaid, double totalFee) {
        this.paymentId = paymentId;
        this.studentId = studentId;
        this.amountPaid = amountPaid;
        this.totalFee = totalFee;
    }

    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public double getAmountPaid() { return amountPaid; }
    public void setAmountPaid(double amountPaid) { this.amountPaid = amountPaid; }
    public double getTotalFee() { return totalFee; }
    public void setTotalFee(double totalFee) { this.totalFee = totalFee; }
    public double getRemainingBalance() { return totalFee - amountPaid; }
}