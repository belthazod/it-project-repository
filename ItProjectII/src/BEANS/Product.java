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
public class Product {

    private String productID;
    private String typeID;
    private String typeName;
    private String name;
    private String description;
    private String supplierID;
    private String supplierName;
    private String unit;
    private String physicalCount;
    private String reorderQuantityLevel;
    
    public Product(String productID, String typeID, String typeName, String name, String description, String supplierID, String supplierName, String unit, String physicalCount, String reorderQuantityLevel) {
        this.productID = productID;
        this.typeID = typeID;
        this.typeName = typeName;
        this.name = name;
        this.description = description;
        this.supplierID = supplierID;
        this.supplierName = supplierName;
        this.unit = unit;
        this.physicalCount = physicalCount;
        this.reorderQuantityLevel = reorderQuantityLevel;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(String supplierID) {
        this.supplierID = supplierID;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPhysicalCount() {
        return physicalCount;
    }

    public void setPhysicalCount(String physicalCount) {
        this.physicalCount = physicalCount;
    }

    public String getReorderQuantityLevel() {
        return reorderQuantityLevel;
    }

    public void setReorderQuantityLevel(String reorderQuantityLevel) {
        this.reorderQuantityLevel = reorderQuantityLevel;
    }
    
    
}
