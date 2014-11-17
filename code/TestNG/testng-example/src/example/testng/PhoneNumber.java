package example.testng;

public class PhoneNumber implements Comparable<PhoneNumber> {

    /**
     * Parse PhoneNumber from a string.
     * 
     * @param s the string to parse in format +[country code] [area code]
     *            [number] x[extension] where only [area code] and [number] are
     *            required.
     * @return the parsed phone number.
     * @throws NullPointerException if s is null.
     * @throws IllegalArgumentException if s is not a valid phone number.
     */
    public static PhoneNumber parse(String s) {
        return null; // TODO: implement
    }

    public PhoneNumber(String areaCode, String number) {
        // TODO: implement
    }

    public PhoneNumber(String countryCode, String areaCode, String number,
            String extension) {
        // TODO: implement
    }

    public String getCountryCode() {
        return null; // TODO: implement
    }

    public String getAreaCode() {
        return null; // TODO: implement
    }

    public String getNumber() {
        return null; // TODO: implement
    }

    public String getExtension() {
        return null; // TODO: implement
    }

    /**
     * Get the phone number formatted as a string.
     * 
     * @return phone number formatted as +[country code] [area code] [number]
     *         x[extension]
     */
    @Override
    public String toString() {
        return null; // TODO: implement
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: implement
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        // TODO: implement
        return super.hashCode();
    }

    public int compareTo(PhoneNumber o) {
        return 0; // TODO: implement
    }
}
