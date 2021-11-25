package be.sch3lp.j2k.builder.kotlin

internal fun aDefaultCustomer(id: CustomerId = CustomerId(),
                     name: Name = Name("Edward","Nigma"),
                     address: Address = aDefaultAddress(),
                     age: Age = Age(52u)): Customer {
    return Customer(id,name, address, age)
}

internal fun aDefaultAddress(
    street: String = "Mantelstraat",
    city: String = "Kruishoutem",
    zip: Zip = Zip("9770"),
    houseNumber: String = "4",
    bus: String? = null
) = Address(street, city, zip, houseNumber, bus)