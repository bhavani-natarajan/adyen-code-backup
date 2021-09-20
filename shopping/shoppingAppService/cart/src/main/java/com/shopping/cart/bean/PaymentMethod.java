package com.shopping.cart.bean;


import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;



/**
 * PaymentMethod
 */
public class PaymentMethod {
    private String brand = null;

    private List<String> brands = null;

    private Map<String, String> configuration = null;

    private List<InputDetail> details = null;

    public enum FundingSourceEnum {
        DEBIT("debit");

        @JsonValue
        private String value;

        FundingSourceEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static FundingSourceEnum fromValue(String text) {
            for (FundingSourceEnum b : FundingSourceEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        /*public static class Adapter extends TypeAdapter<FundingSourceEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final FundingSourceEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public FundingSourceEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return FundingSourceEnum.fromValue(String.valueOf(value));
            }*/
        }

    private FundingSourceEnum fundingSource = null;

    private PaymentMethodGroup group = null;

    private List<InputDetail> inputDetails = null;

    private String name = null;

    private String type = null;

    public PaymentMethod brand(String brand) {
        this.brand = brand;
        return this;
    }

    /**
     * Brand for the selected gift card. For example: plastix, hmclub.
     *
     * @return brand
     **/
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public PaymentMethod brands(List<String> brands) {
        this.brands = brands;
        return this;
    }

    public PaymentMethod addBrandsItem(String brandsItem) {
        if (brands == null) {
            brands = new ArrayList<>();
        }
        brands.add(brandsItem);
        return this;
    }

    /**
     * List of possible brands. For example: visa, mc.
     *
     * @return brands
     **/
    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }

    public PaymentMethod configuration(Map<String, String> configuration) {
        this.configuration = configuration;
        return this;
    }

    public PaymentMethod putConfigurationItem(String key, String configurationItem) {

        if (configuration == null) {
            configuration = new HashMap<>();
        }

        configuration.put(key, configurationItem);
        return this;
    }

    /**
     * The configuration of the payment method.
     *
     * @return configuration
     **/
    public Map<String, String> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Map<String, String> configuration) {
        this.configuration = configuration;
    }

    public PaymentMethod details(List<InputDetail> details) {
        this.details = details;
        return this;
    }

    public PaymentMethod addDetailsItem(InputDetail detailsItem) {

        if (details == null) {
            details = new ArrayList<>();
        }

        details.add(detailsItem);
        return this;
    }

    public List<InputDetail> getDetails() {
        return details;
    }

    public void setDetails(List<InputDetail> details) {
        this.details = details;
    }

    public PaymentMethod fundingSource(FundingSourceEnum fundingSource) {
        this.fundingSource = fundingSource;
        return this;
    }

    public FundingSourceEnum getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(FundingSourceEnum fundingSource) {
        this.fundingSource = fundingSource;
    }


    public PaymentMethod group(PaymentMethodGroup group) {
        this.group = group;
        return this;
    }


    /**
     * Get group
     *
     * @return group
     **/
    public PaymentMethodGroup getGroup() {
        return group;
    }

    public void setGroup(PaymentMethodGroup group) {
        this.group = group;
    }

    public PaymentMethod inputDetails(List<InputDetail> inputDetails) {
        this.inputDetails = inputDetails;
        return this;
    }

    public PaymentMethod addInputDetailsItem(InputDetail inputDetailsItem) {
        if (this.inputDetails == null) {
            this.inputDetails = new ArrayList<InputDetail>();
        }
        this.inputDetails.add(inputDetailsItem);
        return this;
    }

    /**
     * All input details to be provided to complete the payment with this payment method.
     *
     * @return inputDetails
     **/
    public List<InputDetail> getInputDetails() {
        return inputDetails;
    }

    public void setInputDetails(List<InputDetail> inputDetails) {
        this.inputDetails = inputDetails;
    }


    public PaymentMethod name(String name) {
        this.name = name;
        return this;
    }


    /**
     * The displayable name of this payment method.
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PaymentMethod supportsRecurring(Boolean supportsRecurring) {
        return this;
    }

    public PaymentMethod type(String type) {
        this.type = type;
        return this;
    }


    /**
     * The unique payment method code.
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentMethod paymentMethod = (PaymentMethod) o;
        return Objects.equals(this.brand, paymentMethod.brand) &&
                Objects.equals(this.brands, paymentMethod.brands) &&
                Objects.equals(this.configuration, paymentMethod.configuration) &&
                Objects.equals(this.details, paymentMethod.details) &&
                Objects.equals(this.fundingSource, paymentMethod.fundingSource) &&
                Objects.equals(this.group, paymentMethod.group) &&
                Objects.equals(this.inputDetails, paymentMethod.inputDetails) &&
                Objects.equals(this.name, paymentMethod.name) &&
                Objects.equals(this.type, paymentMethod.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, brands, configuration, details, fundingSource, group,
                inputDetails, name, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentMethod {\n");

        sb.append("    brand: ").append(brand).append("\n");
        sb.append("    brands: ").append(brands).append("\n");
        sb.append("    configuration: ").append(configuration).append("\n");
        sb.append("    details: ").append(details).append("\n");
        sb.append("    fundingSource: ").append(fundingSource).append("\n");
        sb.append("    group: ").append(group).append("\n");
        sb.append("    inputDetails: ").append(inputDetails).append("\n");
        sb.append("    name: ").append(name).append("\n");
        sb.append("    type: ").append(type).append("\n");
        sb.append("}");
        return sb.toString();
    }
}



