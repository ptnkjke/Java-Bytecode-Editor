package net.ptnkjke.logic.bcel;

import net.ptnkjke.logic.AbstractChange;
import net.ptnkjke.logic.DataClass;
import org.apache.bcel.classfile.JavaClass;
import org.apache.bcel.classfile.Method;
import org.apache.bcel.generic.ClassGen;
import org.apache.bcel.generic.ConstantPoolGen;
import org.apache.bcel.generic.InstructionList;
import org.apache.bcel.generic.MethodGen;

/**
 * Created by dalopatin on 14.11.2014.
 */
public class BCELMethodChange extends AbstractChange {
    /**
     * Код для метода
     */
    private String code;
    /**
     * Данные класса
     */
    private DataClass dataClass;
    /**
     * Индекс метода
     */
    private Integer methodIndex;

    @Override
    public void acceptChange() {
        JByteParser jByteParser = new JByteParser();

        JavaClass javaClass = dataClass.getBcelJavaClass();
        ClassGen classGen = new ClassGen(javaClass);

        ConstantPoolGen constantPoolGen = classGen.getConstantPool();

        jByteParser.parse(code, constantPoolGen);

        InstructionList instructionList = jByteParser.getInstructions();

        Method old = classGen.getMethodAt(methodIndex);

        MethodGen mg = new MethodGen(old, classGen.getClassName(), classGen.getConstantPool());
        mg.removeLineNumbers();                // IMPORTANT!!
        mg.removeLocalVariables();             // IMPORTANT!!
        mg.setInstructionList(instructionList);
        classGen.setMethodAt(mg.getMethod(), methodIndex);

        // .class after save
        byte [] bytes = classGen.getJavaClass().getBytes();

    }
}
