package com.framebig.dailyshopping.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framebig.dailyshopping.R;
import com.framebig.dailyshopping.model.Product;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

public class SolventRecyclerViewAdapter extends RecyclerView.Adapter<SolventViewHolders> //implements View.OnClickListener
{

    private List<Product> productList;
    private Context context;
    DisplayImageOptions options;
    SolventViewHolders rcv;

    int quatity = 0;
    double totalAmount = 0;

    public SolventRecyclerViewAdapter(Context context, List<Product> itemList) {
        this.productList = itemList;
        this.context = context;
       /* ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .memoryCacheExtraOptions(480, 800) // default = device screen dimensions
                .diskCacheExtraOptions(480, 800, null)
                .threadPriority(Thread.NORM_PRIORITY - 2) // default
                .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheSizePercentage(13) // default
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new BaseImageDownloader(context)) // default
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                .writeDebugLogs()
                .build();*/


        // Create global configuration and initialize ImageLoader with this config
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).build();
        ImageLoader.getInstance().init(config);

        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                //.displayer(new RoundedBitmapDisplayer(20))
                .build();

    }

    @Override
    public SolventViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.solvent_list, null);
        rcv = new SolventViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(final SolventViewHolders holder, final int position) {

        //rcv = holder;

        final Product product = productList.get(position);

        holder.textView_productName.setText(product.getProductName());
        holder.textView_product_price.setText(product.getStandard_price());
        holder.textView_product_weight.setText(product.getWeight_per_unit());

        holder.relative_product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.openProductDetails(view);

            }
        });

        holder.relative_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.visibleCartButton(Double.parseDouble(product.getStandard_price()), position);

            }
        });

        holder.btn_decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.leaveProduct(Double.parseDouble(product.getStandard_price()),position);

            }
        });
        holder.btn_increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.addProduct(Double.parseDouble(product.getStandard_price()), position);

               /* ++quantity;
                holder.textView_quantity.setText("" + quantity);*/

            }
        });

        //holder.imageview_productPhoto.setImageResource(productList.get(position).getProduct_picture());
        ImageLoader.getInstance().displayImage(product.getProduct_picture(), holder.imageview_productPhoto, options);
    }

    /*void addProduct() {

        ++quantity;
        rcv.textView_quantity.setText("" + quantity);
        //TODO UPDATE PRICE WITH QUANTIITY
    }

    void leaveProduct() {

        --quantity;
        if (quantity <= 0) {
            invisibleCartButton();
        } else
            rcv.textView_quantity.setText("" + quantity);

    }


    void visibleCartButton() {

        addProduct();

        rcv.textView_add_to_cart.setVisibility(View.INVISIBLE);

        FDAColorManager.setGridViewColorSelected(rcv.relative_cart);

        rcv.textView_quantity.setVisibility(View.VISIBLE);
        rcv.btn_increment.setVisibility(View.VISIBLE);
        rcv.btn_decrease.setVisibility(View.VISIBLE);
    }

    void invisibleCartButton() {

        quantity = 0;

        rcv.textView_add_to_cart.setVisibility(View.VISIBLE);
        FDAColorManager.setGridViewColorDefault(rcv.relative_cart);

        rcv.textView_quantity.setVisibility(View.INVISIBLE);
        rcv.btn_increment.setVisibility(View.INVISIBLE);
        rcv.btn_decrease.setVisibility(View.INVISIBLE);


    }*/

    @Override
    public int getItemCount() {
        return this.productList.size();
    }


  /*  @Override
    public void onClick(View view) {
        //Toast.makeText(view.getContext(), "Clicked Position ", Toast.LENGTH_SHORT).show();

        if (view == rcv.relative_cart) {

            // visibleCartButton();

        } else if (view == rcv.btn_increment) {

            //  addProduct();


        } else if (view == rcv.btn_decrease) {

            // leaveProduct();


        } else if (view == rcv.relative_product) {

            view.getContext().startActivity(new Intent(view.getContext(), SampleActivity.class));
            Toast.makeText(view.getContext(), "relative_product Clicked   ", Toast.LENGTH_SHORT).show();

        }
    }*/

}
