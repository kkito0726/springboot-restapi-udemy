package com.ken.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

import com.ken.springDemo.model.Item;
import com.ken.springDemo.repository.ItemRepository;

@SpringBootApplication
@EnableCaching
public class SpringDemoApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO 自動生成されたメソッド・スタブ
		return super.configure(builder);
	}

	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		itemRepository.save(new Item("ネックレス", "ジュエリ"));
		itemRepository.save(new Item("パーカー", "ファッション"));
		itemRepository.save(new Item("フェイスクリーム", "ビューティー"));
		itemRepository.save(new Item("サプリメント", "ヘルス"));
		itemRepository.save(new Item("ブルーベリー", "フード"));
	}
}
