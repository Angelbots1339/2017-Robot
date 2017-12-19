package org.usfirst.frc.team1339.utils.scanse;

import org.usfirst.frc.team1339.utils.scanse.jna.SweepJNA;

public class Sweep {

    public static final int VERSION = SweepJNA.sweep_get_version();
    public static final boolean ABI_COMPATIBLE =
            SweepJNA.sweep_is_abi_compatible();

}
