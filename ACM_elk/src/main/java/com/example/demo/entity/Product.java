package com.example.demo.entity;


import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;



import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;



import javax.persistence.Table;

import javax.persistence.Transient;





@Entity

@Table(name = "ACM_PRODUCT")

// @EntityListeners(AuditTrailListener.class)

public class Product implements Serializable {



	/** The Constant serialVersionUID. */

	private static final long serialVersionUID = -7203814268449840070L;



	/** The id. */

	@Id

	@Column(name = "ID_ACM_PRODUCT", nullable = false)

	private Long id;



	/** The code. */

	@Column(name = "CODE", nullable = false)

	private String code;



	/** The description. */

	@Column(name = "DESCRIPTION", nullable = false)

	private String description;



	/** The product id abacus. */

	@Column(name = "PRODUCT_ID_ABACUS")

	private Long productIdAbacus;



	/** The product type abacus. */

	@Column(name = "PRODUCT_TYPE_ID_ABACUS")

	private Long productTypeAbacus;



	/** The creation date abacus. */

	@Column(name = "CREATION_DATE_ABACUS")

	private Date creationDateAbacus;



	/** The edit date abacus. */

	@Column(name = "EDIT_DATE_ABACUS")

	private Date editDateAbacus;



	/** The product individual. */

	@Column(name = "INDIV")

	private Boolean productIndiv;



	/** The product group. */

	@Column(name = "GRP")

	private Boolean productGrp;



	/** The product organization. */

	@Column(name = "ORG")

	private Boolean productOrg;



	/** The rate start date. */

	@Column(name = "RATE_START_DATE")

	private Date rateStartDate;



	/** The rate end date. */

	@Column(name = "RATE_END_DATE")

	private Date rateEndDate;



	/** The rate. */

	@Column(name = "RATE")

	private BigDecimal rate;



	/** The maximum balance. */

	@Column(name = "MAXIMUM_BALANCE")

	private BigDecimal maximumBalance;



	/** The minimum term. */

	@Column(name = "MINIMUM_TERM")

	private Integer minimumTerm;



	/** The maximum term. */

	@Column(name = "MAXIMUM_TERM")

	private Integer maximumTerm;



	/** The issue fee percentage 1. */

	@Column(name = "ISSUE_FEE_PERCENTAGE_1")

	private BigDecimal issueFeePercentage1;



	/** The issue fee percentage 2. */

	@Column(name = "ISSUE_FEE_PERCENTAGE_2")

	private BigDecimal issueFeePercentage2;



	/** The issue fee percentage 3. */

	@Column(name = "ISSUE_FEE_PERCENTAGE_3")

	private BigDecimal issueFeePercentage3;



	/** The issue fee percentage 4. */

	@Column(name = "ISSUE_FEE_PERCENTAGE_4")

	private BigDecimal issueFeePercentage4;



	/** The use schedule interest. */

	@Column(name = "USE_SCHEDULE_INTEREST")

	private Boolean useScheduleInterest;



	/** The capitalise interest when refinancing. */

	@Column(name = "CAPITALISE_INTEREST_WHEN_REFINANCING")

	private Boolean capitaliseInterestWhenRefinancing;



	/** The decimal. */

	@Column(name = "DECIMAL_PLACES")

	private Integer decimal;



	/** The currency. */

	@Column(name = "CURRENCY")

	private String currency;



	/** The about product. */

	@Column(name = "ABOUT_PRODUCT", length = 5000)

	private String aboutProduct;



	/** The maximum age. */

	@Column(name = "MAXIMUM_AGE")

	private Integer maximumAge;



	/** The minimum age. */

	@Column(name = "MINIMUM_AGE")

	private Integer minimumAge;



	/** The max accounts. */

	@Column(name = "MAX_ACCOUNTS")

	private Integer maxAccounts;



	/** The maximum deferred period. */

	@Column(name = "MAXIMUM_DEFERRED_PERIOD")

	private Integer maximumDeferredPeriod;



	/** The minimum deferred period. */

	@Column(name = "MINIMUM_DEFERRED_PERIOD")

	private Integer minimumDeferredPeriod;



	/** The cu insurance ID. */

	@Column(name = "CU_INSURANCE_ID")

	private Integer cuInsuranceID;



	/** The issue fee VAT 1. */

	@Column(name = "ISSUE_FEE_VAT_1")

	private BigDecimal issueFeeVAT1;



	/** The issue fee VAT 2. */

	@Column(name = "ISSUE_FEE_VAT_2")

	private BigDecimal issueFeeVAT2;



	/** The insurance vat. */

	@Column(name = "INSURANCE_VAT")

	private BigDecimal insuranceVat;



	/** The round type. */

	@Column(name = "ROUND_TYPE")

	private String roundType;



	/** The issue fee amount 1. */

	@Column(name = "ISSUEFEEAMOUNT1")

	private BigDecimal issueFeeAmount1;



	/** The issue fee amount 2. */

	@Column(name = "ISSUEFEEAMOUNT2")

	private BigDecimal issueFeeAmount2;



	/** The flat interest rate. */

	@Column(name = "FLAT_INTEREST_RATE")

	private BigDecimal flatInterestRate;





	/** The renewal percentage. */

	@Column(name = "RENEWAL_LOAN_PERCENTAGE")

	private BigDecimal renewalPercentage;



	/** The token. */

	@Transient

	private String token;



	/** The max num days expiry. */

	@Column(name = "ISCORE_NUM_DAYS_EXPIRY_CHECK")

	private Integer maxNumDaysExpiry;



	/** The max score. */

	@Column(name = "ISCORE_MAX_SCORE")

	private Integer maxScore;



	/** The max active loans. */

	@Column(name = "ISCORE_MAX_ACTIVE_LOANS")

	private Integer maxActiveLoans;



	/** The max num days due. */

	@Column(name = "ISCORE_MAX_NUM_DAYS_DUE")

	private Integer maxNumDaysDue;



	/** The aml check pourcentage. */

	@Column(name = "AML_CHECK_POURCENTAGE")

	private BigDecimal amlCheckPourcentage;



	/** The min active loans. */

	@Column(name = "ISCORE_MIN_ACTIVE_LOANS")

	private Integer minActiveLoans;



	/** The min num days due. */

	@Column(name = "ISCORE_MIN_NUM_DAYS_DUE")

	private Integer minNumDaysDue;



	/** The min score. */

	@Column(name = "ISCORE_MIN_SCORE")

	private Integer minScore;



	/** The topup. */

	@Column(name = "TOPUP")

	private Boolean topup;



	/** The refinance. */

	@Column(name = "REFINANCE")

	private Boolean refinance;



	/** The is frequency. */

	@Column(name = "IS_FREQUENCY")

	private Boolean isFrequency;





	/** The supplier. */

	@Column(name = "SUPPLIER")

	private Boolean supplier;



	/** The is frequency with deferred periode. */

	@Column(name = "IS_FREQUENCY_WITH_DEFERRED_PEDIODE")

	private Boolean isFrequencyWithDeferredPeriode;



	/** The disburse. */

	@Column(name = "DISBURSE")

	private Boolean disburse;



	/**

	 * Instantiates a new product.

	 */

	public Product() {



		/*

		 * Empty

		 */

	}



	/**

	 * Instantiates a new product.

	 *

	 * @param id the id

	 */

	public Product(Long id) {



		this.id = id;

	}



	/**

	 * Instantiates a new groupe.

	 *

	 * @param code the code

	 */

	public Product(String code) {



		this.code = code;

	}



	/**

	 * Instantiates a new product.

	 *

	 * @param id the id

	 * @param code the code

	 * @param description the description

	 * @param productIdAbacus the product id abacus

	 * @param productTypeAbacus the product type abacus

	 * @param creationDateAbacus the creation date abacus

	 * @param editDateAbacus the edit date abacus

	 */

	public Product(Long id, String code, String description, Long productIdAbacus,

			Long productTypeAbacus, Date creationDateAbacus, Date editDateAbacus) {



		this.id = id;

		this.code = code;

		this.description = description;

		this.productIdAbacus = productIdAbacus;

		this.productTypeAbacus = productTypeAbacus;

		this.creationDateAbacus = creationDateAbacus;

		this.editDateAbacus = editDateAbacus;

	}



	/**

	 * Instantiates a new product.

	 *

	 * @param code the code

	 * @param description the description

	 * @param productIdAbacus the product id abacus

	 * @param productTypeAbacus the product type abacus

	 * @param creationDateAbacus the creation date abacus

	 * @param editDateAbacus the edit date abacus

	 */

	public Product(String code, String description, Long productIdAbacus, Long productTypeAbacus,

			Date creationDateAbacus, Date editDateAbacus) {



		this.code = code;

		this.description = description;

		this.productIdAbacus = productIdAbacus;

		this.productTypeAbacus = productTypeAbacus;

		this.creationDateAbacus = creationDateAbacus;

		this.editDateAbacus = editDateAbacus;

	}



	/**

	 * Gets the id.

	 *

	 * @return the id

	 */

	public Long getId() {



		return id;

	}



	/**

	 * Sets the id.

	 *

	 * @param id the id to set

	 */

	public void setId(Long id) {



		this.id = id;

	}



	/**

	 * Gets the code.

	 *

	 * @return the code

	 */

	public String getCode() {



		return code;

	}



	/**

	 * Sets the code.

	 *

	 * @param code the code to set

	 */

	public void setCode(String code) {



		this.code = code;

	}



	/**

	 * Gets the description.

	 *

	 * @return the description

	 */

	public String getDescription() {



		return description;

	}



	/**

	 * Sets the description.

	 *

	 * @param description the description to set

	 */

	public void setDescription(String description) {



		this.description = description;

	}



	/**

	 * Gets the product id abacus.

	 *

	 * @return the productIdAbacus

	 */

	public Long getProductIdAbacus() {



		return productIdAbacus;

	}



	/**

	 * Sets the product id abacus.

	 *

	 * @param productIdAbacus the productIdAbacus to set

	 */

	public void setProductIdAbacus(Long productIdAbacus) {



		this.productIdAbacus = productIdAbacus;

	}



	/**

	 * Gets the product type abacus.

	 *

	 * @return the productTypeAbacus

	 */

	public Long getProductTypeAbacus() {



		return productTypeAbacus;

	}



	/**

	 * Sets the product type abacus.

	 *

	 * @param productTypeAbacus the productTypeAbacus to set

	 */

	public void setProductTypeAbacus(Long productTypeAbacus) {



		this.productTypeAbacus = productTypeAbacus;

	}
	
}
