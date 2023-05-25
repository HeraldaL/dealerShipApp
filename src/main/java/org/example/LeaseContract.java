package org.example;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;
    private double monthlyPayment;

    public LeaseContract(String contractDate, String customerName, String customerEmail, Vehicle vehicle,
                         double expectedEndingValue, double leaseFee) {
        super(contractDate, customerName, customerEmail, vehicle);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
        this.monthlyPayment = calculateMonthlyPayment();
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    @Override
    public String getPersistenceString() {
        return null;
    }

    public double getTotalPrice() {
        return getVehicle().getPrice() + leaseFee;
    }

    private double calculateMonthlyPayment() {
        // Lease financed at 4.0% for 36 months
        return (getTotalPrice() * 0.04) / 36;
    }
}