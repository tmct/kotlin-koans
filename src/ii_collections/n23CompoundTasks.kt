package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> =
        customers
                .filter { it.orders.any { it.products.contains(product) } }
                .toSet()

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    return orders
            .filter { it.isDelivered }
            .flatMap { it.products }
            .maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
return customers
        .flatMap { it.orders }
        .flatMap { it.products }
        .count { it == product}
}
