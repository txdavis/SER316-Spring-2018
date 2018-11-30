package main.java.memoranda.ui.htmleditor.filechooser;

import java.io.File;

import javax.swing.filechooser.FileFilter;
//TASK 2-1 SMELL WITHIN A CLASS’
public class ImageFilter extends FileFilter {
    public final static String jpeg = "jpeg";
    public final static String jpg = "jpg";
    public final static String gif = "gif";
    public final static String png = "png";
    // Accept all directories and all gif, jpg, or tiff files.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = getExtension(f);
	if (extension != null) {
            if (extension.equals(png) ||
                extension.equals(gif) ||
                extension.equals(jpeg) ||
                extension.equals(jpg)) {
                    return true;
            } else {
                return false;
            }
    	}

        return false;
    }
  //TASK 2-2 SMELL WITHIN A CLASS’
    // The description of this filter
    public String getDescription() {
        return "Images (GIF, JPEG, PNG)";
    }
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}
