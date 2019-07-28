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
 * <p>Java class for pitched-value.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="pitched-value">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="celesta"/>
 *     &lt;enumeration value="chimes"/>
 *     &lt;enumeration value="glockenspiel"/>
 *     &lt;enumeration value="lithophone"/>
 *     &lt;enumeration value="mallet"/>
 *     &lt;enumeration value="marimba"/>
 *     &lt;enumeration value="steel drums"/>
 *     &lt;enumeration value="tubaphone"/>
 *     &lt;enumeration value="tubular chimes"/>
 *     &lt;enumeration value="vibraphone"/>
 *     &lt;enumeration value="xylophone"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "pitched-value")
@XmlEnum
public enum PitchedValue {

    @XmlEnumValue("celesta")
    CELESTA("celesta"),
    @XmlEnumValue("chimes")
    CHIMES("chimes"),
    @XmlEnumValue("glockenspiel")
    GLOCKENSPIEL("glockenspiel"),
    @XmlEnumValue("lithophone")
    LITHOPHONE("lithophone"),
    @XmlEnumValue("mallet")
    MALLET("mallet"),
    @XmlEnumValue("marimba")
    MARIMBA("marimba"),
    @XmlEnumValue("steel drums")
    STEEL_DRUMS("steel drums"),
    @XmlEnumValue("tubaphone")
    TUBAPHONE("tubaphone"),
    @XmlEnumValue("tubular chimes")
    TUBULAR_CHIMES("tubular chimes"),
    @XmlEnumValue("vibraphone")
    VIBRAPHONE("vibraphone"),
    @XmlEnumValue("xylophone")
    XYLOPHONE("xylophone");
    private final java.lang.String value;

    PitchedValue(java.lang.String v) {
        value = v;
    }

    public java.lang.String value() {
        return value;
    }

    public static PitchedValue fromValue(java.lang.String v) {
        for (PitchedValue c: PitchedValue.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
