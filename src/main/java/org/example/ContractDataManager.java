package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    String contractDataname;
    public ContractDataManager (String contractDataname) {
        this.contractDataname = contractDataname;
    }

    public void saveContract (Contract c) {
        //Write to file
        //c.getSameString() is what we write to file (if-else?)
    }
}


    /*private static final String CONTRACTS_FILE_PATH = "contracts.txt";

    public static void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTRACTS_FILE_PATH, true))) {
            if (contract instanceof SalesContract) {
                writer.write(formatSaleContract((SalesContract) contract));
            } else if (contract instanceof LeaseContract) {
                writer.write(formatLeaseContract((LeaseContract) contract));
            }

            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the contract: " + e.getMessage());
        }
    }

    private static String formatSaleContract(SalesContract contract) {
        StringBuilder sb = new StringBuilder();
        sb.append("SALE | ")
                .append(contract.getContractDate()).append(" | ")
                .append(contract.getCustomerName()).append(" | ")
                .append(contract.getCustomerEmail()).append(" | ")
                .append(contract.getVehicleSold().getVin()).append(" | ")
                .append(contract.getVehicleSold().getMake()).append(" | ")
                .append(contract.getVehicleSold().getModel()).append(" | ")
                .append(contract.getVehicleSold().getColor()).append(" | ")
                .append(contract.getVehicleSold().getPrice()).append(" | ")
                .append(contract.getSalesTaxAmount()).append(" | ")
                .append(contract.getRecordingFee()).append(" | ")
                .append(contract.getProcessingFee()).append(" | ")
                .append(contract.getTotalPrice()).append(" | ")
                .append(contract.getFinanceOption() ? "YES" : "NO").append(" | ")
                .append(contract.getMonthlyPayment());

        return sb.toString();
    }

    private static String formatLeaseContract(LeaseContract contract) {
        StringBuilder sb = new StringBuilder();
        sb.append("LEASE | ")
                .append(contract.getContractDate()).append(" | ")
                .append(contract.getCustomerName()).append(" | ")
                .append(contract.getCustomerEmail()).append(" | ")
                .append(contract.getVehicleSold().getVin()).append(" | ")
                .append(contract.getVehicleSold().getMake()).append(" | ")
                .append(contract.getVehicleSold().getModel()).append(" | ")
                .append(contract.getVehicleSold().getColor()).append(" | ")
                .append(contract.getVehicleSold().getPrice()).append(" | ")
                .append(contract.getExpectedEndingValue()).append(" | ")
                .append(contract.getLeaseFee()).append(" | ")
                .append(contract.getTotalPrice()).append(" | ")
                .append(contract.getMonthlyPayment());

        return sb.toString();
    }


     */