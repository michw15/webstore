package main.pl.javasolution.domain;

public class Customer {

    private String customerId;
    private String name;
    private String adress;
    private boolean noOfOrdersMade;

    public Customer(String customerId, String name, String adress) {
        this.customerId = customerId;
        this.name = name;
        this.adress = adress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public boolean isNoOfOrdersMade() {
        return noOfOrdersMade;
    }

    public void setNoOfOrdersMade(boolean noOfOrdersMade) {
        this.noOfOrdersMade = noOfOrdersMade;
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (customerId == null){
            if (other.customerId != null)
                return false;
        }
        else if (!customerId.equals(other.customerId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Klient [customerId= "+customerId+", nazwa=" + name +"]";
    }


}
