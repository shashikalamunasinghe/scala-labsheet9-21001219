class Account(initialBalance: Double) {
  private var balance: Double = initialBalance

  def getBalance: Double = balance

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(s"Deposited: $amount")
    } else {
      println("Invalid deposit amount")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(s"Withdrew: $amount")
    } else {
      println("Invalid withdrawal amount or insufficient balance")
    }
  }

  def transfer(amount: Double, targetAccount: Account): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      targetAccount.deposit(amount)
      println(s"Transferred: $amount to target account")
    } else {
      println("Invalid transfer amount or insufficient balance")
    }
  }
}

object AccountTest extends App {
  val account1 = new Account(1000.0)
  val account2 = new Account(500.0)

  println("Initial balances:")
  println(s"Account 1 balance: ${account1.getBalance}")
  println(s"Account 2 balance: ${account2.getBalance}")

  account1.deposit(200.0)
  account2.withdraw(50.0)

  println("Balances after transactions:")
  println(s"Account 1 balance: ${account1.getBalance}")
  println(s"Account 2 balance: ${account2.getBalance}")

  account1.transfer(300.0, account2)

  println("Balances after transfer:")
  println(s"Account 1 balance: ${account1.getBalance}")
  println(s"Account 2 balance: ${account2.getBalance}")
}
