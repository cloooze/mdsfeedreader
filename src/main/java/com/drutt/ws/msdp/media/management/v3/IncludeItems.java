
package com.drutt.ws.msdp.media.management.v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for includeItems complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="includeItems">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nbrItems" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sort" type="{http://ws.drutt.com/msdp/media/management/v3}sortItem"/>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "includeItems", propOrder = {
    "nbrItems",
    "sort",
    "groupId"
})
public class IncludeItems {

    protected int nbrItems;
    @XmlElement(required = true)
    protected SortItem sort;
    protected List<String> groupId;

    /**
     * Gets the value of the nbrItems property.
     * 
     */
    public int getNbrItems() {
        return nbrItems;
    }

    /**
     * Sets the value of the nbrItems property.
     * 
     */
    public void setNbrItems(int value) {
        this.nbrItems = value;
    }

    /**
     * Gets the value of the sort property.
     * 
     * @return
     *     possible object is
     *     {@link SortItem }
     *     
     */
    public SortItem getSort() {
        return sort;
    }

    /**
     * Sets the value of the sort property.
     * 
     * @param value
     *     allowed object is
     *     {@link SortItem }
     *     
     */
    public void setSort(SortItem value) {
        this.sort = value;
    }

    /**
     * Gets the value of the groupId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groupId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroupId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getGroupId() {
        if (groupId == null) {
            groupId = new ArrayList<String>();
        }
        return this.groupId;
    }

}
