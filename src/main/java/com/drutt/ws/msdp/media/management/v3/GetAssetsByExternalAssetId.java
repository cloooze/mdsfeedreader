
package com.drutt.ws.msdp.media.management.v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAssetsByExternalAssetId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAssetsByExternalAssetId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="providerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="externalAssetId" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
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
@XmlType(name = "getAssetsByExternalAssetId", propOrder = {
    "providerId",
    "externalAssetId",
    "includeItems"
})
public class GetAssetsByExternalAssetId {

    protected String providerId;
    @XmlElement(required = true)
    protected List<String> externalAssetId;
    protected IncludeItems includeItems;

    /**
     * Gets the value of the providerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProviderId() {
        return providerId;
    }

    /**
     * Sets the value of the providerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProviderId(String value) {
        this.providerId = value;
    }

    /**
     * Gets the value of the externalAssetId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the externalAssetId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExternalAssetId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getExternalAssetId() {
        if (externalAssetId == null) {
            externalAssetId = new ArrayList<String>();
        }
        return this.externalAssetId;
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
