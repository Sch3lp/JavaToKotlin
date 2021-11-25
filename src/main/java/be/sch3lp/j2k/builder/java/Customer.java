package be.sch3lp.j2k.builder.java;

import java.util.Objects;
import java.util.StringJoiner;

public final class Customer {
    private final CustomerId id;
    private final Name name;
    private final Address address;
    private final Age age;

    private Customer(CustomerId id, Name name, Address address, Age age) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public static CustomerBuilder aCustomer() {
        return new CustomerBuilder();
    }

    public CustomerId getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Age getAge() {
        return age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name=" + name)
                .add("address=" + address)
                .add("age=" + age)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(name, customer.name) && Objects.equals(address, customer.address) && Objects.equals(age, customer.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, age);
    }

    public static class CustomerBuilder {
        private CustomerId id;
        private Name name;
        private Address address;
        private Age age;

        private CustomerBuilder() {
        }

        public CustomerBuilder withId(CustomerId id) {
            this.id = id;
            return this;
        }

        public CustomerBuilder withName(String firstName, String lastName) {
            this.name = new Name(firstName, lastName);
            return this;
        }

        public CustomerBuilder withAddress(Address.AddressBuilder addressBuilder) {
            this.address = addressBuilder.build();
            return this;
        }

        public CustomerBuilder withAddress(Address address) {
            this.address = address;
            return this;
        }

        public CustomerBuilder withAge(Age age) {
            this.age = age;
            return this;
        }

        public Customer build() {
            return new Customer(id, name, address, age);
        }
    }
}
