
package com.drutt.ws.msdp.media.management.v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for writeGroups complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="writeGroups">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="assetId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="group" type="{http://ws.drutt.com/msdp/media/management/v3}writeGroup" maxOccurs="unbounded"/>
 *         &lt;element name="requireValid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "writeGroups", propOrder = {
    "assetId",
    "group",
    "requireValid"
})
public class WriteGroups {

    @XmlElement(required = true)
    protected String assetId;
    @XmlElement(required = true)
    protected List<WriteGroup> group;
    protected boolean requireValid;

    /**
     * Gets the value of the assetId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssetId() {
        return assetId;
    }

    /**
     * Sets the value of the assetId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssetId(String value) {
        this.assetId = value;
    }

    /**
     * Gets the value of the group property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the group property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroup().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WriteGroup }
     * 
     * 
     */
    public List<WriteGroup> getGroup() {
        if (group == null) {
            group = new ArrayList<WriteGroup>();
        }
        return this.group;
    }

    /**
     * Gets the value of the requireValid property.
     * 
     */
    public boolean isRequireValid() {
        return requireValid;
    }

    /**
     * Sets the value of the requireValid property.
     * 
     */
    public void setRequireValid(boolean value) {
        this.requireValid = value;
    }

}
