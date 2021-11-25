package be.sch3lp.j2k.builder.java;

import static be.sch3lp.j2k.builder.java.Address.anAddress;
import static be.sch3lp.j2k.builder.java.Zip.zip;

public class AddressTestBuilder {

    private final Address.AddressBuilder addressBuilder;

    private AddressTestBuilder() {
        this.addressBuilder = anAddress();
    }

    public static AddressTestBuilder someAddress() {
        return new AddressTestBuilder();
    }

    public static AddressTestBuilder aDefaultAddress() {
        return someAddress()
                .withStreet("Mantelstraat")
                .withHouseNumber("4")
                .withCity("Kruishoutem")
                .withZip(zip("9770"));
    }

    public AddressTestBuilder withStreet(String street) {
        addressBuilder.withStreet(street);
        return this;
    }

    public AddressTestBuilder withCity(String city) {
        addressBuilder.withCity(city);
        return this;
    }

    public AddressTestBuilder withZip(Zip zip) {
        addressBuilder.withZip(zip);
        return this;
    }

    public AddressTestBuilder withHouseNumber(String houseNumber) {
        addressBuilder.withHouseNumber(houseNumber);
        return this;
    }

    public AddressTestBuilder withBus(String bus) {
        addressBuilder.withBus(bus);
        return this;
    }

    public Address build() {
        return addressBuilder.build();
    }
}
