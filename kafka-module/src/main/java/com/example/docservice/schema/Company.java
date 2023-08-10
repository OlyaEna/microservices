/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.docservice.schema;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Company extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 4192863797721790887L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Company\",\"namespace\":\"com.example.docservice.schema\",\"fields\":[{\"name\":\"id\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"addressId\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"occupation\",\"type\":[\"null\",\"string\"],\"default\":null},{\"name\":\"personnel\",\"type\":\"long\",\"default\":-1},{\"name\":\"formOwnership\",\"type\":{\"type\":\"enum\",\"name\":\"FormOwnership\",\"symbols\":[\"INDIVIDUAL_ENTREPRENEUR\",\"UNITARY_ENTERPRISE\",\"LLC\"]}},{\"name\":\"financialAmount\",\"type\":[\"null\",\"string\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Company> ENCODER =
      new BinaryMessageEncoder<Company>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Company> DECODER =
      new BinaryMessageDecoder<Company>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Company> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Company> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Company> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Company>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Company to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Company from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Company instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Company fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.lang.CharSequence id;
  private java.lang.CharSequence addressId;
  private java.lang.CharSequence occupation;
  private long personnel;
  private com.example.docservice.schema.FormOwnership formOwnership;
  private java.lang.CharSequence financialAmount;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Company() {}

  /**
   * All-args constructor.
   * @param id The new value for id
   * @param addressId The new value for addressId
   * @param occupation The new value for occupation
   * @param personnel The new value for personnel
   * @param formOwnership The new value for formOwnership
   * @param financialAmount The new value for financialAmount
   */
  public Company(java.lang.CharSequence id, java.lang.CharSequence addressId, java.lang.CharSequence occupation, java.lang.Long personnel, com.example.docservice.schema.FormOwnership formOwnership, java.lang.CharSequence financialAmount) {
    this.id = id;
    this.addressId = addressId;
    this.occupation = occupation;
    this.personnel = personnel;
    this.formOwnership = formOwnership;
    this.financialAmount = financialAmount;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return id;
    case 1: return addressId;
    case 2: return occupation;
    case 3: return personnel;
    case 4: return formOwnership;
    case 5: return financialAmount;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: id = (java.lang.CharSequence)value$; break;
    case 1: addressId = (java.lang.CharSequence)value$; break;
    case 2: occupation = (java.lang.CharSequence)value$; break;
    case 3: personnel = (java.lang.Long)value$; break;
    case 4: formOwnership = (com.example.docservice.schema.FormOwnership)value$; break;
    case 5: financialAmount = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   * @return The value of the 'id' field.
   */
  public java.lang.CharSequence getId() {
    return id;
  }


  /**
   * Sets the value of the 'id' field.
   * @param value the value to set.
   */
  public void setId(java.lang.CharSequence value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'addressId' field.
   * @return The value of the 'addressId' field.
   */
  public java.lang.CharSequence getAddressId() {
    return addressId;
  }


  /**
   * Sets the value of the 'addressId' field.
   * @param value the value to set.
   */
  public void setAddressId(java.lang.CharSequence value) {
    this.addressId = value;
  }

  /**
   * Gets the value of the 'occupation' field.
   * @return The value of the 'occupation' field.
   */
  public java.lang.CharSequence getOccupation() {
    return occupation;
  }


  /**
   * Sets the value of the 'occupation' field.
   * @param value the value to set.
   */
  public void setOccupation(java.lang.CharSequence value) {
    this.occupation = value;
  }

  /**
   * Gets the value of the 'personnel' field.
   * @return The value of the 'personnel' field.
   */
  public long getPersonnel() {
    return personnel;
  }


  /**
   * Sets the value of the 'personnel' field.
   * @param value the value to set.
   */
  public void setPersonnel(long value) {
    this.personnel = value;
  }

  /**
   * Gets the value of the 'formOwnership' field.
   * @return The value of the 'formOwnership' field.
   */
  public com.example.docservice.schema.FormOwnership getFormOwnership() {
    return formOwnership;
  }


  /**
   * Sets the value of the 'formOwnership' field.
   * @param value the value to set.
   */
  public void setFormOwnership(com.example.docservice.schema.FormOwnership value) {
    this.formOwnership = value;
  }

  /**
   * Gets the value of the 'financialAmount' field.
   * @return The value of the 'financialAmount' field.
   */
  public java.lang.CharSequence getFinancialAmount() {
    return financialAmount;
  }


  /**
   * Sets the value of the 'financialAmount' field.
   * @param value the value to set.
   */
  public void setFinancialAmount(java.lang.CharSequence value) {
    this.financialAmount = value;
  }

  /**
   * Creates a new Company RecordBuilder.
   * @return A new Company RecordBuilder
   */
  public static com.example.docservice.schema.Company.Builder newBuilder() {
    return new com.example.docservice.schema.Company.Builder();
  }

  /**
   * Creates a new Company RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Company RecordBuilder
   */
  public static com.example.docservice.schema.Company.Builder newBuilder(com.example.docservice.schema.Company.Builder other) {
    if (other == null) {
      return new com.example.docservice.schema.Company.Builder();
    } else {
      return new com.example.docservice.schema.Company.Builder(other);
    }
  }

  /**
   * Creates a new Company RecordBuilder by copying an existing Company instance.
   * @param other The existing instance to copy.
   * @return A new Company RecordBuilder
   */
  public static com.example.docservice.schema.Company.Builder newBuilder(com.example.docservice.schema.Company other) {
    if (other == null) {
      return new com.example.docservice.schema.Company.Builder();
    } else {
      return new com.example.docservice.schema.Company.Builder(other);
    }
  }

  /**
   * RecordBuilder for Company instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Company>
    implements org.apache.avro.data.RecordBuilder<Company> {

    private java.lang.CharSequence id;
    private java.lang.CharSequence addressId;
    private java.lang.CharSequence occupation;
    private long personnel;
    private com.example.docservice.schema.FormOwnership formOwnership;
    private java.lang.CharSequence financialAmount;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.docservice.schema.Company.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.addressId)) {
        this.addressId = data().deepCopy(fields()[1].schema(), other.addressId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.occupation)) {
        this.occupation = data().deepCopy(fields()[2].schema(), other.occupation);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.personnel)) {
        this.personnel = data().deepCopy(fields()[3].schema(), other.personnel);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.formOwnership)) {
        this.formOwnership = data().deepCopy(fields()[4].schema(), other.formOwnership);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.financialAmount)) {
        this.financialAmount = data().deepCopy(fields()[5].schema(), other.financialAmount);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
    }

    /**
     * Creates a Builder by copying an existing Company instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.docservice.schema.Company other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.addressId)) {
        this.addressId = data().deepCopy(fields()[1].schema(), other.addressId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.occupation)) {
        this.occupation = data().deepCopy(fields()[2].schema(), other.occupation);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.personnel)) {
        this.personnel = data().deepCopy(fields()[3].schema(), other.personnel);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.formOwnership)) {
        this.formOwnership = data().deepCopy(fields()[4].schema(), other.formOwnership);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.financialAmount)) {
        this.financialAmount = data().deepCopy(fields()[5].schema(), other.financialAmount);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'id' field.
      * @return The value.
      */
    public java.lang.CharSequence getId() {
      return id;
    }


    /**
      * Sets the value of the 'id' field.
      * @param value The value of 'id'.
      * @return This builder.
      */
    public com.example.docservice.schema.Company.Builder setId(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'id' field has been set.
      * @return True if the 'id' field has been set, false otherwise.
      */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'id' field.
      * @return This builder.
      */
    public com.example.docservice.schema.Company.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'addressId' field.
      * @return The value.
      */
    public java.lang.CharSequence getAddressId() {
      return addressId;
    }


    /**
      * Sets the value of the 'addressId' field.
      * @param value The value of 'addressId'.
      * @return This builder.
      */
    public com.example.docservice.schema.Company.Builder setAddressId(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.addressId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'addressId' field has been set.
      * @return True if the 'addressId' field has been set, false otherwise.
      */
    public boolean hasAddressId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'addressId' field.
      * @return This builder.
      */
    public com.example.docservice.schema.Company.Builder clearAddressId() {
      addressId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'occupation' field.
      * @return The value.
      */
    public java.lang.CharSequence getOccupation() {
      return occupation;
    }


    /**
      * Sets the value of the 'occupation' field.
      * @param value The value of 'occupation'.
      * @return This builder.
      */
    public com.example.docservice.schema.Company.Builder setOccupation(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.occupation = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'occupation' field has been set.
      * @return True if the 'occupation' field has been set, false otherwise.
      */
    public boolean hasOccupation() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'occupation' field.
      * @return This builder.
      */
    public com.example.docservice.schema.Company.Builder clearOccupation() {
      occupation = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'personnel' field.
      * @return The value.
      */
    public long getPersonnel() {
      return personnel;
    }


    /**
      * Sets the value of the 'personnel' field.
      * @param value The value of 'personnel'.
      * @return This builder.
      */
    public com.example.docservice.schema.Company.Builder setPersonnel(long value) {
      validate(fields()[3], value);
      this.personnel = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'personnel' field has been set.
      * @return True if the 'personnel' field has been set, false otherwise.
      */
    public boolean hasPersonnel() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'personnel' field.
      * @return This builder.
      */
    public com.example.docservice.schema.Company.Builder clearPersonnel() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'formOwnership' field.
      * @return The value.
      */
    public com.example.docservice.schema.FormOwnership getFormOwnership() {
      return formOwnership;
    }


    /**
      * Sets the value of the 'formOwnership' field.
      * @param value The value of 'formOwnership'.
      * @return This builder.
      */
    public com.example.docservice.schema.Company.Builder setFormOwnership(com.example.docservice.schema.FormOwnership value) {
      validate(fields()[4], value);
      this.formOwnership = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'formOwnership' field has been set.
      * @return True if the 'formOwnership' field has been set, false otherwise.
      */
    public boolean hasFormOwnership() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'formOwnership' field.
      * @return This builder.
      */
    public com.example.docservice.schema.Company.Builder clearFormOwnership() {
      formOwnership = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'financialAmount' field.
      * @return The value.
      */
    public java.lang.CharSequence getFinancialAmount() {
      return financialAmount;
    }


    /**
      * Sets the value of the 'financialAmount' field.
      * @param value The value of 'financialAmount'.
      * @return This builder.
      */
    public com.example.docservice.schema.Company.Builder setFinancialAmount(java.lang.CharSequence value) {
      validate(fields()[5], value);
      this.financialAmount = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'financialAmount' field has been set.
      * @return True if the 'financialAmount' field has been set, false otherwise.
      */
    public boolean hasFinancialAmount() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'financialAmount' field.
      * @return This builder.
      */
    public com.example.docservice.schema.Company.Builder clearFinancialAmount() {
      financialAmount = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Company build() {
      try {
        Company record = new Company();
        record.id = fieldSetFlags()[0] ? this.id : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.addressId = fieldSetFlags()[1] ? this.addressId : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.occupation = fieldSetFlags()[2] ? this.occupation : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.personnel = fieldSetFlags()[3] ? this.personnel : (java.lang.Long) defaultValue(fields()[3]);
        record.formOwnership = fieldSetFlags()[4] ? this.formOwnership : (com.example.docservice.schema.FormOwnership) defaultValue(fields()[4]);
        record.financialAmount = fieldSetFlags()[5] ? this.financialAmount : (java.lang.CharSequence) defaultValue(fields()[5]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Company>
    WRITER$ = (org.apache.avro.io.DatumWriter<Company>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Company>
    READER$ = (org.apache.avro.io.DatumReader<Company>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    if (this.id == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.id);
    }

    if (this.addressId == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.addressId);
    }

    if (this.occupation == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.occupation);
    }

    out.writeLong(this.personnel);

    out.writeEnum(this.formOwnership.ordinal());

    if (this.financialAmount == null) {
      out.writeIndex(0);
      out.writeNull();
    } else {
      out.writeIndex(1);
      out.writeString(this.financialAmount);
    }

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (in.readIndex() != 1) {
        in.readNull();
        this.id = null;
      } else {
        this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.addressId = null;
      } else {
        this.addressId = in.readString(this.addressId instanceof Utf8 ? (Utf8)this.addressId : null);
      }

      if (in.readIndex() != 1) {
        in.readNull();
        this.occupation = null;
      } else {
        this.occupation = in.readString(this.occupation instanceof Utf8 ? (Utf8)this.occupation : null);
      }

      this.personnel = in.readLong();

      this.formOwnership = com.example.docservice.schema.FormOwnership.values()[in.readEnum()];

      if (in.readIndex() != 1) {
        in.readNull();
        this.financialAmount = null;
      } else {
        this.financialAmount = in.readString(this.financialAmount instanceof Utf8 ? (Utf8)this.financialAmount : null);
      }

    } else {
      for (int i = 0; i < 6; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (in.readIndex() != 1) {
            in.readNull();
            this.id = null;
          } else {
            this.id = in.readString(this.id instanceof Utf8 ? (Utf8)this.id : null);
          }
          break;

        case 1:
          if (in.readIndex() != 1) {
            in.readNull();
            this.addressId = null;
          } else {
            this.addressId = in.readString(this.addressId instanceof Utf8 ? (Utf8)this.addressId : null);
          }
          break;

        case 2:
          if (in.readIndex() != 1) {
            in.readNull();
            this.occupation = null;
          } else {
            this.occupation = in.readString(this.occupation instanceof Utf8 ? (Utf8)this.occupation : null);
          }
          break;

        case 3:
          this.personnel = in.readLong();
          break;

        case 4:
          this.formOwnership = com.example.docservice.schema.FormOwnership.values()[in.readEnum()];
          break;

        case 5:
          if (in.readIndex() != 1) {
            in.readNull();
            this.financialAmount = null;
          } else {
            this.financialAmount = in.readString(this.financialAmount instanceof Utf8 ? (Utf8)this.financialAmount : null);
          }
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









