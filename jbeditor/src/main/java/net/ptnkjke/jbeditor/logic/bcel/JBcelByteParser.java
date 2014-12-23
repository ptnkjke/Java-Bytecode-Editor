package net.ptnkjke.jbeditor.logic.bcel;

import org.apache.bcel.generic.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lopatin on 06.07.2014.
 */
public class JBcelByteParser {
    private InstructionList instructions = new InstructionList();
    private ArrayList<InstructionHandle> instructionHandleList = new ArrayList<InstructionHandle>();
    private ArrayList<BranchStruct> branchStructs = new ArrayList<>();
    private ArrayList<SelectStruct> selectStructs = new ArrayList<>();

    public InstructionList getInstructions() {
        return instructions;
    }

    public void parse(String code, ConstantPoolGen ccg) {
        InstructionList list;

        String[] lines = code.split("\n");
        String[] wLines = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];

            String tLine = line;
            // Убираем последние и первые пробелы, комментарии
            if (line.indexOf("//") != -1) {
                tLine = line.substring(0, line.indexOf("//"));
            }
            tLine = tLine.replaceAll("\\s+$", "").replaceAll("^\\s+", "");
            wLines[i] = tLine;
        }


        int curLine = 0;
        int lastLine;
        while (wLines.length != curLine) {
            lastLine = curLine;
            curLine += parseLine(wLines, curLine);
            if (lastLine == curLine) {
                break;
            }
        }

        // Обработка BranchStructs!
        for (BranchStruct branchStruct : branchStructs) {
            InstructionHandle instructionHandle = getHandleByPos(branchStruct.label);
            branchStruct.instruction.setTarget(instructionHandle);
        }

        // Обработка TABLESELECT + LOOCKUPSELECT
        for (SelectStruct selectStruct : selectStructs) {
            InstructionHandle target = getHandleByPos(selectStruct.target);
            Select select = selectStruct.instruction;
            select.setTarget(target);

            int counter = 0;
            for (Integer i : selectStruct.instructs) {
                InstructionHandle handle = getHandleByPos(i);
                select.getTargets()[counter] = handle;
                counter++;
            }
        }

    }

    public InstructionHandle getHandleByPos(int target) {
        int b = 0;
        for (InstructionHandle handle : instructionHandleList) {
            if (b == target) {
                return handle;
            }
            b += handle.getInstruction().getLength();
        }

        return null;
    }

    /**
     * Сколько строк обработано
     *
     * @return
     */
    private int parseLine(String[] lines, int numLine) {
        String[] _s = lines[numLine].split(" ");
        String instructionName = _s[0];
        String[] args = Arrays.copyOfRange(_s, 1, _s.length);
        InstructionHandle instructionHandle = null;
        Instruction instruction = null;
        // ARITHMETIC
        switch (instructionName) {
            case "dadd":
                instruction = new DADD();
                break;
            case "ddiv":
                instruction = new DDIV();
                break;
            case "dmul":
                instruction = new DMUL();
                break;
            case "dneg":
                instruction = new DNEG();
                break;
            case "drem":
                instruction = new DREM();
                break;
            case "dsub":
                instruction = new DSUB();
                break;
            case "fadd":
                instruction = new FADD();
                break;
            case "fdiv":
                instruction = new FDIV();
                break;
            case "fmul":
                instruction = new FMUL();
                break;
            case "fneg":
                instruction = new FNEG();
                break;
            case "frem":
                instruction = new FREM();
                break;
            case "fsub":
                instruction = new FSUB();
                break;
            case "iadd":
                instruction = new IADD();
                break;
            case "iand":
                instruction = new IAND();
                break;
            case "idiv":
                instruction = new IDIV();
                break;
            case "imul":
                instruction = new IMUL();
                break;
            case "ineg":
                instruction = new INEG();
                break;
            case "ior":
                instruction = new IOR();
                break;
            case "irem":
                instruction = new IREM();
                break;
            case "ishl":
                instruction = new ISHL();
                break;
            case "ishr":
                instruction = new ISHR();
                break;
            case "isub":
                instruction = new ISUB();
                break;
            case "iushr":
                instruction = new IUSHR();
                break;
            case "ixor":
                instruction = new IXOR();
                break;
            case "ladd":
                instruction = new LADD();
                break;
            case "land":
                instruction = new LAND();
                break;
            case "ldiv":
                instruction = new LDIV();
                break;
            case "lmul":
                instruction = new LMUL();
                break;
            case "lneg":
                instruction = new LNEG();
                break;
            case "lor":
                instruction = new LOR();
                break;
            case "lrem":
                instruction = new LREM();
                break;
            case "lshl":
                instruction = new LSHL();
                break;
            case "lshr":
                instruction = new LSHR();
                break;
            case "lsub":
                instruction = new LSUB();
                break;
            case "lushr":
                instruction = new LUSHR();
                break;
            case "lxor":
                instruction = new LXOR();
                break;
        }
        if (instruction != null) {
            instructionHandle = instructions.append((ArithmeticInstruction) instruction);
            instructionHandleList.add(instructionHandle);
            return 1;
        }

        // ARRAYINSTRUCTION
        switch (instructionName) {
            case "aaload":
                instruction = new AALOAD();
                break;
            case "aastore":
                instruction = new AASTORE();
                break;
            case "baload":
                instruction = new BALOAD();
                break;
            case "bastore":
                instruction = new BASTORE();
                break;
            case "caload":
                instruction = new CALOAD();
                break;
            case "castore":
                instruction = new CASTORE();
                break;
            case "daload":
                instruction = new DALOAD();
                break;
            case "dastore":
                instruction = new DASTORE();
                break;
            case "faload":
                instruction = new FALOAD();
                break;
            case "fastore":
                instruction = new FASTORE();
                break;
            case "iaload":
                instruction = new IALOAD();
                break;
            case "iastore":
                instruction = new IASTORE();
                break;
            case "laload":
                instruction = new LALOAD();
                break;
            case "lastore":
                instruction = new LASTORE();
                break;
            case "saload":
                instruction = new SALOAD();
                break;
            case "sastore":
                instruction = new SASTORE();
                break;
        }

        if (instruction != null) {
            instructionHandle = instructions.append((ArrayInstruction) instruction);
            instructionHandleList.add(instructionHandle);
            return 1;
        }

        // BRANCHINSTRUCTION
        switch (instructionName) {
            case "goto":
                instruction = new GOTO(null);
                break;
            case "goto_w":
                instruction = new GOTO_W(null);
                break;
            case "if_acmpeq":
                instruction = new IF_ACMPEQ(null);
                break;
            case "if_acmne":
                instruction = new IF_ACMPNE(null);
                break;
            case "if_icmpeq":
                instruction = new IF_ICMPEQ(null);
                break;
            case "if_icmpge":
                instruction = new IF_ICMPGE(null);
                break;
            case "if_icmpgt":
                instruction = new IF_ICMPGT(null);
                break;
            case "if_icmple":
                instruction = new IF_ICMPLE(null);
                break;
            case "if_icmplt":
                instruction = new IF_ICMPLT(null);
                break;
            case "if_icmpne":
                instruction = new IF_ICMPNE(null);
                break;
            case "ifeq":
                instruction = new IFEQ(null);
                break;
            case "ifge":
                instruction = new IFGE(null);
                break;
            case "ifgt":
                instruction = new IFGT(null);
                break;
            case "ifle":
                instruction = new IFLE(null);
                break;
            case "iflt":
                instruction = new IFLT(null);
                break;
            case "ifne":
                instruction = new IFNE(null);
                break;
            case "ifnonnull":
                instruction = new IFNONNULL(null);
                break;
            case "ifnull":
                instruction = new IFNULL(null);
                break;
            case "jsr":
                instruction = new JSR(null);
                break;
            case "jsr_w":
                instruction = new JSR_W(null);
                break;
        }
        if (instruction != null) {
            instructionHandle = instructions.append((BranchInstruction) instruction);
            instructionHandleList.add(instructionHandle);

            branchStructs.add(new BranchStruct((BranchInstruction) instruction, Integer.parseInt(args[0])));
            return 1;
        }

        switch (instructionName) {
            case "tableswitch":
                int size = Integer.parseInt(args[0]);
                int[] match = new int[size];
                InstructionHandle[] targets = new InstructionHandle[size];
                InstructionHandle defaultTarget = null;
                instruction = new TABLESWITCH(match, targets, defaultTarget);

                instructionHandle = instructions.append((TABLESWITCH) instruction);
                instructionHandleList.add(instructionHandle);

                int counter = 0;
                int[] instructions_arr = new int[size];

                for (int c = numLine + 1; c < numLine + 1 + size; c++) {
                    String tLine = lines[c];
                    String[] subs = tLine.split(":");

                    match[counter] = Integer.parseInt(subs[0].replaceAll(" ", ""));
                    instructions_arr[counter] = Integer.parseInt(subs[1].replaceAll(" ", ""));
                    counter++;
                }
                String def_string = lines[numLine + 1 + size];
                String[] def_subs = def_string.split(":");
                int target = Integer.parseInt(def_subs[1].replaceAll(" ", ""));

                selectStructs.add(new SelectStruct((TABLESWITCH) instruction, instructions_arr, target));
                return 1 + size + 1;
            case "lookupswitch":
                size = Integer.parseInt(args[0]);
                match = new int[size];
                targets = new InstructionHandle[size];
                defaultTarget = null;
                instruction = new LOOKUPSWITCH(match, targets, defaultTarget);

                instructionHandle = instructions.append((LOOKUPSWITCH) instruction);
                instructionHandleList.add(instructionHandle);

                counter = 0;
                instructions_arr = new int[size];
                for (int c = numLine + 1; c < numLine + 1 + size; c++) {
                    String tLine = lines[c];
                    String[] subs = tLine.split(":");

                    match[counter] = Integer.parseInt(subs[0].replaceAll(" ", ""));
                    instructions_arr[counter] = Integer.parseInt(subs[1].replaceAll(" ", ""));
                    counter++;
                }

                def_string = lines[numLine + 1 + size];
                def_subs = def_string.split(":");
                target = Integer.parseInt(def_subs[1].replaceAll(" ", ""));

                selectStructs.add(new SelectStruct((LOOKUPSWITCH) instruction, instructions_arr, target));
                return 1 + size + 1;
        }


        // CONVERSIONINTRUCTION
        switch (instructionName) {
            case "d2i":
                instruction = new D2I();
                break;
            case "f2i":
                instruction = new F2I();
                break;
            case "l2i":
                instruction = new L2I();
                break;
            case "d2f":
                instruction = new D2F();
                break;
            case "i2f":
                instruction = new I2F();
                break;
            case "l2f":
                instruction = new L2F();
                break;
            case "d2l":
                instruction = new D2L();
                break;
            case "f2l":
                instruction = new F2L();
                break;
            case "i2l":
                instruction = new I2L();
                break;
            case "f2d":
                instruction = new F2D();
                break;
            case "i2d":
                instruction = new I2D();
                break;
            case "l2d":
                instruction = new L2D();
                break;
            case "i2b":
                instruction = new I2B();
                break;
            case "i2c":
                instruction = new I2C();
                break;
            case "i2s":
                instruction = new I2S();
                break;
        }

        if (instruction != null) {
            instructionHandle = instructions.append((ConversionInstruction) instruction);
            instructionHandleList.add(instructionHandle);
            return 1;
        }

        // CPINSTRUCTION
        int n;
        switch (instructionName) {
            case "anewarray":
                n = Integer.parseInt(args[0]);
                instruction = new ANEWARRAY(n);
                break;
            case "checkcast":
                n = Integer.parseInt(args[0]);
                instruction = new CHECKCAST(n);
                break;
            case "instanceof":
                n = Integer.parseInt(args[0]);
                instruction = new INSTANCEOF(n);
                break;
            case "ldc":
                n = Integer.parseInt(args[0]);
                instruction = new LDC(n);
                break;
            case "ldc2_w":
                n = Integer.parseInt(args[0]);
                instruction = new LDC2_W(n);
                n = Integer.parseInt(args[0]);
                break;
            case "multianewarray":
                n = Integer.parseInt(args[0]);
                Short sh = Short.parseShort(args[1]);
                instruction = new MULTIANEWARRAY(n, sh);
                break;
            case "getfield":
                n = Integer.parseInt(args[0]);
                instruction = new GETFIELD(n);
                break;
            case "getstatic":
                n = Integer.parseInt(args[0]);
                instruction = new GETSTATIC(n);
                break;
            case "putstatic":
                n = Integer.parseInt(args[0]);
                instruction = new PUTSTATIC(n);
                break;
            case "invokeinterface":
                n = Integer.parseInt(args[0]);
                int nargs = Integer.parseInt(args[1]);
                instruction = new INVOKEINTERFACE(n, nargs);
                break;
            case "invokestatic":
                n = Integer.parseInt(args[0]);
                instruction = new INVOKESTATIC(n);
                break;
            case "invokevirtual":
                n = Integer.parseInt(args[0]);
                instruction = new INVOKEVIRTUAL(n);
                break;
            case "putfield":
                n = Integer.parseInt(args[0]);
                instruction = new PUTFIELD(n);
                break;
            case "invokedynamic":
                n = Integer.parseInt(args[0]);
                int index = Integer.parseInt(args[1]);
                instruction = new INVOKEDYNAMIC((short) n, index);
                break;
            case "invokespecial":
                n = Integer.parseInt(args[0]);
                instruction = new INVOKESPECIAL(n);
                break;
            case "new":
                n = Integer.parseInt(args[0]);
                instruction = new NEW(n);
                break;
        }

        if (instruction != null) {
            instructionHandle = instructions.append((CPInstruction) instruction);
            instructionHandleList.add(instructionHandle);
            return 1;
        }

        // LOCALVARIABLEINSTRUCTION

        int num;
        switch (instructionName) {
            case "aload":
                num = Integer.parseInt(args[0]);
                instruction = new ALOAD(num);
                break;
            case "aload_0":
                instruction = new ALOAD(0);
                break;
            case "aload_1":
                instruction = new ALOAD(1);
                break;
            case "aload_2":
                instruction = new ALOAD(2);
                break;
            case "aload_3":
                instruction = new ALOAD(3);
                break;
            case "dload":
                num = Integer.parseInt(args[0]);
                instruction = new DLOAD(num);
                break;
            case "dload_0":
                instruction = new DLOAD(0);
                break;
            case "dload_1":
                instruction = new DLOAD(1);
                break;
            case "dload_2":
                instruction = new DLOAD(2);
                break;
            case "dload_3":
                instruction = new DLOAD(3);
                break;
            case "fload":
                num = Integer.parseInt(args[0]);
                instruction = new FLOAD(num);
                break;
            case "fload_0":
                instruction = new FLOAD(0);
                break;
            case "fload_1":
                instruction = new FLOAD(1);
                break;
            case "fload_2":
                instruction = new FLOAD(2);
                break;
            case "fload_3":
                instruction = new FLOAD(3);
                break;
            case "iload":
                num = Integer.parseInt(args[0]);
                instruction = new ILOAD(num);
                break;
            case "iload_0":
                instruction = new ILOAD(0);
                break;
            case "iload_1":
                instruction = new ILOAD(1);
                break;
            case "iload_2":
                instruction = new ILOAD(2);
                break;
            case "iload_3":
                instruction = new ILOAD(3);
                break;
            case "lload":
                num = Integer.parseInt(args[0]);
                instruction = new LLOAD(num);
                break;
            case "lload_0":
                instruction = new LLOAD(0);
                break;
            case "lload_1":
                instruction = new LLOAD(1);
                break;
            case "lload_2":
                instruction = new LLOAD(2);
                break;
            case "lload_3":
                instruction = new LLOAD(3);
                break;
            case "astore":
                num = Integer.parseInt(args[0]);
                instruction = new ASTORE(num);
                break;
            case "astore_0":
                instruction = new ASTORE(0);
                break;
            case "astore_1":
                instruction = new ASTORE(1);
                break;
            case "astore_2":
                instruction = new ASTORE(2);
                break;
            case "astore_3":
                instruction = new ASTORE(3);
                break;
            case "dstore":
                num = Integer.parseInt(args[0]);
                instruction = new ASTORE(num);
                break;
            case "dstore_0":
                instruction = new DSTORE(0);
                break;
            case "dstore_1":
                instruction = new DSTORE(1);
                break;
            case "dstore_2":
                instruction = new DSTORE(2);
                break;
            case "dstore_3":
                instruction = new DSTORE(3);
                break;
            case "fstore":
                num = Integer.parseInt(args[0]);
                instruction = new FSTORE(num);
                break;
            case "fstore_0":
                instruction = new FSTORE(0);
                break;
            case "fstore_1":
                instruction = new FSTORE(1);
                break;
            case "fstore_2":
                instruction = new FSTORE(2);
                break;
            case "fstore_3":
                instruction = new FSTORE(3);
                break;
            case "istore":
                num = Integer.parseInt(args[0]);
                instruction = new ISTORE(num);
                break;
            case "istore_0":
                instruction = new ISTORE(0);
                break;
            case "istore_1":
                instruction = new ISTORE(1);
                break;
            case "istore_2":
                instruction = new ISTORE(2);
                break;
            case "istore_3":
                instruction = new ISTORE(3);
                break;
            case "lstore":
                num = Integer.parseInt(args[0]);
                instruction = new LSTORE(num);
                break;
            case "lstore_0":
                instruction = new LSTORE(0);
                break;
            case "lstore_1":
                instruction = new LSTORE(1);
                break;
            case "lstore_2":
                instruction = new LSTORE(2);
                break;
            case "lstore_3":
                instruction = new LSTORE(3);
                break;
            case "iinc":
                num = Integer.parseInt(args[0]);
                int num2 = Integer.parseInt(args[1]);
                instruction = new IINC(num, num2);
                break;
        }

        if (instruction != null) {
            instructionHandle = instructions.append((LocalVariableInstruction) instruction);
            instructionHandleList.add(instructionHandle);
            return 1;
        }

        // RETURNINSTRUCTION

        switch (instructionName) {
            case "areturn":
                instruction = new ARETURN();
                break;
            case "dreturn":
                instruction = new DRETURN();
                break;
            case "freturn":
                instruction = new FRETURN();
                break;
            case "ireturn":
                instruction = new IRETURN();
                break;
            case "lreturn":
                instruction = new LRETURN();
                break;
            case "return":
                instruction = new RETURN();
                break;

        }
        if (instruction != null) {
            instructionHandle = instructions.append((ReturnInstruction) instruction);
            instructionHandleList.add(instructionHandle);
            return 1;
        }

        // STACKINSTRUCTION

        switch (instructionName) {
            case "dup":
                instruction = new DUP();
                break;
            case "dup2":
                instruction = new DUP2();
                break;
            case "dup_x1":
                instruction = new DUP_X1();
                break;
            case "dup_x2":
                instruction = new DUP_X2();
                break;
            case "dup2_x1":
                instruction = new DUP2_X1();
                break;
            case "dup2_x2":
                instruction = new DUP2_X2();
                break;
            case "pop":
                instruction = new POP();
                break;
            case "pop2":
                instruction = new POP2();
                break;
            case "swap":
                instruction = new SWAP();
                break;
        }
        if (instruction != null) {
            instructionHandle = instructions.append((StackInstruction) instruction);
            instructionHandleList.add(instructionHandle);
            return 1;
        }

        // OTHERINSTRUCTION
        switch (instructionName) {
            case "aconst_null":
                instruction = new ACONST_NULL();
                break;
            case "arraylength":
                instruction = new ARRAYLENGTH();
                break;
            case "athrow":
                instruction = new ATHROW();
                break;
            case "breakpoint":
                instruction = new BREAKPOINT();
                break;
            case "dcmpg":
                instruction = new DCMPG();
                break;
            case "dconst_0":
                instruction = new DCONST(0);
                break;
            case "dconst_1":
                instruction = new DCONST(1);
                break;
            case "fcmpg":
                instruction = new FCMPG();
                break;
            case "fcmpl":
                instruction = new FCMPL();
                break;
            case "fconst_0":
                instruction = new FCONST(0);
                break;
            case "fconst_1":
                instruction = new FCONST(1);
                break;
            case "fconst_2":
                instruction = new FCONST(2);
                break;
            case "iconst_m1":
                instruction = new ICONST(-1);
                break;
            case "iconst_0":
                instruction = new ICONST(0);
                break;
            case "iconst_1":
                instruction = new ICONST(1);
                break;
            case "iconst_2":
                instruction = new ICONST(2);
                break;
            case "iconst_3":
                instruction = new ICONST(3);
                break;
            case "iconst_4":
                instruction = new ICONST(4);
                break;
            case "iconst_5":
                instruction = new ICONST(5);
                break;
            case "impdep1":
                instruction = new IMPDEP1();
                break;
            case "impdep2":
                instruction = new IMPDEP2();
                break;
            case "lcmp":
                instruction = new LCMP();
                break;
            case "lconst_0":
                instruction = new LCONST(0);
                break;
            case "lconst_1":
                instruction = new LCONST(1);
                break;
            case "monitorenter":
                instruction = new MONITORENTER();
                break;
            case "monitorexit":
                instruction = new MONITOREXIT();
                break;
            case "newarray":
                Byte b = Byte.parseByte(args[0]);
                instruction = new NEWARRAY(b);
                break;
            case "nop":
                instruction = new NOP();
                break;
            case "ret":
                Integer integer = Integer.parseInt(args[0]);
                instruction = new RET(integer);
                break;
            case "sipush":
                Short sh = Short.parseShort(args[0]);
                instruction = new SIPUSH(sh);
                break;
            case "bipush":
                Byte byt = Byte.parseByte(args[0]);
                instruction = new BIPUSH(byt);
                break;
        }

        if (instruction != null) {
            instructionHandle = instructions.append(instruction);
            instructionHandleList.add(instructionHandle);
            return 1;
        }

        try {
            throw new Exception("");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    private class BranchStruct {
        BranchInstruction instruction;
        int label;

        BranchStruct(BranchInstruction instruction, int label) {
            this.instruction = instruction;
            this.label = label;
        }
    }

    private class SelectStruct {
        Select instruction;
        int[] instructs;
        int target;

        SelectStruct(Select instruction, int[] instructs, int target) {
            this.instruction = instruction;
            this.instructs = instructs;
            this.target = target;
        }
    }
}
