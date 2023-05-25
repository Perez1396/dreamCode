package com.example.dreamcode.nodes;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private List<Category> children;
    private List<String> keywords;
    private Category parent;

    public Category(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.keywords = new ArrayList<>();
        this.parent = null;
    }

    public void addChild(Category category){
        children.add(category);
    }

    public List<Category> getChildren(){
        return children;
    }

    public String getName(){
        return name;
    }

    public void addKeyword(String keyword){
        keywords.add(keyword);
    }

    //2) Get the keywords for a given category

    public Category getParent(){
        return parent;
    }

    public void setParent(Category parent){
        this.parent = parent;
    }

    public List<String> getKeywordsWithParents(){
        List<String> allKeywords = new ArrayList<>(keywords);

        for(Category category : children){
            List<String> childrenKeywords = category.getKeywordsWithParents();
            allKeywords.addAll(childrenKeywords);
        }
        return allKeywords;
    }

    public int getNodeLevel(Category searchNode){
        return getNodeLevelRecursive(this, searchNode, 0);
    }

    //3) Get the level of a category
    public int getNodeLevelRecursive(Category currentNode, Category searchNode, int level){
        if (currentNode == searchNode){
            return level;
        }
        for (Category category : currentNode.getChildren()){
            int childrenLevel = getNodeLevelRecursive(category, searchNode,level + 1);
            if (childrenLevel != -1) {
                return childrenLevel;
            }
        }
        return -1;
    }

}
