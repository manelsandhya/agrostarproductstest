package com.codingtest.agrostarproducts;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sandy on 3/5/2016.
 */
public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {
    int[] productNames = {R.string.strForProduct1,R.string.strForProduct2,R.string.strForProduct3,R.string.strForProduct4,R.string.strForProduct5,R.string.strForProduct6};
    int[] products = {R.drawable.goodmorning_1,R.drawable.goodnight_1,R.drawable.friendship_2,R.drawable.friendship_3,R.drawable.friendship_4,R.drawable.friendship_5};
    Context context;

    ProductsAdapter(Context contextObj){
        context = contextObj;
    }

    /**
     * Method for creating view at first
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item,parent,false);
        return new ProductViewHolder(view);
    }

    /**
     * Method for binding existing view item
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        holder.imgForImage.setImageResource(products[position]);
        holder.txtForProductName.setText(context.getResources().getString((productNames[position])));
    }

    @Override
    public int getItemCount() {
        if(products != null) {
            return products.length;
        }
        else return 0;
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView txtForProductName;
        ImageView imgForImage;
        TextView txtForPrice;
        public ProductViewHolder(View itemView) {
            super(itemView);
            txtForPrice = (TextView)itemView.findViewById(R.id.txtForPrice);
            txtForProductName = (TextView)itemView.findViewById(R.id.txtForName);
            imgForImage = (ImageView)itemView.findViewById(R.id.imgForProductImage);
        }
    }
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
