/**
Practice for serialization using ObjectInputStream
example "Goods" class sited from www.imooc.com
*/

package pj5.IOStream;

import java.io.Serializable;

public class Goods implements Serializable{
	private String goodsId;
	private String goodsName;
	private double price;
	public Goods(String goodsId,String goodsName,double price){
		this.goodsId=goodsId;
		this.goodsName=goodsName;
		this.price=price;
	}
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "info [GID：" + goodsId + ", Name：" + goodsName 
				+ ", Price：" + price + "]";
	}
}