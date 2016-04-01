package m.mprojekt.transaction;

import java.util.*;
import java.util.stream.*;


public class Transactions {
    
    private List<Transaction> transactions;
    private DoubleSummaryStatistics statistic;

    public Transactions() {
        transactions = new ArrayList<>();
        generateStats();
    }

    public Transactions(List<Transaction> transactions) {
        this.transactions = transactions;
        generateStats();
    }
    
    public void add(Transaction transaction){
        this.transactions.add(transaction);
        generateStats();
    }
    
    public DoubleSummaryStatistics getStatistic(){
        return statistic;
    }
    
    public void printStatistic(){
        System.out.println("Statystyki transakcji: " + count() + 
                " transakcje, suma = " + String.format("%.2f", getSum()) + 
                "zł, minimalna = " + String.format("%.2f", getMin()) +
                "zł, średnia = " + String.format("%.2f", getAverage()) + 
                "zł, maksymalna = " + String.format("%.2f", getMax()) + "zł");
    }
    
    public long count(){
        return statistic.getCount();
    }
    
    public double getMin(){
        return (statistic.getMin() == Double.POSITIVE_INFINITY) ? 0d : statistic.getMin();
    }
    
    public double getAverage(){
        return statistic.getAverage();
    }
    
    public double getMax(){
        return (statistic.getMax()== Double.NEGATIVE_INFINITY) ? 0d : statistic.getMax();
    }
    
    public double getSum(){
        return statistic.getSum();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
        generateStats();
    }

    @Override
    public String toString() {
        if(transactions.isEmpty())
            return "Brak transakcji";
        return "Liczba transakcji: " + transactions.size();
    }
    
    private void generateStats() {
        Stream<Transaction> tmp = transactions.stream();
        statistic = tmp.collect(Collectors.summarizingDouble(Transaction::getAmount));
    }
}