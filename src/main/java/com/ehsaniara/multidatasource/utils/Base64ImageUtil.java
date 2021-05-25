package com.ehsaniara.multidatasource.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.*;

public class Base64ImageUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(Base64ImageUtil.class);

    /**
     * Decode string to image
     *
     * @param imageString The string to decode
     * @return decoded image
     */
    public static BufferedImage decodeToImage(String imageString) throws IOException {
        BufferedImage image = null;
        byte[] imageByte;
        BASE64Decoder decoder = new BASE64Decoder();
        imageByte = decoder.decodeBuffer(imageString);
        ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
        image = ImageIO.read(bis);
        bis.close();
        return image;
    }

    /**
     * Encode image to string
     *
     * @param imageFile The image to encode
     * @param type      jpeg, bmp, gif, png
     * @return encoded string
     */
    public static String encodeToString(File imageFile, String type) throws IOException {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        BufferedImage image = ImageIO.read(imageFile);
        ImageIO.write(image, type, bos);
        byte[] imageBytes = bos.toByteArray();

        BASE64Encoder encoder = new BASE64Encoder();
        imageString = encoder.encode(imageBytes);

        bos.close();
        return imageString;
    }

    /**
     * To make base64 string decoded properly, We need to remove the base64 header from a base64 string.
     *
     * @param base64 The Base64 string of an image.
     * @return Base64 string without header.
     */
    public static String removeBase64Header(String base64) {
        if (base64 == null) return null;
        return base64.trim().replaceFirst("data[:]image[/]([a-z])+;base64,", "");
    }

    /**
     * Get the image type.
     *
     * @param base64 The base64 string of an image.
     * @return jpg, png, gif
     */
    public static String getImageType(String base64) {
        String[] header = base64.split("[;]");
        if (header == null || header.length == 0) return null;
        return header[0].split("[/]")[1];
    }

    public static String writeBase64StringPhotoToFile(String base64String, String destinyPath, String fileName) throws IOException {

        // convert base64 string to image
        String imageType = getImageType(base64String);
        File imageFile = new File(destinyPath + "/" + fileName + "." + imageType);


//        String base64Image = imageString.split(",")[1];
        String imageString = removeBase64Header(base64String);
        byte[] imageBytes = DatatypeConverter.parseBase64Binary(imageString);
        try {
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(imageFile));
            outputStream.write(imageBytes);
            LOGGER.info("New file photo saved: " + imageFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageFile.getAbsolutePath();

    }

}