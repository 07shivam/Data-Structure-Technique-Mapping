package Strings.Simple;

public class Defanging_IP_Address {
    public String defangIPaddr(String address) {

        char[] charStr = address.toCharArray();// Java String is immutable, meaning its contents cannot be changed
                                               // directly
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < charStr.length; i++) {
            if (charStr[i] == '.') {
                result.append('[');
                result.append('.');
                result.append(']');
            }

            else {
                result.append(charStr[i]);
            }
        }

        return new String(result);

    }
}
