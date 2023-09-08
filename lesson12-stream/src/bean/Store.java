package bean;

import java.math.BigDecimal;
import java.util.Objects;

public class Store {
	// store id
	private Long storeId;
	
	// store liên quan, trao đổi hàng hóa khi hết hàng
	private Long referenceStoreId;
	
	// doanh thu ngày trước đó
	private BigDecimal stockPreviousDay;
	
	// doanh thu ước tính bán đc ngày hôm nay
	private BigDecimal expectedSales;
	
	// được chọn để cấp phát hàng hóa từ kho
	private Boolean isSelected;
	
	public Store() {
	}

	public Store(final Long storeId, final Long referenceStoreId, final BigDecimal stockPreviousDay, 
			final BigDecimal expectedSales, final Boolean isSelected) {
		this.storeId = storeId;
		this.referenceStoreId = referenceStoreId;
		this.stockPreviousDay = stockPreviousDay;
		this.expectedSales = expectedSales;
		this.isSelected = isSelected;
	}

	public Long getStoreId() {
		return storeId;
	}

	public Long getReferenceStoreId() {
		return referenceStoreId;
	}

	public BigDecimal getStockPreviousDay() {
		return stockPreviousDay;
	}
	
	public BigDecimal getNonNullStockPreviousDay() {
		return stockPreviousDay == null ? BigDecimal.ZERO : stockPreviousDay;
	}

	public BigDecimal getExpectedSales() {
		return expectedSales;
	}

	public BigDecimal getNonNullExpectedSales() {
		return expectedSales == null ? BigDecimal.ZERO : expectedSales;
	}
	
	public Boolean getIsSelected() {
		return isSelected;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		
		if (!(obj instanceof Store)) {
			return false;
		}
		
		Store that = (Store) obj;
		
		return this.getStoreId().equals(that.getStoreId());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(storeId);
	}
	
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", referenceStoreId=" + referenceStoreId + ", stockPreviousDay="
				+ stockPreviousDay + ", expectedSales=" + expectedSales + ", isSelected=" + isSelected + "]";
	}
	
	
}
