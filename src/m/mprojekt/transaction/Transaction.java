package m.mprojekt.transaction;

import java.util.Objects;


public class Transaction {
    
    private String name;
    private String surname;
    private String sourceIban;
    private String destinationIban;
    private double amount;

    public Transaction() {
    }

    public Transaction(String name, String surname, String sourceIban, String destinationIban, double amount) {
        this.name = name;
        this.surname = surname;
        this.sourceIban = sourceIban;
        this.destinationIban = destinationIban;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSourceIban() {
        return sourceIban;
    }

    public void setSourceIban(String sourceIban) {
        this.sourceIban = sourceIban;
    }

    public String getDestinationIban() {
        return destinationIban;
    }

    public void setDestinationIban(String destinationIban) {
        this.destinationIban = destinationIban;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transakcja: " + "imię = " + name + ", nazwisko = " + surname + 
                ", żródłowy iban = " + sourceIban + ", docelowy iban = " + destinationIban + 
                ", kwota = " + String.format( "%.2f", amount ) + "zł }";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.surname);
        hash = 89 * hash + Objects.hashCode(this.sourceIban);
        hash = 89 * hash + Objects.hashCode(this.destinationIban);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Transaction other = (Transaction) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.sourceIban, other.sourceIban)) {
            return false;
        }
        if (!Objects.equals(this.destinationIban, other.destinationIban)) {
            return false;
        }
        if (Double.doubleToLongBits(this.amount) != Double.doubleToLongBits(other.amount)) {
            return false;
        }
        return true;
    }
}