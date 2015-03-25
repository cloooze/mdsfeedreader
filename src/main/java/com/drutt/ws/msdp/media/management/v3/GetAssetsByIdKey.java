
package com.drutt.ws.msdp.media.management.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAssetsByIdKey complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAssetsByIdKey">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="startId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="maxRows" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
@XmlType(name = "getAssetsByIdKey", propOrder = {
    "startId",
    "maxRows",
    "includeItems"
})
public class GetAssetsByIdKey {

    protected long startId;
    protected Integer maxRows;
    protected IncludeItems includeItems;

    /**
     * Gets the value of the startId property.
     * 
     */
    public long getStartId() {
        return startId;
    }

    /**
     * Sets the value of the startId property.
     * 
     */
    public void setStartId(long value) {
        this.startId = value;
    }

    /**
     * Gets the value of the maxRows property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxRows() {
        return maxRows;
    }

    /**
     * Sets the value of the maxRows property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxRows(Integer value) {
        this.maxRows = value;
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
