package ImageSorter;

import java.util.ArrayList;
import java.util.Comparator;



public class ImageSorter {
	private ArrayList<Image> images;
	
	private Comparator<Image> redComparator = Comparator.comparing(img -> img.getAvgRed());
	private Comparator<Image> blueComparator = Comparator.comparingLong(img -> img.getAvgBlue());
	private Comparator<Image> greenComparator = Comparator.comparingLong(img -> img.getAvgGreen());
	private Comparator<Image> brightnessComparator = Comparator.comparingLong(img -> img.getAvgBright());
	/*for desktop version
	private Comparator<Image> lstModComparator = Comparator.comparing(img -> img.lastModified());
	 */
	private Comparator<Image> sizeComparator = Comparator.comparingInt(img -> img.getSize());
	
	public ImageSorter(){}
	public ImageSorter(ArrayList<Image> images) {
		this.images = images;
	}

	public void setImages(ArrayList<Image> images){
		this.images = images;
	}

	public ArrayList<Image> sortBySize(){
		images.sort(sizeComparator);
		return images;
	}
	
	public ArrayList<Image> sortByRed(){
		images.sort(redComparator);
		return images;
	}
	
	public ArrayList<Image> sortByGreen(){
		images.sort(greenComparator);
		return images;
	}
	
	public ArrayList<Image> sortByBlue(){
		images.sort(blueComparator);
		return images;
	}
	
	public ArrayList<Image> sortByBrightness(){
		images.sort(brightnessComparator);
		return images;
	}
	/*
	public ArrayList<Image> sortByLastChng(){
		images.sort(lstModComparator);
		return images;
	}
	*/
}
