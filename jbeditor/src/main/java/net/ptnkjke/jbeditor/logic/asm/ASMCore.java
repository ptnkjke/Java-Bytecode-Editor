package net.ptnkjke.jbeditor.logic.asm;

import net.ptnkjke.jbeditor.logic.asm.bytecode.BCMethodVisitor;
import net.ptnkjke.jbeditor.logic.Core;
import net.ptnkjke.jbeditor.logic.asm.bytecode.BCClassVisitor;
import org.objectweb.asm.ClassReader;

import java.util.List;

/**
 * Утилитарный класс для ASM
 */
public class ASMCore {
    /**
     * Получить байт-код определённого метода
     *
     * @return
     */
    public static String getMethodsCode(String classFile, int indexMethod) {
        byte[] classBytes = Core.INSTANCE.getClassMap().get(classFile);

        ClassReader classReader = new ClassReader(classBytes);
        BCClassVisitor visitor = new BCClassVisitor();
        classReader.accept(visitor, 0);

        BCMethodVisitor method = visitor.methods.get(indexMethod);
        List<Object> codes = method.getTextCode();

        StringBuilder sb = new StringBuilder();
        for (Object o : codes) {
            sb.append(o.toString());
        }
        return sb.toString();
    }
}
