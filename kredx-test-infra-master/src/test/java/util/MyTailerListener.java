package util;

import org.apache.commons.io.input.TailerListenerAdapter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * Created by chandanjavaregowda on 02/07/17.
 */
public class MyTailerListener extends TailerListenerAdapter {
    public void handle(String line) {
        try {
            PrintWriter writer = new PrintWriter("server-log.txt", "UTF-8");
            writer.println(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}