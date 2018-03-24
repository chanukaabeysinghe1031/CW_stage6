import java.util.ArrayList;

class Transaction {
    public static void transferCurrency(ArrayList<BankAccount> loggedBankAccounts) {
        BankAccount sendBankAccount = null;
        BankAccount receiveBankAccount = null;
        int transferFromAccountNumber,
                transferToAccountNumber,
                transferCurrency;

        System.out.println("Please enter the bank account number you want to send from");
        System.out.print("Enter : ");
        transferFromAccountNumber = UserInterface.validateAccountNumber();
        System.out.println("Please enter the bank account number you want to send to");
        System.out.print("Enter : ");
        transferToAccountNumber = UserInterface.validateAccountNumber();

        //check the array list and get the bank account which want to send money
        for (int i = 0; i < loggedBankAccounts.size(); i++) {
            if (transferFromAccountNumber == loggedBankAccounts.get(i).getAccountNumber()) {
                sendBankAccount = loggedBankAccounts.get(i);
            }
        }
        //check the array list and get the bank account which is wanted to be received money
        for (int i = 0; i < loggedBankAccounts.size(); i++) {
            if (transferToAccountNumber == loggedBankAccounts.get(i).getAccountNumber()) {
                receiveBankAccount = loggedBankAccounts.get(i);
            }
        }

        if (!(sendBankAccount == null && receiveBankAccount == null)) {
            System.out.println("Please enter the amount of currency you want to transfer ");
            transferCurrency = UserInterface.validate();

            if (sendBankAccount.getAccountBalance() - transferCurrency < 10
                    && sendBankAccount.getAccountBalance() >= 0) {

                System.out.println("Please notice that tour balance "
                        + "will be reduce than 10. ");
                sendBankAccount.setAccountBalance(sendBankAccount.getAccountBalance() - transferCurrency);
                receiveBankAccount.setAccountBalance(receiveBankAccount.getAccountBalance() + transferCurrency);
                System.out.println("Your new balance of the bank account "
                        + transferFromAccountNumber + " is " + sendBankAccount.getAccountBalance());
                System.out.println("Your new balance of the bank account "
                        + transferToAccountNumber + " is " + receiveBankAccount.getAccountBalance());

            } else if (!(sendBankAccount.getAccountBalance() - transferCurrency < 10
                    || receiveBankAccount.getAccountBalance() + transferCurrency > 100000)) {

                sendBankAccount.setAccountBalance(sendBankAccount.getAccountBalance() - transferCurrency);
                receiveBankAccount.setAccountBalance(receiveBankAccount.getAccountBalance() + transferCurrency);
                System.out.println("Your new balance of the bank account "
                        + transferFromAccountNumber + " is " + sendBankAccount.getAccountBalance());
                System.out.println("Your new balance of the bank account "
                        + transferToAccountNumber + " is " + receiveBankAccount.getAccountBalance());

            } else {
                System.out.println("Sorry!! You can't proceed the transaction");
            }
        }
    }
}
