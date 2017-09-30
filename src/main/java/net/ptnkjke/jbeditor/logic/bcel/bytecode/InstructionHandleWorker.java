package net.ptnkjke.jbeditor.logic.bcel.bytecode;

import net.ptnkjke.jbeditor.MissingInstruction;
import org.apache.bcel.Const;
import org.apache.bcel.generic.*;

public abstract class InstructionHandleWorker {

    public void visit(InstructionHandle handle) throws Exception {
        Instruction instruction = handle.getInstruction();

        if (instruction instanceof ArithmeticInstruction) {           // Arithmetic Instruction
            visitArithmeticInstruction(handle);
        } else if (instruction instanceof ArrayInstruction) {         // Array Instruction
            visitArrayInstruction(handle);
        } else if (instruction instanceof BranchInstruction) {        // Branch Instruction
            visitBranchInstruction(handle);
        } else if (instruction instanceof ConversionInstruction) {    // Conversion Instruction
            visitConversionInstruction(handle);
        } else if (instruction instanceof CPInstruction) {            // CP Instruction
            visitCPInstruction(handle);
        } else if (instruction instanceof LocalVariableInstruction) { // LocalVariable Instruction
            visitLocalVariableInstruction(handle);
        } else if (instruction instanceof ReturnInstruction) {        // Return Instruction
            visitReturnInstruction(handle);
        } else if (instruction instanceof StackInstruction) {         // Stack Instruction
            visitStackInstruction(handle);
        } else if (instruction instanceof ACONST_NULL) {              // ACONST_NULL
            visitACONST_NULL(handle);
        } else if (instruction instanceof ARRAYLENGTH) {              // ARRAYLENGTH
            visitARRAYLENGTH(handle);
        } else if (instruction instanceof ATHROW) {                   // ATHROW
            visitATHROW(handle);
        } else if (instruction instanceof BREAKPOINT) {               // BREAKPOINT
            visitBREAKPOINT(handle);
        } else if (instruction instanceof DCMPG) {                    // DCMPG
            visitDCMPG(handle);
        } else if (instruction instanceof DCONST) {                   // DCONST
            visitDCONST(handle);
        } else if (instruction instanceof FCMPG) {                    // FCMPG
            visitFCMPG(handle);
        } else if (instruction instanceof FCMPL) {                    // FCMPL
            visitFCMPL(handle);
        } else if (instruction instanceof FCONST) {                   // FCONST
            visitFCONST(handle);
        } else if (instruction instanceof ICONST) {                   // ICONST
            visitICONST(handle);
        } else if (instruction instanceof IMPDEP1) {                  // IMPDEP1
            visitIMPDEP1(handle);
        } else if (instruction instanceof IMPDEP2) {                  // IMPDEP2
            visitIMPDEP2(handle);
        } else if (instruction instanceof LCMP) {                     // LCMP
            visitLCMP(handle);
        } else if (instruction instanceof LCONST) {                   // LCONST
            visitLCONST(handle);
        } else if (instruction instanceof MONITORENTER) {             // MONITORENTER
            visitMONITORENTER(handle);
        } else if (instruction instanceof MONITOREXIT) {              // MONITOREXIT
            visitMONITOREXIT(handle);
        } else if (instruction instanceof NEWARRAY) {                 // NEWARRAY
            visitNEWARRAY(handle);
        } else if (instruction instanceof NOP) {                      // NOP
            visitNOP(handle);
        } else if (instruction instanceof RET) {                      // RET
            visitRET(handle);
        } else if (instruction instanceof SIPUSH) {                   // SIPUSH
            visitSIPUSH(handle);
        } else if (instruction instanceof BIPUSH) {                   // PIBUSH
            visitBIPUSH(handle);
        } else {
            throw new MissingInstruction("i dont know #opcode " + instruction.getOpcode());
        }
    }

    private void visitArithmeticInstruction(InstructionHandle instructionHandle) throws Exception {
        Instruction handle = instructionHandle.getInstruction();
        if (handle instanceof DADD) {
            visitDADD(instructionHandle);
        } else if (handle instanceof DDIV) {  //
            visitDDIV(instructionHandle);
        } else if (handle instanceof DMUL) {  //
            visitDMUL(instructionHandle);
        } else if (handle instanceof DNEG) {  //
            visitDNEG(instructionHandle);
        } else if (handle instanceof DREM) {  //
            visitDREM(instructionHandle);
        } else if (handle instanceof DSUB) {  //
            visitDSUB(instructionHandle);
        } else if (handle instanceof FADD) {  //
            visitFADD(instructionHandle);
        } else if (handle instanceof FDIV) {  //
            visitFDIV(instructionHandle);
        } else if (handle instanceof FMUL) {  //
            visitFMUL(instructionHandle);
        } else if (handle instanceof FNEG) {  //
            visitFNEG(instructionHandle);
        } else if (handle instanceof FREM) {  //
            visitFREM(instructionHandle);
        } else if (handle instanceof FSUB) {  //
            visitFSUB(instructionHandle);
        } else if (handle instanceof IADD) {  //
            visitIADD(instructionHandle);
        } else if (handle instanceof IAND) {  //
            visitIAND(instructionHandle);
        } else if (handle instanceof IDIV) {  //
            visitIDIV(instructionHandle);
        } else if (handle instanceof IMUL) {  //
            visitIMUL(instructionHandle);
        } else if (handle instanceof INEG) {  //
            visitINEG(instructionHandle);
        } else if (handle instanceof IOR) {   //
            visitIOR(instructionHandle);
        } else if (handle instanceof IREM) {  //
            visitIREM(instructionHandle);
        } else if (handle instanceof ISHL) {  //
            visitISHL(instructionHandle);
        } else if (handle instanceof ISHR) {  //
            visitISHR(instructionHandle);
        } else if (handle instanceof ISUB) {  //
            visitISUB(instructionHandle);
        } else if (handle instanceof IUSHR) { //
            visitIUSHR(instructionHandle);
        } else if (handle instanceof IXOR) {  //
            visitIXOR(instructionHandle);
        } else if (handle instanceof LADD) {  //
            visitLADD(instructionHandle);
        } else if (handle instanceof LAND) {  //
            visitLAND(instructionHandle);
        } else if (handle instanceof LDIV) {  //
            visitLDIV(instructionHandle);
        } else if (handle instanceof LMUL) {  //
            visitLMUL(instructionHandle);
        } else if (handle instanceof LNEG) {  //
            visitLNEG(instructionHandle);
        } else if (handle instanceof LOR) {   //
            visitLOR(instructionHandle);
        } else if (handle instanceof LREM) {  //
            visitLREM(instructionHandle);
        } else if (handle instanceof LSHL) {  //
            visitLSHL(instructionHandle);
        } else if (handle instanceof LSHR) {  //
            visitLSHR(instructionHandle);
        } else if (handle instanceof LSUB) {  //
            visitLSUB(instructionHandle);
        } else if (handle instanceof LUSHR) { //
            visitLUSHR(instructionHandle);
        } else if (handle instanceof LXOR) {  //
            visitLXOR(instructionHandle);
        } else {
            throw new MissingInstruction("i dont know #opcode " + handle.getOpcode());
        }
    }

    private void visitArrayInstruction(InstructionHandle instructionHandle) throws Exception {

        Instruction handle = instructionHandle.getInstruction();
        if (handle instanceof AALOAD) {            // AALOAD
            visitAALOAD(instructionHandle);
        } else if (handle instanceof AASTORE) {    // AASTORE
            visitAASTORE(instructionHandle);
        } else if (handle instanceof BALOAD) {     // BALOAD
            visitBALOAD(instructionHandle);
        } else if (handle instanceof BASTORE) {    // BASTORE
            visitBASTORE(instructionHandle);
        } else if (handle instanceof CALOAD) {     // CALOAD
            visitCALOAD(instructionHandle);
        } else if (handle instanceof CASTORE) {    // CASTORE
            visitCASTORE(instructionHandle);
        } else if (handle instanceof DALOAD) {     // DALOAD
            visitDALOAD(instructionHandle);
        } else if (handle instanceof DASTORE) {    // DASTORE
            visitDASTORE(instructionHandle);
        } else if (handle instanceof FALOAD) {     // FALOAD
            visitFALOAD(instructionHandle);
        } else if (handle instanceof FASTORE) {    // FASTORE
            visitFASTORE(instructionHandle);
        } else if (handle instanceof IALOAD) {     // IALOAD
            visitIALOAD(instructionHandle);
        } else if (handle instanceof IASTORE) {    // IASTORE
            visitIASTORE(instructionHandle);
        } else if (handle instanceof LALOAD) {     // LALOAD
            visitLALOAD(instructionHandle);
        } else if (handle instanceof LASTORE) {    // LASTORE
            visitLASTORE(instructionHandle);
        } else if (handle instanceof SALOAD) {     // SALOAD
            visitSALOAD(instructionHandle);
        } else if (handle instanceof SASTORE) {    // SASTORE
            visitSASTORE(instructionHandle);
        } else {
            throw new MissingInstruction("i dont know #opcode " + handle.getOpcode());
        }
    }

    private void visitBranchInstruction(InstructionHandle instructionHandle) throws Exception {
        Instruction handle = instructionHandle.getInstruction();
        if (handle instanceof GotoInstruction) {
            if (handle instanceof GOTO) {
                visitGOTO(instructionHandle);
            } else if (handle instanceof GOTO_W) {
                visitGOTO_W(instructionHandle);
            }
        } else if (handle instanceof IfInstruction) {
            switch (handle.getOpcode()) {
                case Const.IF_ACMPEQ:
                    visitIF_ACMPEQ(instructionHandle);
                    break;
                case Const.IF_ACMPNE:
                    visitIF_ACMPNE(instructionHandle);
                    break;
                case Const.IF_ICMPEQ:
                    visitIF_ICMPEQ(instructionHandle);
                    break;
                case Const.IF_ICMPGT:
                    visitIF_ICMPGT(instructionHandle);
                    break;
                case Const.IF_ICMPGE:
                    visitIF_ICMPGE(instructionHandle);
                    break;
                case Const.IF_ICMPLE:
                    visitIF_ICMPLE(instructionHandle);
                    break;
                case Const.IF_ICMPLT:
                    visitIF_ICMPLT(instructionHandle);
                    break;
                case Const.IF_ICMPNE:
                    visitIF_ICMPNE(instructionHandle);
                    break;
                case Const.IFEQ:
                    visitIFEQ(instructionHandle);
                    break;
                case Const.IFGE:
                    visitIFGE(instructionHandle);
                    break;
                case Const.IFGT:
                    visitIFGT(instructionHandle);
                    break;
                case Const.IFLE:
                    visitIFLE(instructionHandle);
                    break;
                case Const.IFLT:
                    visitIFLT(instructionHandle);
                    break;
                case Const.IFNE:
                    visitIFNE(instructionHandle);
                    break;
                case Const.IFNONNULL:
                    visitIFNONNULL(instructionHandle);
                    break;
                case Const.IFNULL:
                    visitIFNULL(instructionHandle);
                    break;
                default:
                    throw new MissingInstruction("i dont know #opcode " + handle.getOpcode());
            }
        } else if (handle instanceof JsrInstruction) {
            if (handle instanceof JSR) {
                visitJSR(instructionHandle);
            } else if (handle instanceof JSR_W) {
                visitJSR_W(instructionHandle);
            }
        } else if (handle instanceof Select) {
            if (handle instanceof LOOKUPSWITCH) {
                visitLOOKUPSWITCH(instructionHandle);
            } else if (handle instanceof TABLESWITCH) {
                visitTABLESWITCH(instructionHandle);
            }
        } else {
            throw new MissingInstruction("i dont know #opcode " + handle.getOpcode());
        }
    }

    private void visitConversionInstruction(InstructionHandle instructionHandle) throws Exception {
        Instruction handle = instructionHandle.getInstruction();
        switch (handle.getOpcode()) {
            case Const.D2F:
                visitD2F(instructionHandle);
                break;
            case Const.D2I:
                visitD2I(instructionHandle);
                break;
            case Const.D2L:
                visitD2L(instructionHandle);
                break;
            case Const.F2D:
                visitF2D(instructionHandle);
                break;
            case Const.F2I:
                visitF2I(instructionHandle);
                break;
            case Const.F2L:
                visitF2L(instructionHandle);
                break;
            case Const.I2B:
                visitI2B(instructionHandle);
                break;
            case Const.I2C:
                visitI2C(instructionHandle);
                break;
            case Const.I2D:
                visitI2D(instructionHandle);
                break;
            case Const.I2F:
                visitI2F(instructionHandle);
                break;
            case Const.I2L:
                visitI2L(instructionHandle);
                break;
            case Const.I2S:
                visitI2S(instructionHandle);
                break;
            case Const.L2D:
                visitL2D(instructionHandle);
                break;
            case Const.L2F:
                visitL2F(instructionHandle);
                break;
            case Const.L2I:
                visitL2I(instructionHandle);
                break;
            default:
                throw new MissingInstruction("i dont know #opcode " + handle.getOpcode());
        }
    }

    private void visitCPInstruction(InstructionHandle instructionHandle) throws Exception {
        Instruction handle = instructionHandle.getInstruction();
        if (handle instanceof ANEWARRAY) {
            visitANEWARRAY(instructionHandle);
        } else if (handle instanceof CHECKCAST) {
            visitCHECKCAST(instructionHandle);
        } else if (handle instanceof INSTANCEOF) {
            visitINSTANCEOF(instructionHandle);
        } else if (handle instanceof LDC) {
            visitLDC(instructionHandle);
        } else if (handle instanceof LDC2_W) {
            visitLDC2_W(instructionHandle);
        } else if (handle instanceof MULTIANEWARRAY) {
            visitMULTIANEWARRAY(instructionHandle);
        } else if (handle instanceof NEW) {
            visitNEW(instructionHandle);
        } else {
            switch (handle.getOpcode()) {
                case Const.GETFIELD:
                    visitGETFIELD(instructionHandle);
                    break;
                case Const.GETSTATIC:
                    visitGETSTATIC(instructionHandle);
                    break;
                case Const.INVOKEINTERFACE:
                    visitINVOKEINTERFACE(instructionHandle);
                    break;
                case Const.INVOKESPECIAL:
                    visitINVOKESPECIAL(instructionHandle);
                    break;
                case Const.INVOKESTATIC:
                    visitINVOKESTATIC(instructionHandle);
                    break;
                case Const.INVOKEVIRTUAL:
                    visitINVOKEVIRTUAL(instructionHandle);
                    break;
                case Const.PUTFIELD:
                    visitPUTFIELD(instructionHandle);
                    break;
                case Const.PUTSTATIC:
                    visitPUTSTATIC(instructionHandle);
                    break;
                case Const.INVOKEDYNAMIC:
                    visitINVOKEDYNAMIC(instructionHandle);
                    break;
                default:
                    throw new MissingInstruction("i dont know #opcode " + handle.getOpcode());
            }
        }
    }

    private void visitLocalVariableInstruction(InstructionHandle instructionHandle) throws Exception {
        Instruction handle = instructionHandle.getInstruction();
        if (handle instanceof LoadInstruction) {
            switch (handle.getOpcode()) {
                case Const.ALOAD:
                case Const.ALOAD_0:
                case Const.ALOAD_1:
                case Const.ALOAD_2:
                case Const.ALOAD_3:
                    visitALOAD(instructionHandle);
                    break;
                case Const.DLOAD:
                case Const.DLOAD_0:
                case Const.DLOAD_1:
                case Const.DLOAD_2:
                case Const.DLOAD_3:
                    visitDLOAD(instructionHandle);
                    break;
                case Const.FLOAD:
                case Const.FLOAD_0:
                case Const.FLOAD_1:
                case Const.FLOAD_2:
                case Const.FLOAD_3:
                    visitFLOAD(instructionHandle);
                    break;
                case Const.ILOAD:
                case Const.ILOAD_0:
                case Const.ILOAD_1:
                case Const.ILOAD_2:
                case Const.ILOAD_3:
                    visitILOAD(instructionHandle);
                    break;
                case Const.LLOAD:
                case Const.LLOAD_0:
                case Const.LLOAD_1:
                case Const.LLOAD_2:
                case Const.LLOAD_3:
                    visitLLOAD(instructionHandle);
                    break;
                default:
                    throw new MissingInstruction("i dont know #opcode " + handle.getOpcode());
            }
        } else if (handle instanceof StoreInstruction) {
            switch (handle.getOpcode()) {
                case Const.ASTORE:
                case Const.ASTORE_0:
                case Const.ASTORE_1:
                case Const.ASTORE_2:
                case Const.ASTORE_3:
                    visitASTORE(instructionHandle);
                    break;
                case Const.DSTORE:
                case Const.DSTORE_0:
                case Const.DSTORE_1:
                case Const.DSTORE_2:
                case Const.DSTORE_3:
                    visitDSTORE(instructionHandle);
                    break;
                case Const.FSTORE:
                case Const.FSTORE_0:
                case Const.FSTORE_1:
                case Const.FSTORE_2:
                case Const.FSTORE_3:
                    visitFSTORE(instructionHandle);
                    break;
                case Const.ISTORE:
                case Const.ISTORE_0:
                case Const.ISTORE_1:
                case Const.ISTORE_2:
                case Const.ISTORE_3:
                    visitISTORE(instructionHandle);
                    break;
                case Const.LSTORE:
                case Const.LSTORE_0:
                case Const.LSTORE_1:
                case Const.LSTORE_2:
                case Const.LSTORE_3:
                    visitLSTORE(instructionHandle);
                    break;
                default:
                    throw new MissingInstruction("i dont know #opcode " + handle.getOpcode());
            }
        } else if (handle instanceof IINC) {
            visitIINC(instructionHandle);
        } else {
            throw new MissingInstruction("i dont know #opcode " + handle.getOpcode());
        }
    }

    private void visitReturnInstruction(InstructionHandle instructionHandle) throws Exception {
        Instruction handle = instructionHandle.getInstruction();

        if (handle instanceof ARETURN) {
            visitARETURN(instructionHandle);
        } else if (handle instanceof DRETURN) {
            visitDRETURN(instructionHandle);
        } else if (handle instanceof FRETURN) {
            visitFRETURN(instructionHandle);
        } else if (handle instanceof IRETURN) {
            visitIRETURN(instructionHandle);
        } else if (handle instanceof LRETURN) {
            visitLRETURN(instructionHandle);
        } else if (handle instanceof RETURN) {
            visitRETURN(instructionHandle);
        } else {
            throw new MissingInstruction("i dont know #opcode " + handle.getOpcode());
        }
    }

    private void visitStackInstruction(InstructionHandle instructionHandle) throws Exception {

        Instruction handle = instructionHandle.getInstruction();
        if (handle instanceof DUP) {
            visitDUP(instructionHandle);
        } else if (handle instanceof DUP2) {
            visitDUP2(instructionHandle);
        } else if (handle instanceof DUP_X1) {
            visitDUP_X1(instructionHandle);
        } else if (handle instanceof DUP_X2) {
            visitDUP_X2(instructionHandle);
        } else if (handle instanceof DUP2_X1) {
            visitDUP2_X1(instructionHandle);
        } else if (handle instanceof DUP2_X2) {
            visitDUP2_X2(instructionHandle);
        } else if (handle instanceof POP) {
            visitPOP(instructionHandle);
        } else if (handle instanceof POP2) {
            visitPOP2(instructionHandle);
        } else if (handle instanceof SWAP) {
            visitSWAP(instructionHandle);
        } else {
            throw new MissingInstruction("i dont know #opcode " + handle.getOpcode());
        }
    }
    // ARITHMETICINSTRUCTION

    public abstract void visitDADD(InstructionHandle instructionHandle);

    public abstract void visitDDIV(InstructionHandle instructionHandle);

    public abstract void visitDMUL(InstructionHandle instructionHandle);

    public abstract void visitDNEG(InstructionHandle instructionHandle);

    public abstract void visitDREM(InstructionHandle instructionHandle);

    public abstract void visitDSUB(InstructionHandle instructionHandle);

    public abstract void visitFADD(InstructionHandle instructionHandle);

    public abstract void visitFDIV(InstructionHandle instructionHandle);

    public abstract void visitFMUL(InstructionHandle instructionHandle);

    public abstract void visitFNEG(InstructionHandle instructionHandle);

    public abstract void visitFREM(InstructionHandle instructionHandle);

    public abstract void visitFSUB(InstructionHandle instructionHandle);

    public abstract void visitIADD(InstructionHandle instructionHandle);

    public abstract void visitIAND(InstructionHandle instructionHandle);

    public abstract void visitIDIV(InstructionHandle instructionHandle);

    public abstract void visitIMUL(InstructionHandle instructionHandle);

    public abstract void visitINEG(InstructionHandle instructionHandle);

    public abstract void visitIOR(InstructionHandle instructionHandle);

    public abstract void visitIREM(InstructionHandle instructionHandle);

    public abstract void visitISHL(InstructionHandle instructionHandle);

    public abstract void visitISHR(InstructionHandle instructionHandle);

    public abstract void visitISUB(InstructionHandle instructionHandle);

    public abstract void visitIUSHR(InstructionHandle instructionHandle);

    public abstract void visitIXOR(InstructionHandle instructionHandle);

    public abstract void visitLADD(InstructionHandle instructionHandle);

    public abstract void visitLAND(InstructionHandle instructionHandle);

    public abstract void visitLDIV(InstructionHandle instructionHandle);

    public abstract void visitLMUL(InstructionHandle instructionHandle);

    public abstract void visitLNEG(InstructionHandle instructionHandle);

    public abstract void visitLOR(InstructionHandle instructionHandle);

    public abstract void visitLREM(InstructionHandle instructionHandle);

    public abstract void visitLSHL(InstructionHandle instructionHandle);

    public abstract void visitLSHR(InstructionHandle instructionHandle);

    public abstract void visitLSUB(InstructionHandle instructionHandle);

    public abstract void visitLUSHR(InstructionHandle instructionHandle);

    public abstract void visitLXOR(InstructionHandle instructionHandle);

    // ARRAYINSTRUCTIONS

    public abstract void visitAALOAD(InstructionHandle instructionHandle);

    public abstract void visitAASTORE(InstructionHandle instructionHandle);

    public abstract void visitBALOAD(InstructionHandle instructionHandle);

    public abstract void visitBASTORE(InstructionHandle instructionHandle);

    public abstract void visitCALOAD(InstructionHandle instructionHandle);

    public abstract void visitCASTORE(InstructionHandle instructionHandle);

    public abstract void visitDALOAD(InstructionHandle instructionHandle);

    public abstract void visitDASTORE(InstructionHandle instructionHandle);

    public abstract void visitFALOAD(InstructionHandle instructionHandle);

    public abstract void visitFASTORE(InstructionHandle instructionHandle);

    public abstract void visitIALOAD(InstructionHandle instructionHandle);

    public abstract void visitIASTORE(InstructionHandle instructionHandle);

    public abstract void visitLALOAD(InstructionHandle instructionHandle);

    public abstract void visitLASTORE(InstructionHandle instructionHandle);

    public abstract void visitSALOAD(InstructionHandle instructionHandle);

    public abstract void visitSASTORE(InstructionHandle instructionHandle);


    // BRANCH

    public abstract void visitGOTO(InstructionHandle instructionHandle);

    public abstract void visitGOTO_W(InstructionHandle instructionHandle);

    public abstract void visitIF_ACMPEQ(InstructionHandle instructionHandle);

    public abstract void visitIF_ACMPNE(InstructionHandle instructionHandle);

    public abstract void visitIF_ICMPEQ(InstructionHandle instructionHandle);

    public abstract void visitIF_ICMPGT(InstructionHandle instructionHandle);

    public abstract void visitIF_ICMPGE(InstructionHandle instructionHandle);

    public abstract void visitIF_ICMPLE(InstructionHandle instructionHandle);

    public abstract void visitIF_ICMPLT(InstructionHandle instructionHandle);

    public abstract void visitIF_ICMPNE(InstructionHandle instructionHandle);

    public abstract void visitIFEQ(InstructionHandle instructionHandle);

    public abstract void visitIFGE(InstructionHandle instructionHandle);

    public abstract void visitIFGT(InstructionHandle instructionHandle);

    public abstract void visitIFLE(InstructionHandle instructionHandle);

    public abstract void visitIFLT(InstructionHandle instructionHandle);

    public abstract void visitIFNE(InstructionHandle instructionHandle);

    public abstract void visitIFNONNULL(InstructionHandle instructionHandle);

    public abstract void visitIFNULL(InstructionHandle instructionHandle);

    public abstract void visitJSR(InstructionHandle instructionHandle);

    public abstract void visitJSR_W(InstructionHandle instructionHandle);

    public abstract void visitLOOKUPSWITCH(InstructionHandle instructionHandle);

    public abstract void visitTABLESWITCH(InstructionHandle instructionHandle);

    // CONVERSION

    public abstract void visitD2F(InstructionHandle instructionHandle);

    public abstract void visitD2I(InstructionHandle instructionHandle);

    public abstract void visitD2L(InstructionHandle instructionHandle);

    public abstract void visitF2D(InstructionHandle instructionHandle);

    public abstract void visitF2I(InstructionHandle instructionHandle);

    public abstract void visitF2L(InstructionHandle instructionHandle);

    public abstract void visitI2B(InstructionHandle instructionHandle);

    public abstract void visitI2C(InstructionHandle instructionHandle);

    public abstract void visitI2D(InstructionHandle instructionHandle);

    public abstract void visitI2F(InstructionHandle instructionHandle);

    public abstract void visitI2L(InstructionHandle instructionHandle);

    public abstract void visitI2S(InstructionHandle instructionHandle);

    public abstract void visitL2D(InstructionHandle instructionHandle);

    public abstract void visitL2F(InstructionHandle instructionHandle);

    public abstract void visitL2I(InstructionHandle instructionHandle);

    // CPInstruction
    public abstract void visitANEWARRAY(InstructionHandle instructionHandle);

    public abstract void visitCHECKCAST(InstructionHandle instructionHandle);

    public abstract void visitINSTANCEOF(InstructionHandle instructionHandle);

    public abstract void visitLDC(InstructionHandle instructionHandle);

    public abstract void visitLDC2_W(InstructionHandle instructionHandle);

    public abstract void visitMULTIANEWARRAY(InstructionHandle instructionHandle);

    public abstract void visitGETFIELD(InstructionHandle handle);

    public abstract void visitGETSTATIC(InstructionHandle handle);

    public abstract void visitINVOKEINTERFACE(InstructionHandle handle);

    public abstract void visitINVOKESPECIAL(InstructionHandle handle);

    public abstract void visitINVOKESTATIC(InstructionHandle handle);

    public abstract void visitINVOKEVIRTUAL(InstructionHandle handle);

    public abstract void visitPUTFIELD(InstructionHandle handle);

    public abstract void visitPUTSTATIC(InstructionHandle handle);

    public abstract void visitINVOKEDYNAMIC(InstructionHandle instructionHandle);

    public abstract void visitNEW(InstructionHandle instructionHandle);

    // LocalVariable

    public abstract void visitALOAD(InstructionHandle instructionHandle);

    public abstract void visitDLOAD(InstructionHandle instructionHandle);

    public abstract void visitFLOAD(InstructionHandle instructionHandle);

    public abstract void visitLLOAD(InstructionHandle instructionHandle);

    public abstract void visitILOAD(InstructionHandle instructionHandle);

    public abstract void visitASTORE(InstructionHandle instructionHandle);

    public abstract void visitDSTORE(InstructionHandle instructionHandle);

    public abstract void visitFSTORE(InstructionHandle instructionHandle);

    public abstract void visitISTORE(InstructionHandle instructionHandle);

    public abstract void visitLSTORE(InstructionHandle instructionHandle);

    public abstract void visitIINC(InstructionHandle instructionHandle);

    // Return

    public abstract void visitARETURN(InstructionHandle instructionHandle);

    public abstract void visitDRETURN(InstructionHandle instructionHandle);

    public abstract void visitFRETURN(InstructionHandle instructionHandle);

    public abstract void visitIRETURN(InstructionHandle instructionHandle);

    public abstract void visitLRETURN(InstructionHandle instructionHandle);

    public abstract void visitRETURN(InstructionHandle instructionHandle);

    // Stack

    public abstract void visitDUP(InstructionHandle instructionHandle);

    public abstract void visitDUP2(InstructionHandle instructionHandle);

    public abstract void visitDUP_X1(InstructionHandle instructionHandle);

    public abstract void visitDUP_X2(InstructionHandle instructionHandle);

    public abstract void visitDUP2_X1(InstructionHandle instructionHandle);

    public abstract void visitDUP2_X2(InstructionHandle instructionHandle);

    public abstract void visitPOP(InstructionHandle instructionHandle);

    public abstract void visitPOP2(InstructionHandle instructionHandle);

    public abstract void visitSWAP(InstructionHandle instructionHandle);

    // OTHERS

    public abstract void visitACONST_NULL(InstructionHandle instructionHandle);

    public abstract void visitARRAYLENGTH(InstructionHandle instructionHandle);

    public abstract void visitATHROW(InstructionHandle instructionHandle);

    public abstract void visitBREAKPOINT(InstructionHandle instructionHandle);

    public abstract void visitDCMPG(InstructionHandle instructionHandle);

    public abstract void visitDCONST(InstructionHandle instructionHandle);

    public abstract void visitFCMPG(InstructionHandle instructionHandle);

    public abstract void visitFCMPL(InstructionHandle instructionHandle);

    public abstract void visitFCONST(InstructionHandle instructionHandle);

    public abstract void visitICONST(InstructionHandle instructionHandle);

    public abstract void visitIMPDEP1(InstructionHandle instructionHandle);

    public abstract void visitIMPDEP2(InstructionHandle instructionHandle);

    public abstract void visitLCMP(InstructionHandle instructionHandle);

    public abstract void visitLCONST(InstructionHandle instructionHandle);

    public abstract void visitMONITORENTER(InstructionHandle instructionHandle);

    public abstract void visitMONITOREXIT(InstructionHandle instructionHandle);

    public abstract void visitNEWARRAY(InstructionHandle instructionHandle);

    public abstract void visitNOP(InstructionHandle instructionHandle);

    public abstract void visitRET(InstructionHandle instructionHandle);

    public abstract void visitSIPUSH(InstructionHandle instructionHandle);

    public abstract void visitBIPUSH(InstructionHandle instructionHandle);
}
