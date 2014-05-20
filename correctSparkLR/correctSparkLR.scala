package com.anphoenix.demo

import java.util.Random
import scala.math.exp
import breeze.linalg.{Vector, DenseVector}
import org.apache.spark._
/**
* Logistic regression based classification.
*/
object CorrectSparkLR {
	val D = 3 // Numer of dimensions
	val ITERATIONS = 500
	case class DataPoint(x: Vector[Double], y: Double)

	def parseVector(line: String): Vector[Double] = {
		DenseVector(line.split(' ').map(_.toDouble))
	}

        def getDataFromFile(sc: SparkContext) = {
        	val lines = sc.textFile("lr.data.label")
		val data = lines.map(parseVector _)
                val mappedData=data.map(p=>DataPoint(p(0 to 2),p(3)))
                mappedData
	}

def main(args: Array[String]) {
	val sc = new SparkContext("local", "SparkLR",
		System.getenv("SPARK_HOME"),List("target/scala-2.10/correct-spark-lr-project_2.10-1.0.jar"))
        val points = getDataFromFile(sc)
	// Initialize w to a random value
	var w = DenseVector.ones[Double](D)
	println("Initial w: " + w)
	for (i <- 1 to ITERATIONS) {
		println("On iteration " + i)
	/**	val gradient = points.map { p =>
			p.x * (1 / (1 + exp(-p.y * (w.dot(p.x)))) - 1) * p.y
		}.reduce(_ + _)*/
		
		val gradient = points.map { p => p.x * (1 / (1 + exp(-w.dot(p.x)))-p.y)}.reduce(_ + _)
	w -= (gradient/2000.0)
       }
       
	println("Final w: " + w)
	sc.stop()
}
}
