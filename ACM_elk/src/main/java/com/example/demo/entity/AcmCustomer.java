package com.example.demo.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.annotation.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACM_CUSTOMER")
public class AcmCustomer implements Serializable {

	/** The Constant serialVersionUID. */

	private static final long serialVersionUID = 8252918111601978289L;

	/** The id. */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ACM_CUSTOMER", unique = true, nullable = false)
	private Long id;

	/** The customer id extern. */

	@Column(name = "CUSTOMER_ID_EXTERN", nullable = false)

	private Long customerIdExtern;

	/** The person id extern. */

	@Column(name = "PERSON_ID_EXTERN")

	private Long personIdExtern;

	/** The customer number. */

	@Column(name = "CUSTOMER_NUMBER", length = 512)

	private String customerNumber;

	/** The open date. */

	@Column(name = "CUSTOMER_OPENDATE")

	private Date customerOpenDate;

	/** The customer name. */

	@Column(name = "CUSTOMER_NAME", length = 512)

	private String customerName;

	/** The correspondance name. */

	@Column(name = "CORRESPONDENCE_NAME", length = 512)

	private String correspondanceName;

	/** The alt name. */

	@Column(name = "ALT_NAME", length = 512)

	private String altName;

	/** The date of birth. */

	@Column(name = "DATE_OF_BIRTH", length = 512)

	private Date dateOfBirth;

	/** The age. */

	@Transient

	private Long age;

	/** The account portflio id. */

	@Column(name = "ACCOUNT_PORTFOLIO_ID", nullable = false)

	private Long accountPortfolioID;

	/** The portflio code. */

	@Column(name = "PORTFOLIO_CODE", length = 512)

	private String accountPortfolioCode;

	/** The portflio description. */

	@Column(name = "PORTFOLIO_DESCRIPTION", length = 512)

	private String accountPortfolioDescription;

	/** The adresse. */

	@Column(name = "CUSTOMER_ADDRESS", length = 512)

	private String customerAddress;

	/** The branchID. */

	@Column(name = "BRANCH_ID")

	private Integer branchId;

	/** The branch name. */

	@Column(name = "BRANCHE_NAME", length = 512)

	private String branchesName;

	/** The branch description. */

	@Column(name = "BRANCHE_DESCRIPTION", length = 512)

	private String branchesDescription;

	/** The telephone1. */

	@Column(name = "TELEPHONE_1", length = 256)

	private String telephone1;

	/** The telephone 2. */

	@Column(name = "TELEPHONE_2", length = 256)

	private String telephone2;

	/** The telephone 3. */

	@Column(name = "TELEPHONE_3", length = 256)

	private String telephone3;

	/** The customer type. */

	@Column(name = "CUSTOMER_TYPE", length = 215)

	private String customerType;

	/** The is customer. */

	@Column(name = "IS_CUSTOMER")

	private Boolean isCustomer;

	/** The organisation id extern. */

	@Column(name = "ORGANISATION_ID_EXTERN")

	private Long organisationIdExtern;

	/** The organisation id . */

	@Column(name = "ORGANISATION_ID")

	private Long organisationId;

	/** The register number. */

	@Column(name = "REGISTER_NUMBER")

	private String registerNumber;

	/** The fax. */

	@Column(name = "FAX")

	private String fax;

	/** The web site. */

	@Column(name = "WEB_SITE")

	private String webSite;

	/** The sector. */

	@Column(name = "SECTOR")

	private String sector;

	/** The email. */

	@Column(name = "EMAIL")

	private String email;

	/** The gender. */

	@Column(name = "GENDER")

	private String gender;

	/** The date of birth hijri. */

	@Column(name = "DATE_OF_BIRTH_HIJRI")

	private String dateOfBirthHijri;

	/** The organization name. */

	@Column(name = "ORGANIZATION_NAME")

	private String organizationName;

	/** The account year end. */

	@Column(name = "ACCOUNT_YEAR_END")

	private Date accountYearEnd;

	/** The solidarity name. */

	@Column(name = "SOLIDARITY_NAME")

	private String solidarityName;

	/** The update customer. */

	@Column(name = "UPDATE_CUSTOMER")

	private Boolean updateCustomer;

	/** The identity customer. */

	@Column(name = "IDENTITY_NUMBER")

	private String identity;

	/** The marital status : {@link CustomerMaritalStatus}. */

	@Column(name = "MARITAL_STATUS", length = 5)

	private String maritalStatus;

	/** The meza card status : {@link CustomerMezaCardStatus} . */

	@Column(name = "MEZA_CARD_STATUS", length = 50)

	private String mezaCardStatus;

	/** The photo. */

	@Column(name = "PHOTO")

	private byte[] photo;

	/** The loans. */

	/*@OneToMany(mappedBy = "customer")
	private Set<Loan> loans = new HashSet<>();*/

	/** The enable critical data. */

	@Column(name = "ENABLE_CRITICAL_DATA")

	private Boolean enableCriticalData;

	/** The ib customer id. */

	@Column(name = "IB_CUSTOMER_ID")

	private Long ibCustomerId;

	/** The is supplier. */

	@Column(name = "IS_SUPPLIER")

	private Boolean isSupplier;

	/** The beneficial effective. */

	@Column(name = "BENEFICIAL_EFFECTIVE")

	private String beneficialEffective;

	/** The prospection source. */

	@Column(name = "PROSPECTION_SOURCE")

	private String prospectionSource;

	/** The prospection comment. */

	@Column(name = "PROSPECTION_COMMENT")

	private String prospectionComment;

	/** The supplier recommandation. */

	@Column(name = "SUPPLIER_RECOMMANDATION")

	private Long supplierRecommandation;



	public AcmCustomer(Long customerIdExtern, String customerNumber, Date customerOpenDate,

			String customerName, String correspondanceName, String altName, Date dateOfBirth,

			Long accountPortfolioID, String accountPortfolioCode,

			String accountPortfolioDescription, String customerAddress, Integer branchId,

			String branchesName, String branchesDescription, Long age, String telephone1,

			String telephone2, String telephone3, String customerType, Boolean isCustomer,

			Long organisationId, Long organisationIdExtern, String registerNumber, String fax,

			String webSite, String sector, String email, Boolean isSupplier,

			String beneficialEffective, String prospectionSource, String prospectionComment,

			Long supplierRecommandation) {



		this.customerIdExtern = customerIdExtern;

		this.customerNumber = customerNumber;

		this.customerOpenDate = customerOpenDate;

		this.customerName = customerName;

		this.correspondanceName = correspondanceName;

		this.altName = altName;

		this.dateOfBirth = dateOfBirth;

		this.accountPortfolioID = accountPortfolioID;

		this.accountPortfolioCode = accountPortfolioCode;

		this.accountPortfolioDescription = accountPortfolioDescription;

		this.customerAddress = customerAddress;

		this.branchId = branchId;

		this.branchesName = branchesName;

		this.branchesDescription = branchesDescription;

		this.telephone1 = telephone1;

		this.telephone2 = telephone2;

		this.telephone3 = telephone3;

		this.customerType = customerType;

		this.isCustomer = isCustomer;

		this.organisationId = organisationId;

		this.organisationIdExtern = organisationIdExtern;

		this.registerNumber = registerNumber;

		this.fax = fax;

		this.webSite = webSite;

		this.sector = sector;

		this.email = email;

		this.isSupplier = isSupplier;

		this.beneficialEffective = beneficialEffective;

		this.prospectionSource = prospectionSource;

		this.prospectionComment = prospectionComment;

		this.supplierRecommandation = supplierRecommandation;

	}
}