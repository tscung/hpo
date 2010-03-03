package sg.com.stellarstudios.imser.common;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class Resizer extends Panel {
	public static int HEIGHT=1;
	public static int WIDTH=2;
	
	private static Resizer me;
	public static Resizer getInstance() {
		if (me == null)
			me = new Resizer();
		
		return me;
	}

	public byte[] resize(byte[]originalImage,int maxWidth,int maxHeight) {
		//calls twice. 1st time check for width, 2nd time check for height
		byte[] firstResize = internalResize(originalImage, maxWidth, maxHeight);
		byte[] secondResize = internalResize(firstResize, maxWidth, maxHeight);
		
		return secondResize;
	}
	private byte[] internalResize(byte[]originalImage,int maxWidth,int maxHeight) {
		//get the original image
		Image img=getToolkit().createImage(originalImage);
        loadImage(img);
        int iw=img.getWidth(this);
        int ih=img.getHeight(this);
       
        int orientation = 0;
        //resize only if either width or height exceeds max.
        if (iw > maxWidth) orientation = WIDTH;
        if (ih > maxHeight) orientation = HEIGHT;
        
        if (orientation == 0) return originalImage;
        
		//determine factor based on orientation
		double factor=0;
		if (orientation==HEIGHT) factor=maxHeight/(new Double(ih));
		if (orientation==WIDTH) factor=maxWidth/(new Double(iw));
		
		//disable enlarge
		if (factor>1) factor=1;
		
		//System.out.println("Image resize factor: "+factor);

		int iw2=new Double(iw*factor).intValue();
		int ih2=new Double(ih*factor).intValue();
		
		//System.out.println("Resized from: "+iw+"x"+ih+" to "+iw2+"x"+ih2+".");

        //reduce the image
        Image i2=img.getScaledInstance(iw2,ih2,Image.SCALE_SMOOTH);
        loadImage(i2);
            
        //load it into a BufferedImage
        BufferedImage bi=new BufferedImage(iw2,ih2,BufferedImage.TYPE_INT_RGB);
        Graphics2D big=bi.createGraphics();
        big.drawImage(i2,0,0,this);

        //use JPEGImageEncoder to write the BufferedImage to a file
        //set buffer to 10MB
        byte[] ret = null;
        ByteArrayOutputStream baos = null;
        try{
        	baos = new ByteArrayOutputStream(1024*10);
			BufferedOutputStream os = new BufferedOutputStream(baos);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
			encoder.encode(bi);
			os.close();
        }
        catch(IOException io){ io.printStackTrace(); }
        finally {
        	ret = baos.toByteArray();
        }
        
        return ret;
    }
    
	private void loadImage(Image img){
		try {
			MediaTracker tracker=new MediaTracker(this);
			tracker.addImage(img,0);
			tracker.waitForID(0);
		} 
		catch (Exception e) { e.printStackTrace(); }
    }
	
	public static void main(String[]args) {
//		01 130 195 1400 1000
		processFolder(new File(args[0]), args[1], Integer.valueOf(args[2]), Integer.valueOf(args[3]), Integer.valueOf(args[4]), Integer.valueOf(args[5]));
//		String baseFolder = "D:\\my files\\sayjon's\\stellar\\projects\\0709 - TEP Productions\\orange09\\3rd Day Photos";
//		File folder = new File(baseFolder);
//		processFolder(folder);
		
		
	}
	
	private static Integer counter = 0;
	
	public static void processFolder(File folder, String album, Integer tmw, Integer tmh, Integer rmw, Integer rmh) {
		System.out.println("Processing folder: " + folder.getName());
//		String baseFolder = "C:\\orange_photos";
		String resizefolder = folder.getAbsolutePath() + "\\r";
		String thumbfolder = folder.getAbsolutePath() + "\\t";
		
//		String album = "05";
//		Integer tmw = new Integer(150);
//		Integer tmh = new Integer(150);
//		Integer rmw = new Integer(1024);
//		Integer rmh = new Integer(768);		
		
		File[]files = folder.listFiles();
		List<File> filesToSort = Arrays.asList(files);
		Collections.sort(filesToSort, new Comparator<File>() {
			public int compare(File file1, File file2) {
				//for same types only
				if ((!file1.isDirectory() && !file2.isDirectory()) || (file1.isDirectory() && file2.isDirectory())) {
					Integer i1 = null, i2 = null;
					boolean castable = true;
					try {
						i1 = new Integer(file1.getName());
						i2 = new Integer(file2.getName());
					}
					catch (NumberFormatException e) {
						castable = false;
					}
					if (castable) return i1.compareTo(i2);
					else return file1.getName().compareTo(file2.getName());
				}
				else {
					if (file1.isDirectory() && !file2.isDirectory()) return -1;
					else return 1;
				}
			}
		});
		for (int i = 0; i < filesToSort.size(); i++) {
			File image = filesToSort.get(i);
			//is it really image?
			if (!image.isDirectory() && (image.getName().endsWith(".JPG") || image.getName().endsWith(".jpg"))) {
				try {
					counter++;
					
					FileInputStream fis = new FileInputStream(image);
					byte[]buffer = new byte[fis.available()];
					fis.read(buffer);

					byte[] thumb = Resizer.getInstance().resize(buffer, tmw, tmh);
					File thumbfile = new File(thumbfolder+"\\a" + album + "p" + Utility.getInstance().buildDigitNumber(counter, 3) + ".jpg");
					thumbfile.createNewFile();
					FileOutputStream fos = new FileOutputStream(thumbfile);
					fos.write(thumb);
					

					byte[] resized = Resizer.getInstance().resize(buffer, rmw, rmh);
					File resizefile = new File(resizefolder+"\\a" + album + "p" + Utility.getInstance().buildDigitNumber(counter, 3) + ".jpg");
					resizefile.createNewFile();
					FileOutputStream fos2 = new FileOutputStream(resizefile);
					fos2.write(resized);
					
					fis.close();
					fos.close();
					fos2.close();
					
					System.out.println("done: "+image.getName());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			else {
				if (!image.getName().equals("r") && !image.getName().equals("t")) processFolder(folder, album, tmw, tmh, rmw, rmh);
			}
		}
	}
}