package org.example;

public class SalesContract extends Contract {
    private double salesTaxAmount = 0.05;
    private double recordingFee = 100;
    private double processingFee;
    private boolean financeOption;

    public SalesContract(String contractDate, String customerName, String customerEmail, Vehicle vehicle,
                        double salesTaxAmount, double recordingFee, double processingFee, boolean financeOption) {
        super(contractDate, customerName, customerEmail, vehicle);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeOption = financeOption;
       // this.monthlyPayment = calculateMonthlyPayment();
    }

    public double getSalesTaxAmount() {
        return getVehicle().getPrice() * salesTaxAmount;
    }


    public double getRecordingFee() {
        return recordingFee;
    }


    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceOption() {
        return financeOption;
    }

    public void setFinanceOption(boolean financeOption) {
        this.financeOption = financeOption;
    }



    @Override
    public String getPersistenceString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SALE | ")
                .append(getContractDate()).append(" | ")
                .append(getCustomerName()).append(" | ")
                .append(getCustomerEmail()).append(" | ")
                .append(getVehicle().getVin()).append(" | ")
                .append(getVehicle().getMake()).append(" | ")
                .append(getVehicle().getModel()).append(" | ")
                .append(getVehicle().getColor()).append(" | ")
                .append(getVehicle().getPrice()).append(" | ")
                .append(getSalesTaxAmount()).append(" | ")
                .append(getRecordingFee()).append(" | ")
                .append(getProcessingFee()).append(" | ")
                .append(getTotalPrice()).append(" | ")
                .append(isFinanceOption() ? "YES" : "NO").append(" | ")
                .append(getMonthlyPayment());

        return sb.toString();
    }

    public double getTotalPrice() {
        return getVehicle().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    public double getMonthlyPayment() {
        if (isFinanceOption()) {
            if (getVehicle().getPrice() >= 10000) {
                // Loan at 4.25% for 48 months
                return (getTotalPrice() * 0.0425) / 48;
            } else {
                // Loan at 5.25% for 24 months
                return (getTotalPrice() * 0.0525) / 24;
            }
        } else {
            return 0.0;
        }
    }
}