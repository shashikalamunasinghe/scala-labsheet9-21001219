
  class Rational(n: Int, d: Int) {
    require(d != 0, "Denominator must not be zero")

    private val gcdVal = gcd(n.abs, d.abs)
    val numer = n / gcdVal
    val denom = d / gcdVal

    private def gcd(a: Int, b: Int): Int = {
      if (b == 0) a else gcd(b, a % b)
    }

    def neg: Rational = new Rational(-numer, denom)

    override def toString: String = s"$numer / $denom"
  }

  object RationalTest extends App {
    val x = new Rational(2, 3)
    println(s"x = $x")
    println(s"Negation of x = ${x.neg}")
  }
