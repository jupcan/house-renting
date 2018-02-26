/**
 * Represents the Other type (not chalets) of the App
 * @author Francisco López Navarro & Juan Perea Campos
 *
 */
public class Other extends House {
		
		private boolean furnished;
		private String specific_type;
		
		public Other(int House_ID, int size, int age, int price, String status, String type, boolean furnished, String specific_type) {
			super(House_ID, size, age, price, status, type);
			this.furnished = furnished;
			this.specific_type = specific_type;
		}

		/**
		 * @return the furnished
		 */
		public boolean isFurnished() {
			return furnished;
		}

		/**
		 * @param furnished the furnished to set
		 */
		public void setFurnished(boolean furnished) {
			this.furnished = furnished;
		}

		/**
		 * @return the other_type
		 */
		public String getSpecific_type() {
			return specific_type;
		}

		/**
		 * @param other_type the other_type to set
		 */
		public void setSpecific_type(String specific_type) {
			this.specific_type = specific_type;
		}
	}
