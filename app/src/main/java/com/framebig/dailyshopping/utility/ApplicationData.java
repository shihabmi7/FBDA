package com.framebig.dailyshopping.utility;

import com.framebig.dailyshopping.model.Order;
import com.framebig.dailyshopping.model.Product;

import java.util.ArrayList;

public class ApplicationData {

    // GENERAL PRODUCT DETAILS

    public static ArrayList<Product> productArrayList = new ArrayList<Product>();
    public static ArrayList<Order> orderList = new ArrayList<Order>();
    public static int orderSize[];

    //public static ArrayList<WSAUser> wsaOthersUsersArrayList = new ArrayList<WSAUser>();
    public static String BASE_URL_GENYMOTION = "http://192.168.0.104:8080"; //"http://10.0.3.2:8080/Framebig";
    public static String BASE_URL = "http://192.168.0.104:8080/Framebig"; //"http://10.0.2.2:8080/Framebig";

    public static final int MAX_NO_QUANTITY = 20;
    public final static String SHOW_ALL_RESTAURENT = "http://45.55.196.7:1337/rest/searchRestaurant";
    public final static String POST_CODE = "postCode";
    private static String menu_Text[] = {"Edit your profile", "Write orderSize review", "Setting", "Your recent orders", "Your recent reviews", "Your HalalHub points", "Your favourite food"};

    public static void orderSIze(int size) {

        orderSize = new int[size];
    }

}
