package be.sch3lp.j2k.builder.java;

import org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static be.sch3lp.j2k.builder.java.Address.anAddress;
import static be.sch3lp.j2k.builder.java.Age.age;
import static be.sch3lp.j2k.builder.java.Customer.aCustomer;
import static be.sch3lp.j2k.builder.java.CustomerId.newCustomerId;
import static be.sch3lp.j2k.builder.java.CustomerTestBuilder.aDefaultCustomer;
import static be.sch3lp.j2k.builder.java.Zip.zip;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.recursive.comparison.RecursiveComparisonConfiguration.builder;

public class CustomerTest {
    @Test
    @DisplayName("A Customer can be created in an easily readable way")
    void aCustomerCanBeCreatedInAnEasilyReadableWay() {
        final var customerId = newCustomerId();
        final var actual = aCustomer()
                .withId(customerId)
                .withAge(age(40))
                .withName("Bruce", "Wayne")
                .withAddress(anAddress()
                        .withStreet("Vleermuisstraat")
                        .withCity("Dilbeek")
                        .withZip(zip("1700"))
                        .withHouseNumber("15"))
                .build();

        assertThat(actual.getId()).isEqualTo(customerId);
        assertThat(actual.getAge()).isEqualTo(age(40));
        assertThat(actual.getName()).isEqualTo(new Name("Bruce", "Wayne"));
        assertThat(actual.getAddress()).isEqualTo(anAddress()
                .withStreet("Vleermuisstraat")
                .withCity("Dilbeek")
                .withZip(zip("1700"))
                .withHouseNumber("15")
                .withBus(null)
                .build());
    }

    @Test
    @DisplayName("A Customer can be created using a TestBuilder")
    void aCustomerCanBeCreatedUsingATestBuilder() {
        final var customerId = newCustomerId();
        final var expected = aCustomer()
                .withId(customerId)
                .withAge(age(52))
                .withName("Edward", "Nigma")
                .withAddress(anAddress()
                        .withStreet("Mantelstraat")
                        .withHouseNumber("4")
                        .withCity("Kruishoutem")
                        .withZip(zip("9770")))
                .build();

        assertThat(aDefaultCustomer().build())
                .usingRecursiveComparison(excluding(CustomerId.class))
                .isEqualTo(expected);
    }

    @NotNull
    private RecursiveComparisonConfiguration excluding(Class<?>... types) {
        return builder().withIgnoredFieldsOfTypes(types).build();
    }
}
