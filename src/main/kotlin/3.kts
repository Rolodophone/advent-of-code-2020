import java.io.File

fun part1() {
	var x = 0
	var numTrees = 0
	var evenRow = true

	File("3.txt").forEachLine { line ->
		if (evenRow) {
			if (line[x] == '#') {
				numTrees++
			}
			x += 1
			x %= line.length
		}
		evenRow = !evenRow
	}

	println(numTrees)
}

part1()