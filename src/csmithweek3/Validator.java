package csmithweek3;

/**
 * @Course: SDEV 250 ~ Java Programming I
 * @Author Name: Craig Smith
 * @Assignment Name: csmith_week12_week13/Java2_weeks1-8
 * @Date: Aug 4, 2020
 * @Subclass Validator Description: Class to provide canned input validations
 * Updated 8/12/20 to add the integer checker Updated 9/20/20 to add
 * checkZipCode,checkPhoneNumber,checkEmailAdd, checkAlphaTextFieldLength,
 * checkTextFieldLength Updates 9/26/20 added isInteger 10/9/20 - added the
 * isInteger method
 */
//Imports
//Begin Subclass Validator
public class Validator {

    //Attributes
    /**
     * Constructor - empty
     */
    public Validator() {
    }

    /**
     * Method to check any possible yes/no input
     *
     * @param answer
     * @return 0 = No, 1 = Yes, -1 = Invalid
     */
    public static int checkYesOrNo(String answer) {

        if (answer.matches("[Yy]|^[Yy][Ee][Ss]")) {
            return 1;
        } else if (answer.matches("[Nn]|^[Nn][Oo]")) {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * Method to validate if an integer is in a specified range
     *
     * @param first - start of integer range (inclusive)
     * @param last - end of integer range (inclusive)
     * @param answer - the checked integer
     * @return - the checked integer or -1 if not in range
     */
    public static int checkIntInRange(int first, int last, int answer) {
        for (int i = first; i < last + 1; i++) {
            if (i == answer) {
                return answer;
            }
        }
        return -1;
    }

    /**
     * Method to validate if a given string has a valid zip code format
     *
     * @param zip Valid Zip Codes formats nnnnn or nnnnn-nnnn
     * @return true - valid zip code, false - invalid zip code
     */
    public static boolean checkZipCode(String zip) {
        return zip.matches("^[0-9]{5}(?:-[0-9]{4})?$");
    }

    /**
     * Method to validate if a given string has a valid phone number format
     *
     * @param phone Valid values nnn.nnn.nnn, nnn nnn nnnn, nnn-nnn-nnnn or some
     * combination of "." "" "-" number separators
     * @return true - valid phone number, false - invalid phone number
     */
    public static boolean checkPhoneNumber(String phone) {
        return phone.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}");
    }

    /**
     * Method to validate if a given string has a valid email address format
     *
     * @param email Valid values text@text.text or text.text@text.text
     * @return true - valid email format, false - invalid email format
     */
    public static boolean checkEmailAdd(String email) {
        String exp = "^[_A-Za-z0-9-\\+]+(\\.[A-Za-z0-9-]+)*@[A-Za-z0-9-]+"
                + "(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return email.matches(exp);
    }

    /**
     * Method to validate if a given string is between 1 and x characters in
     * length and only contains alphanumeric characters A-Z or a-z.
     *
     * @param text String to evaluate
     * @param maxLength Maximum number of characters the string can contain
     * (1-max)
     * @return true - valid text field characters and length, false - invalid
     * format
     */
    public static boolean checkAlphaTextFieldLength(String text, int maxLength) {
        String exp = String.format("[A-Za-z]{1,%d}", maxLength);
        return text.matches(exp);
    }

    /**
     * Method to validate if a given string is between 0 and x characters in
     * length and can contain any combination of types of values
     *
     * @param text String to evaluate
     * @param maxLength Maximum length of the string
     * @return true - String at most maxLength, false - String is longer than
     * maxLength
     */
    public static boolean checkTextFieldLength(String text, int maxLength) {
        return text.length() <= maxLength;
    }

    /**
     * Method to validate if a given
     *
     * @param number as a String
     * @return true if the given value is an integer
     */
    public static boolean isInteger(String number) {
        return number.matches("[+-]?[0-9]+");
    }

    /**
     * Method to validate if a given String literal is a positive integer >=0
     *
     * @param number as a String
     * @return true if the given value is a positive integer >= 0
     */
    public static boolean isPositiveInteger(String number) {
        return number.matches("[+]?[0-9]+");
    }

    /**
     * Method to validate if a given String literal is a positive integer > 0
     *
     * @param number as a String (prefixed 0's ok if contains [1-9] after
     * @return true if the given value is a positive integer > 0
     */
    public static boolean isPositiveIntegerExcludeZero(String number) {
        return number.matches("^(?!0+$)\\d+$");
    }

    /**
     * Method to check if a text field is empty or only contains spaces
     *
     * @param tfText
     * @return true if the text field is empty or only contains spaces
     */
    public static boolean isTextFieldEmpty(String tfText) {
        return (tfText == null) || (tfText.trim().isEmpty());

    }

} //End Subclass Validator

