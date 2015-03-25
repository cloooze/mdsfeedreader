
package com.drutt.ws.msdp.media.management.v3;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchItems complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchItems">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="assetId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="filename" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="device" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="paginationInfo" type="{http://ws.drutt.com/msdp/media/management/v3}paginationInfo" minOccurs="0"/>
 *         &lt;element name="sortItem" type="{http://ws.drutt.com/msdp/media/management/v3}sortItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchItems", propOrder = {
    "assetId",
    "groupId",
    "filename",
    "device",
    "paginationInfo",
    "sortItem"
})
public class SearchItems {

    @XmlElement(required = true)
    protected String assetId;
    @XmlElement(required = true)
    protected String groupId;
    protected String filename;
    protected String device;
    protected PaginationInfo paginationInfo;
    protected SortItem sortItem;

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
     * Gets the value of the groupId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * Sets the value of the groupId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupId(String value) {
        this.groupId = value;
    }

    /**
     * Gets the value of the filename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilename() {
        return filename;
    }

    /**
     * Sets the value of the filename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilename(String value) {
        this.filename = value;
    }

    /**
     * Gets the value of the device property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDevice() {
        return device;
    }

    /**
     * Sets the value of the device property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDevice(String value) {
        this.device = value;
    }

    /**
     * Gets the value of the paginationInfo property.
     * 
     * @return
     *     possible object is
     *     {@link PaginationInfo }
     *     
     */
    public PaginationInfo getPaginationInfo() {
        return paginationInfo;
    }

    /**
     * Sets the value of the paginationInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link PaginationInfo }
     *     
     */
    public void setPaginationInfo(PaginationInfo value) {
        this.paginationInfo = value;
    }

    /**
     * Gets the value of the sortItem property.
     * 
     * @return
     *     possible object is
     *     {@link SortItem }
     *     
     */
    public SortItem getSortItem() {
        return sortItem;
    }

    /**
     * Sets the value of the sortItem property.
     * 
     * @param value
     *     allowed object is
     *     {@link SortItem }
     *     
     */
    public void setSortItem(SortItem value) {
        this.sortItem = value;
    }

}
