package com.codingtest.agrostarproducts;

/**
 * Created by Sandy on ०६-०३-२०१६.
 */
public class ProductPresenter implements IProductPresenter{

    IProductView view;
    public ProductPresenter(ProductsView viewObj){
        view = viewObj;
    }

    @Override
    public void setToolBarProperties() {
        view.setToolbarProperties();
    }

    @Override
    public void setProductAndFeaturesDetails() {
        view.setproductsAndFeatures();
    }
}
