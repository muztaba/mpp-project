package com.mpp.serializer;

import java.io.*;

abstract class Serializer implements ISerializer {

    @Override
    public void serialize(Object obj) {
        try {
            FileOutputStream fOut = new FileOutputStream(getFileName());
            ObjectOutputStream oos = new ObjectOutputStream(fOut);
            oos.writeObject(obj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object deserialize() {
        ObjectInputStream objectinputstream = null;
        try {
            FileInputStream streamIn = new FileInputStream(getFileName());
            objectinputstream = new ObjectInputStream(streamIn);
            return objectinputstream.readObject();
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println(getFileName() + " file not found.. returning null");
        } finally {
            if(objectinputstream != null){
                try {
                    objectinputstream .close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    abstract String getFileName();

}
