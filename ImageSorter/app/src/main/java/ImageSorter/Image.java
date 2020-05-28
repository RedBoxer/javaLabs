package ImageSorter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import java.util.ArrayList;


public class Image {

	private String name;
	private Bitmap source;
	private BitmapDrawable picture;
	private int height;
	private int width;
	private int size;
	private long timeOfLastChng;
	private long avgRed = 0;
	private long avgGreen = 0;
	private long avgBlue = 0;
	private long avgBright = 0;
	
	public Image(Bitmap source){
		if(setSource(source)){
			//System.out.println("Image loaded");
		} else {
			//System.out.println("Image loading failed. Check file name");
		}
	}
	
	boolean setSource(Bitmap source) {
		try {
			this.source = source;
			height = source.getHeight();
			width = source.getWidth();
			size = height * width;
			for(int h = 0; h < height; h++) {
				for(int w = 0; w < width; w++) {
					avgRed += this.getRed(w, h);
					avgBlue += this.getBlue(w, h);
					avgGreen += this.getGreen(w, h);
				}
			}
			avgRed /= size ;
			avgGreen /= size;
			avgBlue /= size;
			avgBright = (avgRed + avgBlue + avgGreen) / 3;;
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	int getSize() {return size;}
	int getWidth() {return width;}
	int getHeight() {return height;}
	long lastModified() {return timeOfLastChng;}
	long getAvgRed() {return avgRed;}
	long getAvgGreen() {return avgGreen;}
	long getAvgBlue() {return avgBlue;}
	long getAvgBright() {return avgBright;}
	public String getName() {return this.name;}
	public Bitmap getSource(){return this.source;};
	
	int getRed(int x, int y) {
		int point = source.getPixel(x, y);
		return Color.red(point);
	}
	
	int getBlue(int x, int y) {
		int point = source.getPixel(x, y);
		return Color.blue(point);
	}
	
	int getGreen(int x, int y) {
		int point = source.getPixel(x, y);
		return Color.green(point);
	}
	
	ArrayList<Integer> getRGB (int x, int y) {
		ArrayList<Integer> rgb = new ArrayList<>();
		rgb.add(getRed(x, y));
		rgb.add(getGreen(x, y));
		rgb.add(getBlue(x, y));
		return rgb;
	}
	
	
}
