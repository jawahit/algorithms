/**
 * 
 */
package com.problems.algorithms.week2.sorting;

/**
 * @author Thangaraj Jawahar
 *
 */
public class AirTicket implements Comparable<AirTicket>{
	
	private double price;
	private int duration;
	private String flightName;
	
	
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}



	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}



	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}



	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

    
	
	/**
	 * @return the flightName
	 */
	public String getFlightName() {
		return flightName;
	}



	/**
	 * @param flightName the flightName to set
	 */
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duration;
		result = prime * result + ((flightName == null) ? 0 : flightName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirTicket other = (AirTicket) obj;
		if (duration != other.duration)
			return false;
		if (flightName == null) {
			if (other.flightName != null)
				return false;
		} else if (!flightName.equals(other.flightName))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		return true;
	}


	@Override
	public int compareTo(AirTicket o) {
		if (getClass() != o.getClass())
			throw new IllegalArgumentException("differnt Type can't be compared");
		if(this.price < o.price) return -1;
		if(this.price > o.price) return 1;
		int i = this.flightName.compareTo(o.flightName);
		if(i < 0) return -1;
		if(i > 0) return 1;
		return 0;
	}
	
	

}
