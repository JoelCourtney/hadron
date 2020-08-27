package values

class CommonValues {
    companion object {
        val zero = IntegerValue(0)
        val one = IntegerValue(1)

        val `true` = BooleanValue(true)
        val `false` = BooleanValue(false)

        val emptyString = StringValue("")
    }
}
