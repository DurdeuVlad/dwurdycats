package com.dwurdy.dwurdycats.compat.neoforge;

import com.dwurdy.dwurdycats.compat.AdditionalPlacementsCompat;
import com.firemerald.additionalplacements.generation.Registration;

public class AdditionalPlacementsCompatNeoForge {
    public static void register() {
        Registration.addRegistration(new AdditionalPlacementsCompat());
    }
}
