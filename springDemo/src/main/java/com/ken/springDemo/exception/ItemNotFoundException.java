package com.ken.springDemo.exception;

public class ItemNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ItemNotFoundException(Long itemId) {
		// TODO 自動生成されたコンストラクター・スタブ
		super("商品コード: " + itemId + "は見つかりませんでした");
	}
}
