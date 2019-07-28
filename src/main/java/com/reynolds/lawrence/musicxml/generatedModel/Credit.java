//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.07.21 at 08:00:56 PM BST 
//


package com.reynolds.lawrence.musicxml.generatedModel;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * The credit type represents the appearance of the title, composer, arranger, lyricist, copyright, dedication, and other text, symbols, and graphics that commonly appear on the first page of a score. The credit-words, credit-symbol, and credit-image elements are similar to the words, symbol, and image elements for directions. However, since the credit is not part of a measure, the default-x and default-y attributes adjust the origin relative to the bottom left-hand corner of the page. The enclosure for credit-words and credit-symbol is none by default.
 * 
 * By default, a series of credit-words and credit-symbol elements within a single credit element follow one another in sequence visually. Non-positional formatting attributes are carried over from the previous element by default.
 * 
 * The page attribute for the credit element specifies the page number where the credit should appear. This is an integer value that starts with 1 for the first page. Its value is 1 by default. Since credits occur before the music, these page numbers do not refer to the page numbering specified by the print element's page-number attribute.
 * 
 * The credit-type element indicates the purpose behind a credit. Multiple types of data may be combined in a single credit, so multiple elements may be used. Standard values include page number, title, subtitle, composer, arranger, lyricist, and rights.
 * 
 * 
 * <p>Java class for credit complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="credit">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="credit-type" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="link" type="{}link" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="bookmark" type="{}bookmark" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="credit-image" type="{}image"/>
 *           &lt;sequence>
 *             &lt;choice>
 *               &lt;element name="credit-words" type="{}formatted-text-id"/>
 *               &lt;element name="credit-symbol" type="{}formatted-symbol-id"/>
 *             &lt;/choice>
 *             &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *               &lt;element name="link" type="{}link" maxOccurs="unbounded" minOccurs="0"/>
 *               &lt;element name="bookmark" type="{}bookmark" maxOccurs="unbounded" minOccurs="0"/>
 *               &lt;choice>
 *                 &lt;element name="credit-words" type="{}formatted-text-id"/>
 *                 &lt;element name="credit-symbol" type="{}formatted-symbol-id"/>
 *               &lt;/choice>
 *             &lt;/sequence>
 *           &lt;/sequence>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}optional-unique-id"/>
 *       &lt;attribute name="page" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "credit", propOrder = {
    "creditType",
    "linkRenamed",
    "bookmark",
    "creditImage",
    "creditWords",
    "creditSymbol",
    "linkAndBookmarkAndCreditWords"
})
public class Credit {

    @XmlElement(name = "credit-type")
    protected List<java.lang.String> creditType;
    @XmlElement(name = "link")
    protected List<Link> linkRenamed;
    protected List<Bookmark> bookmark;
    @XmlElement(name = "credit-image")
    protected Image creditImage;
    @XmlElement(name = "credit-words")
    protected FormattedTextId creditWords;
    @XmlElement(name = "credit-symbol")
    protected FormattedSymbolId creditSymbol;
    @XmlElements({
        @XmlElement(name = "link", type = Link.class),
        @XmlElement(name = "bookmark", type = Bookmark.class),
        @XmlElement(name = "credit-words", type = FormattedTextId.class),
        @XmlElement(name = "credit-symbol", type = FormattedSymbolId.class)
    })
    protected List<Object> linkAndBookmarkAndCreditWords;
    @XmlAttribute(name = "page")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger page;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected java.lang.String id;

    /**
     * Gets the value of the creditType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the creditType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreditType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link java.lang.String }
     * 
     * 
     */
    public List<java.lang.String> getCreditType() {
        if (creditType == null) {
            creditType = new ArrayList<java.lang.String>();
        }
        return this.creditType;
    }

    /**
     * Gets the value of the linkRenamed property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linkRenamed property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinkRenamed().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Link }
     * 
     * 
     */
    public List<Link> getLinkRenamed() {
        if (linkRenamed == null) {
            linkRenamed = new ArrayList<Link>();
        }
        return this.linkRenamed;
    }

    /**
     * Gets the value of the bookmark property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bookmark property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBookmark().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Bookmark }
     * 
     * 
     */
    public List<Bookmark> getBookmark() {
        if (bookmark == null) {
            bookmark = new ArrayList<Bookmark>();
        }
        return this.bookmark;
    }

    /**
     * Gets the value of the creditImage property.
     * 
     * @return
     *     possible object is
     *     {@link Image }
     *     
     */
    public Image getCreditImage() {
        return creditImage;
    }

    /**
     * Sets the value of the creditImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Image }
     *     
     */
    public void setCreditImage(Image value) {
        this.creditImage = value;
    }

    /**
     * Gets the value of the creditWords property.
     * 
     * @return
     *     possible object is
     *     {@link FormattedTextId }
     *     
     */
    public FormattedTextId getCreditWords() {
        return creditWords;
    }

    /**
     * Sets the value of the creditWords property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormattedTextId }
     *     
     */
    public void setCreditWords(FormattedTextId value) {
        this.creditWords = value;
    }

    /**
     * Gets the value of the creditSymbol property.
     * 
     * @return
     *     possible object is
     *     {@link FormattedSymbolId }
     *     
     */
    public FormattedSymbolId getCreditSymbol() {
        return creditSymbol;
    }

    /**
     * Sets the value of the creditSymbol property.
     * 
     * @param value
     *     allowed object is
     *     {@link FormattedSymbolId }
     *     
     */
    public void setCreditSymbol(FormattedSymbolId value) {
        this.creditSymbol = value;
    }

    /**
     * Gets the value of the linkAndBookmarkAndCreditWords property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linkAndBookmarkAndCreditWords property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinkAndBookmarkAndCreditWords().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Link }
     * {@link Bookmark }
     * {@link FormattedTextId }
     * {@link FormattedSymbolId }
     * 
     * 
     */
    public List<Object> getLinkAndBookmarkAndCreditWords() {
        if (linkAndBookmarkAndCreditWords == null) {
            linkAndBookmarkAndCreditWords = new ArrayList<Object>();
        }
        return this.linkAndBookmarkAndCreditWords;
    }

    /**
     * Gets the value of the page property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPage() {
        return page;
    }

    /**
     * Sets the value of the page property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPage(BigInteger value) {
        this.page = value;
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
