package net.ptnkjke.jbeditor.utils;

import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

/**
 * Created by Lopatin on 06.07.2014.
 */
public class Editor extends InstructionHandleWorker {
    private String result;

    private void base(InstructionHandle handle) {
        result = Constants.OPCODE_NAMES[handle.getInstruction().getOpcode()] + "      // [" + handle.getPosition() + "]";
    }

    private void branch(InstructionHandle handle) {
        BranchInstruction branchInstruction = (BranchInstruction) handle.getInstruction();
        result = Constants.OPCODE_NAMES[handle.getInstruction().getOpcode()]
                + " "
                + branchInstruction.getTarget().getPosition()
                + "      // [" + handle.getPosition() + "]";
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public void visitDADD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDDIV(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDMUL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDNEG(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDREM(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDSUB(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFADD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFDIV(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFMUL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFNEG(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFREM(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFSUB(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIADD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIAND(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIDIV(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIMUL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitINEG(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIOR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIREM(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitISHL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitISHR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitISUB(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIUSHR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIXOR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLADD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLAND(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLDIV(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLMUL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLNEG(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLOR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLREM(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLSHL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLSHR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLSUB(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLUSHR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLXOR(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    //
    @Override
    public void visitAALOAD(InstructionHandle instructionHandle) {
        AALOAD aaload = (AALOAD) instructionHandle.getInstruction();
        base(instructionHandle);
    }

    @Override
    public void visitAASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitBALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitBASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitCALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitCASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitSALOAD(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitSASTORE(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    //

    @Override
    public void visitGOTO(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitGOTO_W(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIF_ACMPEQ(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIF_ACMPNE(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIF_ICMPEQ(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIF_ICMPGT(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIF_ICMPGE(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIF_ICMPLE(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIF_ICMPLT(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIF_ICMPNE(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIFEQ(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIFGE(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIFGT(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIFLE(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIFLT(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIFNE(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIFNONNULL(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitIFNULL(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitJSR(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitJSR_W(InstructionHandle instructionHandle) {
        branch(instructionHandle);
    }

    @Override
    public void visitLOOKUPSWITCH(InstructionHandle instructionHandle) {
        Instruction instruction = instructionHandle.getInstruction();

        StringBuilder temp = new StringBuilder();
        temp.append(Constants.OPCODE_NAMES[instruction.getOpcode()]);

        LOOKUPSWITCH lookupswitch = (LOOKUPSWITCH) instruction;
        InstructionHandle[] targets = lookupswitch.getTargets();
        int[] mathes = lookupswitch.getMatchs();
        InstructionHandle defaultTarget = lookupswitch.getTarget();

        temp.append(" ").append(targets.length).append("\n");
        int i = 0;
        for (InstructionHandle handle : targets) {
            temp.append("    ").append(mathes[i]).append(": ").append(handle.getPosition()).append("\n");
            i++;
        }
        InstructionHandle target = lookupswitch.getTarget();
        temp.append("    ").append("default").append(": ").append(target.getPosition());
        result = temp.toString();
    }

    @Override
    public void visitTABLESWITCH(InstructionHandle instructionHandle) {
        Instruction instruction = instructionHandle.getInstruction();

        StringBuilder temp = new StringBuilder();
        temp.append(Constants.OPCODE_NAMES[instruction.getOpcode()]);


        TABLESWITCH tableswitch = (TABLESWITCH) instruction;
        InstructionHandle[] targets = tableswitch.getTargets();
        int[] mathes = tableswitch.getMatchs();
        InstructionHandle defaultTarget = tableswitch.getTarget();

        temp.append(" ").append(targets.length).append("\n");
        int i = 0;
        for (InstructionHandle handle : targets) {
            temp.append("    ").append(mathes[i]).append(": ").append(handle.getPosition()).append("\n");
            i++;
        }

        InstructionHandle target = tableswitch.getTarget();
        temp.append("    ").append("default").append(": ").append(target.getPosition());
        result = temp.toString();
    }

    //


    @Override
    public void visitD2F(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitD2I(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitD2L(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitF2D(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitF2I(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitF2L(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitI2B(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitI2C(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitI2D(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitI2F(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitI2L(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitI2S(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitL2D(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitL2F(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitL2I(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }


    // CP INstruction


    @Override
    public void visitANEWARRAY(InstructionHandle handle) {
        ANEWARRAY instruction = (ANEWARRAY) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitCHECKCAST(InstructionHandle handle) {
        CHECKCAST instruction = (CHECKCAST) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitINSTANCEOF(InstructionHandle handle) {
        INSTANCEOF instruction = (INSTANCEOF) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitLDC(InstructionHandle handle) {
        LDC instruction = (LDC) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitLDC2_W(InstructionHandle handle) {
        LDC2_W instruction = (LDC2_W) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitMULTIANEWARRAY(InstructionHandle handle) {
        MULTIANEWARRAY instruction = (MULTIANEWARRAY) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + instruction.getDimensions() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitGETFIELD(InstructionHandle handle) {
        GETFIELD instruction = (GETFIELD) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitGETSTATIC(InstructionHandle handle) {
        GETSTATIC instruction = (GETSTATIC) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitINVOKEINTERFACE(InstructionHandle handle) {
        INVOKEINTERFACE instruction = (INVOKEINTERFACE) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + " " + instruction.getCount() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitINVOKESPECIAL(InstructionHandle handle) {
        INVOKESPECIAL instruction = (INVOKESPECIAL) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitINVOKESTATIC(InstructionHandle handle) {
        INVOKESTATIC instruction = (INVOKESTATIC) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitINVOKEVIRTUAL(InstructionHandle handle) {
        INVOKEVIRTUAL instruction = (INVOKEVIRTUAL) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitPUTFIELD(InstructionHandle handle) {
        PUTFIELD instruction = (PUTFIELD) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitPUTSTATIC(InstructionHandle handle) {
        PUTSTATIC instruction = (PUTSTATIC) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitINVOKEDYNAMIC(InstructionHandle handle) {
        INVOKEDYNAMIC instruction = (INVOKEDYNAMIC) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitNEW(InstructionHandle handle) {
        NEW instruction = (NEW) handle.getInstruction();
        result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + instruction.getIndex() + "      // [" + handle.getPosition() + "]";
    }


    @Override
    public void visitALOAD(InstructionHandle handle) {
        ALOAD instruction = (ALOAD) handle.getInstruction();
        int index = instruction.getIndex();

        if (instruction.getOpcode() == Constants.ALOAD) {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + index + "      // [" + handle.getPosition() + "]";
        } else {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + "      // [" + handle.getPosition() + "]";
        }
    }

    @Override
    public void visitDLOAD(InstructionHandle handle) {
        DLOAD instruction = (DLOAD) handle.getInstruction();
        int index = instruction.getIndex();

        if (instruction.getOpcode() == Constants.DLOAD) {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + index + "      // [" + handle.getPosition() + "]";
        } else {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + "      // [" + handle.getPosition() + "]";
        }
    }

    @Override
    public void visitFLOAD(InstructionHandle handle) {
        FLOAD instruction = (FLOAD) handle.getInstruction();
        int index = instruction.getIndex();

        if (instruction.getOpcode() == Constants.FLOAD) {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + index + "      // [" + handle.getPosition() + "]";
        } else {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + "      // [" + handle.getPosition() + "]";
        }
    }

    @Override
    public void visitLLOAD(InstructionHandle handle) {
        LLOAD instruction = (LLOAD) handle.getInstruction();
        int index = instruction.getIndex();

        if (instruction.getOpcode() == Constants.LLOAD) {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + index + "      // [" + handle.getPosition() + "]";
        } else {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + "      // [" + handle.getPosition() + "]";
        }
    }

    @Override
    public void visitILOAD(InstructionHandle handle) {
        ILOAD instruction = (ILOAD) handle.getInstruction();
        int index = instruction.getIndex();

        if (instruction.getOpcode() == Constants.ILOAD) {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + index + "      // [" + handle.getPosition() + "]";
        } else {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + "      // [" + handle.getPosition() + "]";
        }
    }

    @Override
    public void visitASTORE(InstructionHandle handle) {
        ASTORE instruction = (ASTORE) handle.getInstruction();
        int index = instruction.getIndex();

        if (instruction.getOpcode() == Constants.ASTORE) {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + index + "      // [" + handle.getPosition() + "]";
        } else {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + "      // [" + handle.getPosition() + "]";
        }
    }

    @Override
    public void visitDSTORE(InstructionHandle handle) {
        DSTORE instruction = (DSTORE) handle.getInstruction();
        int index = instruction.getIndex();

        if (instruction.getOpcode() == Constants.DSTORE) {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + index + "      // [" + handle.getPosition() + "]";
        } else {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + "      // [" + handle.getPosition() + "]";
        }
    }

    @Override
    public void visitFSTORE(InstructionHandle handle) {
        FSTORE instruction = (FSTORE) handle.getInstruction();
        int index = instruction.getIndex();

        if (instruction.getOpcode() == Constants.FSTORE) {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + index + "      // [" + handle.getPosition() + "]";
        } else {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + "      // [" + handle.getPosition() + "]";
        }
    }

    @Override
    public void visitISTORE(InstructionHandle handle) {
        ISTORE instruction = (ISTORE) handle.getInstruction();
        int index = instruction.getIndex();

        if (instruction.getOpcode() == Constants.ISTORE) {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + index + "      // [" + handle.getPosition() + "]";
        } else {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + "      // [" + handle.getPosition() + "]";
        }
    }

    @Override
    public void visitLSTORE(InstructionHandle handle) {
        LSTORE instruction = (LSTORE) handle.getInstruction();
        int index = instruction.getIndex();

        if (instruction.getOpcode() == Constants.LSTORE) {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + " " + index + "      // [" + handle.getPosition() + "]";
        } else {
            result = Constants.OPCODE_NAMES[instruction.getOpcode()] + "      // [" + handle.getPosition() + "]";
        }
    }

    @Override
    public void visitIINC(InstructionHandle handle) {
        IINC iinc = (IINC) handle.getInstruction();
        result = Constants.OPCODE_NAMES[iinc.getOpcode()] + " " + iinc.getIndex() + " " + iinc.getIncrement() + "      // [" + handle.getPosition() + "]";
    }

    @Override
    public void visitARETURN(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDRETURN(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFRETURN(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIRETURN(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLRETURN(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitRETURN(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDUP(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDUP2(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDUP_X1(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDUP_X2(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDUP2_X1(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDUP2_X2(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitPOP(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitPOP2(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitSWAP(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitACONST_NULL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitARRAYLENGTH(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitATHROW(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitBREAKPOINT(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDCMPG(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitDCONST(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFCMPG(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFCMPL(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitFCONST(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitICONST(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIMPDEP1(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitIMPDEP2(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLCMP(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitLCONST(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitMONITORENTER(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitMONITOREXIT(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitNEWARRAY(InstructionHandle instructionHandle) {
        NEWARRAY newarray = (NEWARRAY) instructionHandle.getInstruction();
        result = Constants.OPCODE_NAMES[newarray.getOpcode()] + " " + newarray.getTypecode() + "      // [" + instructionHandle.getPosition() + "]";
    }

    @Override
    public void visitNOP(InstructionHandle instructionHandle) {
        base(instructionHandle);
    }

    @Override
    public void visitRET(InstructionHandle instructionHandle) {
        RET ret = (RET) instructionHandle.getInstruction();
        result = Constants.OPCODE_NAMES[ret.getOpcode()] + " " + ret.getIndex() + "      // [" + instructionHandle.getPosition() + "]";
    }

    @Override
    public void visitSIPUSH(InstructionHandle instructionHandle) {
        SIPUSH sipush = (SIPUSH) instructionHandle.getInstruction();
        result = Constants.OPCODE_NAMES[sipush.getOpcode()] + " " + sipush.getValue() + "      // [" + instructionHandle.getPosition() + "]";
    }

    @Override
    public void visitBIPUSH(InstructionHandle instructionHandle) {
        BIPUSH bipush = (BIPUSH) instructionHandle.getInstruction();
        result = Constants.OPCODE_NAMES[bipush.getOpcode()] + " " + bipush.getValue() + "      // [" + instructionHandle.getPosition() + "]";
    }
}
