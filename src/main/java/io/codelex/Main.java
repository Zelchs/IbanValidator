package io.codelex;

public class Main {
    public static void main(String[] args) {
        String iban = args.length > 0 ? args[0] : "";

        if (IbanValidator.validate(iban)) {
            System.out.println("IBAN is valid");
        } else {
            System.out.println("IBAN is invalid");
        }
    }
}