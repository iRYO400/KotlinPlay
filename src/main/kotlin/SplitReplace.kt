import java.util.concurrent.TimeUnit

const val VERSION_NAME = "2.19.0-VCAPPS-4570_ci_with_release_builds"
const val VERSION_NAME_PURE = "2.19.0"

fun main(args: Array<String>) {

    val d = VERSION_NAME_PURE.split('-')
    println(d)

    val time = DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS
    println(time)
}

val DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS = TimeUnit.HOURS.toSeconds(12)
