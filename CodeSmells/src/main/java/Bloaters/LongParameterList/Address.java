package Bloaters.LongParameterList;

public class Address {
    private String city;
    private String country;
    private String postcode;

    public Address(String city, String country, String postcode) {
        this.city = city;
        this.country = country;
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}
