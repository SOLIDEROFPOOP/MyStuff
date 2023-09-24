public class SchollarshipCard {
    private String cardId;
    private Double balance;

    public SchollarshipCard(String cardId, Double balance) {
        this.cardId = cardId;
        this.balance = balance;
    }

    public String getCardId() {
        return cardId;
    }
    public SchollarshipCard(){

    }
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "SchollarshipCard{" +
                "cardId='" + cardId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
