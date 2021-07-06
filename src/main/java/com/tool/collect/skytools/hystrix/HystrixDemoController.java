package com.tool.collect.skytools.hystrix;

import com.alibaba.fastjson.JSON;
import rx.Observer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/7/6 下午3:33
 **/
@RestController
public class HystrixDemoController {


	@GetMapping("HystrixTest")
	public Object HystrixTest() {
		GetProductGroupCommand getProductGroupCommand = new GetProductGroupCommand(new String[]{"1","2","3","4"});
		getProductGroupCommand.observe().subscribe(new Observer<ProductInfo>() {
			@Override
			public void onCompleted() {
				System.out.println("请求处理完成");
			}

			@Override
			public void onError(Throwable throwable) {
				System.out.println("oh no 请求出错了");
			}

			@Override
			public void onNext(ProductInfo productInfo) {
				System.out.println(JSON.toJSONString(productInfo));
			}
		});

		GetProductCommand getProductCommand = new GetProductCommand(11L);
		getProductCommand.execute();
		return null;
	}
}
