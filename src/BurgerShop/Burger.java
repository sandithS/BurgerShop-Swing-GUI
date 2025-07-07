package BurgerShop;

public class Burger {

    private String orderId;
    private String customerId;
    private String customerName;
    private int burgerQty;
    private String status;

    public Burger() {
        
    }

    public Burger(String orderId, String customerId, String customerName, int burgerQty, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.burgerQty = burgerQty;
        this.status = status;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the burgerQty
     */
    public int getBurgerQty() {
        return burgerQty;
    }

    /**
     * @param burgerQty the burgerQty to set
     */
    public void setBurgerQty(int burgerQty) {
        this.burgerQty = burgerQty;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return orderId + "," + customerId + "," + customerName + "," + burgerQty + "," + status;
    }

    public boolean equals(Burger customer) {
        return this.orderId.equalsIgnoreCase(customer.orderId);
    }

}
