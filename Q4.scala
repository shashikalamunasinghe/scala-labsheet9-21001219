class Accountx(val initialBalance: Double) {
  private var balance: Double = initialBalance

  def getBalance: Double = balance

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
    }
  }

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else {
      balance += balance * 0.1
    }
  }

  override def toString: String = s"Balance: $balance"
}

class Bank(val accounts: List[Accountx]) {
  def negativeBalances: List[Accountx] = {
    accounts.filter(account => account.getBalance < 0)
  }

  def totalBalance: Double = {
    accounts.map(_.getBalance).sum
  }

  def applyInterestToAll(): Unit = {
    accounts.foreach(_.applyInterest())
  }

  override def toString: String = accounts.mkString("\n")
}

object BankTest extends App {
  val account1 = new Accountx(1000.0)
  val account2 = new Accountx(-500.0)
  val account3 = new Accountx(2000.0)

  val bank = new Bank(List(account1, account2, account3))

  println("Initial bank state:")
  println(bank)

  println("\nAccounts with negative balances:")
  bank.negativeBalances.foreach(println)

  println("\nTotal balance of all accounts:")
  println(bank.totalBalance)

  println("\nApplying interest to all accounts:")
  bank.applyInterestToAll()
  println(bank)
}
