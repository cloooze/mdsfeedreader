package com.ericsson.mdsfeedreader;

public class MDSRecord {

	public final static String DELIMITER = "~";
	public final static String UPDATE_DELIMITER = ",";

	// data coming from MDS
	private String itemId = "";
	private String vuBrand = "";
	private String vuEqp = "";
	private String awPremium = "";
	private String msrp = "";
	private String productSet = "";

	// data coming from MDS, only useful for operations
	private String vuEffDate = "";
	private String updateColumns = "";
	private String sysNcType = "";

	// data coming from EAI EquipmentAvailablility
	private String orderSubTypeCode = "";
	private boolean availableForSaleInd = false;
	private boolean preOrderInd = false;

	// missing data
	private String backOrder = "";
	private transient String replenishStartDate = "";
	private transient String replenishEndDate = "";
	private transient String launchDate = "";

	// data from mapping file stays the same
	private String marketingName = "";
	private String plvSku = "";

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		if (itemId != null) {
			this.itemId = itemId;
		}
	}

	public String getVuBrand() {
		return vuBrand;
	}

	public void setVuBrand(String vuBrand) {
		if (vuBrand != null) {
			this.vuBrand = vuBrand;
		}
	}

	public String getVuEffDate() {
		return vuEffDate;
	}

	public void setVuEffDate(String vuEffDate) {
		if (vuEffDate != null) {
			this.vuEffDate = vuEffDate;
		}
	}

	public String getVuEqp() {
		return vuEqp;
	}

	public void setVuEqp(String vuEqp) {
		if (vuEqp != null) {
			this.vuEqp = vuEqp;
		}
	}

	public String getMsrp() {
		return msrp;
	}

	public void setMsrp(String msrp) {
		if (msrp != null) {
			this.msrp = msrp;
		}
	}

	public String getProductSet() {
		return productSet;
	}

	public void setProductSet(String productSet) {
		this.productSet = productSet;
	}

	public String getUpdateColumns() {
		return updateColumns;
	}

	public void setUpdateColumns(String updateColumns) {
		if (updateColumns != null) {
			this.updateColumns = updateColumns;
		}
	}

	public String getSysNcType() {
		return sysNcType;
	}

	public void setSysNcType(String sysNcType) {
		if (sysNcType != null) {
			this.sysNcType = sysNcType;
		}
	}

	public String getOrderSubTypeCode() {
		return orderSubTypeCode;
	}

	public void setOrderSubTypeCode(String orderSubTypeCode) {
		if (orderSubTypeCode != null) {
			this.orderSubTypeCode = orderSubTypeCode;
		}
	}

	public String getReplenishStartDate() {
		return replenishStartDate;
	}

	public void setReplenishStartDate(String replenishStartDate) {
		if (replenishStartDate != null) {
			this.replenishStartDate = replenishStartDate;
		}
	}

	public String getReplenishEndDate() {
		return replenishEndDate;
	}

	public void setReplenishEndDate(String replenishEndDate) {
		if (replenishEndDate != null) {
			this.replenishEndDate = replenishEndDate;
		}
	}

	public String getLaunchDate() {
		return launchDate;
	}

	public void setLaunchDate(String launchDate) {
		if (launchDate != null) {
			this.launchDate = launchDate;
		}
	}

	public String getMarketingName() {
		return marketingName;
	}

	public void setMarketingName(String marketingName) {
		if (marketingName != null) {
			this.marketingName = marketingName;
		}
	}

	public String getAwPremium() {
		return awPremium;
	}

	public void setAwPremium(String awPremium) {
		if (awPremium != null) {
			this.awPremium = awPremium;
		}
	}

	public boolean isAvailableForSaleInd() {
		return availableForSaleInd;
	}

	public void setAvailableForSaleInd(boolean availableForSaleInd) {
		this.availableForSaleInd = availableForSaleInd;
	}

	public boolean getPreOrderInd() {
		return preOrderInd;
	}

	public void setPreOrderInd(boolean preOrderInd) {
		this.preOrderInd = preOrderInd;
	}

	public String getBackOrder() {
		return backOrder;
	}

	public void setBackOrder(String backOrder) {
		if (backOrder != null) {
			this.backOrder = backOrder;
		}
	}

	public String getPlvSku() {
		return plvSku;
	}

	public void setPlvSku(String plvSku) {
		if (plvSku != null) {
			this.plvSku = plvSku;
		}
	}

	@Override
	public String toString() {
		return "MDSRecord [itemId=" + itemId + ", vuBrand=" + vuBrand + ", vuEqp=" + vuEqp + ", awPremium=" + awPremium + ", msrp=" + msrp + ", productSet=" + productSet
				+ ", vuEffDate=" + vuEffDate + ", updateColumns=" + updateColumns + ", sysNcType=" + sysNcType + ", orderSubTypeCode=" + orderSubTypeCode
				+ ", availableForSaleInd=" + availableForSaleInd + ", preOrderInd=" + preOrderInd + ", backOrder=" + backOrder + ", replenishStartDate=" + replenishStartDate
				+ ", replenishEndDate=" + replenishEndDate + ", launchDate=" + launchDate + ", marketingName=" + marketingName + ", plvSku=" + plvSku + "]";
	}

}
