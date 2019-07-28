//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.21 at 08:00:56 PM BST 
//


package com.reynolds.lawrence.musicxml.generatedModel;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The formatted-symbol-id type represents a SMuFL musical symbol element with formatting and id attributes.
 * 
 * <p>Java class for formatted-symbol-id complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="formatted-symbol-id">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>smufl-glyph-name">
 *       &lt;attGroup ref="{}symbol-formatting"/>
 *       &lt;attGroup ref="{}optional-unique-id"/>
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "formatted-symbol-id", propOrder = {
    "value"
})
public class FormattedSymbolId {

    @XmlValue
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String value;
    @XmlAttribute(name = "line-height")
    protected java.lang.String lineHeight;
    @XmlAttribute(name = "rotation")
    protected BigDecimal rotation;
    @XmlAttribute(name = "justify")
    protected LeftCenterRight justify;
    @XmlAttribute(name = "enclosure")
    protected EnclosureShape enclosure;
    @XmlAttribute(name = "letter-spacing")
    protected java.lang.String letterSpacing;
    @XmlAttribute(name = "underline")
    protected Integer underline;
    @XmlAttribute(name = "overline")
    protected Integer overline;
    @XmlAttribute(name = "line-through")
    protected Integer lineThrough;
    @XmlAttribute(name = "dir")
    protected TextDirection dir;
    @XmlAttribute(name = "valign")
    protected Valign valign;
    @XmlAttribute(name = "halign")
    protected LeftCenterRight halign;
    @XmlAttribute(name = "font-family")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String fontFamily;
    @XmlAttribute(name = "font-style")
    protected FontStyle fontStyle;
    @XmlAttribute(name = "font-size")
    protected java.lang.String fontSize;
    @XmlAttribute(name = "font-weight")
    protected FontWeight fontWeight;
    @XmlAttribute(name = "color")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected java.lang.String color;
    @XmlAttribute(name = "default-x")
    protected BigDecimal defaultX;
    @XmlAttribute(name = "default-y")
    protected BigDecimal defaultY;
    @XmlAttribute(name = "relative-x")
    protected BigDecimal relativeX;
    @XmlAttribute(name = "relative-y")
    protected BigDecimal relativeY;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;

    /**
     * The smufl-glyph-name type is used for attributes that reference a specific Standard Music Font Layout (SMuFL) character. The value is a SMuFL canonical glyph name, not a code point. For instance, the value for a standard piano pedal mark would be keyboardPedalPed, not U+E650.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    /**
     * Gets the value of the lineHeight property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getLineHeight() {
        return lineHeight;
    }

    /**
     * Sets the value of the lineHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setLineHeight(java.lang.String value) {
        this.lineHeight = value;
    }

    /**
     * Gets the value of the rotation property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRotation() {
        return rotation;
    }

    /**
     * Sets the value of the rotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRotation(BigDecimal value) {
        this.rotation = value;
    }

    /**
     * Gets the value of the justify property.
     * 
     * @return
     *     possible object is
     *     {@link LeftCenterRight }
     *     
     */
    public LeftCenterRight getJustify() {
        return justify;
    }

    /**
     * Sets the value of the justify property.
     * 
     * @param value
     *     allowed object is
     *     {@link LeftCenterRight }
     *     
     */
    public void setJustify(LeftCenterRight value) {
        this.justify = value;
    }

    /**
     * Gets the value of the enclosure property.
     * 
     * @return
     *     possible object is
     *     {@link EnclosureShape }
     *     
     */
    public EnclosureShape getEnclosure() {
        return enclosure;
    }

    /**
     * Sets the value of the enclosure property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnclosureShape }
     *     
     */
    public void setEnclosure(EnclosureShape value) {
        this.enclosure = value;
    }

    /**
     * Gets the value of the letterSpacing property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getLetterSpacing() {
        return letterSpacing;
    }

    /**
     * Sets the value of the letterSpacing property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setLetterSpacing(java.lang.String value) {
        this.letterSpacing = value;
    }

    /**
     * Gets the value of the underline property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUnderline() {
        return underline;
    }

    /**
     * Sets the value of the underline property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUnderline(Integer value) {
        this.underline = value;
    }

    /**
     * Gets the value of the overline property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOverline() {
        return overline;
    }

    /**
     * Sets the value of the overline property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOverline(Integer value) {
        this.overline = value;
    }

    /**
     * Gets the value of the lineThrough property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLineThrough() {
        return lineThrough;
    }

    /**
     * Sets the value of the lineThrough property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLineThrough(Integer value) {
        this.lineThrough = value;
    }

    /**
     * Gets the value of the dir property.
     * 
     * @return
     *     possible object is
     *     {@link TextDirection }
     *     
     */
    public TextDirection getDir() {
        return dir;
    }

    /**
     * Sets the value of the dir property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextDirection }
     *     
     */
    public void setDir(TextDirection value) {
        this.dir = value;
    }

    /**
     * Gets the value of the valign property.
     * 
     * @return
     *     possible object is
     *     {@link Valign }
     *     
     */
    public Valign getValign() {
        return valign;
    }

    /**
     * Sets the value of the valign property.
     * 
     * @param value
     *     allowed object is
     *     {@link Valign }
     *     
     */
    public void setValign(Valign value) {
        this.valign = value;
    }

    /**
     * Gets the value of the halign property.
     * 
     * @return
     *     possible object is
     *     {@link LeftCenterRight }
     *     
     */
    public LeftCenterRight getHalign() {
        return halign;
    }

    /**
     * Sets the value of the halign property.
     * 
     * @param value
     *     allowed object is
     *     {@link LeftCenterRight }
     *     
     */
    public void setHalign(LeftCenterRight value) {
        this.halign = value;
    }

    /**
     * Gets the value of the fontFamily property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFontFamily() {
        return fontFamily;
    }

    /**
     * Sets the value of the fontFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFontFamily(java.lang.String value) {
        this.fontFamily = value;
    }

    /**
     * Gets the value of the fontStyle property.
     * 
     * @return
     *     possible object is
     *     {@link FontStyle }
     *     
     */
    public FontStyle getFontStyle() {
        return fontStyle;
    }

    /**
     * Sets the value of the fontStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link FontStyle }
     *     
     */
    public void setFontStyle(FontStyle value) {
        this.fontStyle = value;
    }

    /**
     * Gets the value of the fontSize property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getFontSize() {
        return fontSize;
    }

    /**
     * Sets the value of the fontSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setFontSize(java.lang.String value) {
        this.fontSize = value;
    }

    /**
     * Gets the value of the fontWeight property.
     * 
     * @return
     *     possible object is
     *     {@link FontWeight }
     *     
     */
    public FontWeight getFontWeight() {
        return fontWeight;
    }

    /**
     * Sets the value of the fontWeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link FontWeight }
     *     
     */
    public void setFontWeight(FontWeight value) {
        this.fontWeight = value;
    }

    /**
     * Gets the value of the color property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getColor() {
        return color;
    }

    /**
     * Sets the value of the color property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setColor(java.lang.String value) {
        this.color = value;
    }

    /**
     * Gets the value of the defaultX property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDefaultX() {
        return defaultX;
    }

    /**
     * Sets the value of the defaultX property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDefaultX(BigDecimal value) {
        this.defaultX = value;
    }

    /**
     * Gets the value of the defaultY property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDefaultY() {
        return defaultY;
    }

    /**
     * Sets the value of the defaultY property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDefaultY(BigDecimal value) {
        this.defaultY = value;
    }

    /**
     * Gets the value of the relativeX property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRelativeX() {
        return relativeX;
    }

    /**
     * Sets the value of the relativeX property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRelativeX(BigDecimal value) {
        this.relativeX = value;
    }

    /**
     * Gets the value of the relativeY property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRelativeY() {
        return relativeY;
    }

    /**
     * Sets the value of the relativeY property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRelativeY(BigDecimal value) {
        this.relativeY = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setId(java.lang.String value) {
        this.id = value;
    }

}
