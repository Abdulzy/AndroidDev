package edu.neu.madcourse.numad21fa_abdulrahmanisegen;

public class URLCard {
    private final String itemName;
    private final String itemDesc;

    public URLCard(String itemName, String itemDesc) {
        this.itemName = itemName;
        this.itemDesc = itemDesc;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }
}
