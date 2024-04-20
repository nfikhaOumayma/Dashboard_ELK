package com.example.demo.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACM_COLLECTION")
public class AcmCollection implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1633108725945267561L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ACM_COLLECTION", unique = true, nullable = false)
	private Long id;

	/** The type customer. */
	@Column(name = "CUSTOMER_TYPE", nullable = false)
	private String typeCustomer;

	/** The cutomer id extern. */
	@Column(name = "CUSTOMER_ID_EXTERN", nullable = false)
	private Long customerIdExtern;

	/** The account number. */
	@Column(name = "ACCOUNT_NUMBER", nullable = false, length = 256)
	private String accountNumber;

	/** The product description. */
	@Column(name = "PRODUCT_DESCRIPTION", nullable = false, length = 512)
	private String productDescription;

	/** The customer name. */
	@Column(name = "CUSTOMER_NAME", nullable = false, length = 512)
	private String customerName;

	/** The branch description. */
	@Column(name = "BRANCH_DESCRIPTION", nullable = false, length = 256)
	private String branchDescription;

	/** The amount. */
	@Column(name = "AMOUNT", nullable = false)
	private BigDecimal amount;

	/** The loan officer. */
	@Column(name = "LOAN_OFFICER", length = 50)
	private String loanOfficer;

	/** The first unpaid installment. */
	@Column(name = "FIRST_UNPAID_INSTALLMENT", nullable = false)
	private Date firstUnpaidInstallment;

	/** The unpaid amount. */
	@Column(name = "UNPAID_AMOUNT", nullable = false)
	private BigDecimal unpaidAmount;

	/** The late days. */
	@Column(name = "LATE_DAYS", nullable = false)
	private Integer lateDays;

	/** The number of unpaid installment. */
	@Column(name = "NUMBER_OF_UNPAID_INSTALLMENT", nullable = false)
	private Integer numberOfUnpaidInstallment;

	/** The status. */
	@Column(name = "STATUS")
	private Integer status;

	/** The id acm collection step. */
	@Column(name = "ID_ACM_COLLECTION_STEP", nullable = false)
	private Long idAcmCollectionStep;

	/** The product id. */
	@Column(name = "PRODUCT_ID", nullable = false)
	private Long productId;

	/** The branch id. */
	@Column(name = "BRANCH_ID", nullable = false)
	private Long branchId;

	/** The currency symbol. */
	@Column(name = "CURRENCY_SYMBOL")
	private String currencySymbol;

	/** The currency decimal places. */
	@Column(name = "CURRENCY_DECIMALPLACES")
	private Integer currencyDecimalPlaces;

	/** The id loan extern. */
	@Column(name = "ID_LOAN_EXTERN")
	private Integer idLoanExtern;

	/** The available date. */
	@Column(name = "AVAILABLE_DATE")
	private Date availableDate;

	/** The owner. */
	@Column(name = "COLLECTION_OWNER")
	private String owner;

	/** The owner name. */
	@Column(name = "COLLECTION_OWNER_NAME")
	private String ownerName;

	/** The group owner. */
	@Column(name = "GROUP_OWNER")
	private String groupOwner;

	/** The group owner name. */
	@Column(name = "GROUP_OWNER_NAME")
	private String groupOwnerName;

	/** The collection type. */
	@Column(name = "COLLECTION_TYPE")
	private String collectionType;

	/** The collection type. */
	@Column(name = "ID_PARENT_COLLECTION")
	private Long idParentCollection;

	/** The Current status Label. */
	@Column(name = "STATUT_LIBELLE")
	private String statutLibelle;

	/** The Done status Label. */
	@Column(name = "STATUT_LIBELLE_DONE")
	private String statutLibelleDone;
	
	/** The statut workflow. */
	@Column(name = "STATUT_WORKFLOW")
	private String statutWorkflow;

	public AcmCollection(Long id, String typeCustomer, Long customerIdExtern, String accountNumber,
			String productDescription, String customerName, String branchDescription,
			BigDecimal amount, String loanOfficer, Date firstUnpaidInstallment,
			BigDecimal unpaidAmount, Integer lateDays, Integer numberOfUnpaidInstallment,
			Integer status, Long idAcmCollectionStep, Long productId, Long branchId,
			String currencySymbol, Integer currencyDecimalPlaces, Integer idLoanExtern,
			Date availableDate, String owner, String ownerName, String groupOwner,
			String groupOwnerName, String collectionType, Long idParentCollection,
			String statutLibelle, String statutLibelleDone, String statutWorkflow) {

		super();
		this.id = id;
		this.typeCustomer = typeCustomer;
		this.customerIdExtern = customerIdExtern;
		this.accountNumber = accountNumber;
		this.productDescription = productDescription;
		this.customerName = customerName;
		this.branchDescription = branchDescription;
		this.amount = amount;
		this.loanOfficer = loanOfficer;
		this.firstUnpaidInstallment = firstUnpaidInstallment;
		this.unpaidAmount = unpaidAmount;
		this.lateDays = lateDays;
		this.numberOfUnpaidInstallment = numberOfUnpaidInstallment;
		this.status = status;
		this.idAcmCollectionStep = idAcmCollectionStep;
		this.productId = productId;
		this.branchId = branchId;
		this.currencySymbol = currencySymbol;
		this.currencyDecimalPlaces = currencyDecimalPlaces;
		this.idLoanExtern = idLoanExtern;
		this.availableDate = availableDate;
		this.owner = owner;
		this.ownerName = ownerName;
		this.groupOwner = groupOwner;
		this.groupOwnerName = groupOwnerName;
		this.collectionType = collectionType;
		this.idParentCollection = idParentCollection;
		this.statutLibelle = statutLibelle;
		this.statutLibelleDone = statutLibelleDone;
		this.statutWorkflow = statutWorkflow;
	}

}