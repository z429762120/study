package com.tool.collect.skytools.hystrix;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Observer;
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

			try {
				for (String productId : productIds) {
					if (productId.equals("3")) {
						throw new RuntimeException("产品id错误");
					}
					ProductInfo info = new ProductInfo(Long.valueOf(productId), "花生" + productId);
					subscriber.onNext(info);
				}
				subscriber.onCompleted();
			}
			catch (RuntimeException e) {
				subscriber.onError(e);
			}

		}).subscribeOn(Schedulers.io());
    }


    public static void main(String[] args) throws Exception {
        String[] pids=new String[]{"1","2","3","4"};
        GetProductGroupCommand command = new GetProductGroupCommand(pids);
        command.observe().subscribe(new Observer<ProductInfo>() {
            @Override
            public void onCompleted() {
                System.out.println("请求完成");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("出错了"+throwable.getMessage());
            }

            @Override
            public void onNext(ProductInfo productInfo) {
                System.out.println(JSON.toJSONString(productInfo));
            }
        });
        Thread.sleep(10000L);
    }
}
