package com.example.demo.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ACM_LOAN")
public class Loan implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4508256347060684391L;

	/** The id loan. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ACM_LOAN", unique = true, nullable = false)
	private Long idLoan;

	/** The id loan extern. */
	@Column(name = "ID_LOAN_EXTERN", nullable = false)
	private Long idLoanExtern;

	/** The id account extern. */
	@Column(name = "ID_ACCOUNT_EXTERN")
	private Long idAccountExtern;

	/** The account number extern. */
	@Column(name = "ACCOUNT_NUMBER_EXTERN")
	private String accountNumberExtern;

	/** The process instance id. */
	@Column(name = "PROCESS_INSTANCE_ID", length = 256)
	private String processInstanceId;

	/** The portfolio id. */
	@Column(name = "PORTFOLIO_ID")
	private Long portfolioId;

	/** The statut. */
	@Column(name = "STATUT", nullable = false)
	private Integer statut;

	/** The product description. */
	@Column(name = "LOANPRODUCT_DESCRIPTION")
	private String productDescription;

	/** The product code. */
	@Column(name = "LOANPRODUCT_CODE")
	private String productCode;

	/** The product id. */
	@Column(name = "PRODUCT_ID")
	private Integer productId;

	/** The id customer. */
	@Column(name = "CUSTOMER_ID")
	private Long customerId;

	/** The customer name. */
	@Column(name = "CUSTOMER_NAME")
	private String customerName;

	/** The applyamounttotal. */
	@Column(name = "APPLY_AMOUNT_TOTAL")
	private BigDecimal applyAmountTotal;

	/** The approvel amount. */
	@Column(name = "APPROVEL_AMOUNT")
	private BigDecimal approvelAmount;

	/** The currency symbol. */
	@Column(name = "CURRENCY_SYMBOL")
	private String currencySymbol;

	/** The currency decimal places. */
	@Column(name = "CURRENCY_DECIMALPLACES")
	private Integer currencyDecimalPlaces;

	/** The apply date. */
	@Column(name = "APPLYDATE")
	private Date applyDate;

	/** The account portfolio code. */
	@Column(name = "ACCOUNTPORTFOLIO_CODE")
	private String portfolioCode;

	/** The account portfolio description. */
	@Column(name = "ACCOUNTPORTFOLIO_DESCRIPTION")
	private String portfolioDescription;

	/** The owner. */
	@Column(name = "LOAN_OWNER")
	private String owner;

	/** The owner name. */
	@Column(name = "LOAN_OWNER_NAME")
	private String ownerName;

	/** The statut workflow. */
	@Column(name = "STATUT_WORKFLOW")
	private Integer statutWorkflow;

	/** The statut libelle. */
	@Column(name = "STATUT_LIBELLE")
	private String statutLibelle;

	/** The etape workflow. */
	@Column(name = "ID_ACM_WORKFLOW_STEP")
	private Integer etapeWorkflow;

	/** The ihm root. */
	@Column(name = "IHM_WEB_ROOT", length = 512)
	private String ihmRoot;

	/** The note. */
	@Column(name = "LOAN_NOTE")
	private String note;

	/** The graceperiod. */
	@Column(name = "GRACE_PERIOD")
	private Integer gracePeriod;

	/** The industrycodeid. */
	@Column(name = "ACCOUNT_INDUSTRY_CODE_CODE", length = 256)
	private String industryCode;

	/** The industry code description. */
	@Column(name = "ACCOUNT_INDUSTRY_CODE_DESCRIPTION", length = 256)
	private String industryCodeDescription;

	/** The issuedate. */
	@Column(name = "ISSUE_DATE")
	private Date issueDate;

	/** The creation date. */
	@Column(name = "CREATION_DATE_ABACUS")
	private Date creationDate;

	/** The term period num. */
	@Column(name = "TERM_PERIOD")
	private Integer termPeriodNum;

	/** The payment freq. */
	@Column(name = "PERIOD_FREQ")
	private Integer paymentFreq;

	/** The issue fee amount. */
	@Column(name = "ISSUE_FEE_AMOUNT")
	private BigDecimal issueFeeAmount;

	/** The product rate. */
	@Column(name = "PRODUCT_RATE")
	private BigDecimal productRate;

	/** The loan reason code. */
	@Column(name = "PRODUCT_LOAN_REASONS_CODE", length = 256)
	private String loanReasonCode;

	/** The loan reason description. */
	@Column(name = "PRODUCT_LOAN_REASONS_DESCRIPTION", length = 256)
	private String loanReasonDescription;

	/** The initial payment date. */
	@Column(name = "INITIAL_PAYMENT_DATE")
	private Date initialPaymentDate;

	/** The normal payment. */
	@Column(name = "NORMAL_PAYMENT")
	private Long normalPayment;

	/** The ignore odd days. */
	@Column(name = "IGNORE_ODD_DAYS")
	private Boolean ignoreOddDays;

	/** The periods deferred. */
	@Column(name = "PERIODS_DEFERRED")
	private Integer periodsDeferred;

	/** The calculate initial payment date. */
	@Column(name = "CALCULATE_INITIAL_PAYMENT_DATE")
	private Boolean calculateInitialPaymentDate;

	/** The term period ID. */
	@Column(name = "TERM_PERIOD_ID")
	private Long termPeriodID;

	/** The branchID. */
	@Column(name = "BRANCHID")
	private Integer branchID;

	/** The branch name. */
	@Column(name = "BRANCHE_NAME", length = 50)
	private String branchName;

	/** The branch description. */
	@Column(name = "BRANCHE_DESCRIPTION", length = 200)
	private String branchDescription;

	/** The category. */
	@Column(name = "CATEGORY", length = 256)
	private String category;

	/** The change date status workflow. */
	@Column(name = "CHANGE_DATE_STATUS_WORKFLOW")
	private Date changeDateStatusWorkflow;

	/** The customer type. */
	@Column(name = "CUSTOMER_TYPE", length = 215)
	private String customerType;

	/** The parentid. */
	@Column(name = "PARENT_ID", nullable = false)
	private Long parentId;
	/** The process name. */
	@Column(name = "BPMN_PROCESS_NAME")
	private String processName;

	/** The community CU loan ID. */
	@Column(name = "COMMUNITY_CULOAN_ID")
	private Long communityCULoanID;

	/** The guarantor source id. */
	@Column(name = "GUARANTOR_SOURCE_ID")
	private Integer guarantorSourceId;

	/** The source of funds ID. */
	@Column(name = "SOURCE_OF_FUNDS_ID")
	private Integer sourceOfFundsID;

	/** The refinance reason id. */
	@Column(name = "REFINANCE_REASON_ID")
	private Integer refinanceReasonId;

	/** The district code id. */
	@Column(name = "DISTRICT_CODE_ID")
	private Integer districtCodeId;

	/** The interest freq. */
	@Column(name = "INTEREST_FREQ")
	private Integer interestFreq;

	/** The int pay period num. */
	@Column(name = "INT_PAY_PERIOD_NUM")
	private Integer intPayPeriodNum;

	/** The update loan. */
	@Column(name = "UPDATE_LOAN")
	private Boolean updateLoan;

	/** The loan assigned to customer. */
	@Column(name = "ASSIGN_CUSTOMER")
	private Boolean assignCustomer;

	/** The loan calculation mode. */
	@Column(name = "LOAN_CALCULATION_MODE")
	private Integer loanCalculationMode;

	/** The apr. */
	@Column(name = "APR")
	private BigDecimal apr;

	/** The effective int rate. */
	@Column(name = "EFFECTIVE_INT_RATE")
	private BigDecimal effectiveIntRate;


	/** The group owner name. */
	@Column(name = "GROUP_OWNER_NAME")
	private String groupOwnerName;

	/** The group owner. */
	@Column(name = "GROUP_OWNER")
	private String groupOwner;

	/** The fee amt 1 Application Fees. */
	@Column(name = "FEE_AMOUNT1")
	private BigDecimal feeAmt1;

	/** The is topup refinance. */
	@Column(name = "LOAN_APPLICATION_STATUS")
	private String loanApplicationStatus;

	/** The is topup refinance. */
	@Column(name = "OPENING_BALANCE")
	private Integer openingBalance;

	/** The periods deferred type. */
	@Column(name = "PERIODS_DEFERRED_TYPE_ID")
	private Integer periodsDeferredType;

	/** The installment number. */
	@Column(name = "INSTALLMENT_NUMBER")
	private Integer installmentNumber;

	/** The ready for disb. */
	@Column(name = "READY_FOR_DISB")
	private Integer readyForDisb;


	/** The token. */
	@Transient
	private String token;

	/** The review from. */
	@Column(name = "REVIEW_FROM")
	private Long reviewFrom;

	/** The total interest. */
	@Column(name = "TOTAL_INTEREST")
	private BigDecimal totalInterest;

	/** The personal contribution. */
	@Column(name = "PERSONAL_CONTRIBUTION")
	private Integer personalContribution;

	/** The workflow completed. */
	@Column(name = "WORKFLOW_COMPLETED")
	private Boolean workflowCompleted;

	/** The id ib loan. */
	@Column(name = "ID_IB_loan")
	private Long idIbLoan;

	/** The other informations. */
	@Column(name = "OTHER_INFORMATIONS")
	private String otherInformations;

	/** The max installment. */
	@Column(name = "MAX_INSTALLMENT")
	private BigDecimal maxInstallment;

	/** The sign contarct validation. */
	@Column(name = "SIGN_CONTARCT_VALIDATION")
	private String signContarctValidation;

	/** The Bank information. */
	@Column(name = "BANK_INFORMATION")
	private String bankInformation;

	public Loan(Long idLoan, Long idLoanExtern, Long idAccountExtern, String accountNumberExtern,
			String processInstanceId, Long portfolioId, Integer statut, String productDescription,
			String productCode, Integer productId, Long customerId, String customerName,
			BigDecimal applyAmountTotal, BigDecimal approvelAmount, String currencySymbol,
			Integer currencyDecimalPlaces, Date applyDate, String portfolioCode,
			String portfolioDescription, String owner, String ownerName, Integer statutWorkflow,
			String statutLibelle, Integer etapeWorkflow, String ihmRoot, String note,
			Integer gracePeriod, String industryCode, String industryCodeDescription,
			Date issueDate, Date creationDate, Integer termPeriodNum, Integer paymentFreq,
			BigDecimal issueFeeAmount, BigDecimal productRate, String loanReasonCode,
			String loanReasonDescription, Date initialPaymentDate, Long normalPayment,
			Boolean ignoreOddDays, Integer periodsDeferred, Boolean calculateInitialPaymentDate,
			Long termPeriodID, Integer branchID, String branchName, String branchDescription,
			String category, Date changeDateStatusWorkflow, String customerType, Long parentId,
			String processName, Long communityCULoanID, Integer guarantorSourceId,
			Integer sourceOfFundsID, Integer refinanceReasonId, Integer districtCodeId,
			Integer interestFreq, Integer intPayPeriodNum, Boolean updateLoan,
			Boolean assignCustomer, Integer loanCalculationMode, BigDecimal apr,
			BigDecimal effectiveIntRate, String groupOwnerName, String groupOwner,
			BigDecimal feeAmt1, String loanApplicationStatus, Integer openingBalance,
			Integer periodsDeferredType, Integer installmentNumber, Integer readyForDisb,
			String token, Long reviewFrom, BigDecimal totalInterest, Integer personalContribution,
			Boolean workflowCompleted, Long idIbLoan, String otherInformations,
			BigDecimal maxInstallment, String signContarctValidation, String bankInformation) {

		super();
		this.idLoan = idLoan;
		this.idLoanExtern = idLoanExtern;
		this.idAccountExtern = idAccountExtern;
		this.accountNumberExtern = accountNumberExtern;
		this.processInstanceId = processInstanceId;
		this.portfolioId = portfolioId;
		this.statut = statut;
		this.productDescription = productDescription;
		this.productCode = productCode;
		this.productId = productId;
		this.customerId = customerId;
		this.customerName = customerName;
		this.applyAmountTotal = applyAmountTotal;
		this.approvelAmount = approvelAmount;
		this.currencySymbol = currencySymbol;
		this.currencyDecimalPlaces = currencyDecimalPlaces;
		this.applyDate = applyDate;
		this.portfolioCode = portfolioCode;
		this.portfolioDescription = portfolioDescription;
		this.owner = owner;
		this.ownerName = ownerName;
		this.statutWorkflow = statutWorkflow;
		this.statutLibelle = statutLibelle;
		this.etapeWorkflow = etapeWorkflow;
		this.ihmRoot = ihmRoot;
		this.note = note;
		this.gracePeriod = gracePeriod;
		this.industryCode = industryCode;
		this.industryCodeDescription = industryCodeDescription;
		this.issueDate = issueDate;
		this.creationDate = creationDate;
		this.termPeriodNum = termPeriodNum;
		this.paymentFreq = paymentFreq;
		this.issueFeeAmount = issueFeeAmount;
		this.productRate = productRate;
		this.loanReasonCode = loanReasonCode;
		this.loanReasonDescription = loanReasonDescription;
		this.initialPaymentDate = initialPaymentDate;
		this.normalPayment = normalPayment;
		this.ignoreOddDays = ignoreOddDays;
		this.periodsDeferred = periodsDeferred;
		this.calculateInitialPaymentDate = calculateInitialPaymentDate;
		this.termPeriodID = termPeriodID;
		this.branchID = branchID;
		this.branchName = branchName;
		this.branchDescription = branchDescription;
		this.category = category;
		this.changeDateStatusWorkflow = changeDateStatusWorkflow;
		this.customerType = customerType;
		this.parentId = parentId;
		this.processName = processName;
		this.communityCULoanID = communityCULoanID;
		this.guarantorSourceId = guarantorSourceId;
		this.sourceOfFundsID = sourceOfFundsID;
		this.refinanceReasonId = refinanceReasonId;
		this.districtCodeId = districtCodeId;
		this.interestFreq = interestFreq;
		this.intPayPeriodNum = intPayPeriodNum;
		this.updateLoan = updateLoan;
		this.assignCustomer = assignCustomer;
		this.loanCalculationMode = loanCalculationMode;
		this.apr = apr;
		this.effectiveIntRate = effectiveIntRate;
		this.groupOwnerName = groupOwnerName;
		this.groupOwner = groupOwner;
		this.feeAmt1 = feeAmt1;
		this.loanApplicationStatus = loanApplicationStatus;
		this.openingBalance = openingBalance;
		this.periodsDeferredType = periodsDeferredType;
		this.installmentNumber = installmentNumber;
		this.readyForDisb = readyForDisb;
		this.token = token;
		this.reviewFrom = reviewFrom;
		this.totalInterest = totalInterest;
		this.personalContribution = personalContribution;
		this.workflowCompleted = workflowCompleted;
		this.idIbLoan = idIbLoan;
		this.otherInformations = otherInformations;
		this.maxInstallment = maxInstallment;
		this.signContarctValidation = signContarctValidation;
		this.bankInformation = bankInformation;
	}
	
}
