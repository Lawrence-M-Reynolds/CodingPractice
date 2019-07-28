//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.21 at 08:00:56 PM BST 
//


package com.reynolds.lawrence.musicxml.generatedModel;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for stick-location.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="stick-location">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="center"/>
 *     &lt;enumeration value="rim"/>
 *     &lt;enumeration value="cymbal bell"/>
 *     &lt;enumeration value="cymbal edge"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "stick-location")
@XmlEnum
public enum StickLocation {

    @XmlEnumValue("center")
    CENTER("center"),
    @XmlEnumValue("rim")
    RIM("rim"),
    @XmlEnumValue("cymbal bell")
    CYMBAL_BELL("cymbal bell"),
    @XmlEnumValue("cymbal edge")
    CYMBAL_EDGE("cymbal edge");
    private final java.lang.String value;

    StickLocation(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static StickLocation fromValue(java.lang.String v) {
        for (StickLocation c: StickLocation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
