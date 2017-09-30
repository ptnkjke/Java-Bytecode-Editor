package net.ptnkjke.jbeditor.logic.asm.bytecode;

import org.objectweb.asm.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dalopatin on 13.11.2014.
 */
public class BCClassVisitor extends org.objectweb.asm.ClassVisitor {

    public List<BCMethodVisitor> methods = new ArrayList<BCMethodVisitor>();


    public BCClassVisitor() {
        super(Opcodes.ASM5);
    }


    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        BCMethodVisitor mv = new BCMethodVisitor();
        methods.add(mv);
        return mv;
    }

}
