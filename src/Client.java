/**
 * Represents the Clients of the App
 * @author Francisco López Navarro & Juan Perea Campos
 *
 */
public class Client {
	
	private String name, dni;
	private int young_card_number;
	private long credit_card;
	private boolean young_card, usual;
	
	public Client(String dni, String name, long credit_card, boolean young_card, int young_card_number) {
		this.dni = dni;
		this.name = name;
		this.credit_card = credit_card;
		this.young_card = young_card;
		this.young_card_number = young_card_number;
	}

	/**
	 * @return the dNI
	 */
	public String getDNI() {
		return dni;
	}

	/**
	 * @param dNI the dNI to set
	 */
	public void setDNI(String dni) {
		this.dni = dni;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the credit_card
	 */
	public long getCredit_card() {
		return credit_card;
	}

	/**
	 * @param credit_card the credit_card to set
	 */
	public void setCredit_card(int credit_card) {
		this.credit_card = credit_card;
	}

	/**
	 * @return the young_card
	 */
	public boolean getYoung_card() {
		return young_card;
	}

	/**
	 * @param young_card the young_card to set
	 */
	public void setYoung_card(boolean young_card) {
		this.young_card = young_card;
	}
	
	/**
	 * @return the young_card_number
	 */
	public int getYoung_card_number() {
		return young_card_number;
	}

	/**
	 * @param young_card_number the young_card_number to set
	 */
	public void setYoung_card_number(int young_card_number) {
		this.young_card_number = young_card_number;
	}
	
	/**
	 * @return the usual
	 */
	public boolean getUsual() {
		return usual;
	}

	/**
	 * @param usual the usual to set
	 */
	public void setUsual(boolean usual) {
		this.usual = usual;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[DNI=" + dni + ", name=" + name + ", credit_card="
				+ credit_card + ", young_card_number=" + young_card_number
				+ ", young_card=" + young_card + ", usual=" + usual + "]";
	}
}