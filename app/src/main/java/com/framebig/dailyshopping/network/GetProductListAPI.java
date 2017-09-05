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
    public String URL_IMAGE = "http://192.168.0.104:8080/Framebig/";


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
                resObj.setWeight_per_unit(jobj2.getString("weight_per_unit"));

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

}
