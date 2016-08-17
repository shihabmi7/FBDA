package com.framebig.dailyshopping.network;

import android.content.Context;
import android.util.Log;

import com.framebig.dailyshopping.model.Product;
import com.framebig.dailyshopping.model.ProductType;
import com.framebig.dailyshopping.utility.ApplicationData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetProductListAPI extends BaseTask {

    String start = "1";
    String requestString = "";
    public String jsonData = "";
    public String Message = "";
    public boolean Status = false;

    public final String TAGS = "data";
    public final String PROFILE = "profile";
    public final String NAME = "name";
    public final String ID = "id";
    public final String EMAIL = "email";
    public final String ADDRESS = "address";
    public final String POSTCODE = "postalCode";
    public final String FOOD_TYPE_TAG = "tag";
    public final String FOOD_LOGO_IMAGE = "logoImage";
    public final String STATUS = "status";
    public final String OPENING_TIME = "opening_time";
    public final String CLOSING_TIME = "closing_time";


    public String postCode = null;
    public ProductType userType = null;
    public String SUB_URL = "/product/productlist";
    public String URL_IMAGE = "http://10.0.3.2:8080/framebig_daily_apps/";


    /*
     * "id": 3, "name": "Wow Burger", "address":
     * "House 12, Road 18, Sector 3, Dhaka, 1230", "postalCode": "1230",
     * "email": "sds@asda.fdgdf", "category": 2, "status": "active", "profile":
     * 3, "geo_location": "", "opening_time": "1970-01-01T04:00:00.000Z",
     * "closing_time": "1970-01-01T16:00:00.000Z", "delivery_start_time":
     * "1970-01-01T05:00:00.000Z", "delivery_end_time":
     * "1970-01-01T15:00:00.000Z", "creation_date": "2015-08-23T13:04:16.000Z",
     * "update_date": "2015-08-23T13:09:36.000Z"
     */
    public GetProductListAPI(Context ctx, boolean displayProgress, ProductType userType) {

        super(ctx, displayProgress);
        this.userType = userType;
    }

    @Override
    boolean task() {

        ApplicationData.productArrayList.clear();
        try {

         /*   HashMap<String, String> params = new HashMap<String, String>();
            params.put(new String("postalCode"), postCode);
            params.put(new String("tag"), "");*/

            HttpRequest request = HttpRequest.get(ApplicationData.BASE_URL_GENYMOTION + SUB_URL, true);
            jsonData = request.body();
            System.out.println(jsonData);
            Log.i("product list", jsonData);


        } catch (Exception e) {

            e.printStackTrace();

        }

        return true;

    }

    @Override
    boolean taskOnComplete() {

        try {

            // JSONObject jObject = new JSONObject(jsonData);
/*
            "full_name": "American Burger",
                    "stock_status": "20",
                    "standard_price": "120.00",
                    "id": "1",
                    "picture_location": "http://localhost:8080/framebig_daily_apps/burger.jpg"
                    */

            JSONArray jsonArray = new JSONArray(jsonData);

            // JSONArray jsonArray = jObject.getJSONArray(TAGS);

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jobj2 = jsonArray.getJSONObject(i);

                Product resObj = new Product();

                resObj.setProductName(jobj2.getString("full_name"));
                // resObj.setBrand_name(jobj2.getString("stock_status"));
                resObj.setStandard_price(jobj2.getString("standard_price"));
                resObj.setProduct_picture(URL_IMAGE + jobj2.getString("picture_location"));
                // resObj.setProduct_picture("http://10.0.3.2:8080/framebig_daily_apps/burger.jpg");
                Log.e("pic url", "" + jobj2.getString("picture_location"));
                ApplicationData.productArrayList.add(resObj);

                /*
                  if (jobj2.has(TAGS)) {

				  JSONArray array = jobj2.getJSONArray(TAGS);

				  for (int j = 0; j < array.length(); j++) {

				  JSONObject jObj3 = array.getJSONObject(j);

				  String tag = jObj3.getString(FOOD_TYPE_TAG);

				  Log.e(" fOOD tag >> ", tag);

				  // photo_reference = jObj3.getString("photo_reference"); //
				  resObj.setImage_Url(PHOTO_URL_FIRST_PART // + photo_reference
				  + "&" + key); } } if (jobj2.has(PROFILE)) {

				  // JSONArray array = jobj2.getJSONArray(PROFILE); //
				 JSONObject jObj3 = jobj2.getJSONObject(PROFILE); String
				 image_url = jObj3.getString(FOOD_LOGO_IMAGE);
				 resObj.setImage_Url(ApplicationData.BASE_URL + image_url);

				  Log.e(" Res Image >> ", image_url);

				 }

                      else {

					  resObj.setImage_Url(jobj2.getString("icon")); }

			  */


                // ApplicationData.restaurantList.add(resObj);


            }

        } catch (JSONException e) {

            e.printStackTrace();
        } catch (Exception e) {

        }

        return true;
    }

    @Override
    boolean taskOnFailure() {

        return false;

    }

    @Override
    public void setListener(CustomListener cust) {
        listener = cust;
    }

   /* private ArrayList<WSAUser> getFamilyMemberList() {

        ArrayList<WSAUser> familymemberlist = new ArrayList<WSAUser>();
        WSAUser wsaUser = null;

        wsaUser = new WSAUser();
        wsaUser.setName("Shihab");
        wsaUser.setUserType(WSAUserType.FAMILY);
        familymemberlist.add(wsaUser);


        wsaUser = new WSAUser();
        wsaUser.setName("Riad");
        wsaUser.setUserType(WSAUserType.FAMILY);
        familymemberlist.add(wsaUser);


        wsaUser = new WSAUser();
        wsaUser.setName("Arshi");
        wsaUser.setUserType(WSAUserType.FAMILY);
        familymemberlist.add(wsaUser);

        return familymemberlist;

    }

    private ArrayList<WSAUser> getOtherMembersLISt() {

        ArrayList<WSAUser> otherMemberList = new ArrayList<WSAUser>();
        WSAUser wsaUser = null;

        wsaUser = new WSAUser();
        wsaUser.setName("Rony");
        wsaUser.setUserType(WSAUserType.OTHERS);
        otherMemberList.add(wsaUser);

        wsaUser = new WSAUser();
        wsaUser.setName("Towhid");
        wsaUser.setUserType(WSAUserType.OTHERS);
        otherMemberList.add(wsaUser);


        wsaUser = new WSAUser();
        wsaUser.setName("Masum");
        wsaUser.setUserType(WSAUserType.OTHERS);
        otherMemberList.add(wsaUser);

        return otherMemberList;
    }*/
}
