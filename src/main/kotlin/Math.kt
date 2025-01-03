import kotlin.math.pow

fun main() {

    val x = 1
    val y = 2
    val opponentX = 1
    val opponentY = 2
    val distanceToOpponent = Math.sqrt(
        (opponentX - x).toDouble().pow(2) + (opponentY - y).toDouble().pow(2)
    )

    test1()
}

fun test1() {

//    val minAngle = Math.min(90, Math.abs(nextCheckpointAngle)).toDouble()
//    var thrust = (Math.cos(Math.toRadians(minAngle)) * 100).toInt()
//
//
//    if (nextCheckpointDist <= 2000) {
//        thrust = (thrust * nextCheckpointDist * 1f / 1500).toInt()
//    }
//
//    thrust = Math.max(20, thrust)
//
//    thrust = Math.min(thrust, 100)
//
//    System.err.println("Debug messages...$nextCheckpointAngle $thrust distance: $nextCheckpointDist")
//    if (nextCheckpointDist > 8000
//        && thrust > 95
//        && !isBoostUsed
//    ) {
//        println("$nextCheckpointX $nextCheckpointY BOOST")
//        isBoostUsed = true
//    } else {
//        println("$nextCheckpointX $nextCheckpointY $thrust")
//    }
}
