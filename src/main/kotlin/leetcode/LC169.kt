package leetcode

fun main() {

    println("majorityElement ${majorityElement(intArrayOf(3, 2, 3))}")
    println("majorityElement2 ${majorityElement2(intArrayOf(3, 2, 3))}")
    println("majorityElement3 ${majorityElement3(intArrayOf(3, 3, 3, 3, 2, 2, 2))}")
}

private fun majorityElement(nums: IntArray): Int {
    val map = hashMapOf<Int, Int>()

    nums.forEach {
        map[it] = (map[it] ?: 0) + 1
    }

    return map.maxBy { it.value }.key
}

private fun majorityElement2(nums: IntArray): Int {
    nums.sort()
    return nums[nums.size / 2]
}

/**
 * Реализация алгоритма Бойера-Мура (Boyer-Moore Voting Algorithm)
 * Объяснение кода:
 * 	1.	Инициализация:
 * 	•	Переменная candidate хранит текущего кандидата на “множество”.
 * 	•	Переменная count отслеживает число голосов за кандидата.
 * 	2.	Первый проход по массиву:
 * 	•	Если count == 0, назначаем текущий элемент как кандидата.
 * 	•	Если текущий элемент совпадает с кандидатом, увеличиваем счетчик.
 * 	•	Если текущий элемент не совпадает, уменьшаем счетчик.
 * 	3.	(Опционально) Второй проход:
 * 	•	Подтверждаем, что кандидат действительно является “множество”, проверяя, что он встречается более  n/2  раз.
 * 	4.	Возврат результата:
 * 	•	Возвращаем candidate, если он подтвержден.
 */
private fun majorityElement3(nums: IntArray): Int {
    var candidate = 0
    var counter = 0

    nums.forEach { num ->
        if (counter == 0) {
            candidate = num
        }

        if (candidate == num) {
            counter++
        } else {
            counter--
        }
//        counter += if (candidate == num) 1 else -1
    }

    return candidate
}
