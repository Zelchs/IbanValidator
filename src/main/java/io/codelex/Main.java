package io.codelex;

public class Main {
    public static void main(String[] args) {
        String iban = "GB82 WEST 1234 5698 7654 32";

        if (IbanValidator.validate(iban)) {
            System.out.println("IBAN is valid");
        } else {
            System.out.println("IBAN is invalid");
        }
    }
}