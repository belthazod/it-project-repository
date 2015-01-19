/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BEANS;

/**
 *
 * @author Belthazod
 */
public class SecondHandProduct {
    private String productID;
    private String name;
    private String quality;
    private String description;
    private String physicalCount;
    private String typeID;
    private String typeName;
    
    public SecondHandProduct(String productID, String name, String description, String quality, String physicalCount,String typeID,String typeName ) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.quality = quality;
        this.physicalCount = physicalCount;
        this.typeID = typeID;
        this.typeName = typeName;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhysicalCount() {
        return physicalCount;
    }

    public void setPhysicalCount(String physicalCount) {
        this.physicalCount = physicalCount;
    }
    
}
