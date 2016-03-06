package com.codingtest.agrostarproducts;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ProductsView extends Activity implements IProductView{
    @Bind(R.id.vpForFeaturedImages)
    ViewPager vpForFeaturedImages;
    @Bind(R.id.rcvForProducts)
    RecyclerView rcvForProducts;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    ProductListSwipeAdapter productListSwipeAdapter;
    ProductsAdapter productsAdapter;
    ProductPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_view);
        ButterKnife.bind(this);

        presenter = new ProductPresenter(this);

        presenter.setToolBarProperties();
        presenter.setProductAndFeaturesDetails();

       /* vpForFeaturedImages.setPageMargin(-25);
        productListSwipeAdapter = new ProductListSwipeAdapter(this);
        vpForFeaturedImages.setAdapter(productListSwipeAdapter);
        vpForFeaturedImages.setClipToPadding(false);
        vpForFeaturedImages.setOffscreenPageLimit(3);

        productsAdapter = new ProductsAdapter(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        rcvForProducts.setLayoutManager(layoutManager);
        rcvForProducts.setAdapter(productsAdapter);
*/
    }

    private void setLocalization(String language) {
        Configuration newConfig = new Configuration();
        Locale myLocale = new Locale(language);
        newConfig.locale = myLocale;
        onConfigurationChanged(newConfig);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getBaseContext().getResources().updateConfiguration(newConfig, getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.products_view);
        ButterKnife.bind(this);
        presenter.setToolBarProperties();
        presenter.setProductAndFeaturesDetails();
        /*setToolbarProperties();
        vpForFeaturedImages.setPageMargin(-25);

        productListSwipeAdapter = new ProductListSwipeAdapter(this);
        vpForFeaturedImages.setAdapter(productListSwipeAdapter);
        // vpForFeaturedImages.setClipChildren(false);
        vpForFeaturedImages.setClipToPadding(false);
        vpForFeaturedImages.setOffscreenPageLimit(3);

        productsAdapter = new ProductsAdapter(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        rcvForProducts.setLayoutManager(layoutManager);
        rcvForProducts.setAdapter(productsAdapter);*/
    }

    @Override
    public void setToolbarProperties() {
        toolbar.setTitle(this.getResources().getString(R.string.home_title));
        toolbar.inflateMenu(R.menu.menu_products);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d("Products", item.getTitle().toString());
                if(item.getItemId() == R.id.action_hindi_language){
                    setLocalization("hi");
                }
                if(item.getItemId() == R.id.action_marathi_language){
                    setLocalization("mr");
                }
                if(item.getItemId() == R.id.action_english_language){
                    setLocalization("en_US");
                }
                if(item.getItemId() == R.id.action_search){

                }
                return false;
            }
        });
    }

    @Override
    public void setproductsAndFeatures() {
        vpForFeaturedImages.setPageMargin(-25);
        productListSwipeAdapter = new ProductListSwipeAdapter(this);
        vpForFeaturedImages.setAdapter(productListSwipeAdapter);
        vpForFeaturedImages.setClipToPadding(false);
        vpForFeaturedImages.setOffscreenPageLimit(3);

        productsAdapter = new ProductsAdapter(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        rcvForProducts.setLayoutManager(layoutManager);
        rcvForProducts.setAdapter(productsAdapter);
    }

    /*public void setToolbarProperties() {
        toolbar.setTitle(this.getResources().getString(R.string.home_title));
        toolbar.inflateMenu(R.menu.menu_products);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Log.d("Products", item.getTitle().toString());
                if(item.getItemId() == R.id.action_hindi_language){
                    setLocalization("hi");
                }
                if(item.getItemId() == R.id.action_marathi_language){
                    setLocalization("mr");
                }
                if(item.getItemId() == R.id.action_english_language){
                    setLocalization("en_US");
                }
                if(item.getItemId() == R.id.action_search){

                }
                return false;
            }
        });
    }*/


}
