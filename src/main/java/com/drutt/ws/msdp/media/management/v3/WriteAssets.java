
package com.drutt.ws.msdp.media.management.v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for writeAssets complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="writeAssets">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="asset" type="{http://ws.drutt.com/msdp/media/management/v3}writeAsset" maxOccurs="unbounded"/>
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
@XmlType(name = "writeAssets", propOrder = {
    "asset",
    "requireValid"
})
public class WriteAssets {

    @XmlElement(required = true)
    protected List<WriteAsset> asset;
    protected boolean requireValid;

    /**
     * Gets the value of the asset property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the asset property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAsset().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WriteAsset }
     * 
     * 
     */
    public List<WriteAsset> getAsset() {
        if (asset == null) {
            asset = new ArrayList<WriteAsset>();
        }
        return this.asset;
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
