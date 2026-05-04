package entities;

public class TuitionFeePayment {

    private String paymentId;
    private String studentID;
    private double amountPaid;
    private double totalFee;

    public TuitionFeePayment(String paymentId, String studentID, double amountPaid, double totalFee) {
        this.paymentId = paymentId;
        this.studentID = studentID;
        this.amountPaid = amountPaid;
        this.totalFee = totalFee;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = this.studentID;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public double getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }

    public double getRemainingBalance() {
        return totalFee - amountPaid;
    }
}




