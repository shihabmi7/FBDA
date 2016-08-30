package com.framebig.dailyshopping.model;

/**
 * Created by Shihab on 8/29/2016.
 */
public class Order {


    /* Master : >>  id, order_no, customer_id, order_date, customer_preferred_delivery_date, customer_preferred_delivery_time,
     planned_delivery_date, actual_delivery_date, delivererd_by.

     */
    /*
    Details : order_details - id, order_no(fk), product_id(fk), amount_in_unit, sales_price_per_unit.
    */
    private String id;
    private String order_no;
    private String customer_id;
    private String order_date;
    private String customer_preferred_delivery_date;
    private String customer_preferred_delivery_time;
    private String planned_delivery_date;
    private String actual_delivery_date;
    private String delivererd_by;
    private String product_id;
    private String amount_in_unit;
    private String sales_price_per_unit;
    private String vat;
    private String salesTax;
    private String total;
    private String subTotal;
    private String orderType;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getCustomer_preferred_delivery_date() {
        return customer_preferred_delivery_date;
    }

    public void setCustomer_preferred_delivery_date(String customer_preferred_delivery_date) {
        this.customer_preferred_delivery_date = customer_preferred_delivery_date;
    }

    public String getCustomer_preferred_delivery_time() {
        return customer_preferred_delivery_time;
    }

    public void setCustomer_preferred_delivery_time(String customer_preferred_delivery_time) {
        this.customer_preferred_delivery_time = customer_preferred_delivery_time;
    }

    public String getPlanned_delivery_date() {
        return planned_delivery_date;
    }

    public void setPlanned_delivery_date(String planned_delivery_date) {
        this.planned_delivery_date = planned_delivery_date;
    }

    public String getActual_delivery_date() {
        return actual_delivery_date;
    }

    public void setActual_delivery_date(String actual_delivery_date) {
        this.actual_delivery_date = actual_delivery_date;
    }

    public String getDelivererd_by() {
        return delivererd_by;
    }

    public void setDelivererd_by(String delivererd_by) {
        this.delivererd_by = delivererd_by;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getAmount_in_unit() {
        return amount_in_unit;
    }

    public void setAmount_in_unit(String amount_in_unit) {
        this.amount_in_unit = amount_in_unit;
    }

    public String getSales_price_per_unit() {
        return sales_price_per_unit;
    }

    public void setSales_price_per_unit(String sales_price_per_unit) {
        this.sales_price_per_unit = sales_price_per_unit;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(String salesTax) {
        this.salesTax = salesTax;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
