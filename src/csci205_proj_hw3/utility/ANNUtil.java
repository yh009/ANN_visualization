/* *****************************************
 *
 * CSCI205 - Software Engineering and Design
 *
 * Spring 2017
 *
 *
 *
 * Name: Zilin Ma, Yuxuan Huang
 *
 * Date: Apr 1, 2017
 *
 * Time: 4:57:13 PM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3.utility
 *
 * File: ANNUtil
 *
 * Description:
 *
 *
 *
 * ****************************************
 * /
 *
 *
 *
 * @author Zilin Ma
 */
package csci205_proj_hw3.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import neuralnet.ANN;

public class ANNUtil {

    /**
     * Deserializes a file. fileName is the name of the .ser file. Returns the
     * ANN object that is deserialized.
     *
     * @param fileName
     * @return the deserialized ANN
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     * @see
     * <a href="https://www.tutorialspoint.com/java/java_serialization.html">https://www.tutorialspoint.com/java/java_serialization.html</a>
     *
     */
    public static ANN deserializeANN(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        ANN myANN = null;
        FileInputStream fileIn;
        fileIn = new FileInputStream(fileName);
        try (final ObjectInputStream in = new ObjectInputStream(fileIn)) {
            myANN = (ANN) in.readObject();
        }
        fileIn.close();
        return myANN;
    }

    /**
     * Serializes the ANN object to a file. myANN is the object being
     * serialized, and fileName is the .ser filename.
     *
     * @param myANN
     * @param dirName the directory of name.
     * @throws java.io.FileNotFoundException
     * @see
     * <a href="https://www.tutorialspoint.com/java/java_serialization.htm">https://www.tutorialspoint.com/java/java_serialization.htm</a>
     */
    public static void serializeANN(ANN myANN, String dirName) throws FileNotFoundException, IOException {
        //try {
        dirName += ".ser";
        FileOutputStream fileOut = new FileOutputStream(dirName);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(myANN);
        out.close();
        fileOut.close();
        System.out.printf("Serialized data is saved in " + dirName + "\n");
        //} catch (IOException i) {
        //}
    }

}
