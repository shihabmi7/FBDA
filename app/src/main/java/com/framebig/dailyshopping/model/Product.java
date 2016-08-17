package com.framebig.dailyshopping.model;

/**
 * Created by Shihab on 8/16/2016.
 */
public class Product {

    /*prouduct-id,

    company_id(fk),category_id
    (fk),brand_id,full_name,short_name,code,description,unit_name,weight_per_unit,dimension,
    standard_price,discount_amount,discount_from_date,discount_to_date,stock_status,standard_delivery_time_in_days.
*/

    private String product_name;
    private String company_name;
    private String Brand_name;
    private String prouduct_id;
    private String full_name;
    private String short_name;
    private String description;
    private String unit_name;
    private String weight_per_unit;
    private String dimension;
    private String standard_price;
    private String discount_amount;
    private String discount_from_date;
    private String discount_to_date;
    private String stock_status;
    private String standard_delivery_time_in_days;
    private String product_picture;


    public String getProductName() {
        return product_name;
    }

    public void setProductName(String name) {
        this.product_name = name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getBrand_name() {
        return Brand_name;
    }

    public void setBrand_name(String brand_name) {
        Brand_name = brand_name;
    }

    public String getProuduct_id() {
        return prouduct_id;
    }

    public void setProuduct_id(String prouduct_id) {
        this.prouduct_id = prouduct_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public String getWeight_per_unit() {
        return weight_per_unit;
    }

    public void setWeight_per_unit(String weight_per_unit) {
        this.weight_per_unit = weight_per_unit;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getStandard_price() {
        return standard_price;
    }

    public void setStandard_price(String standard_price) {
        this.standard_price = standard_price;
    }

    public String getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(String discount_amount) {
        this.discount_amount = discount_amount;
    }

    public String getDiscount_from_date() {
        return discount_from_date;
    }

    public void setDiscount_from_date(String discount_from_date) {
        this.discount_from_date = discount_from_date;
    }

    public String getDiscount_to_date() {
        return discount_to_date;
    }

    public void setDiscount_to_date(String discount_to_date) {
        this.discount_to_date = discount_to_date;
    }

    public String getStock_status() {
        return stock_status;
    }

    public void setStock_status(String stock_status) {
        this.stock_status = stock_status;
    }

    public String getStandard_delivery_time_in_days() {
        return standard_delivery_time_in_days;
    }

    public void setStandard_delivery_time_in_days(String standard_delivery_time_in_days) {
        this.standard_delivery_time_in_days = standard_delivery_time_in_days;
    }

    public String getProduct_picture() {
        return product_picture;
    }

    public void setProduct_picture(String product_picture) {
        this.product_picture = product_picture;
    }
}
