import java.io.File
import java.nio.file.Paths

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

fun main() {
	var count = 0

	println(Paths.get("").toAbsolutePath())

	File("src/main/resources/2.txt").forEachLine { line ->
		val parts = line.split(" ")
		val positions = parts[0].split("-").map { it.toInt() }
		val letter = parts[1][0]
		val password = parts[2]

		if (positions.count { password[it - 1] == letter } == 1) count++
	}

	println(count)
}