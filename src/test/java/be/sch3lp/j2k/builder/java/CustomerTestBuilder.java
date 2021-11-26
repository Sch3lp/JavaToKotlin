package be.sch3lp.j2k.builder.java;

import static be.sch3lp.j2k.builder.java.AddressTestBuilder.aDefaultAddress;
import static be.sch3lp.j2k.builder.java.Age.age;

public class CustomerTestBuilder {
    private final Customer.CustomerBuilder customerBuilder;

    private CustomerTestBuilder() {
        customerBuilder = Customer.aCustomer();
    }

    public static CustomerTestBuilder aDefaultCustomer() {
        return someCustomer()
                .withId(CustomerId.newCustomerId())
                .withAge(age(52))
                .withName("Joren", "Kennes")
                .withAddress(aDefaultAddress())
                ;
    }

    public static CustomerTestBuilder someCustomer() {
        return new CustomerTestBuilder();
    }

    public CustomerTestBuilder withId(CustomerId id) {
        customerBuilder.withId(id);
        return this;
    }

    public CustomerTestBuilder withName(String firstName, String lastName) {
        customerBuilder.withName(firstName, lastName);
        return this;
    }

    public CustomerTestBuilder withAddress(AddressTestBuilder addressTestBuilder) {
        customerBuilder.withAddress(addressTestBuilder.build());
        return this;
    }

    public CustomerTestBuilder withAge(Age age) {
        customerBuilder.withAge(age);
        return this;
    }

    public Customer build() {
        return customerBuilder.build();
    }
}
