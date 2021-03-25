package com.javahw;

public class BankAccount {

    private String name;
    private double count;
    private double bankProfit;

    public BankAccount(String name, double count) {
        this.name = name;
        this.count = count;
    }

    public void add(double money) {
        double commission = money * 0.005 / 100;
        count += money - commission;
        bankProfit += commission;
        System.out.printf("На счет пользлвателя %s зачислено %s$ комиссия: %s$\n", this.name, money, commission);
    }

    public void transfer(BankAccount otherPerson, double money){
        if(money > this.count) {
            System.out.println("Не удалось выполнить транзакцию");
        }
        this.count -= money;
        double commission = money * 0.01 / 100;
        otherPerson.count += money - commission;
        bankProfit += commission;
        System.out.printf("Транзакия: пользователь %s перевел на счет %s %s$ комиссия: %s$\n", this.name, otherPerson.name, money, commission);
    }

    public double getBankProfit() {
        return bankProfit;
    }
}