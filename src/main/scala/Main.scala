import scala.annotation.tailrec

object Main extends App{
  def findMiddleElement[T](xs: List[T]): Option[T] = {
    @tailrec
    def loop(ys: List[T], acc: List[T], cnt: Int): Option[T] = {
      ys match {
        case head :: tail if cnt % 2 == 0 =>
          println("first case")
          println(acc.head)
          println("tail")
          tail.foreach(t => print(t + " "))
          println()
          println("accTail")
          acc.tail.foreach(f => print(f + " "))
          println()
          if(tail == Nil){
            loop(tail,acc, cnt + 1)
          }else{
          loop(tail, acc.tail, cnt + 1) }
        case _ :: tail =>
          println("second case")
          println("tail")
          tail.foreach(t => print(t + " "))
          println()
          println("acc")
          acc.foreach(t => print(t + " "))
          println()
          loop(tail, acc , cnt + 1)
        case Nil => acc.headOption
      }
    }
    loop(xs, xs, 0)
  }
  println(findMiddleElement(List(1,2,3,4)))
}
