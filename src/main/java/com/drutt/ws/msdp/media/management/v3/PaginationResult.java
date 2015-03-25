
package com.drutt.ws.msdp.media.management.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for paginationResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="paginationResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="lastItem" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nbrIems" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "paginationResult", propOrder = {
    "lastItem",
    "nbrIems"
})
public class PaginationResult {

    protected int lastItem;
    protected int nbrIems;

    /**
     * Gets the value of the lastItem property.
     * 
     */
    public int getLastItem() {
        return lastItem;
    }

    /**
     * Sets the value of the lastItem property.
     * 
     */
    public void setLastItem(int value) {
        this.lastItem = value;
    }

    /**
     * Gets the value of the nbrIems property.
     * 
     */
    public int getNbrIems() {
        return nbrIems;
    }

    /**
     * Sets the value of the nbrIems property.
     * 
     */
    public void setNbrIems(int value) {
        this.nbrIems = value;
    }

}
