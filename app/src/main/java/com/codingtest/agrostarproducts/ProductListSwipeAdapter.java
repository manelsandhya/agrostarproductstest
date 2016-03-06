package com.codingtest.agrostarproducts;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Sandy on 3/5/2016.
 */
public class ProductListSwipeAdapter extends PagerAdapter {

    int[] featureNames = {R.string.strFeatures1,R.string.strFeatures2,R.string.strFeatures3,R.string.strFeatures4,R.string.strFeatures5,R.string.strFeatures6};
    int[] featureImageResources = {R.drawable.funny_1,R.drawable.friendship_1,R.drawable.friendship_2,R.drawable.friendship_3,R.drawable.friendship_4,R.drawable.friendship_5};
    Context context;
    LayoutInflater layoutInflater;

    /**
     * @param contextObj
     */
    public ProductListSwipeAdapter(Context contextObj){
        context = contextObj;
    }

    @Override
    public int getCount() {
        if(featureImageResources != null && featureImageResources.length > 0){
            return featureImageResources.length;
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (RelativeLayout)object);
    }

    /**
     * Method for initialization
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.product_item,container,false);

        TextView txtForProductName = (TextView)item_view.findViewById(R.id.txtForName);
        TextView txtForProductPrice = (TextView)item_view.findViewById(R.id.txtForPrice);
        ImageView imgOfProduct = (ImageView)item_view.findViewById(R.id.imgForProductImage);
        txtForProductName.setText(context.getResources().getString(featureNames[position]));
        imgOfProduct.setImageResource(featureImageResources[position]);
        container.addView(item_view);
        return item_view;
    }

    /**
     * Method to handle destroy item event
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }

    /**
     * Override this method to handle page width in viewpager control
     * @param position
     * @return
     */
    @Override
    public float getPageWidth(int position) {
        return 0.40f;
    }
}
