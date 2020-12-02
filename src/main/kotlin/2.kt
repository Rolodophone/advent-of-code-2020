import java.io.File

fun part1() {
	var count = 0

	File("2.txt").forEachLine { line ->
		val parts = line.split(" ")
		val rangeList = parts[0].split("-").map { it.toInt() }
		val range = rangeList[0]..rangeList[1]
		val letter = parts[1][0]
		val password = parts[2]

		if (password.count { it == letter } in range) count++
	}

	println(count)
}

fun part2() {

}