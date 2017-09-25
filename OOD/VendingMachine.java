
enum Item {
    COKE("Coke", 25), PEPSI("Pepsi", 35), SODA("Soda", 45);
    private String name;
    private int price;

    private Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }
}


enum Coin {
    PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
    private int denomination;

    private Coin(int denomination) {
        this.denomination = denomination;
    }

    public int getDenomination() {
        return denomination;
    }
}

class VendingInventory<T> {


    Map<T, Integer> map = new HashMap<>();


    public void add(T t) {

        if (map.containsKey(t)) {
            map.put(t, map.get(t) + 1);
        } else {
            map.put(t, 1);
        }
    }

    public void removeItem(T t) {

        if (map.get(t) > 2) {
            map.put(t, map.get(t) - 1);
        } else {
            map.remove(t);
        }


    }

    public int getQuantity(T item) {
        Integer value = map.get(item);
        return value == null ? 0 : value;
    }

    public void put(T item, int quantity) {
        map.put(item, quantity);
    }


    public boolean hasItem(T item) {
        return getQuantity(item) > 0;
    }


}

interface VendingMachineInterface {
    public long selectItemAndGetPrice(Item item);

    public void insertCoin(Coin coin);

    public List<Coin> refund();

    public VendingMachine.Bucket<Item, List<Coin>> collectItemAndChange();

    public void reset();


}


class VendingMachineFactory {
    public static VendingMachine createVendingMachine() {
        return new VendingMachine();
    }
}

public class VendingMachine implements VendingMachineInterface {

    private VendingInventory<Coin> cashInventory = new VendingInventory<>();
    private VendingInventory<Item> itemInventory = new VendingInventory<>();
    private double totalSales;
    private Item currentItem;
    private double currentBalance;

    private void initialize() {
        //initialize machine with 5 coins of each denomination
        // and 5 cans of each Item for
        for (Coin c : Coin.values()) {
            cashInventory.put(c, 5);
        }
        for (Item i : Item.values()) {
            itemInventory.put(i, 5);
        }

    }

    @Override
    public long selectItemAndGetPrice(Item item) {
        if (itemInventory.hasItem(item)) {

            currentItem = item;

            return currentItem.getPrice();
        }

        throw new EmptyException("Sold Out, Please buy another item");


    }

    @Override
    public void insertCoin(Coin coin) {
        currentBalance = currentBalance + coin.getDenomination();
        cashInventory.add(coin);
    }


    private List<Coin> collectChange() {
        double changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance = 0;
        currentItem = null;
        return change;
    }

    @Override
    public List<Coin> refund() {
        List<Coin> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;
    }

    private void updateCashInventory(List<Coin> change) {
        for (Coin c : change) {
            cashInventory.removeItem(c);
        }
    }

    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        Item item = collectItem();
        totalSales = totalSales + currentItem.getPrice();
        List<Coin> change = collectChange();
        return new Bucket<>(item, change);
    }

    @Override
    public void reset() {

    }


    private List<Coin> getChange(double amount) throws NotSufficientChangeException {
        List<Coin> changes = new ArrayList<>();

        if (amount > 0) {
            changes = new ArrayList<>();
            double balance = amount;
            while (balance > 0) {
                if (balance >= Coin.QUARTER.getDenomination() && cashInventory.hasItem(Coin.QUARTER)) {
                    changes.add(Coin.QUARTER);
                    balance = balance - Coin.QUARTER.getDenomination();

                } else if (balance >= Coin.DIME.getDenomination() && cashInventory.hasItem(Coin.DIME)) {
                    changes.add(Coin.DIME);
                    balance = balance - Coin.DIME.getDenomination();

                } else if (balance >= Coin.NICKLE.getDenomination() && cashInventory.hasItem(Coin.NICKLE)) {
                    changes.add(Coin.NICKLE);
                    balance = balance - Coin.NICKLE.getDenomination();

                } else if (balance >= Coin.PENNY.getDenomination() && cashInventory.hasItem(Coin.PENNY)) {
                    changes.add(Coin.PENNY);
                    balance = balance - Coin.PENNY.getDenomination();

                } else {
                    throw new NotSufficientChangeException("NotSufficientChange, Please try another product");
                }
            }
        }

        return changes;
    }


    private boolean hasSufficientChange() {
        return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice());
    }


    private boolean hasSufficientChangeForAmount(double amount) {
        boolean hasChange = true;
        try {
            getChange(amount);
        } catch (NotSufficientChangeException nsce) {
            return hasChange = false;
        }
        return hasChange;
    }


    private boolean isFullPaid() {
        return currentBalance >= currentItem.getPrice();
    }


    private Item collectItem() {
        if (isFullPaid()) {
            if (hasSufficientChange()) {
                itemInventory.removeItem(currentItem);
                return currentItem;
            }
            throw new NotSufficientChangeException("Not Sufficient change in Inventory");
        }
        double remainingBalance = currentItem.getPrice() - currentBalance;
        throw new NotFullPaidException("Price not full paid, remaining : ", remainingBalance);
    }

    public class NotSufficientChangeException extends RuntimeException {
        private String message;

        public NotSufficientChangeException(String string) {
            this.message = string;
        }

        @Override
        public String getMessage() {
            return message;
        }
    }


    public class EmptyException extends RuntimeException {
        private String message;

        public EmptyException(String string) {
            this.message = string;
        }

        @Override
        public String getMessage() {
            return message;
        }

    }

    public class NotFullPaidException extends RuntimeException {
        private String message;
        private double remaining;

        public NotFullPaidException(String message, double remaining) {
            this.message = message;
            this.remaining = remaining;
        }

        public double getRemaining() {
            return remaining;
        }

        @Override
        public String getMessage() {
            return message + remaining;
        }
    }

    class Bucket<E1, E2> {
        private E1 first;
        private E2 second;

        public Bucket(E1 first, E2 second) {
            this.first = first;
            this.second = second;
        }

        public E1 getFirst() {
            return first;
        }

        public E2 getSecond() {
            return second;
        }
    }


}
