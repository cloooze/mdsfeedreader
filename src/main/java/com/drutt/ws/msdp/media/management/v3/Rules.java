
package com.drutt.ws.msdp.media.management.v3;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rules complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rules">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="allOf" type="{http://ws.drutt.com/msdp/media/management/v3}rule" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="anyOf" type="{http://ws.drutt.com/msdp/media/management/v3}rule" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="noneOf" type="{http://ws.drutt.com/msdp/media/management/v3}rule" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rules", propOrder = {
    "allOf",
    "anyOf",
    "noneOf"
})
public class Rules {

    protected List<Rule> allOf;
    protected List<Rule> anyOf;
    protected List<Rule> noneOf;

    /**
     * Gets the value of the allOf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allOf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllOf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rule }
     * 
     * 
     */
    public List<Rule> getAllOf() {
        if (allOf == null) {
            allOf = new ArrayList<Rule>();
        }
        return this.allOf;
    }

    /**
     * Gets the value of the anyOf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anyOf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnyOf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rule }
     * 
     * 
     */
    public List<Rule> getAnyOf() {
        if (anyOf == null) {
            anyOf = new ArrayList<Rule>();
        }
        return this.anyOf;
    }

    /**
     * Gets the value of the noneOf property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the noneOf property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNoneOf().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rule }
     * 
     * 
     */
    public List<Rule> getNoneOf() {
        if (noneOf == null) {
            noneOf = new ArrayList<Rule>();
        }
        return this.noneOf;
    }

}
