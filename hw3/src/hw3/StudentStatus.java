/**
 * 
 */
package hw3;


public enum StudentStatus {

	INSTATE{
		public float getTuition(){
			return 3500;
		}
	}, OUTSTATE{
		public float getTuition(){
			return 4000;
		}
	},INTERNATIONAL{
		public float getTuition(){
			return 4500;
		}
	};
	public float getTuition(){
		return 0;
	}
}
