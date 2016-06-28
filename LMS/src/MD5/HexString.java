/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MD5;

/**
 *
 * @author ELC-17
 */
public class HexString {

    private static final char K_HEX_CHARS[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String charArrayToHex(byte buffer[]) {
        return HexString.charArrayToHex(buffer, 0, buffer.length);
    }

    public static String charArrayToHex(byte buffer[], int startOffset, int length) {
        StringBuffer hexString = new StringBuffer(2 * length);
        int endOffset = startOffset + length;
        for (int i = startOffset; i < endOffset; i++) {
            HexString.appendHexPair(buffer[i], hexString);
        }
        return hexString.toString();
    }

    private static void appendHexPair(byte b, StringBuffer hexString) {
        char highNibble = K_HEX_CHARS[(b & 0xF0) >> 4];
        char lowNibble = K_HEX_CHARS[b & 0x0F];
        hexString.append(highNibble);
        hexString.append(lowNibble);
    }
}
