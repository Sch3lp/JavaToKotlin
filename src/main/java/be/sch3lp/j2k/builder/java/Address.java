package be.sch3lp.j2k.builder.java;

import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.StringJoiner;

public final class Address {
    private final String street;
    private final String city;
    private final Zip zip;
    private final String houseNumber;
    @Nullable private final String bus;

    public Address(String street, String city, Zip zip, String houseNumber, @Nullable String bus) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.houseNumber = houseNumber;
        this.bus = bus;
    }

    public static AddressBuilder anAddress() {
        return new AddressBuilder();
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public Zip getZip() {
        return zip;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    @Nullable
    public String getBus() {
        return bus;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]")
                .add("street='" + street + "'")
                .add("city='" + city + "'")
                .add("zip=" + zip)
                .add("houseNumber='" + houseNumber + "'")
                .add("bus='" + bus + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(zip, address.zip) && Objects.equals(houseNumber, address.houseNumber) && Objects.equals(bus, address.bus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, zip, houseNumber, bus);
    }

    public static class AddressBuilder {

        private String street;
        private String city;
        private Zip zip;
        private String houseNumber;
        private String bus;

        private AddressBuilder() {
        }

        public AddressBuilder withStreet(String street) {
            this.street = street;
            return this;
        }

        public AddressBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public AddressBuilder withZip(Zip zip) {
            this.zip = zip;
            return this;
        }

        public AddressBuilder withHouseNumber(String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        public AddressBuilder withBus(String bus) {
            this.bus = bus;
            return this;
        }

        public Address build() {
            return new Address(street, city, zip, houseNumber, bus);
        }
    }
}
