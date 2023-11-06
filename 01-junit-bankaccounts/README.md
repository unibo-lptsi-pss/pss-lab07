# Unit testing with JUnit 5

Consider the *Banking* domain of previous labs: `AccountHolder`s, `BankAccount`s, and their implementations.
Write unit tests to verify the correctness of these classes.

Guidelines:

* For each class, test the construction of new instances (their initial state)
* Test each method/behaviour works as expected
* Consider "corner cases" - i.e. what might happen if the user passes "weird" inputs (e.g., a deposit of a negative value)
* Use what your "learn" by preparing/running tests to improve the soundness of your implementations

1. Write a test class `TestSimpleBankAccount` to test `SimpleBankAccount`
2. Write a test class `TestStrictBankAccount` to test `StrictBankAccount`

Notes:

* Consult the [JavaDoc of JUnit 5](https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/package-summary.html)
* For asserting equality on floats/doubles, consider using the overloaded method `assertEquals(double expected, double actual, double delta)` which allows you to specify a `delta` (tolerance) for equality
    * By the way, notice that the "standard" handling of floats/doubles (cf. IEEE 754) in programming languages is not a great choice for the management of bank accounts and financial transactions. It would be far better to use [`BigDecimal`](https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html).