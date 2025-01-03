package med.lib;

public class MedicalAccessory extends Item {
	private String modelNo;
	private boolean hasDiscount;

	public MedicalAccessory(String name, String manufacturer, String modelNo, double unitPrice, int quantity) {
		super(name, manufacturer, unitPrice, quantity);
		this.hasDiscount = false;
		this.modelNo = modelNo;
		super.addPrefixCodeToId("MA");
	}

	public String getModelNo() {
		return modelNo;
	}

	public boolean getHasDiscount() {
		return hasDiscount;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public void setHasDiscount(boolean hasDiscount) {
		this.hasDiscount = hasDiscount;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t" + hasDiscount + "\t" + modelNo;
	}

	public double getBill() {
		if (getHasDiscount()) {
			return super.getBill() * 0.9;
		} else {
			return super.getBill();
		}
	}
}
