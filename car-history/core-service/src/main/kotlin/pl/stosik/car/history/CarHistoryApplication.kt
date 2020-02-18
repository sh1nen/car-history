package pl.stosik.car.history

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CarHistoryApplication

fun main(args: Array<String>) {
	runApplication<CarHistoryApplication>(*args)
}
