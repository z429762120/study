package com.tool.collect.skytools.beancopier;

import java.util.Date;
import java.util.List;

import com.tool.collect.skytools.dto.Person;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 评论信息
 * @author zhonghuashishan
 *
 */
@Data
@EqualsAndHashCode
public class CommentInfoDO {

	/**
	 * 订单条目对应的商品id
	 */
	private long goodsId;
	/**
	 * 订单条目对应的商品sku id
	 */
	private Long goodsSkuId;
	/**
	 * 商品sku销售属性
	 */
	private String goodsSkuSaleProperties;
	/**
	 * 客服评分
	 */
	private Integer customerServiceScore;

	/**
	 * 评论内容
	 */
	private String commentContent;
	/**
	 * 是否晒图
	 */
	private Integer showPictures;
	/**
	 * 是否是默认评论
	 */
	private Integer defaultComment;
	/**
	 * 评论状态
	 */
	private Integer commentStatus;
	/**
	 * 评论类型
	 */
	private Integer commentType;
	/**
	 * 评论的创建时间
	 */
	private Date gmtCreate;
	/**
	 * 评论的修改时间
	 */
	private Date gmtModified;
	private List<Person> personList;

}
