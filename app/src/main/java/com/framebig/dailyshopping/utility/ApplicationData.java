package com.framebig.dailyshopping.utility;

import com.framebig.dailyshopping.model.Product;

import java.util.ArrayList;

public class ApplicationData {

    // GENERAL PRODUCT DETAILS
    public static ArrayList<String> GeoCodeTemp = new ArrayList<String>();
    public static ArrayList<Product> productArrayList = new ArrayList<Product>();
    //public static ArrayList<WSAUser> wsaOthersUsersArrayList = new ArrayList<WSAUser>();
    public static String BASE_URL_GENYMOTION = "http://10.0.3.2:8080/Framebig";
    public static String BASE_URL= "http://10.0.2.2:8080/Framebig";


    public static final int MAX_NO_QUANTITY = 20;
    public static final int MIN_NO_QUANTITY = 1;
    public static final String CURRENCY = "BDT";

    public final static String SHOW_ALL_RESTAURENT = "http://45.55.196.7:1337/rest/searchRestaurant";
    public final static String SHOW_RESTAURENT_MENU = "http://45.55.196.7:1337/rest/restaurantMenu/all/with/menuItems";
    public final static String SHOW_FOOD_DETAILS = "http://45.55.196.7:1337/rest/foodItem/get/";
    public final static String LOG_IN_BASE_URL = "http://45.55.196.7:1337/auth/local";
    public final static String REGISTRATION_BASE_URL = "http://45.55.196.7:1337/auth/local/register";
    public final static String REGISTRATION_ORDER_URL = "http://45.55.196.7:1337/rest/order/createOrUpdate";


    public final static String POST_CODE = "postCode";
    private static String menu_Text[] = {"Edit your profile", "Write a review", "Setting", "Your recent orders", "Your recent reviews", "Your HalalHub points", "Your favourite food"};


    //	Library We use
    //	Toast: https://github.com/JohnPersano/Supertoasts/wiki/SuperActivityToast


}
