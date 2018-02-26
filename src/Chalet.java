/**
 * Represents the Chalets of the App
 * @author Francisco López Navarro & Juan Perea Campos
 *
 */
public class Chalet extends House {
		
		private boolean swimming_pool;
		private double distance;
		
		public Chalet(int House_ID, int size, int age, int price, String status, String type, boolean swimming_pool, double distance) {
		super(House_ID, size, age, price, status, type);
			this.swimming_pool = swimming_pool;
			this.distance = distance;
		}

		/**
		 * @return the swimming_pool
		 */
		public boolean getSwimming_pool() {
			return swimming_pool;
		}

		/**
		 * @param swimming_pool the swimming_pool to set
		 */
		public void setSwimming_pool(boolean swimming_pool) {
			this.swimming_pool = swimming_pool;
		}

		/**
		 * @return the distance
		 */
		public double getDistance() {
			return distance;
		}

		/**
		 * @param distance the distance to set
		 */
		public void setDistance(double distance) {
			this.distance = distance;
		}
	}
