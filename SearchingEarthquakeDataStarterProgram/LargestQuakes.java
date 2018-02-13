
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class LargestQuakes {
    public int indexOfLargest(ArrayList<QuakeEntry> data) {
        int minIndex = 0;
        int k = 0;
        for (QuakeEntry qe : data) {
            if (qe.getMagnitude() > 
                data.get(minIndex).getMagnitude()) {
                minIndex = k;
            }
            k++;
        }
        return minIndex;
    }
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        if (quakeData.size() <= howMany) {
            return copy;
        }
        for (int i=0; i < howMany; i++) {
            int high = indexOfLargest(copy);
            ret.add(copy.get(high));
            copy.remove(high);
        }
        return ret;
    }
    public void findLargestQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println(list.size()+ " Quakes");
        //System.out.println("Largest quake : "+list.get(indexOfLargest(list)));
        System.out.println(getLargest(list, 50));
    }
}
