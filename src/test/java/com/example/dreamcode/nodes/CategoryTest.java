package com.example.dreamcode.nodes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    void testGetKeywordsWithParents() {
        Category root = new Category("root");
        Category homeAppliances = new Category("homeAppliances");
        Category lawnNgarden = new Category("lawnNgarden");
        Category majorAppliances = new Category("majorAppliances");
        Category kitchenAppliances = new Category("kitchenAppliances");
        Category generalAppliances = new Category("generalAppliances");
        Category minorAppliances = new Category("minorAppliances");

        //Adding child nodes to the root node
        root.addChild(homeAppliances);
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

        List<String> expectedKeywords = Arrays.asList("fridge", "tv", "cooler");
        List<String> actualKeywords = generalAppliances.getKeywordsWithParents();
        assertEquals(expectedKeywords, actualKeywords);
    }

    @Test
    void testGetNodeLevel() {
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

        //Adding child nodes to the furniture node
        furnitures.addChild(office);
        furnitures.addChild(home);

        //Adding child nodes to the electronics node
        electronics.addChild(mobile);
        electronics.addChild(remoteControl);

        int levelExpected = 3;
        int levelActual = root.getNodeLevel(generalAppliances);
        assertEquals(levelExpected, levelActual);
    }
}