public class SalesPerson {
    private String id;
    private Sales[] salesHistory;
    private int count = 0;

    public SalesPerson(String id) {
        this.id = id;
        this.salesHistory = new Sales[100]; // Assuming a maximum of 100 sales
        this.count = 0;
    }
    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
    }
    public Sales getSalesHistory(int index) {
        return salesHistory[index];
    }
    public void setSalesHistory(Sales s) {
        salesHistory[count] = s;
        count++;
    }

    public double calcTotalSales() {
        double totalSales = 0.0;
        for (int i = 0; i < count; i++) {
            totalSales += salesHistory[i].getValue() * salesHistory[i].getQuantity();
        }
        return totalSales;
    }

    public Sales largestSale() {
        Sales lSale;
        lSale = null;
        double currentMax = 0.0;
        for (int i = 0; i < count; i++) {
            if (salesHistory[i].getValue() > currentMax) {
                lSale = salesHistory[i];
                currentMax = salesHistory[i].getValue();
            }
        }
        return lSale;
    }

}
