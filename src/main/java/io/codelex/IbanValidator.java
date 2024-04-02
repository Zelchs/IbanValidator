package io.codelex;

import java.math.BigInteger;

public class IbanValidator {
    private IbanValidator() {

    }

    public static boolean validate(String iban) {
        String trimmedIbanString = iban.replaceAll("\\s+", "").toUpperCase();

        if (!isValidIbanLength(trimmedIbanString)) {
            return false;
        }

        BigInteger numericIban = getFormattedIban(trimmedIbanString);
        return numericIban.mod(BigInteger.valueOf(97)).equals(BigInteger.ONE);
    }

    private static boolean isValidIbanLength(String iban) {
        String countryCode = iban.substring(0, 2);
        return iban.length() == IbanPrefix.getIbanLengthByCountryCode(countryCode);
    }

    private static BigInteger getFormattedIban(String iban) {
        iban = iban.substring(4) + iban.substring(0, 4);
        StringBuilder ibanStr = new StringBuilder();

        for (char c : iban.toCharArray()) {
            if (Character.isLetter(c)) {
                ibanStr.append(c - 55);
            } else {
                ibanStr.append(c);
            }
        }
        return new BigInteger(ibanStr.toString());
    }
}
