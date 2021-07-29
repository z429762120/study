package com.tool.collect.skytools.beancopier;

import java.util.Date;
import java.util.List;

import com.tool.collect.skytools.dto.Personnal;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 评论信息
 * @author zhonghuashishan
 *
 */
@Data
@EqualsAndHashCode
public class CommentInfoDTO {

	/**
	 * 订单条目对应的商品id
	 */
	private Long goodsId;

	/**
	 * 商品sku销售属性
	 */
	private String goodsSkuSaleProperties;


	/**
	 * 评论内容
	 */
	private String commentContent;

	/**
	 * 是否是默认评论
	 */
	private int defaultComment;
	/**
	 * 评论的修改时间
	 */
	private Date gmtModified;
	private String name;

	private List<Personnal> personList;


}
