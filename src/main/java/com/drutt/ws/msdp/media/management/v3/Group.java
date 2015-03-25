
package com.drutt.ws.msdp.media.management.v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for group complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="group">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.drutt.com/msdp/media/management/v3}baseGroup">
 *       &lt;sequence>
 *         &lt;element name="idKey" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="totalItems" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="item" type="{http://ws.drutt.com/msdp/media/management/v3}item" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "group", propOrder = {
    "idKey",
    "totalItems",
    "item"
})
public class Group
    extends BaseGroup
{

    protected long idKey;
    protected int totalItems;
    protected List<Item> item;

    /**
     * Gets the value of the idKey property.
     * 
     */
    public long getIdKey() {
        return idKey;
    }

    /**
     * Sets the value of the idKey property.
     * 
     */
    public void setIdKey(long value) {
        this.idKey = value;
    }

    /**
     * Gets the value of the totalItems property.
     * 
     */
    public int getTotalItems() {
        return totalItems;
    }

    /**
     * Sets the value of the totalItems property.
     * 
     */
    public void setTotalItems(int value) {
        this.totalItems = value;
    }

    /**
     * Gets the value of the item property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the item property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Item }
     * 
     * 
     */
    public List<Item> getItem() {
        if (item == null) {
            item = new ArrayList<Item>();
        }
        return this.item;
    }

}
