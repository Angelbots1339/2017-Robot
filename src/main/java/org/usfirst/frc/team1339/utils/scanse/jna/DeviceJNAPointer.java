package org.usfirst.frc.team1339.utils.scanse.jna;

import java.util.Arrays;
import java.util.List;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class DeviceJNAPointer extends Structure {

    public Pointer device;

    @Override
    protected List<String> getFieldOrder() {
        return Arrays.asList("device");
    }

}
