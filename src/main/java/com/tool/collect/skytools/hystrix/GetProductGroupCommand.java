package com.tool.collect.skytools.hystrix;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * @Descriiption
 * @Author bo
 * @Date 2021/4/6 下午5:18
 **/
public class GetProductGroupCommand extends HystrixObservableCommand<ProductInfo> {
    private String[] productIds;

    public GetProductGroupCommand(String[] productIds) {
        super(HystrixCommandGroupKey.Factory.asKey(GetProductGroupCommand.class.getName()));
        this.productIds = productIds;
    }

    @Override
    protected Observable<ProductInfo> construct() {
        return Observable.create((Observable.OnSubscribe<ProductInfo>) subscriber -> {
            for (String productId : productIds) {
                if (productId.equals("3")) {
                    throw new RuntimeException("产品id错误");
                }
                ProductInfo info = new ProductInfo(Long.valueOf(productId), "花生" + productId);
                System.out.println(1);
                subscriber.onNext(info);
            }
            subscriber.onCompleted();
        }).subscribeOn(Schedulers.io());
    }
}
