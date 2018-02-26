/**
 * Represents the Requests of the App
 * @author Francisco López Navarro & Juan Perea Campos
 *
 */
public class Request {

	private String request;
	private int rent_time;
	private House house;
	private Client client;
	
	public Request(String request, int rent_time, House house, Client client) {
		this.request = request;
		this.rent_time = rent_time;
		this.house = house;
		this.client = client;
	}

	/**
	 * @return the request
	 */
	public String getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(String request) {
		this.request = request;
	}

	/**
	 * @return the rent_time
	 */
	public int getRent_time() {
		return rent_time;
	}

	/**
	 * @param rent_time the rent_time to set
	 */
	public void setRent_time(int rent_time) {
		this.rent_time = rent_time;
	}

	/**
	 * @return the house
	 */
	public House getHouse() {
		return house;
	}

	/**
	 * @param house the house to set
	 */
	public void setHouse(House house) {
		this.house = house;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[request=" + request + ", rent_time=" + rent_time+ "]";
	}
}