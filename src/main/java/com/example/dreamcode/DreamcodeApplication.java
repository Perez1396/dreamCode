package com.example.dreamcode;

import com.example.dreamcode.nodes.Category;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DreamcodeApplication {

	public static void main(String[] args) {
		//1)
		//Creation of all the nodes involved
		Category root = new Category("root");
		Category homeAppliances = new Category("homeAppliances");
		Category furnitures = new Category("furnitures");
		Category electronics = new Category("electronics");
		Category lawnNgarden = new Category("lawnNgarden");
		Category majorAppliances = new Category("majorAppliances");
		Category kitchenAppliances = new Category("kitchenAppliances");
		Category generalAppliances = new Category("generalAppliances");
		Category minorAppliances = new Category("minorAppliances");
		Category office = new Category("office");
		Category home = new Category("home");
		Category mobile = new Category("mobile");
		Category remoteControl = new Category("remoteControl");

		//Adding child nodes to the root node
		root.addChild(homeAppliances);
		root.addChild(furnitures);
		root.addChild(electronics);
		root.addKeyword("house");
		root.addKeyword("decoration");

		//Adding child nodes to the homeAppliances node
		homeAppliances.addChild(lawnNgarden);
		homeAppliances.addChild(majorAppliances);
		homeAppliances.addChild(minorAppliances);
		homeAppliances.addKeyword("appliances");

		//Adding child nodes to the majorAppliances node
		majorAppliances.addChild(kitchenAppliances);
		majorAppliances.addKeyword("big");
		majorAppliances.addKeyword("energy");
		majorAppliances.addChild(generalAppliances);
		generalAppliances.addKeyword("fridge");
		generalAppliances.addKeyword("tv");
		generalAppliances.addKeyword("cooler");
		generalAppliances.setParent(majorAppliances);
		kitchenAppliances.setParent(majorAppliances);
		majorAppliances.setParent(homeAppliances);
		homeAppliances.setParent(root);
		electronics.setParent(root);

		//Adding child nodes to the furniture node
		furnitures.addChild(office);
		furnitures.addChild(home);

		//Adding child nodes to the electronics node
		electronics.addChild(mobile);
		electronics.addChild(remoteControl);

		//2) Calling of the method getKeywords returning the list of keywords
		List<String> keywords = generalAppliances.getKeywordsWithParents();
		System.out.println("**** Keywords related a given node: " + keywords);

		//3) Calling of the method getNodeLevel returning the value
		int nodeLevel = root.getNodeLevel(generalAppliances);
		System.out.println("**** NODE LEVEL: " + nodeLevel);

		Category nodeParent = generalAppliances.getParent();


		SpringApplication.run(DreamcodeApplication.class, args);

	}

}
