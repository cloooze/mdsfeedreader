
package com.drutt.ws.msdp.media.management.v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAssetsByAssetId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAssetsByAssetId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="assetId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="includeItems" type="{http://ws.drutt.com/msdp/media/management/v3}includeItems" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAssetsByAssetId", propOrder = {
    "assetId",
    "includeItems"
})
public class GetAssetsByAssetId {

    @XmlElement(required = true)
    protected List<String> assetId;
    protected IncludeItems includeItems;

    /**
     * Gets the value of the assetId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assetId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssetId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAssetId() {
        if (assetId == null) {
            assetId = new ArrayList<String>();
        }
        return this.assetId;
    }

    /**
     * Gets the value of the includeItems property.
     * 
     * @return
     *     possible object is
     *     {@link IncludeItems }
     *     
     */
    public IncludeItems getIncludeItems() {
        return includeItems;
    }

    /**
     * Sets the value of the includeItems property.
     * 
     * @param value
     *     allowed object is
     *     {@link IncludeItems }
     *     
     */
    public void setIncludeItems(IncludeItems value) {
        this.includeItems = value;
    }

}
