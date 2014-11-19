package net.ptnkjke.logic.asm;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.util.*;

/**
 * Created by dalopatin on 17.11.2014.
 */
public class JAsmByteParser {
    private Map<Integer, LabelNode> labelNodeMap = new HashMap<Integer, LabelNode>();
    private List<TryCatchBlockNode> tryCatchBlockNodeList = new ArrayList<TryCatchBlockNode>();
    private InsnList insnList = new InsnList();

    public void parse(String code) {
        String[] lines = code.split("\n");
        String[] wLines = new String[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];

            String tLine = line;
            // Remove first and last Spaces + comments
            if (line.indexOf("//") != -1) {
                tLine = line.substring(0, line.indexOf("//"));
            }

            tLine = tLine.replaceAll("\\s+$", "").replaceAll("^\\s+", "");
            wLines[i] = tLine;
        }
    }


    private void parseLine(String[] lines, int numLine) {
        String[] _s = lines[numLine].split(" ");
        String instructionName = _s[0].toUpperCase();
        String[] args = Arrays.copyOfRange(_s, 1, _s.length);


        AbstractInsnNode insnNode = null;
        LabelNode labelNode = null;

        // JumpInstruction
        switch (instructionName) {
            case "IFEQ":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IFEQ, labelNode);
                break;
            case "IFNE":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IFNE, labelNode);
                break;
            case "IFLT":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IFLT, labelNode);
                break;
            case "IFGE":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IFGE, labelNode);
                break;
            case "IFGT":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IFGT, labelNode);
                break;
            case "IFLE":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IFLE, labelNode);
                break;
            case "IF_ICMPEQ":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IF_ICMPEQ, labelNode);
                break;
            case "IF_ICMPNE":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IF_ICMPNE, labelNode);
                break;
            case "IF_ICMPLT":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IF_ICMPLT, labelNode);
                break;
            case "IF_ICMPGE":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IF_ICMPGE, labelNode);
                break;
            case "IF_ICMPGT":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IF_ICMPGT, labelNode);
                break;
            case "IF_ICMPLE":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IF_ICMPLE, labelNode);
                break;
            case "IF_ACMPEQ":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IF_ACMPEQ, labelNode);
                break;
            case "IF_ACMPNE":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IF_ACMPNE, labelNode);
                break;
            case "GOTO":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.GOTO, labelNode);
                break;
            case "JSR":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.JSR, labelNode);
                break;
            case "IFNULL":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IFNULL, labelNode);
                break;
            case "IFNONNULL":
                labelNode = parseLable(args[0]);
                insnNode = new JumpInsnNode(Opcodes.IFNONNULL, labelNode);
                break;
        }
        if(insnNode != null){
            insnList.add(insnNode);
            return;
        }

        // LineNumber
        if(instructionName.equals("LINENUMBER")){
            labelNode = parseLable(args[1]);
            int lineNumber = Integer.parseInt(args[0]);

            insnList.add(new LineNumberNode(lineNumber, labelNode));
            return;
        }

        // Insn
        switch (instructionName) {
            case "NOP":
                insnNode = new InsnNode(Opcodes.NOP);
                break;
            case "ACONST_NULL":
                insnNode = new InsnNode(Opcodes.ACONST_NULL);
                break;
            case "ICONST_M1":
                insnNode = new InsnNode(Opcodes.ICONST_M1);
                break;
            case "ICONST_0":
                insnNode = new InsnNode(Opcodes.ICONST_0);
                break;
            case "ICONST_1":
                insnNode = new InsnNode(Opcodes.ICONST_1);
                break;
            case "ICONST_2":
                insnNode = new InsnNode(Opcodes.ICONST_2);
                break;
            case "ICONST_3":
                insnNode = new InsnNode(Opcodes.ICONST_3);
                break;
            case "ICONST_4":
                insnNode = new InsnNode(Opcodes.ICONST_4);
                break;
            case "ICONST_5":
                insnNode = new InsnNode(Opcodes.ICONST_5);
                break;
            case "LCONST_0":
                insnNode = new InsnNode(Opcodes.LCONST_0);
                break;
            case "LCONST_1":
                insnNode = new InsnNode(Opcodes.LCONST_1);
                break;
            case "FCONST_0":
                insnNode = new InsnNode(Opcodes.FCONST_0);
                break;
            case "FCONST_1":
                insnNode = new InsnNode(Opcodes.FCONST_1);
                break;
            case "FCONST_2":
                insnNode = new InsnNode(Opcodes.FCONST_2);
                break;
            case "DCONST_0":
                insnNode = new InsnNode(Opcodes.DCONST_0);
                break;
            case "DCONST_1":
                insnNode = new InsnNode(Opcodes.DCONST_1);
                break;
            case "IALOAD":
                insnNode = new InsnNode(Opcodes.IALOAD);
                break;
            case "LALOAD":
                insnNode = new InsnNode(Opcodes.LALOAD);
                break;
            case "FALOAD":
                insnNode = new InsnNode(Opcodes.FALOAD);
                break;
            case "DALOAD":
                insnNode = new InsnNode(Opcodes.DALOAD);
                break;
            case "AALOAD":
                insnNode = new InsnNode(Opcodes.AALOAD);
                break;
            case "BALOAD":
                insnNode = new InsnNode(Opcodes.BALOAD);
                break;
            case "CALOAD":
                insnNode = new InsnNode(Opcodes.CALOAD);
                break;
            case "SALOAD":
                insnNode = new InsnNode(Opcodes.SALOAD);
                break;
            case "IASTORE":
                insnNode = new InsnNode(Opcodes.IASTORE);
                break;
            case "LASTORE":
                insnNode = new InsnNode(Opcodes.LASTORE);
                break;
            case "FASTORE":
                insnNode = new InsnNode(Opcodes.FASTORE);
                break;
            case "DASTORE":
                insnNode = new InsnNode(Opcodes.DASTORE);
                break;
            case "AASTORE":
                insnNode = new InsnNode(Opcodes.AASTORE);
                break;
            case "BASTORE":
                insnNode = new InsnNode(Opcodes.BASTORE);
                break;
            case "CASTORE":
                insnNode = new InsnNode(Opcodes.CASTORE);
                break;
            case "SASTORE":
                insnNode = new InsnNode(Opcodes.SASTORE);
                break;
            case "POP":
                insnNode = new InsnNode(Opcodes.POP);
                break;
            case "POP2":
                insnNode = new InsnNode(Opcodes.POP2);
                break;
            case "DUP":
                insnNode = new InsnNode(Opcodes.DUP);
                break;
            case "DUP_X1":
                insnNode = new InsnNode(Opcodes.DUP_X1);
                break;
            case "DUP_X2":
                insnNode = new InsnNode(Opcodes.DUP_X2);
                break;
            case "DUP2":
                insnNode = new InsnNode(Opcodes.DUP2);
                break;
            case "DUP2_X1":
                insnNode = new InsnNode(Opcodes.DUP2_X1);
                break;
            case "DUP2_X2":
                insnNode = new InsnNode(Opcodes.DUP2_X2);
                break;
            case "SWAP":
                insnNode = new InsnNode(Opcodes.SWAP);
                break;
            case "IADD":
                insnNode = new InsnNode(Opcodes.IADD);
                break;
            case "LADD":
                insnNode = new InsnNode(Opcodes.LADD);
                break;
            case "FADD":
                insnNode = new InsnNode(Opcodes.FADD);
                break;
            case "DADD":
                insnNode = new InsnNode(Opcodes.DADD);
                break;
            case "ISUB":
                insnNode = new InsnNode(Opcodes.ISUB);
                break;
            case "LSUB":
                insnNode = new InsnNode(Opcodes.LSUB);
                break;
            case "FSUB":
                insnNode = new InsnNode(Opcodes.FSUB);
                break;
            case "DSUB":
                insnNode = new InsnNode(Opcodes.DSUB);
                break;
            case "IMUL":
                insnNode = new InsnNode(Opcodes.IMUL);
                break;
            case "LMUL":
                insnNode = new InsnNode(Opcodes.LMUL);
                break;
            case "FMUL":
                insnNode = new InsnNode(Opcodes.FMUL);
                break;
            case "DMUL":
                insnNode = new InsnNode(Opcodes.DMUL);
                break;
            case "IDIV":
                insnNode = new InsnNode(Opcodes.IDIV);
                break;
            case "LDIV":
                insnNode = new InsnNode(Opcodes.LDIV);
                break;
            case "FDIV":
                insnNode = new InsnNode(Opcodes.FDIV);
                break;
            case "DDIV":
                insnNode = new InsnNode(Opcodes.DDIV);
                break;
            case "IREM":
                insnNode = new InsnNode(Opcodes.IREM);
                break;
            case "LREM":
                insnNode = new InsnNode(Opcodes.LREM);
                break;
            case "FREM":
                insnNode = new InsnNode(Opcodes.FREM);
                break;
            case "DREM":
                insnNode = new InsnNode(Opcodes.DREM);
                break;
            case "INEG":
                insnNode = new InsnNode(Opcodes.INEG);
                break;
            case "LNEG":
                insnNode = new InsnNode(Opcodes.LNEG);
                break;
            case "FNEG":
                insnNode = new InsnNode(Opcodes.FNEG);
                break;
            case "DNEG":
                insnNode = new InsnNode(Opcodes.DNEG);
                break;
            case "ISHL":
                insnNode = new InsnNode(Opcodes.ISHL);
                break;
            case "LSHL":
                insnNode = new InsnNode(Opcodes.LSHL);
                break;
            case "ISHR":
                insnNode = new InsnNode(Opcodes.ISHR);
                break;
            case "LSHR":
                insnNode = new InsnNode(Opcodes.LSHR);
                break;
            case "IUSHR":
                insnNode = new InsnNode(Opcodes.IUSHR);
                break;
            case "LUSHR":
                insnNode = new InsnNode(Opcodes.LUSHR);
                break;
            case "IAND":
                insnNode = new InsnNode(Opcodes.IAND);
                break;
            case "LAND":
                insnNode = new InsnNode(Opcodes.LAND);
                break;
            case "IOR":
                insnNode = new InsnNode(Opcodes.IOR);
                break;
            case "LOR":
                insnNode = new InsnNode(Opcodes.LOR);
                break;
            case "IXOR":
                insnNode = new InsnNode(Opcodes.IXOR);
                break;
            case "LXOR":
                insnNode = new InsnNode(Opcodes.LXOR);
                break;
            case "I2L":
                insnNode = new InsnNode(Opcodes.I2L);
                break;
            case "I2F":
                insnNode = new InsnNode(Opcodes.I2F);
                break;
            case "I2D":
                insnNode = new InsnNode(Opcodes.I2D);
                break;
            case "L2I":
                insnNode = new InsnNode(Opcodes.L2I);
                break;
            case "L2F":
                insnNode = new InsnNode(Opcodes.L2F);
                break;
            case "L2D":
                insnNode = new InsnNode(Opcodes.L2D);
                break;
            case "F2I":
                insnNode = new InsnNode(Opcodes.F2I);
                break;
            case "F2L":
                insnNode = new InsnNode(Opcodes.F2L);
                break;
            case "F2D":
                insnNode = new InsnNode(Opcodes.F2D);
                break;
            case "D2I":
                insnNode = new InsnNode(Opcodes.D2I);
                break;
            case "D2L":
                insnNode = new InsnNode(Opcodes.D2L);
                break;
            case "D2F":
                insnNode = new InsnNode(Opcodes.D2F);
                break;
            case "I2B":
                insnNode = new InsnNode(Opcodes.I2B);
                break;
            case "I2C":
                insnNode = new InsnNode(Opcodes.I2C);
                break;
            case "I2S":
                insnNode = new InsnNode(Opcodes.I2S);
                break;
            case "LCMP":
                insnNode = new InsnNode(Opcodes.LCMP);
                break;
            case "FCMPL":
                insnNode = new InsnNode(Opcodes.FCMPL);
                break;
            case "FCMPG":
                insnNode = new InsnNode(Opcodes.FCMPG);
                break;
            case "DCMPL":
                insnNode = new InsnNode(Opcodes.DCMPL);
                break;
            case "DCMPG":
                insnNode = new InsnNode(Opcodes.DCMPG);
                break;
            case "IRETURN":
                insnNode = new InsnNode(Opcodes.IRETURN);
                break;
            case "LRETURN":
                insnNode = new InsnNode(Opcodes.LRETURN);
                break;
            case "FRETURN":
                insnNode = new InsnNode(Opcodes.FRETURN);
                break;
            case "DRETURN":
                insnNode = new InsnNode(Opcodes.DRETURN);
                break;
            case "ARETURN":
                insnNode = new InsnNode(Opcodes.ARETURN);
                break;
            case "RETURN":
                insnNode = new InsnNode(Opcodes.RETURN);
                break;
            case "ARRAYLENGTH":
                insnNode = new InsnNode(Opcodes.ARRAYLENGTH);
                break;
            case "ATHROW":
                insnNode = new InsnNode(Opcodes.ATHROW);
                break;
            case "MONITORENTER":
                insnNode = new InsnNode(Opcodes.MONITORENTER);
                break;
            case "MONITOREXIT":
                insnNode = new InsnNode(Opcodes.MONITOREXIT);
                break;
        }
        if(insnNode != null){
            insnList.add(insnNode);
            return;
        }

        // IincInsnNode
        if(instructionName.equals("")){
            //TODO ME PLEASE <3!!
            return;
        }

        // TryCatchBlock
        if(instructionName.equals("TRYCATCHBLOCK")){
            LabelNode start = parseLable(args[0]);
            LabelNode end = parseLable(args[1]);
            LabelNode handler= parseLable(args[2]);
            String type =args[3];
            tryCatchBlockNodeList.add(new TryCatchBlockNode(start, end, handler, type));
            return;
        }


        // LOOKUPSWITCH
        //TODO ME PLEASE <3!!
        // TABLESWITCH
        //TODO ME PLEASE <3!!

        try {
            throw new Exception(lines[numLine]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private LabelNode parseLable(String arg){
        Integer number = Integer.parseInt(arg.substring(1));
        LabelNode node = labelNodeMap.get(number);

        if(node == null){
            node = new LabelNode();
            node.resetLabel();
            labelNodeMap.put(number, node);
            insnList.add(node);
        }

        return node;
    }
}
