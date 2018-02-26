/**
 * Represents the Houses of the App
 * @author Francisco López Navarro & Juan Perea Campos
 *
 */
public class House {

	protected int house_ID, size, age, price;
	protected String type, status, specific_type;
	boolean characteristics;
	
	public House(int house_ID, int size, int age, int price, String status, String type) {
		this.house_ID = house_ID;
		this.size = size;
		this.age = age;
		this.price = price;
		this.status = status;
		this.type = type;
	}
	
	/**
	 * @return the rent_price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * @param rent_price the rent_price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * @return the rent
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param rent the rent to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the house_ID
	 */
	public int getHouse_ID() {
		return house_ID;
	}

	/**
	 * getter
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @return the specific_type
	 */
	public String getSpecific_type() {
		return specific_type;
	}

	/**
	 * @param specific_type the specific_type to set
	 */
	public void setSpecific_type(String specific_type) {
		this.specific_type = specific_type;
	}

	/**
	 * @return the characteristics
	 */
	public boolean isCharacteristics() {
		return characteristics;
	}

	/**
	 * @param characteristics the characteristics to set
	 */
	public void setCharacteristics(boolean characteristics) {
		this.characteristics = characteristics;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[House_ID=" + house_ID + ", size=" + size + ", age="
				+ age + ", price=" + price + ", type=" + type + ", status="
				+ status + "]";
	}
}