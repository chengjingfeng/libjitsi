/*
 * Jitsi, the OpenSource Java VoIP and Instant Messaging client.
 *
 * Distributable under LGPL license.
 * See terms of license at gnu.org.
 */
package org.jitsi.impl.neomedia.wincoreaudio;

import org.jitsi.util.*;

/**
 * JNI link to the Windows CoreAudio library.
 *
 * @author Vincent Lucqs
 */
public class CoreAudioDevice
{
    static
    {
        System.loadLibrary("jnwincoreaudio");
    }

//    public static native AudioDeviceID getDevice(
//            String deviceUID);

    public static String getDeviceName(
            String deviceUID)
    {
        byte[] deviceNameBytes = getDeviceNameBytes(deviceUID);
        String deviceName = StringUtils.newString(deviceNameBytes);

        return deviceName;
    }

    public static native int initDevices();

    public static native void freeDevices();

    public static native byte[] getDeviceNameBytes(
            String deviceUID);

    public static native int setInputDeviceVolume(
            String deviceUID,
            float volume);

    public static native int setOutputDeviceVolume(
            String deviceUID,
            float volume);

    public static native float getInputDeviceVolume(
            String deviceUID);

    public static native float getOutputDeviceVolume(
            String deviceUID);
}