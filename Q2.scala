class kRational(n: Int, d: Int) {
  require(d != 0, "Denominator must not be zero")

  private val gcdVal = gcd(n.abs, d.abs)
  val numer = n / gcdVal
  val denom = d / gcdVal

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  def sub(that: kRational): kRational = {
    new kRational(numer * that.denom - that.numer * denom, denom * that.denom)
  }

  override def toString: String = s"$numer / $denom"
}

object RationalTests extends App {
  val x = new kRational(3, 4)
  val y = new kRational(5, 8)
  val z = new kRational(2, 7)

  val result = x.sub(y).sub(z)
  println(s"x - y - z = $result")
}

