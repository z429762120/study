package com.tool.collect.skytools.support.springExtension.view;


import com.tool.collect.skytools.support.model.PropertyFilterInfo;

/**
 * @author Gnoll
 * @create 2017-06-17 18:18
 **/
public class UnifySuccessView extends UnifyView {

    public UnifySuccessView() {
        this(null);
    }

    public UnifySuccessView(Object object) {
        super();
        if(null != object){
            this.addStaticAttribute(DATA,object);
        }
        this.addStaticAttribute(CODE,200);
    }

    public UnifySuccessView(Object object, PropertyFilterInfo... filters) {
        super(filters);
        if(null != object){
            this.addStaticAttribute(DATA,object);
        }
        this.addStaticAttribute(CODE,200);
    }
}
