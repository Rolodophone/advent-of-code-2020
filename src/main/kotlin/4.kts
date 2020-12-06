import java.io.File

val necessaryFields = listOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

val data = File("4.txt").readText()

val passports = data.split("\n\n")

val passportsWithFields = passports.map {
	it.split(Regex("""[\n ]"""))
}

fun part1() {
	println(passportsWithFields.count { passport ->
		necessaryFields.all { it in passport.map { it.slice(0..2) } }
	})
}

fun part2() {
	println(passportsWithFields.count { passport ->
		necessaryFields.all { it in passport.map { it.take(3) } } &&

		passport.all { entry ->
			val value = entry.drop(4)
			when (entry.take(3)) {
				"byr" -> value.toInt() in 1920..2002

				"iyr" -> value.toInt() in 2010..2020

				"eyr" -> value.toInt() in 2020..2030

				"hgt" -> when (value.takeLast(2)) {
					"cm" -> {
						value.dropLast(2).toInt() in 150..193
					}
					"in" -> {
						value.dropLast(2).toInt() in 59..76
					}
					else -> false
				}

				"hcl" -> value.matches(Regex("""#[0-9a-f]{6}"""))

				"ecl" -> value in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

				"pid" -> value.length == 9 && value.all { it.isDigit() }

				"cid" -> true

				else -> false
			}.also { println("Entry $entry was $it") }
		}
	})
}

part2()