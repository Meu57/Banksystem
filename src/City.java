/**

 City class represents a city that has a name and belongs to a region.
 */
public class City {
    String cityName;
    String regionName;

    /**

     Creates a new City object with the given city name and region name.
     @param cityName the name of the city
     @param regionName the name of the region that the city belongs to
     */
    public City(String cityName, String regionName) {
        this.cityName = cityName;
        this.regionName = regionName;
    }
    /**

     Returns the string representation of this city in the format "cityName - regionName".
     @return the string representation of this city
     */
    @Override
    public String toString() {
        return cityName + " - " + regionName;
    }
}