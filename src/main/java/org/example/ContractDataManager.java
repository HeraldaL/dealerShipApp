package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    String contractDataname;

    public ContractDataManager(String contractDataname) {
        this.contractDataname = contractDataname;
    }

    public void saveContract(Contract D) {
        try (FileWriter writer = new FileWriter(contractDataname, true)) {
            writer.write(D.getPersistenceString() + "\n");
            System.out.println("Contract saved successfully.");
        } catch (IOException e) {
            System.err.println("Error : ");
        }
    }
}
