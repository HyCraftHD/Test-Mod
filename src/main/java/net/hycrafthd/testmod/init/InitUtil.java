package net.hycrafthd.testmod.init;

import net.hycrafthd.testmod.TestConstants;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class InitUtil {

    public static <T extends IForgeRegistryEntry> Set<T> getRegistryEntries(Class<T> clazz, Class<?> init) {
        Set<T> set = new HashSet<>();
        try {
            for (Field field : init.getDeclaredFields()) {
                if (clazz.isAssignableFrom(field.getType())) {
                    set.add((T)field.get(null));
                }
            }
        } catch(Exception ex) {
            TestConstants.LOGGER.error(ex);
        }
        return set;
    }

}
