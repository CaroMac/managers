/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2019.
 */
package dev.galasa.zos3270.internal.datastream;

public class CommandReadModified extends AbstractCommandCode {

    public byte[] getBytes() {
        return new byte[] { READ_MODIFIED };
    }

}
