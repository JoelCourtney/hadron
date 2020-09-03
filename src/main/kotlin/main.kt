import java.io.File

fun main(args: Array<String>) {
    if (args.size == 1) {
        val source = HadronParser.parseHadron(File(args[0]).readText())
        source.exec()
    } else {
        val source = HadronParser.parseHadron(File("test.hn").readText())
        source.exec()
    }

//    val distance = BaseDimension("Distance")
//    val meter = BaseUnit("m", distance)
//    val kilometer = DerivedUnit("km", CompositeUnit(mapOf(meter to CommonValues.one)), IntegerValue(1000))
//
//    val m1 = UnitNumericValue(IntegerValue(1), meter)
//    println(m1)
//
//    val km2 = UnitNumericValue(IntegerValue(2), kilometer)
//    println(km2)
//
//    println(km2.convert(meter))
}