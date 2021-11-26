package be.sch3lp.j2k.builder.java;

import be.sch3lp.j2k.common.ValueObject;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.StringJoiner;

public final class Address extends ValueObject {
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
